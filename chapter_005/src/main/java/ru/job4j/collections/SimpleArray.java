package ru.job4j.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] arr;
    private int idx = 0;

    public SimpleArray(int size) {
        arr = (T[]) new Object[size];
    }

    public void add(T model) {
        arr[idx++] = model;
    }

    private boolean checkIndexOutOfBounds(int index) {
        return index < 0 || index >= idx;
    }

    public void set(int index, T model) {
        if (checkIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = model;
    }

    public void remove(int index) {
        if (checkIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);
        arr[arr.length - 1] = null;
    }

    public T get(int index) {
        if (checkIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int iterIndex = 0;

            @Override
            public boolean hasNext() {
                return iterIndex < arr.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return arr[iterIndex++];
            }
        };
    }
}
