package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.function.Predicate;

public class Find {
    private final FindArgs params;
    private final HashMap<FindArgs.FindModes, Predicate<Path>> findModes = new HashMap<>();

    public Find(FindArgs params) {
        this.params = params;
        initFindModes(params);
    }

    private void initFindModes(FindArgs params) {
        findModes.put(FindArgs.FindModes.BY_EXACT, path -> path.getFileName().toString().equals(params.mask()));
        findModes.put(FindArgs.FindModes.BY_MASK, path -> path.getFileName().toString().matches(params.regexp()));
        findModes.put(FindArgs.FindModes.BY_REGEXP, path -> path.getFileName().toString().matches(params.regexp()));
    }

    private static void print2StreamNoEx(String text, BufferedOutputStream s) {
        try {
            s.write((text + System.lineSeparator()).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Predicate<Path> getPredicate() {
        return findModes.get(params.mode());
    }

    public void printFiles() {
        try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(params.output()))) {
            Search.search(Path.of(params.directory()), getPredicate(), (Path p) -> p.toAbsolutePath().toString())
                    .stream()
                    .forEach(s -> print2StreamNoEx(s, output));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        ArrayList<String> myArgs = new ArrayList<>();
//        myArgs.add("-d"); myArgs.add("j:\\Work\\tmp\\searchResult");
//        myArgs.add("-n"); myArgs.add("*.sql");
//        myArgs.add("-m");
//        myArgs.add("-o"); myArgs.add("j:\\Work\\tmp\\searchResult\\search_result.txt");
//        FindArgs params = new FindArgs(myArgs.toArray(new String[0]));
        FindArgs params = new FindArgs(args);
        if (params.valid()) {
            new Find(params).printFiles();
        } else {
            FindArgs.printHelp();
            throw new IllegalArgumentException();
        }
    }
}
