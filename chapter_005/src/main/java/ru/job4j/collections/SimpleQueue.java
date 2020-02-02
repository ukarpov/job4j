package ru.job4j.collections;

public class SimpleQueue<T> {

    private final SimpleStack<T> st1;
    private final SimpleStack<T> st2;

    public SimpleQueue() {
        st1 = new SimpleStack<>();
        st2 = new SimpleStack<>();
    }

    public T poll() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.poll().get());
            }
        }
        return st2.poll().get();
    }

    public void push(T value) {
        st1.push(value);
    }
}
