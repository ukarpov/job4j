package ru.job4j.collections;

import org.junit.Test;

import java.util.Calendar;
import java.util.Iterator;

import static org.junit.Assert.*;

public class MyHashMapTest {

    @Test
    public void whenInsertFiveElementsAndThenGet() {
        MyHashMap<User, Integer> myMap = new MyHashMap<>();
        Calendar d1 = Calendar.getInstance();
        d1.set(1980, 1, 1);
        User u1 = new User("A1", 1, d1);
        User u2 = new User("A2", 1, d1);
        User u3 = new User("A3", 1, d1);
        User u4 = new User("A4", 1, d1);
        User u5 = new User("A5", 1, d1);

        assertTrue(myMap.insert(u1, 1));
        assertTrue(myMap.insert(u2, 2));
        assertTrue(myMap.insert(u3, 3));
        assertTrue(myMap.insert(u4, 4));
        assertTrue(myMap.insert(u5, 5));
        assertEquals(Integer.valueOf(5), myMap.get(u5));
        assertEquals(Integer.valueOf(4), myMap.get(u4));
        assertEquals(Integer.valueOf(3), myMap.get(u3));
    }

    @Test
    public void whenInsertSameKey() {
        MyHashMap<User, Integer> myMap = new MyHashMap<>();
        Calendar d1 = Calendar.getInstance();
        d1.set(1980, 1, 1);
        User u1 = new User("A1", 1, d1);

        assertTrue(myMap.insert(u1, 1));
        assertTrue(myMap.insert(u1, 2));

        assertEquals(Integer.valueOf(2), myMap.get(u1));
    }

    @Test
    public void whenInsertBadHash() {
        class Foo {
            private String value;
            Foo(String str) {
                value = str;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Foo foo = (Foo) o;
                return value.equals(foo.value);
            }

            @Override
            public int hashCode() {
                return 42;
            }
        }

        MyHashMap<Foo, Integer> myMap = new MyHashMap<>();
        Foo f1 = new Foo("A");
        Foo f2 = new Foo("B");
        assertTrue(myMap.insert(f1, 1));
        assertFalse(myMap.insert(f2, 1));
    }

    @Test
    public void whenDeleteExistingElement() {
        MyHashMap<User, Integer> myMap = new MyHashMap<>();
        Calendar d1 = Calendar.getInstance();
        d1.set(1980, 1, 1);
        User u1 = new User("A1", 1, d1);
        myMap.insert(u1, 1);
        assertTrue(myMap.delete(u1));
    }

    @Test
    public void whenDeleteNotExistingElement() {
        MyHashMap<User, Integer> myMap = new MyHashMap<>();
        Calendar d1 = Calendar.getInstance();
        d1.set(1980, 1, 1);
        User u1 = new User("A1", 1, d1);
        assertFalse(myMap.delete(u1));
    }

    @Test
    public void whenTestIterator() {
        MyHashMap<String, String> myMap = new MyHashMap<>();
        myMap.insert("A", "B");
        Iterator<MyHashMap.Node> iter = myMap.iterator();
        assertTrue(iter.hasNext());
        MyHashMap.Node e = iter.next();
        assertEquals("AB", (new StringBuilder()).append(e.getKey()).append(e.getValue()).toString());
    }
}