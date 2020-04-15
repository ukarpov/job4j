package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.assertTrue;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenStartsWorking() throws IOException {
        File source = folder.newFile("server.log");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01" + System.lineSeparator() +
                        "500 10:57:01" + System.lineSeparator() +
                        "400 10:58:01" + System.lineSeparator() +
                        "200 10:59:01" + System.lineSeparator() +
                        "500 11:01:02" + System.lineSeparator() +
                        "200 11:02:02");
        }
        File target = folder.newFile("unavailable.csv");
        Analizy an = new Analizy();
        an.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        try (BufferedReader read = new BufferedReader(new FileReader(target.getAbsolutePath()))) {
            String line = read.readLine();
            assertTrue(line.equals("10:57:01;10:59:01"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenOpenPeriod() throws IOException {
        File source = folder.newFile("server.log");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("500 10:57:01");
        }
        File target = folder.newFile("unavailable.csv");
        Analizy an = new Analizy();
        an.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        try (BufferedReader read = new BufferedReader(new FileReader(target.getAbsoluteFile()))) {
            String line = read.readLine();
            assertTrue(line.equals("10:57:01;"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}