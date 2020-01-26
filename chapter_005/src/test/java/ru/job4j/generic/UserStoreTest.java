package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class UserStoreTest {
    private UserStore us;

    @Before
    public void init() {
        us = new UserStore(5);
        us.add(new User("Vasia"));
        us.add(new User("Petia"));
        us.add(new User("Masha"));
    }

    @Test
    public void testAdd() {
        us.add(new User("Alex"));
        assertTrue(us.findById("Alex").getId().equals("Alex"));
    }

    @Test
    public void testReplaceTrue() {
        assertTrue(us.replace("Vasia", new User("Misha")));
        assertNull(us.findById("Vasia"));
    }

    @Test
    public void testReplaceFalse() {
        assertFalse(us.replace("XXX", new User("Kolia")));
    }

    @Test
    public void testDelete() {
        assertTrue(us.delete("Petia"));
        assertNull(us.findById("Petia"));
    }
}
