package ru.job4j.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------\n");
        sb.append("|      |\n");
        sb.append("|      |\n");
        sb.append("--------");
        return sb.toString();
    }
}
