package ru.job4j;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAdd1Until3() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                0, 3, 1,
                (value, index) -> (double) value + index,
                result -> buffer.add(result)
        );
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = new Calculator().diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadrFunction() {
        List<Double> result = new Calculator().diapason(5, 8, x -> 2 * Math.pow(x, 2) - 7 * x + 9);
        List<Double> expected = Arrays.asList(24D, 39D, 58D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenNaturalLogFunction() {
        List<Double> result = new Calculator().diapason(5, 8,
                x -> {
                    BigDecimal bd = BigDecimal.valueOf(Math.log(x + 2));
                    bd = bd.setScale(4, RoundingMode.HALF_UP);
                    return bd.doubleValue();
                });
        List<Double> expected = Arrays.asList(1.9459D, 2.0794D, 2.1972D);
        assertThat(result, is(expected));
    }

}
