package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter cntr = new Counter();

        assertThat(cntr.add(1, 10), is(30));

        assertThat(cntr.add(2, 2), is(2));

        assertThat(cntr.add(1, 1), is(0));

        assertThat(cntr.add(1, 5), is(6));
    }

}
