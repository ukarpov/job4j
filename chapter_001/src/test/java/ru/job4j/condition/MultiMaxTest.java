package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MultiMaxTest {
    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();

        assertThat(check.max(1, 4, 2), is(4));

        assertThat(check.max(3, 2, 1), is(3));

        assertThat(check.max(3, 2, 5), is(5));

        assertThat(check.max(2, 2, 1), is(2));

        assertThat(check.max(7, 7, 7), is(7));
    }
}
