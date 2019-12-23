package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int len = Math.min(left.length(), right.length());
        int result = 0;
        for (int i = 0; result == 0 && i < len; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
        }
        if (result == 0) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}
