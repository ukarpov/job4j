package ru.job4j.collections;

import java.util.ArrayList;
import java.util.List;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        int found = 0;
        int changed = 0;
        int deleted = 0;
        for (User uPrev : previous) {
            int idx = current.indexOf(uPrev);
            if (idx >= 0) {
                found++;
                if (!current.get(idx).name.equals(uPrev.name)) {
                    changed++;
                }
            } else {
                deleted++;
            }
        }
        Info i = new Info();
        i.added = current.size() - found;
        i.changed = changed;
        i.deleted = deleted;
        return i;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        @Override
        public String toString() {
            return "Info{" +
                    "added=" + added +
                    ", changed=" + changed +
                    ", deleted=" + deleted +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<User> prev = new ArrayList<>();
        List<User> current = new ArrayList<>();

        User u1 = new User(1, "User1");
        User u2 = new User(5, "User2");
        User u2_2 = new User(5, "User2_2");
        User u3 = new User(11, "User3");
        User u4 = new User(15, "User4");
        User u5 = new User(2, "User5");

        prev.add(u1);
        prev.add(u2);
        prev.add(u3);

        current.add(u2_2);
        current.add(u3);
        current.add(u4);
        current.add(u5);

        Analize an = new Analize();

        Info i = an.diff(prev, current);

        System.out.println(i);
    }
}
