package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("|\\" + System.lineSeparator())
                                .append("| \\" + System.lineSeparator())
                                .append("|  \\" + System.lineSeparator())
                                .append("-----")
                                .toString()
                )
        );
    }
}
