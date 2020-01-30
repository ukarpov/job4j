package ru.job4j.collections;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleStackTest {

    private SimpleStack<String> strStack = new SimpleStack<>();

    @Test
    public void whenPushThenPoll() {
        strStack.push("CCC");
        strStack.push("BBB");
        strStack.push("AAA");
        assertEquals("AAA", strStack.poll().get());
        assertEquals("BBB", strStack.poll().get());
    }

    @Test
    public void whenNoPushThenPollGivesNull() {
        assertTrue(strStack.poll().isEmpty());
    }
}