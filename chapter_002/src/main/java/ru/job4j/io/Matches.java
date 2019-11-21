package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        System.out.println("На столе лежат 11 спичек. Два игрока по очереди берут от 1 до 3 спичек. Выигрывает тот, кто забрал последние спички.");
        int matches = 11;
        Scanner input = new Scanner(System.in);
        int playerNum = 0;
        while (matches > 0) {
            playerNum = (playerNum == 1) ? 2 : 1;
            System.out.println("Игрок " + playerNum + ", возьмите от 1 до 3 спичек: ");
            int matchesTaken = Integer.valueOf(input.nextLine());
            matches -= matchesTaken;
            System.out.println(matchesLeftToString(matches));
        }
        System.out.println();
        System.out.println("Выиграл игрок " + playerNum + "!");
    }

    private static String matchesLeftToString(int matchesLeft) {
        String result;
        if (matchesLeft <= 0) {
            result = "Спичек не осталось!";
        } else if (matchesLeft == 1) {
            result = "Осталась 1 спичка!";
        } else if (matchesLeft <= 4) {
            result = "Осталась " + matchesLeft + " спички!";
        } else {
            result = "Осталась " + matchesLeft + " спичек!";
        }
        return result;
    }
}
