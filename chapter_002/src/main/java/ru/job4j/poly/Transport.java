package ru.job4j.poly;

public interface Transport {
    void drive();

    void takeIn(int passengers);

    int refuel(int fuelLiters);
}
