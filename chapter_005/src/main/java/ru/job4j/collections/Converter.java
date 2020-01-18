package ru.job4j.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> currentIterator;

            private boolean currentHasNext() {
                return currentIterator != null && currentIterator.hasNext();
            }

            @Override
            public boolean hasNext() {
                if (!currentHasNext()) {
                    while (it.hasNext()) {
                        currentIterator = it.next();
                        if (currentIterator.hasNext()) {
                            break;
                        }
                    }
                }
                return currentHasNext();
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
