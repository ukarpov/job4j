package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DeleteItemActionTest {
    @Test
    public void whenDeleteItem() {
        Store tracker = new MemTracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                item.getId()
        };
        new DeleteItemAction(0).execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertNull(replaced);
    }
}
