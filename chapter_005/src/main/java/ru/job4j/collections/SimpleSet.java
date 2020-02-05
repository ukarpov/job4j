package ru.job4j.collections;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArrayList<E> sl;

    public SimpleSet() {
        sl = new SimpleArrayList<>();
    }

    private boolean findElement(E e) {
        boolean result = false;
        for (int i = 0; i < sl.getSize(); i++) {
            if (sl.get(i).equals(e)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void add(E e) {
        if (!findElement(e)) {
            sl.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return sl.iterator();
    }
}
