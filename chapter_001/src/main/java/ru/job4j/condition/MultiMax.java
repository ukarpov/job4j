package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int firstPair = (first>second) ? first : second;

        int result = (firstPair>third) ? firstPair : third;

        return result;
    }
}
