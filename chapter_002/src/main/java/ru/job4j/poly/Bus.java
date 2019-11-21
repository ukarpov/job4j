package ru.job4j.poly;

public class Bus implements Transport {
    private int passengers = 0;
    private int fuel = 0;

    @Override
    public void drive() {
        this.fuel--;
    }

    @Override
    public void takeIn(int passengers) {
        this.passengers += passengers;
    }

    @Override
    public int refuel(int fuelLiters) {
        this.fuel += fuelLiters;
        return fuelLiters * 42;
    }
}
