package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class RoleStoreTest {
    private RoleStore rs;

    @Before
    public void init() {
        rs = new RoleStore(5);
        rs.add(new Role("Role1"));
        rs.add(new Role("Role2"));
        rs.add(new Role("Role3"));
    }

    @Test
    public void testAdd() {
        rs.add(new Role("Role3"));
        assertTrue(rs.findById("Role3").getId().equals("Role3"));
    }

    @Test
    public void testReplaceTrue() {
        assertTrue(rs.replace("Role1", new Role("Role4")));
        assertNull(rs.findById("Role1"));
    }

    @Test
    public void testReplaceFalse() {
        assertFalse(rs.replace("XXX", new Role("Role5")));
    }

    @Test
    public void testDelete() {
        assertTrue(rs.delete("Role2"));
        assertNull(rs.findById("Role2"));
    }

}
