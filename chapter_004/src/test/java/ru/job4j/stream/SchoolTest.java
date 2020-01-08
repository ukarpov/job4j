package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void whenRangeA() {
        List<Student> all = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10) {
            all.add(new Student("Name" + i, i));
        }
        School sch = new School();
        List<Student> classA = sch.collect(all, stud -> stud.getScore() >= 70 && stud.getScore() <= 100);
        assertThat(classA, is(Arrays.asList(new Student("Name70", 70), new Student("Name80", 80), new Student("Name90", 90), new Student("Name100", 100))));
    }

    @Test
    public void whenRangeB() {
        List<Student> all = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10) {
            all.add(new Student("Name" + i, i));
        }
        School sch = new School();
        List<Student> classA = sch.collect(all, stud -> stud.getScore() >= 50 && stud.getScore() < 70);
        assertThat(classA, is(Arrays.asList(new Student("Name50", 50), new Student("Name60", 60))));
    }

    @Test
    public void whenRangeC() {
        List<Student> all = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10) {
            all.add(new Student("Name" + i, i));
        }
        School sch = new School();
        List<Student> classA = sch.collect(all, stud -> stud.getScore() < 50);
        assertThat(classA, is(Arrays.asList(new Student("Name10", 10), new Student("Name20", 20), new Student("Name30", 30), new Student("Name40", 40))));
    }

    @Test
    public void whenStudentsListToMap() {
        List<Student> all = new ArrayList<>();
        Map<String, Student> expected = new HashMap<>();
        for (int i = 10; i <= 20; i += 10) {
            Student s = new Student("Name" + i, i);
            all.add(s);
            expected.put(s.getName(), s);
        }
        School sch = new School();
        Map<String, Student> studMap = sch.toMap(all);
        assertThat(studMap, is(expected));
    }
}
