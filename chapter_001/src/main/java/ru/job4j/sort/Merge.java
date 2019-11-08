package ru.job4j.sort;

import java.util.Arrays;

public class Merge {

    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int leftIdx = 0, rightIdx = 0;
        while (leftIdx + rightIdx < rsl.length) {
            if (rightIdx >= right.length || (leftIdx < left.length && left[leftIdx] < right[rightIdx])) {
                rsl[leftIdx + rightIdx] = left[leftIdx];
                leftIdx++;
            } else if (leftIdx >= left.length || (rightIdx < right.length && left[leftIdx] >= right[rightIdx])) {
                rsl[leftIdx + rightIdx] = right[rightIdx];
                rightIdx++;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 2, 3, 4},
                new int[] {4, 6, 7, 8, 9}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
