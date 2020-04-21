package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class SearchTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenSearchFiles() throws IOException {
        File f1 = folder.newFile("111.js");
        File f2 = folder.newFile("111.txt");
        File f3 = folder.newFile("222.js");
        List<String> l = Search.search(f1.toPath().getParent(), "js");
        assertTrue(l.size() == 2);
    }
}