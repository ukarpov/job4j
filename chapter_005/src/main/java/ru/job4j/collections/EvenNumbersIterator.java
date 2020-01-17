package ru.job4j.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {
    private final int[] nums;
    private int lastIndex = 0;

    public EvenNumbersIterator(final int[] numbers) {
        this.nums = numbers;
    }

    private int getNextEvenIndex(int index) {
        int result = -1;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return getNextEvenIndex(this.lastIndex) >= 0;
    }

    @Override
    public Object next() {
        int idx = getNextEvenIndex(this.lastIndex);
        if (idx < 0) {
            throw new NoSuchElementException();
        }
        this.lastIndex = idx;
        return nums[this.lastIndex++];
    }
}
