package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Hare kosoy = new Hare();
        Wolf seriy = new Wolf();
        Fox lisa = new Fox();

        kosoy.tryEat(kolobok);
        seriy.tryEat(kolobok);
        lisa.tryEat(kolobok);
    }
}
