package ru.job4j.collections;

import org.junit.Test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class UserWithEmailsTest {

    @Test
    public void testDeduplicateUsers() {
        Map<String, Set<String>> usersFull = new TreeMap<>();
        usersFull.put("user1", new TreeSet<>(Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        usersFull.put("user2", new TreeSet<>(Set.of("foo@gmail.com", "ups@pisem.net")));
        usersFull.put("user3", new TreeSet<>(Set.of("xyz@pisem.net", "vasya@pupkin.com")));
        usersFull.put("user4", new TreeSet<>(Set.of("ups@pisem.net", "aaa@bbb.ru")));
        usersFull.put("user5", new TreeSet<>(Set.of("xyz@pisem.net")));

        var users = UserWithEmails.deduplicateUsers(usersFull);
        assertEquals(2, users.size());
    }
}