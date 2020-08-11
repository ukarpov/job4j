package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
        tracker.delete(item.getId());
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
        tracker.delete(previous.getId());
    }

    @Test
    public void whenDeleteThenReturnNull() {
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        Item i1 = new Item("test1");
        tracker.add(i1);
        tracker.delete(i1.getId());
        assertNull(tracker.findById(i1.getId()));
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        Item i1 = new Item("test1");
        tracker.add(i1);
        Item i2 = new Item("test2");
        tracker.add(i2);
        ArrayList<Item> allItems = tracker.findAll();
        ArrayList<Item> testRes = new ArrayList<>(List.of(i1, i2));
        assertEquals(testRes, allItems);
        allItems.forEach(i -> tracker.delete(i.getId()));
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        Item i1 = new Item("test1");
        tracker.add(i1);
        Item i2 = new Item("test2");
        tracker.add(i2);
        Item i3 = new Item("test1");
        tracker.add(i3);
        ArrayList<Item> allItems = tracker.findByName("test1");
        ArrayList<Item> testRes = new ArrayList<>(List.of(i1, i3));
        assertEquals(testRes, allItems);
        tracker.delete(i1.getId());
        tracker.delete(i2.getId());
        tracker.delete(i3.getId());
    }

    @Test
    public void whenFindByNameNotFound() {
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        Item i1 = new Item("test1");
        tracker.add(i1);
        Item i2 = new Item("test2");
        tracker.add(i2);
        Item i3 = new Item("test1");
        tracker.add(i3);
        ArrayList<Item> allItems = tracker.findByName("test5");
        assertEquals(new ArrayList<Item>(), allItems);
        tracker.delete(i1.getId());
        tracker.delete(i2.getId());
        tracker.delete(i3.getId());
    }
}
