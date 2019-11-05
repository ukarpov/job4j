package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void max() {
        assertThat(SqMax.max(1, 2, 3, 4), is(4));

        assertThat(SqMax.max(1, 2, 5, 3), is(5));

        assertThat(SqMax.max(1, 6, 3, 2), is(6));

        assertThat(SqMax.max(7, 2, 3, 1), is(7));

        assertThat(SqMax.max(1, 1, 1, 1), is(1));

        assertThat(SqMax.max(4, 2, 5, 3), is(5));
    }


}
