package ru.job4j.tracker;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;
    private static final Logger LOG = LogManager.getLogger(SqlTracker.class.getName());

    public SqlTracker() {
    }

    public SqlTracker(Connection connection) {
        this.cn = connection;
    }

    public void init() {
        if (cn == null) {
            try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
                Properties config = new Properties();
                config.load(in);
                Class.forName(config.getProperty("driver-class-name"));
                cn = DriverManager.getConnection(
                        config.getProperty("url"),
                        config.getProperty("username"),
                        config.getProperty("password")
                );
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        final int[] itemId = new int[1];
        runSelect("INSERT INTO items(item_name) VALUES(?) RETURNING item_id", s -> s.setString(1, item.getName()), r -> {
            while (r.next()) {
                itemId[0] = r.getInt("item_id");
            }
        });
        String itemIdStr = String.valueOf(itemId[0]);
        item.setId(itemIdStr);
        return findById(itemIdStr);
    }

    @Override
    public boolean replace(String id, Item item) {
        return runDML("UPDATE items SET item_name = ? WHERE item_id = ?", s -> {
            s.setString(1, item.getName());
            s.setInt(2, Integer.parseInt(id));
        }) > 0;
    }

    @Override
    public boolean delete(String id) {
        return runDML("DELETE FROM items WHERE item_id = ?", s -> s.setInt(1, Integer.parseInt(id))) > 0;
    }

    @Override
    public List<Item> findAll() {
        return getItemsByQuery("SELECT item_id, item_name FROM items ORDER BY item_id");
    }

    @Override
    public List<Item> findByName(String key) {
        return getItemsByQuery("SELECT item_id, item_name FROM items WHERE item_name = ? ORDER BY item_id", st -> st.setString(1, key));
    }

    @Override
    public Item findById(String id) {
        Item res = null;
        if (!id.equals("")) {
            List<Item> a = getItemsByQuery("SELECT item_id, item_name FROM items WHERE item_id = ?", st -> st.setInt(1, Integer.parseInt(id)));
            if (a.size() > 0) {
                res = a.get(0);
            }
        }
        return res;
    }

    private interface ConsumerThrowsSQLEx<T> {
        void accept(T t) throws SQLException;
    }

    private void runSelect(String select, ConsumerThrowsSQLEx<PreparedStatement> bindsSet, ConsumerThrowsSQLEx<ResultSet> rsCons) {
        try (PreparedStatement st = cn.prepareStatement(select)) {
            bindsSet.accept(st);
            rsCons.accept(st.executeQuery());
        } catch (SQLException e) {
            LOG.error(e);
        }
    }

    private List<Item> getItemsByQuery(String select, ConsumerThrowsSQLEx<PreparedStatement> bindsSet) {
        ArrayList<Item> res = new ArrayList<>();
        runSelect(select, bindsSet, r -> {
            while (r.next()) {
                res.add(resultRow2Item(r));
            }
        });
        return res;
    }

    private List<Item> getItemsByQuery(String select) {
        return getItemsByQuery(select, s -> { });
    }

    private int runDML(String select, ConsumerThrowsSQLEx<PreparedStatement> bindsSet) {
        int res = 0;
        try (PreparedStatement st = cn.prepareStatement(select)) {
            bindsSet.accept(st);
            res = st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e);
        }
        return res;
    }

    private Item resultRow2Item(ResultSet r) throws SQLException {
        Item res = new Item(r.getString("item_name"));
        res.setId(String.valueOf(r.getInt("item_id")));
        return res;
    }
}
