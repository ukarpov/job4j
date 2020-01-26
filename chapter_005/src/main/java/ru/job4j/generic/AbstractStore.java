package ru.job4j.generic;

import ru.job4j.collections.SimpleArray;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> arr;

    public AbstractStore(int elementNum) {
        arr = new SimpleArray<>(elementNum);
    }

    private int findIndexById(String id) {
        int result = -1;
        for (T e : arr) {
            result++;
            if (e != null && e.getId().equals(id)) {
                break;
            }
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
        try {
            arr.set(findIndexById(id), model);
        } catch (IndexOutOfBoundsException e) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = true;
        try {
            arr.remove(findIndexById(id));
        } catch (IndexOutOfBoundsException e) {
            result = false;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (T e : arr) {
            if (e != null && e.getId().equals(id)) {
                result = e;
                break;
            }
        }
        return result;
    }
}
