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

    public void init() {
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

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        int itemId = -1;
        try {
            ResultSet r = runSelect("INSERT INTO items(item_name) VALUES(?) RETURNING item_id", s -> s.setString(1, item.getName()));
            while (r.next()) {
                itemId = r.getInt("item_id");
                item.setId(String.valueOf(itemId));
            }
        } catch (SQLException e) {
            LOG.error(e);
        }
        return findById(String.valueOf(itemId));
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

    private ResultSet runSelect(String select, ConsumerThrowsSQLEx<PreparedStatement> bindsSet) throws SQLException {
        PreparedStatement st = cn.prepareStatement(select);
        bindsSet.accept(st);
        return st.executeQuery();
    }

    private List<Item> getItemsByQuery(String select, ConsumerThrowsSQLEx<PreparedStatement> bindsSet) {
        ArrayList<Item> res = new ArrayList<>();
        try {
            ResultSet r = runSelect(select, bindsSet);
            while (r.next()) {
                res.add(resultRow2Item(r));
            }
        } catch (SQLException e) {
            LOG.error(e);
        }
        return res;
    }

    private List<Item> getItemsByQuery(String select) {
        return getItemsByQuery(select, s -> { });
    }

    private int runDML(String select, ConsumerThrowsSQLEx<PreparedStatement> bindsSet) {
        int res = 0;
        try {
            PreparedStatement st = cn.prepareStatement(select);
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
