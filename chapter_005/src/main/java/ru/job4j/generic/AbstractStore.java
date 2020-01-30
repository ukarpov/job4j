package ru.job4j.generic;

import ru.job4j.collections.SimpleArray;

import java.util.Optional;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> arr;

    public AbstractStore(int elementNum) {
        arr = new SimpleArray<>(elementNum);
    }

    private int findIndexById(String id) {
        int result = -1;
        int i = 0;
        for (T e : arr) {
            if (e != null && e.getId().equals(id)) {
                result = i;
                break;
            }
            i++;
        }
        return result;
    }

    @Override
    public void add(T model) {
        arr.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = true;
        int idx = findIndexById(id);
        if (idx >= 0) {
            arr.set(idx, model);
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = true;
        int idx = findIndexById(id);
        if (idx >= 0) {
            arr.remove(idx);
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public Optional<T> findById(String id) {
        Optional<T> result = Optional.empty();
        for (T e : arr) {
            if (e != null && e.getId().equals(id)) {
                result = Optional.of(e);
                break;
            }
        }
        return result;
    }
}
