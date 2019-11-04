package ru.job4j.array;

public class MatrixCheck {
    public static boolean isWin(char[][] board) {
        boolean result = false;

        int[] lines = new int[board.length*2];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                //char sign = board[row][cell];
                int signNum = (board[row][col]=='X') ? 1 : 0;
                lines[row] += signNum;
                lines[col+board.length] += signNum;

                if (lines[row] == board.length || lines[col+board.length]==board.length) {
                    result = true;
                    break;
                }
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
