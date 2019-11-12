package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void distance() {
        double expected = 2;
        Point a = new Point(0,0);
        Point b = new Point(2,0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);

        expected = 0;
        a = new Point(10,10);
        b = new Point(10,10);
        out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);

        expected = 4;
        a = new Point(6,2);
        b = new Point(6,-2);
        out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}
