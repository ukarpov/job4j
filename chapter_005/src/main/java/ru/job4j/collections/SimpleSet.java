package ru.job4j.collections;

import java.util.Iterator;

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
        return sl.iterator();
    }
}
