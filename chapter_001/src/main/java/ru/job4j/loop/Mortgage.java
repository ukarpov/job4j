package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int salary, double percent) {
        int year = 0;

        double rest = amount;

        do {
            year++;
            rest *= (1 + (percent / 100));
            rest -= salary;
        } while ((rest > 0) && (year < 100));

        return year;
    }
}
