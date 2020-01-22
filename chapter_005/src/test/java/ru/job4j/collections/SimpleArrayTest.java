package ru.job4j.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    private SimpleArray<Integer> testArray;

    @Before
    public void init() {
        testArray = new SimpleArray<>(5);
        testArray.add(0);
        testArray.add(1);
        testArray.add(2);
    }

    @Test
    public void testAdd() {
        testArray.add(5);
        assertThat(testArray.get(3), is(5));
    }

    @Test
    public void testSet() {
        testArray.set(2, 5);
        assertThat(testArray.get(2), is(5));
    }

    @Test
    public void testRemove() {
        testArray.remove(0);
        assertThat(testArray.get(0), is(1));
    }

    @Test
    public void testIterator() {
        SimpleArray<Integer> arr = new SimpleArray<>(1);
        arr.add(1);
        Iterator<Integer> iter = arr.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(1));
    }
}