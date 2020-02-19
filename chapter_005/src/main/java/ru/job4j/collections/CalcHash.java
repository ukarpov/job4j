package ru.job4j.collections;

import java.util.Calendar;
import java.util.Objects;

public class CalcHash {
    private int num;
    private String str;
    private User u;
    private boolean b;

    public CalcHash(int num, String str, User u, boolean b) {
        this.num = num;
        this.str = str;
        this.u = u;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalcHash calcHash = (CalcHash) o;
        return num == calcHash.num &&
                b == calcHash.b &&
                Objects.equals(str, calcHash.str) &&
                Objects.equals(u, calcHash.u);
    }

    private int addHash(int hash, int add) {
        return hash * 37 + add;
    }

    @Override
    public int hashCode() {
        int result = addHash(0, num);
        for (int i = 0; i < str.length(); i++) {
            result = addHash(result, str.charAt(i));
        }
        result = addHash(result, u.hashCode());
        result = addHash(result, b ? 0 : 1);
        return result;
    }

    public static void main(String[] args) {
        Calendar d1 = Calendar.getInstance();
        d1.set(1980, 1, 1);
        User u1 = new User("AAA", 1, d1);
        CalcHash ch1 = new CalcHash(10, "Str", u1, true);
        System.out.println("Hash 1 = " + ch1.hashCode());
        CalcHash ch2 = new CalcHash(9, "AAA", u1, false);
        System.out.println("Hash 2 = " + ch2.hashCode());
    }
}
