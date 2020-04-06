package ru.job4j.collections;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void testDiff() {
        List<Analize.User> prev = new ArrayList<>();
        List<Analize.User> current = new ArrayList<>();

        Analize.User u1 = new Analize.User(1, "User1");
        Analize.User u2 = new Analize.User(5, "User2");
        Analize.User u2_2 = new Analize.User(5, "User2_2");
        Analize.User u3 = new Analize.User(11, "User3");
        Analize.User u4 = new Analize.User(15, "User4");
        Analize.User u5 = new Analize.User(2, "User5");

        prev.add(u1);
        prev.add(u2);
        prev.add(u3);

        current.add(u2_2);
        current.add(u3);
        current.add(u4);
        current.add(u5);

        Analize an = new Analize();

        Analize.Info i = an.diff(prev, current);

        assertTrue(i.added == 2 && i.deleted == 1 && i.changed == 1);
    }
}