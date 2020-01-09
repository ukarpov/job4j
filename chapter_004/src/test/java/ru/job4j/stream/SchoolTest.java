package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    private List<Student> allStudents = new ArrayList<>();

    @Before
    public void init() {
        for (int i = 10; i <= 100; i += 10) {
            allStudents.add(new Student("Name" + i, i));
        }
    }

    @Test
    public void whenRangeA() {
        School sch = new School();
        List<Student> classA = sch.collect(allStudents, stud -> stud.getScore() >= 70 && stud.getScore() <= 100);
        assertThat(classA, is(Arrays.asList(new Student("Name70", 70), new Student("Name80", 80), new Student("Name90", 90), new Student("Name100", 100))));
    }

    @Test
    public void whenRangeB() {
        School sch = new School();
        List<Student> classA = sch.collect(allStudents, stud -> stud.getScore() >= 50 && stud.getScore() < 70);
        assertThat(classA, is(Arrays.asList(new Student("Name50", 50), new Student("Name60", 60))));
    }

    @Test
    public void whenRangeC() {
        School sch = new School();
        List<Student> classA = sch.collect(allStudents, stud -> stud.getScore() < 50);
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

    @Test
    public void whenStudentsLevelOfBound() {
        int bound = 50;
        List<Student> expected = new ArrayList<>();
        for (int i = bound + 10; i <= 100; i += 10) {
                expected.add(new Student("Name" + i, i));
        }
        allStudents.add(null);
        School sch = new School();
        List<Student> level = sch.levelOf(allStudents, bound);
        assertThat(level, is(expected));
    }
}
