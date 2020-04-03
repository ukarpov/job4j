package ru.job4j.collections;

import java.util.*;

public class UserWithEmails {

    public static Map<String, Set<String>> deduplicateUsers(Map<String, Set<String>> users) {
        Map<String, Set<String>> result = new TreeMap<>();
        Map<String, String> userByEmail = new TreeMap<>();

        for (String user : users.keySet()) {
            String prevUser = null;
            for (String email : users.get(user)) {
                prevUser = userByEmail.get(email);
                if (prevUser == null) {
                    userByEmail.put(email, user);
                } else {
                    break;
                }
            }
            if (prevUser == null) {
                result.put(user, users.get(user));
            } else {
                result.get(prevUser).addAll(users.get(user));
                for (String email : users.get(user)) {
                    userByEmail.put(email, prevUser);
                }
            }
        }
        return result;
    }
}
