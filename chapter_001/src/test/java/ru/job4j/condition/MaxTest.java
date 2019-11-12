package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax() {
        assertThat(Max.max(1, 2), is(2));

        assertThat(Max.max(4, 2), is(4));

        assertThat(Max.max(3, 3), is(3));

        assertThat(Max.max(3, 3, 5), is(5));

        assertThat(Max.max(3, 4, 1, 2), is(4));
    }
}
