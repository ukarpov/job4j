package ru.job4j.converter;

public class Converter {
    public static double rubleToEuro(double value) {
        return value / 70;
    }

    public static double rubleToDollar(double value) {
        return value / 60;
    }

    public static double euroToRuble(double value) {
        return value*70;
    }

    public static double dollarsToRuble(double value) {
        return value*60;
    }

    public static void main(String[] args) {
        double in = 140;
        double expected = 2;
        double out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2. Test result : " + passed);

        in = 180;
        expected = 3;
        out = rubleToDollar(180);
        passed = expected == out;
        System.out.println(in+" rubles are "+expected+". Test result : " + passed);

        in = 3;
        expected = 210;
        out = euroToRuble(3);
        passed = expected == out;
        System.out.println(in+" euros are "+expected+". Test result : " + passed);

        in = 3.5;
        expected = 210;
        out = dollarsToRuble(3.5);
        passed = expected == out;
        System.out.println(in+" dollars are "+expected+". Test result : " + passed);

    }
}
