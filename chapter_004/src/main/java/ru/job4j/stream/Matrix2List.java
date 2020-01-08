package ru.job4j.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix2List {
    public static void main(String[] args) {
        Integer[][] iArr = new Integer[3][3];
        for (int i = 0; i < iArr.length; i++) {
            for (int j = 0; j < iArr[i].length; j++) {
                iArr[i][j] = i * iArr[i].length + j + 1;
            }
        }
        System.out.println(
                Stream.of(iArr).flatMap(i -> Stream.of(i)).collect(Collectors.toList())
        );
    }
}
