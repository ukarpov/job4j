package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        for (int i=0; i<array.length/2;i++) {
            int tmp = array[i];
            int oppIdx = array.length-1-i;
            array[i] = array[oppIdx];
            array[oppIdx] = tmp;
        }
        return array;
    }
}
