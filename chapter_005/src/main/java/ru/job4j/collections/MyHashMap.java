package ru.job4j.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class MyHashMap<K, V> implements Iterable {
    private final int extentSize = 4;
    private Node[] table;
    private int size = 0;

    public MyHashMap() {
        size = extentSize;
        table = new Node[size];
    }

    private int getIndex(int h) {
        return h & (size - 1);
    }

    private void resize() {
        Node[] old = table;
        size = (table.length + extentSize);
        table = new Node[size];
        for (int i = 0; i < old.length; i++) {
            int newIdx = getIndex(old[i].key.hashCode());
            table[newIdx] = old[i];
        }
    }

    public boolean insert(K key, V value) {
        boolean result = true;
        int h = key.hashCode();
        int idx = getIndex(h);
        if (table[idx] == null) {
            table[idx] = new Node(key, value);
        } else {
            Node e = table[idx];
            if (e.key.hashCode() == h) {
                if (e.key.equals(key)) {
                    e.value = value;
                } else {
                    result = false;
                }
            } else {
                resize();
                result = insert(key, value);
            }
        }
        return result;
    }

    public V get(K key) {
        V result = null;
        Node e = table[getIndex(key.hashCode())];
        if (e != null) {
            result = (V) e.value;
        }
        return result;
    }

    public boolean delete(K key) {
        boolean result = false;
        int idx = getIndex(key.hashCode());
        if (table[idx] != null) {
            table[idx] = null;
            result = true;
        }
        return result;
    }

    public class Node<K, V> {
        private K key;
        private V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int idx = 0;

            @Override
            public boolean hasNext() {
                for (; idx < size; idx++) {
                    if (table[idx] != null) {
                        break;
                    }
                }
                return (idx < size);
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[idx++];
            }
        };
    }
}
