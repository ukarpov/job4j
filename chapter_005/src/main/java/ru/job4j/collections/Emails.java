package ru.job4j.collections;

import java.util.*;

public class Emails {
    private Set<String> emails;

    private Map<Node, Integer> nodes = new HashMap();
    private List<Node> nodesList = new ArrayList<>();
    private Map<Integer, Map<Integer, Boolean>> links = new HashMap<>();

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

    class Node {
        private String user;
        private String email;
        private boolean visited = false;

        Node(String user, String email) {
            this.user = user;
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(user, node.user) &&
                    Objects.equals(email, node.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(user, email);
        }
    }

    private void scanNodes(int startFrom, Map<String, Set<String>> users) {
        Node n = nodesList.get(startFrom);
        n.visited = true;
//        for ()
//        for (int i = i; i < links.size(); i++) {
//            for (int j = 0; i < links.size(); i++) {
//        }
    }

    private void addNode(Node n, int index) {
        nodes.put(n, index);
        nodesList.add(index, n);
    }

    public Map<String, Set<String>> mergeUsers(Map<String, Set<String>> users) {
        int index = 0;
        for (Map.Entry<String, Set<String>> me : users.entrySet()) {
            //nodes.put(new Node(me.getKey(), null), index++);
            addNode(new Node(me.getKey(), null), index++);
            int userIndex = index;
            for (String e : me.getValue()) {
                Node emailNode = new Node(null, e);
                Integer emailIdx = nodes.get(emailNode);
                if (emailIdx == null) {
                    addNode(new Node(me.getKey(), null), index++);
                }
                if (links.get(userIndex) == null) {
                    links.put(userIndex, new HashMap<>());
                }
                links.get(userIndex).put(emailIdx, true);
            }
        }

        //ArrayList<String> users = new ArrayList<>();
        //ArrayList<String> emails = new ArrayList<>();
        //boolean[][] links = new boolean[users.size()][emails.size()];



        Map<String, Set<String>> result = new HashMap<>();
        return result;
    }

    @Override
    public String toString() {
        return "Emails{" +
                "emails=" + emails +
                '}';
    }

    public static void main(String[] args) {
//        Map<String, Emails> usersFull = new TreeMap<>();
//        usersFull.put("user1", new Emails(new TreeSet<>(Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"))));
//        usersFull.put("user2", new Emails(new TreeSet<>(Set.of("foo@gmail.com", "ups@pisem.net"))));
//        usersFull.put("user3", new Emails(new TreeSet<>(Set.of("xyz@pisem.net", "vasya@pupkin.com"))));
//        usersFull.put("user4", new Emails(new TreeSet<>(Set.of("ups@pisem.net", "aaa@bbb.ru"))));
//        usersFull.put("user5", new Emails(new TreeSet<>(Set.of("xyz@pisem.net"))));
//
//        System.out.println(usersFull);
//        System.out.println("+++++++++++++++++++++++++++++");
//        System.out.println(Emails.deduplicateUsers(usersFull));
        //List<List<Boolean>> arr = new ArrayList<>();
//        Map<Integer, Map<Integer, Boolean>> arr = new HashMap<>();
//        arr.put(0, new HashMap<>());
//        arr.get(0).put(3, true);
//        arr.put(1, new HashMap<>());
//        arr.get(1).put(5, true);
//        System.out.println("1st level size = " + arr.size());
//        for (int i = 0; i < arr.size(); i++) {
//            System.out.println("2nd level" + arr.get(i) + " size = " + arr.get(i).size());
//        }
//        for (int i = 0; i < arr.size(); i++) {
//            for (int j = 0; j < arr.get(i).size(); j++) {
//                System.out.println("val["+i+"]["+j+"] = " + arr.get(i).get(j));
//            }
//        }
    }
}