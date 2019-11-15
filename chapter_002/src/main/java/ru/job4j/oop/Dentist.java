package ru.job4j.oop;

import java.util.Date;

public class Dentist extends Doctor {
    public Dentist(String name, String surname, Date birthday) {
        super(name, surname, "Dentist", birthday);
    }

    public void removeTeeth(Patient p, int teethNum) {
    }

}
