package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSingleton1Test {
    @Test
    public void whenCheckTrackerInstances() {
        TrackerSingleton1 tracker1 = TrackerSingleton1.INSTANCE;
        TrackerSingleton1 tracker2 = TrackerSingleton1.INSTANCE;
        assertSame(tracker1, tracker2);
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        TrackerSingleton1 tracker = TrackerSingleton1.INSTANCE;
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
        tracker.clear();
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        TrackerSingleton1 tracker = TrackerSingleton1.INSTANCE;
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
        tracker.clear();
    }

    @Test
    public void whenDeleteThenReturnNull() {
        TrackerSingleton1 tracker = TrackerSingleton1.INSTANCE;
        Item i1 = new Item("test1");
        tracker.add(i1);
        tracker.delete(i1.getId());
        assertNull(tracker.findById(i1.getId()));
        tracker.clear();
    }

    @Test
    public void whenFindAll() {
        TrackerSingleton1 tracker = TrackerSingleton1.INSTANCE;
        Item i1 = new Item("test1");
        tracker.add(i1);
        Item i2 = new Item("test2");
        tracker.add(i2);
        List<Item> allItems = tracker.findAll();
        List<Item> testRes = new ArrayList<>(List.of(i1, i2));
        assertEquals(testRes, allItems);
        tracker.clear();
    }

    @Test
    public void whenFindByName() {
        TrackerSingleton1 tracker = TrackerSingleton1.INSTANCE;
        Item i1 = new Item("test1");
        tracker.add(i1);
        Item i2 = new Item("test2");
        tracker.add(i2);
        Item i3 = new Item("test1");
        tracker.add(i3);
        List<Item> allItems = tracker.findByName("test1");
        List<Item> testRes = new ArrayList<>(List.of(i1, i3));
        assertEquals(testRes, allItems);
        tracker.clear();
    }

    @Test
    public void whenFindByNameNotFound() {
        TrackerSingleton1 tracker = TrackerSingleton1.INSTANCE;
        Item i1 = new Item("test1");
        tracker.add(i1);
        Item i2 = new Item("test2");
        tracker.add(i2);
        Item i3 = new Item("test1");
        tracker.add(i3);
        List<Item> allItems = tracker.findByName("test5");
        assertEquals(new ArrayList<Item>(), allItems);
        tracker.clear();
    }

    @Test
    public void whenClearAllItems() {
        TrackerSingleton1 tracker = TrackerSingleton1.INSTANCE;
        Item i1 = new Item("test1");
        tracker.add(i1);
        Item i2 = new Item("test2");
        tracker.add(i2);
        tracker.clear();
        assertEquals(new ArrayList<Item>(), tracker.findAll());
    }
}
