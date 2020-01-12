package ru.job4j.lambda;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class GroupTest {

    @Test
    public void whenGroupStudents() {
        List<Student> students = List.of(
                new Student("Vasia", Set.of("Math", "Prog", "Drawing")),
                new Student("Kolia", Set.of("Math")),
                new Student("Tania", Set.of("Drawing", "Dance"))
        );
        Map<String, Set<String>> exp = Map.of(
                "Drawing", Set.of("Vasia", "Tania"),
                "Math", Set.of("Vasia", "Kolia"),
                "Prog", Set.of("Vasia"),
                "Dance", Set.of("Tania"));
        assertThat(Group.sections(students), is(exp));
    }
}
