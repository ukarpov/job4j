package ru.job4j.lambda;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Group {
    static class Holder {
        String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Holder{"
                    + "key='" + key + '\''
                    + ", value='" + value + '\''
                    + '}';
        }
    }

    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream()
                .flatMap(s -> s.getUnits().stream().map(u -> new Holder(u, s.getName())))
                .collect(
                        Collectors.groupingBy(t -> t.key,
                                Collector.of(HashSet::new,
                                        (set, el) -> set.add(el.value),
                                        (left, right) -> {
                                            left.addAll(right);
                                            return left;
                                        })
                        )
                );
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Vasia", Set.of("Math", "Prog", "Drawing")),
                new Student("Kolia", Set.of("Math")),
                new Student("Tania", Set.of("Drawing", "Dance"))
        );
        System.out.println(students);

        System.out.println("After grouping " + System.lineSeparator()
                + Group.sections(students)
        );
    }
}
