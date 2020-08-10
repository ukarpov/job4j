package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MemTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        MemTracker tracker = new MemTracker();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteThenReturnNull() {
        MemTracker tracker = new MemTracker();
        Item i1 = new Item("test1");
        tracker.add(i1);
        tracker.delete(i1.getId());
        assertNull(tracker.findById(i1.getId()));
    }

    @Test
    public void whenFindAll() {
        MemTracker tracker = new MemTracker();
        Item i1 = new Item("test1");
        tracker.add(i1);
        Item i2 = new Item("test2");
        tracker.add(i2);
        ArrayList<Item> allItems = tracker.findAll();
        ArrayList<Item> testRes = new ArrayList<>(List.of(i1, i2));
        assertEquals(testRes, allItems);
    }

    @Test
    public void whenFindByName() {
        MemTracker tracker = new MemTracker();
        Item i1 = new Item("test1");
        tracker.add(i1);
        Item i2 = new Item("test2");
        tracker.add(i2);
        Item i3 = new Item("test1");
        tracker.add(i3);
        ArrayList<Item> allItems = tracker.findByName("test1");
        ArrayList<Item> testRes = new ArrayList<>(List.of(i1, i3));
        assertEquals(testRes, allItems);
    }

    @Test
    public void whenFindByNameNotFound() {
        MemTracker tracker = new MemTracker();
        Item i1 = new Item("test1");
        tracker.add(i1);
        Item i2 = new Item("test2");
        tracker.add(i2);
        Item i3 = new Item("test1");
        tracker.add(i3);
        ArrayList<Item> allItems = tracker.findByName("test5");
        assertEquals(new ArrayList<Item>(), allItems);
    }

    @Test
    public void whenClearAllItems() {
        MemTracker tracker = new MemTracker();
        Item i1 = new Item("test1");
        tracker.add(i1);
        Item i2 = new Item("test2");
        tracker.add(i2);
        tracker.clear();
        assertEquals(new ArrayList<Item>(), tracker.findAll());
    }
}
