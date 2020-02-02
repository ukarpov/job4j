package ru.job4j.collections;

import junit.framework.TestCase;

public class NodeTest extends TestCase {

    public void testHasCycleTrue() {
        Node<Integer> n1 = new Node(1);
        Node<Integer> n2 = new Node(2);
        Node<Integer> n3 = new Node(3);
        Node<Integer> n4 = new Node(4);
        Node<Integer> n5 = new Node(5);
        Node<Integer> n6 = new Node(6);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n3);
        n6.setNext(null);

        assertTrue(Node.hasCycle(n1));
    }

    public void testHasCycleFalse() {
        Node<Integer> n1 = new Node(1);
        Node<Integer> n2 = new Node(2);
        Node<Integer> n3 = new Node(3);
        Node<Integer> n4 = new Node(4);
        Node<Integer> n5 = new Node(5);
        Node<Integer> n6 = new Node(6);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(null);

        assertFalse(Node.hasCycle(n1));
    }
}