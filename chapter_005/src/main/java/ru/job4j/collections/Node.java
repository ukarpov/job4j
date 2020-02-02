package ru.job4j.collections;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public static boolean hasCycle(Node first) {
        Node p1 = first;
        Node p2 = first;

        while (p1 != null && p1.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == null || p2 == null) {
                break;
            }

            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    public void setNext(Node n) {
        this.next = n;
    }
}
