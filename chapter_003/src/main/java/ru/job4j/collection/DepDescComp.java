package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        String[] dep1 = o1.split("/");
        String[] dep2 = o2.split("/");
        for (int i = 0; i < Math.min(dep1.length, dep2.length) && result == 0; i++) {
            result = dep2[i].compareTo(dep1[i]);
        }
        if (result == 0) {
            result = Integer.compare(dep1.length, dep2.length);
        }
        return result;
    }
}
