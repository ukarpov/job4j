package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenExist() {
        assertThat(Triangle.exist(2.0, 2.0, 2.0), is(true));

        assertThat(Triangle.exist(2.0, 2.0, 5.0), is(false));
    }
}
