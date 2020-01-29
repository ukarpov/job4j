package ru.job4j.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LinkedListContainerTest {
    private LinkedListContainer<String> ls;

    @Before
    public void initTestData() {
        ls = new LinkedListContainer<>();
        ls.add("A");
        ls.add("B");
    }

    @Test
    public void whenGetElement() {
        assertTrue(ls.get(0).equals("B"));
    }

    @Test
    public void whenAddAnotherElementThenResize() {
        ls.add("C");
        assertTrue(ls.get(0).equals("C"));
    }

    @Test
    public void testIterator() {
        Iterator<String> it = ls.iterator();
        assertThat(it.hasNext(), is(true));
        assertTrue(it.next().equals("B"));
    }

    @Test
    public void testIteratorFailFast() {
        Iterator<String> it = ls.iterator();
        ls.add("D");
        boolean wasError = false;
        try {
            it.hasNext();
        } catch(ConcurrentModificationException cme) {
            wasError = true;
        }
        assertTrue(wasError);
    }

}
