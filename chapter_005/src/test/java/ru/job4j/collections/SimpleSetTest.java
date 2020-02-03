package ru.job4j.collections;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenTestSimpleSet() {
        SimpleSet<String> ss = new SimpleSet<>();
        ss.add("A");
        ss.add("A");
        ss.add("B");
        ss.add("B");
        ss.add("C");
        ss.add("D");
        ss.add("C");
        ss.add("D");
        ss.add("D");
        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            sb.append(s);
        }
        assertEquals("DCBA", sb.toString());
    }

}