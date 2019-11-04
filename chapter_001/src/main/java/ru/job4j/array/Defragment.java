package ru.job4j.array;

public class Defragment {
    public static String[] compress(String[] array) {

        for (int index = 0; index < array.length; index++) {
            String cell = array[index];

            if (cell == null) {
                int tmpIdx = index + 1;
                while (tmpIdx < array.length && array[tmpIdx] == null) {
                    tmpIdx++;
                }
                if (tmpIdx == array.length) {
                    break;
                } else {
                    array[index] = array[tmpIdx];
                    array[tmpIdx] = null;
                }
            }

            System.out.print(array[index] + " ");
        }

        return array;
    }

    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (int index = 0; index < compressed.length; index++) {
            System.out.print(compressed[index] + " ");
        }
    }
}
