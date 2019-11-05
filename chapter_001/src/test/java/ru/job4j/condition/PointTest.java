package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void distance() {
        double expected = 2;
        double out = Point.distance(0, 0, 2, 0);
        Assert.assertEquals(expected, out, 0.01);

        expected = 0;
        out = Point.distance(10, 10, 10, 10);
        Assert.assertEquals(expected, out, 0.01);

        expected = 4;
        out = Point.distance(6, 2, 6, -2);
        Assert.assertEquals(expected, out, 0.01);
    }
}
