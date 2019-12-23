package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class UserTestComparators {
    @Test
    public void whenByNameAsc() {
        Comparator<User> cmpNameAsc = new UserByNameAsc();
        int rsl = cmpNameAsc.compare(
                new User("AAAA", 20),
                new User("BBBB", 20)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenByNameDesc() {
        Comparator<User> cmpNameDesc = new UserByNameDesc();
        int rsl = cmpNameDesc.compare(
                new User("AAAA", 20),
                new User("BBBB", 20)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenByAgeAsc() {
        Comparator<User> cmpAgeAsc = new UserByAgeAsc();
        int rsl = cmpAgeAsc.compare(
                new User("AAAA", 20),
                new User("BBBB", 21)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenByAgeDesc() {
        Comparator<User> cmpAgeDesc = new UserByAgeDesc();
        int rsl = cmpAgeDesc.compare(
                new User("AAAA", 20),
                new User("BBBB", 21)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenByNameAscAgeDesc() {
        Comparator<User> cmpNameAscAgeDesc = new UserByNameAsc().thenComparing(new UserByAgeDesc());
        int rsl = cmpNameAscAgeDesc.compare(
                new User("AAAA", 20),
                new User("AAAA", 21)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenByAgeAscNameDesc() {
        Comparator<User> cmpAgeAscNameDesc = new UserByAgeAsc().thenComparing(new UserByNameDesc());
        int rsl = cmpAgeAscNameDesc.compare(
                new User("XXXX", 20),
                new User("AAAA", 20)
        );
        assertThat(rsl, lessThan(0));
    }
}
