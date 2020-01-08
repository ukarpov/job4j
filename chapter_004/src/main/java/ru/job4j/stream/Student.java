package ru.job4j.stream;

import java.util.Objects;

public class Student {
    private int score;
    private String name;

    public Student(String name, int score) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{"
                + "name=" + name
                + "score=" + score
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return name.equals(student.name)
               && score == student.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
