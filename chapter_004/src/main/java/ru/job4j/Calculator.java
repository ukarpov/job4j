package ru.job4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Calculator {

    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> res = new ArrayList<>();
        for (int index = start; index != end; index++) {
            res.add(func.apply((double) index));
        }
        return res;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(
                0, 10, 2,
                (value, index) -> {
                    double result = value * index;
                    System.out.printf("Multiple %s * %s = %s %n", value, index, result);
                    return result;
                },
                result -> System.out.println(result)
        );
    }
}
