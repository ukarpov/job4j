package ru.job4j.tracker;

import java.util.Arrays;

public class Bug extends Item {
    public Bug() {
        super("Some bug");
    }

    public static void main(String[] args) {
        int[] a1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] a2 = {-1};

        int idx = 3;
        int position = 9;
        System.out.println(Arrays.toString(a1));
        System.arraycopy(a1, idx + 1, a1, idx, a1.length - idx - 1);
        System.out.println(Arrays.toString(a1));
        System.arraycopy(a2, 0, a1, position, a1.length - position);
        System.out.println(Arrays.toString(a1));
    }
}
