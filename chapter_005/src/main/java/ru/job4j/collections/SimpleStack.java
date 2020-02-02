package ru.job4j.collections;

import java.util.Optional;

public class SimpleStack<T> {
    private final LinkedListContainer<T> container = new LinkedListContainer<>();
    private int count = 0;

    public void push(T value) {
        container.add(value);
        count++;
    }

    public Optional<T> poll() {
        Optional<T> result = Optional.empty();
        if (count > 0) {
            result = Optional.of(container.get(0));
            container.remove(0);
            count--;
        }
        return result;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
