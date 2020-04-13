package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.assertTrue;

public class AnalizyTest {
    @Test
    public void whenStartsWorking() {
        String srcPath = "./data/server.log";
        String tgtPath = "./data/unavailable.csv";
        Analizy an = new Analizy();
        an.unavailable(srcPath, tgtPath);

        try (BufferedReader read = new BufferedReader(new FileReader(tgtPath))) {
            String line = read.readLine();
            assertTrue(line.equals("10:57:01;10:59:01"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenOpenPeriod() {
        String srcPath = "./data/server2.log";
        String tgtPath = "./data/unavailable2.csv";
        Analizy an = new Analizy();
        an.unavailable(srcPath, tgtPath);

        try (BufferedReader read = new BufferedReader(new FileReader(tgtPath))) {
            String line = read.readLine();
            assertTrue(line.equals("10:57:01;"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}