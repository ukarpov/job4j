package ru.job4j.collections;

import junit.framework.TestCase;

public class SimpleQueueTest extends TestCase {

    public void testSimpleQueue() {
        SimpleQueue<String> sq = new SimpleQueue<>();
        sq.push("A");
        sq.push("B");
        assertEquals("A", sq.poll());
        sq.push("C");
        assertEquals("B", sq.poll());
        sq.push("D");
        assertEquals("C", sq.poll());
        assertEquals("D", sq.poll());
    }
}