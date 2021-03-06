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
        chatActions.put("закончить", (String t, BufferedOutputStream l, Bot b) -> {
            stopProgram = true;
            outputText(t, l, b);
        });
        chatActions.put("стоп", (String t, BufferedOutputStream l, Bot b) -> {
            botActive = false;
            outputText(t, l, b);
        });
        chatActions.put("продолжить", (String t, BufferedOutputStream l, Bot b) -> {
            botActive = true;
            outputText(t, l, b);
        });
    }

    private interface ChatAction {
        void execute(String text, BufferedOutputStream log, Bot b);
    }

    private void printText(String text, BufferedOutputStream log) {
        System.out.println(text);
        try {
            log.write((text + System.lineSeparator()).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void outputText(String text, BufferedOutputStream log, Bot b) {
        printText("user: " + text, log);
        if ((!this.stopProgram) && botActive) {
            printText("bot: " + b.getAnswer(), log);
        }
    }

    public void runChat(Bot b) {
        stopProgram = false;
        try (BufferedOutputStream log = new BufferedOutputStream(new FileOutputStream(this.logFile))) {
            do {
                String userText = scanner.nextLine();
                chatActions.getOrDefault(userText, this::outputText).execute(userText, log, b);
            } while (!this.stopProgram);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Chat ch = new Chat(new File("chapter_006\\data\\chatLog.txt"));
        Bot b = new Bot(new File("chapter_006\\data\\bot.txt"));
        ch.runChat(b);
    }
}
