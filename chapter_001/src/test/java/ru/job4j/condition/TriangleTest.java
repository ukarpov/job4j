package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class TriangleTest {
    @Test
    public void area2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 2);
        Point c = new Point(0, 2);
        Triangle t = new Triangle(a, b, c);
        assertEquals(2, t.area(), 0.01);
    }
}
