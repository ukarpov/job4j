package ru.job4j.io.chatbot;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

public class Chat {
    private final File logFile;
    private final Scanner scanner = new Scanner(System.in);
    private boolean stopProgram = false;
    private boolean botActive = true;
    private final Map<String, ChatAction> chatActions = new HashMap<>();

    public Chat(File logFile) {
        this.logFile = logFile;

        initActions();
    }

    private void initActions() {
        chatActions.put("закончить", () -> stopProgram = true);
        chatActions.put("стоп", () -> botActive = false);
        chatActions.put("продолжить", () -> botActive = true);
    }

    private interface ChatAction {
        void execute();
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
        stopProgram = false;
        try (BufferedOutputStream log = new BufferedOutputStream(new FileOutputStream(this.logFile))) {
            do {
                String userText = scanner.nextLine();
                ChatAction action = chatActions.get(userText);
                if (action != null) {
                    action.execute();
                }
                printText("user: " + userText, log);
                if ((!this.stopProgram) && botActive) {
                    printText("bot: " + b.getAnswer(), log);
                }
            } while (!this.stopProgram);
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
