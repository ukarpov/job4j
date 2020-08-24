package ru.job4j.collections;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicContainer<E> implements Iterable<E> {
    private final int initialSize = 10;

    private E[] array;
    private int arrayIndex = 0;
    private int modCount = 0;

    public DynamicContainer() {
        initArray(initialSize);
    }

    public DynamicContainer(int size) {
        initArray(size);
    }

    public E get(int index) {
        return array[index];
    }

    public void add(E value) {
        if (arrayIndex >= array.length) {
            E[] temp = array;
            initArray(array.length + 1);
            System.arraycopy(temp, 0, array, 0, temp.length);
        }
        array[arrayIndex++] = value;
        modCount++;
    }

    private void initArray(int size) {
        array =  (E[]) new Object[size];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return currentIndex < array.length;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[currentIndex++];
            }
        };
    }
}
