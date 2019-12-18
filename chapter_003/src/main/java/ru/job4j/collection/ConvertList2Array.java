package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {
            array[row][cell] = num;
            if (cell + 1 == cells) {
                row++;
                cell = 0;
            } else {
                cell++;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int[] arr: list) {
            for (int num : arr) {
                res.add(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        int[][] rsl = toArray(list, 5);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
