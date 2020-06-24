package ru.job4j.io.chatbot;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Chat {
    private final File logFile;
    private final Scanner scanner = new Scanner(System.in);

    public Chat(File logFile) {
        this.logFile = logFile;
    }

    private void printText(String text, BufferedOutputStream log) {
        System.out.println(text);
        try {
            log.write((text + System.lineSeparator()).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runChat(Bot b) {
        boolean terminate = false;
        boolean runBot = true;
        try (BufferedOutputStream log = new BufferedOutputStream(new FileOutputStream(this.logFile))) {
            do {
                String userText = scanner.nextLine();
                terminate = userText.toLowerCase().equals("закончить");
                printText("user: " + userText, log);
                if (!terminate) {
                    if (userText.toLowerCase().equals("стоп")) {
                        runBot = false;
                    } else if (userText.toLowerCase().equals("продолжить")) {
                        runBot = true;
                    }
                    if (runBot) {
                        printText("bot: " + b.getAnswer(), log);
                    }
                }
            } while (!terminate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Chat ch = new Chat(new File("c:\\projects\\job4j\\chapter_006\\data\\chatLog.txt"));
        Bot b = new Bot(new File("c:\\projects\\job4j\\chapter_006\\data\\bot.txt"));
        ch.runChat(b);
    }
}
