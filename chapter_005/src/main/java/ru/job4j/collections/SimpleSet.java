package ru.job4j.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArrayList<E> sl;

    public SimpleSet() {
        sl = new SimpleArrayList<>();
    }

    public void add(E e) {
        boolean found = false;
        for (int i = 0; i < sl.getSize(); i++) {
            if (sl.get(i).equals(e)) {
                found = true;
                break;
            }
        }
        if (!found) {
            sl.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < sl.getSize();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return sl.get(index++);
            }
        };
    }
}
