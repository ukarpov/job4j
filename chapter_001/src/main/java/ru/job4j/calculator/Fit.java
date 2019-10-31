package ru.job4j.calculator;

public class Fit {
    public static double manWeight(double height) {
        // Идеальный вес для мужчин = (рост в сантиметрах – 100) · 1,15.
        return (height - 100) * 1.15;
    }


    public static double womanWeight(double height) {
        // Идеальный вес для женщин = (рост в сантиметрах – 110) · 1,15.
        return (height - 110) * 1.15;
    }



    public static void main(String[] args) {
        double man = manWeight(170);
        System.out.println("For man height 170 perfect weight is: " + man);

        double woman = womanWeight(165);
        System.out.println("For woman height 165 perfect weight is: " + woman);
    }
}
