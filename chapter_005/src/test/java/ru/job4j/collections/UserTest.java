package ru.job4j.collections;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void when2UsersInMap() {
        Map<User, String> m = new HashMap<>();

        Calendar d1 = Calendar.getInstance();
        d1.set(1980, 1, 1);

        User u1 = new User("AAA", 1, d1);
        User u2 = new User("AAA", 1, d1);

        m.put(u1, "1st element");
        m.put(u2, "2nd element");

        System.out.println(m.get(u2));

        System.out.println(m);
    }
}