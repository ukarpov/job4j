package ru.job4j.oop;

import java.util.Date;

public class Programmer extends Engineer {
    public Programmer(String name, String surname, Date birthday) {
        super(name, surname, "Programmer", birthday);
    }

    public String writeCode() {
        return "System.out.println(\"Hello world!\")";
    }

    public Bug[] doDebug() {
        return new Bug[10];
    }
}
