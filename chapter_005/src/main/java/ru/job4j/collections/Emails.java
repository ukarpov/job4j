package ru.job4j.collections;

import java.util.*;

public class Emails {
    private Set<String> emails;

    public Emails(Set<String> e) {
        emails = e;
    }

    private boolean emailsIntersects(Set<String> e1, Set<String> e2) {
        boolean res = false;
        for (String e : e1) {
            if (e2.contains(e)) {
                res = true;
                break;
            }
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emails emails1 = (Emails) o;
        return emailsIntersects(emails, emails1.emails);
    }

    @Override
    public int hashCode() {
        return 42;
    }

    public static Map<String, Emails> deduplicateUsers(Map<String, Emails> users) {
        Map<Emails, Map.Entry<String, Emails>> temp = new HashMap<>();
        for (Map.Entry<String, Emails> me : users.entrySet()) {
            var u = temp.get(me.getValue());
            if (u == null) {
                temp.put(me.getValue(), me);
            } else {
                temp.remove(me.getValue());
                u.getValue().emails.addAll(me.getValue().emails);
                temp.put(u.getValue(), u);
            }
        }
        Map<String, Emails> result = new HashMap<>();
        for (var t : temp.values()) {
            result.put(t.getKey(), t.getValue());
        }
        return result;
    }

    @Override
    public String toString() {
        return "Emails{" +
                "emails=" + emails +
                '}';
    }

    public static void main(String[] args) {
        Map<String, Emails> usersFull = new TreeMap<>();
        usersFull.put("user1", new Emails(new TreeSet<>(Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"))));
        usersFull.put("user2", new Emails(new TreeSet<>(Set.of("foo@gmail.com", "ups@pisem.net"))));
        usersFull.put("user3", new Emails(new TreeSet<>(Set.of("xyz@pisem.net", "vasya@pupkin.com"))));
        usersFull.put("user4", new Emails(new TreeSet<>(Set.of("ups@pisem.net", "aaa@bbb.ru"))));
        usersFull.put("user5", new Emails(new TreeSet<>(Set.of("xyz@pisem.net"))));

        System.out.println(usersFull);
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println(Emails.deduplicateUsers(usersFull));
    }
}