package ru.job4j.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicContainerTest {

    private DynamicContainer<String> ds;

    @Before
    public void initTestData() {
        ds = new DynamicContainer<>(2);
        ds.add("A");
        ds.add("B");
    }

    @Test
    public void whenGetElement() {
        assertTrue(ds.get(0).equals("A"));
    }

    @Test
    public void whenAddAnotherElementThenResize() {
        ds.add("C");
        assertTrue(ds.get(2).equals("C"));
    }

    @Test
    public void testIterator() {
        Iterator<String> it = ds.iterator();
        assertThat(it.hasNext(), is(true));
        assertTrue(it.next().equals("A"));
    }

    @Test
    public void testIteratorFailFast() {
        Iterator<String> it = ds.iterator();
        ds.add("D");
        boolean wasError = false;
        try {
            it.hasNext();
        } catch (ConcurrentModificationException cme) {
            wasError = true;
        }
        assertTrue(wasError);
    }


}