package ru.job4j.tracker;

public interface UserAction {
    String name();

    int key();

    String info();

    boolean execute(Input input, Tracker tracker);


}
