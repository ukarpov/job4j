package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        Files.walkFileTree(start, new PrintFiles());
    }

    static class FileVisitorWithPredicate implements FileVisitor<Path> {

        private final Predicate<Path> p;
        private final List<String> l;
        private final Function<Path, String> f;

        FileVisitorWithPredicate(Predicate<Path> p, List<String> l, Function<Path, String> f) {
            this.p = p;
            this.l = l;
            this.f = f;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (p.test(file)) {
//                l.add(file.getFileName().toString());
                l.add(f.apply(file));
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
    }

    public static List<String> search(Path root, Predicate<Path> p) {
        return search(root, p, (Path file) -> file.getFileName().toString());
    }

    public static List<String> search(Path root, Predicate<Path> p, Function<Path, String> f) {
        List<String> result = new ArrayList<>();
        try {
            Files.walkFileTree(root, new FileVisitorWithPredicate(p, result, f));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}