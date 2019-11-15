package ru.job4j.oop;

import java.util.Date;

public class Surgeon extends Doctor {
    public Surgeon(String name, String surname, Date birthday) {
        super(name, surname, "Surgeon", birthday);
    }

    public void cut(Patient p) {
    }
}
