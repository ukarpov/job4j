package ru.job4j.array;

public class MatrixCheck {
    public static boolean isWin2(char[][] board) {
        boolean result = false;

        for (int row = 0; row < board.length; row++) {
            int rowXCount = 0;
            for (int col = 0; col < board.length; col++) {
                char sign = board[row][col];
                int colXCount = 0;

                if (sign == 'X') {
                    rowXCount++;

                    // На первой строке массива если символ = X, то проверяем столбец
                    if (row == 0) {
                        colXCount++;
                        for (int row2 = 1; row2 < board.length; row2++) {
                            if (board[row2][col] == 'X') {
                                colXCount++;
                            }
                        }
                    }
                }

                if (colXCount == board.length) {
                    result = true;
                    break;
                }
            }

            if (result || rowXCount == board.length) {
                result = true;
                break;
            }
        }

        return result;
    }

    public static boolean isWin(char[][] board) {
        boolean result = false;
        for (int row = 0; row < board.length; row++) {
            if (board[row][row] == 'X') {
                int rowXCount = 0;
                int colXCount = 0;
                for (int col = 0; col < board.length; col++) {
                    if (board[row][col] == 'X') {
                        rowXCount++;
                    }
                    if (board[col][row] == 'X') {
                        colXCount++;
                    }
                }
                if (rowXCount == board.length || colXCount == board.length) {
                    result = true;
                }
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] hasWinVertical = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean win = isWin(hasWinVertical);
        System.out.println("A board has a winner : " + win);
        System.out.println();
        char[][] hasWinHor = {
                {'_', '_', '_', '_', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
        };
        boolean winHor = isWin(hasWinHor);
        System.out.println("A board has a winner : " + winHor);
        System.out.println();
        char[][] notWin = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean lose = isWin(notWin);
        System.out.println("A board has a winner : " + lose);

        System.out.println();
        char[][] field = {
                {'_', 'X', 'X', 'X', 'X'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', 'X', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean winComplex = isWin(field);
        System.out.println("A board has a winner : " + winComplex);

        System.out.println();
        char[][] fieldMixedloose = {
                {'_', 'X', 'X', 'X', 'X'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', 'X', '_'},
                {'X', '_', 'X', 'X', 'X'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean loseComplex = isWin(fieldMixedloose);
        System.out.println("A board has a winner : " + loseComplex);
    }
}
