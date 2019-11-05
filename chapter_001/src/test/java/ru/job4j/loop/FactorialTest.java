package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        assertThat((new Factorial()).calc(5), is(120));

        assertThat((new Factorial()).calc(10), is(3628800));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        assertThat((new Factorial()).calc(0), is(1));

        assertThat((new Factorial()).calc(1), is(1));
    }
}
