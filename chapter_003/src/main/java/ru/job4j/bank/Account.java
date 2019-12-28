package ru.job4j.bank;

public class Account {
    private double value = 0;
    private String requisites;

    public Account(String reqs) {
        this.requisites = reqs;
    }

    public boolean transfer(Account dest, double amount) {
        boolean result = false;
        if (value >= amount) {
            this.addAmount(-amount);
            dest.addAmount(amount);
            result = true;
        }
        return result;
    }

    public void addAmount(double amount) {
        this.value += amount;
    }

    public String getRequisites() {
        return this.requisites;
    }

    public double getValue() {
        return value;
    }
}
