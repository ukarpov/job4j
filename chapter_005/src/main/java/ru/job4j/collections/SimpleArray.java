package ru.job4j.collections;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] arr;
    private int idx = 0;

    public SimpleArray(int size) {
        arr = (T[]) new Object[size];
        String[] a = new String[size];
    }

    public void add(T model) {
        arr[idx++] = model;
    }

    public void set(int index, T model) {
        arr[index] = model;
    }

    public void remove(int index) {
        for (int i = index; i < arr.length; i++) {
            arr[i] = (i == arr.length - 1) ? null : arr[i + 1];
        }
    }

    public T get(int index) {
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
                return arr[iterIndex++];
            }
        };
    }
}
