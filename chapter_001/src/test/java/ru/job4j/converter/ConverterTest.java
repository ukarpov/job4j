package ru.job4j.converter;

import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {
    @Test
    public void rubleToEuro() {
        double in = 140;
        double expected = 2;
        double out = Converter.rubleToEuro(in);
        Assert.assertEquals(expected, out, 0D);
    }

    @Test
    public void rubleToDollar() {
        double in = 180;
        double expected = 3;
        double out = Converter.rubleToDollar(in);
        Assert.assertEquals(expected, out, 0D);
    }

    @Test
    public void euroToRuble() {
        double in = 3;
        double expected = 210;
        double out = Converter.euroToRuble(in);
        Assert.assertEquals(expected, out, 0D);
    }

    @Test
    public void dollarsToRuble() {
        double in = 3.5;
        double expected = 210;
        double out = Converter.dollarsToRuble(in);
        Assert.assertEquals(expected, out, 0D);
    }
}
