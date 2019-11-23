package ru.job4j.strategy;

public class Paint {
    public void draw(Shape s) {
        System.out.println(s.draw());
    }
    public static void main(String[] args) {
        Paint p = new Paint();

        p.draw(new Square());
        p.draw(new Triangle());
    }
}
