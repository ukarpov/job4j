package ru.job4j.tracker;

public class Animal {
    private String name;

    public Animal(String name) {
        super();
        this.name = name;
        System.out.println("Animal: " + name);
    }

    public static void main(String[] args) {
        Tiger sherkhan = new Tiger("Sherkhan");
    }
}
