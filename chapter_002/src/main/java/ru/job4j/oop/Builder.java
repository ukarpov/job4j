package ru.job4j.oop;

import java.util.Date;

public class Builder extends Engineer {
    public Builder(String name, String surname, Date birthday) {
        super(name, surname, "Builder", birthday);
    }

    public void doWork() {
    }
}
