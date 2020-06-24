package ru.job4j.io.chatbot;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Bot {
    private final File src;
    private ArrayList<String> arr = new ArrayList<>();;

    public Bot(File srcFile) {
        this.src = srcFile;
        try (BufferedReader r = new BufferedReader(new FileReader(this.src, UTF_8))) {
            r.lines().forEach(arr::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAnswer() {
        Random random = new Random();
        int idx = random.nextInt(arr.size());
        return arr.get(idx);
    }
}
