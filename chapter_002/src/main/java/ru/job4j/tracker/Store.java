package ru.job4j.tracker;

import java.util.ArrayList;

public interface Store extends AutoCloseable {
    void init();
    Item add(Item item);
    boolean replace(String id, Item item);
    boolean delete(String id);
    ArrayList<Item> findAll();
    ArrayList<Item> findByName(String key);
    Item findById(String id);
}
