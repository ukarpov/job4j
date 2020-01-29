package ru.job4j.collections;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListContainer<E> implements Iterable<E> {
    private Node<E> first = null;
    private int size = 0;
    private int modCount = 0;

    private class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> element = first;
        for (int i = 0; i < index; i++) {
            element = element.next;
        }
        return element.data;
    }

    public void add(E value) {
        Node<E> el = new Node(value, first);
        first = el;
        size++;
        modCount++;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private final int expectedModCount = modCount;
            private int index = 0;
            Node<E> lastNode = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> res = lastNode;
                lastNode = res.next;
                index++;
                return res.data;
            }
        };
    }

}
