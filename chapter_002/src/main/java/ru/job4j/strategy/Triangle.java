package ru.job4j.strategy;

public class Triangle implements Shape {

    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("|\\" + System.lineSeparator());
        sb.append("| \\" + System.lineSeparator());
        sb.append("|  \\" + System.lineSeparator());
        sb.append("-----");
        return sb.toString();
    }

}
