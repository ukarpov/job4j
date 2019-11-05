package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        assertThat(Max.max(1, 2), is(2));

        assertThat(Max.max(4, 2), is(4));

        assertThat(Max.max(3, 3), is(3));
    }
}
