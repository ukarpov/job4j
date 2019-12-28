package ru.job4j.bank;

import java.util.Objects;

public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.passport.equals(((User) o).passport);
    }

    @Override
    public int hashCode() {
        return passport.hashCode();
    }

    public String getName() {
        return this.name;
    }

    public String getPassport() {
        return this.passport;
    }
}
