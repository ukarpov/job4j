package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int charge) {
        this.load = charge;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery b1 = new Battery(100);
        Battery b2 = new Battery(50);

        System.out.println("first battery : " + b1.load + ". second : " + b2.load);
        b2.exchange(b1);
        System.out.println("first battery : " + b1.load + ". second : " + b2.load);
    }
}
