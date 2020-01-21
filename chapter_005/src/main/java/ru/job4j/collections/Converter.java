package ru.job4j.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> currentIterator = it.next();

            @Override
            public boolean hasNext() {
                while (!currentIterator.hasNext() && it.hasNext()) {
                    currentIterator = it.next();
                }
                return currentIterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return currentIterator.next();
            }
        };
    }

}
