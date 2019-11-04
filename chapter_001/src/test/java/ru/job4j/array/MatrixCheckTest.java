package ru.job4j.array;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Ignore
public class MatrixCheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', 'X', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenHorizontalWin() {
        char[][] input = {
                {'_', '_', '_', '_', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
        };
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenMixedWin() {
        char[][] input = {
                {'_', 'X', 'X', 'X', 'X'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', 'X', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenMixedLoose() {
        char[][] input = {
                {'_', 'X', 'X', 'X', 'X'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', 'X', '_'},
                {'X', '_', 'X', 'X', 'X'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenMixedLooseSize6() {
        char[][] input = {
                {'_', 'X', 'X', 'X', 'X', '_'},
                {'_', '_', 'X', '_', '_', '_'},
                {'_', 'X', '_', 'X', '_', '_'},
                {'X', '_', 'X', 'X', 'X', '_'},
                {'_', '_', 'X', '_', '_', '_'},
                {'_', '_', 'X', '_', '_', '_'},
        };
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(false));
    }
}
