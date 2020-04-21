package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        Files.walkFileTree(start, new PrintFiles());
    }

    public static List<String> search(Path root, String ext) {
        List<String> result = new ArrayList<>();
        try {
            Files.walkFileTree(root, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.getFileName().toString().endsWith(ext)) {
                        result.add(file.getFileName().toString());
                    }
                    return CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return CONTINUE;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}