package ru.job4j.array;

public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i=0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }

    public static int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.

        for (int i=start; i <= finish; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }

        return rst;
    }

    public static int[] sort(int[] data) {

        for(int i = 0; i < data.length; i++) {
            int min = MinDiapason.findMin(data, i, data.length-1);
            int index = FindLoop.indexOf(data, min, i, data.length-1);
            int tmp = data[i];
            data[i] = data[index];
            data[index] = tmp;
        }

        return data;
    }
}
