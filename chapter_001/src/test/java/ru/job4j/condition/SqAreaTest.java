package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {
    @Test
    public void square() {
        double expected = 1;
        double out = SqArea.square(4, 1);
        Assert.assertEquals(expected, out, 0D);

        expected = 2;
        out = SqArea.square(6, 2);
        Assert.assertEquals(expected, out, 0D);
    }
}
