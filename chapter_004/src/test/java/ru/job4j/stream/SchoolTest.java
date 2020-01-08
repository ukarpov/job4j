package ru.job4j.stream;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void whenRangeA() {
        List<Student> all = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10) {
            all.add(new Student(i));
        }
        School sch = new School();
        List<Student> classA = sch.collect(all, stud -> stud.getScore() >= 70 && stud.getScore() <= 100);
        assertThat(classA, is(Arrays.asList(new Student(70), new Student(80), new Student(90), new Student(100))));
    }

    @Test
    public void whenRangeB() {
        List<Student> all = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10) {
            all.add(new Student(i));
        }
        School sch = new School();
        List<Student> classA = sch.collect(all, stud -> stud.getScore() >= 50 && stud.getScore() < 70);
        assertThat(classA, is(Arrays.asList(new Student(50), new Student(60))));
    }

    @Test
    public void whenRangeC() {
        List<Student> all = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10) {
            all.add(new Student(i));
        }
        School sch = new School();
        List<Student> classA = sch.collect(all, stud -> stud.getScore() < 50);
        assertThat(classA, is(Arrays.asList(new Student(10), new Student(20), new Student(30), new Student(40))));
    }
}
