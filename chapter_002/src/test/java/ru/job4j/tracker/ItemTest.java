package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    @Test
    public void whenSortAsc() {
        Item a = new Item("AAA");
        Item b = new Item("BBB");
        Item c = new Item("CCC");
        List<Item> result = Arrays.asList(b, a, c);
        Collections.sort(result, new ItemSortByNameAsc());
        List<Item> expected = Arrays.asList(a, b, c);
        assertEquals(expected, result);
    }

    @Test
    public void whenSortDesc() {
        Item a = new Item("AAA");
        Item b = new Item("BBB");
        Item c = new Item("CCC");
        List<Item> result = Arrays.asList(b, a, c);
        Collections.sort(result, new ItemSortByNameDesc());
        List<Item> expected = Arrays.asList(c, b, a);
        assertEquals(expected, result);
    }
}
