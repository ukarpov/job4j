package ru.job4j.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator<I> implements Iterator<I> {
    private final int[][] matrix;
    private int rowIndex = 0;
    private int colIndex = 0;

    public MatrixIterator(int[][] m) {
        this.matrix = m;
    }

    @Override
    public boolean hasNext() {
        return this.rowIndex < this.matrix.length - 1
                || this.colIndex < this.matrix[this.rowIndex].length;
    }

    @Override
    public I next() {
        if (!(colIndex < matrix[rowIndex].length)) {
            if (rowIndex < this.matrix.length - 1) {
                rowIndex++;
                colIndex = 0;
            } else {
                throw new NoSuchElementException();
            }
        }
        int res = matrix[rowIndex][colIndex++];
        return (I) (Integer) res;
    }
}
