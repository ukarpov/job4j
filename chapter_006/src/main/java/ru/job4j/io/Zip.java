package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File f : sources) {
                zip.putNextEntry(new ZipEntry(f.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(f))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<File> listString2File(List<String> ls) {
        List<File> result = new ArrayList<File>();
        for (String e : ls) {
            result.add(new File(e));
        }
        return result;
    }

    public static void main(String[] args) {
//        new Zip().packSingleFile(
//                new File("./chapter_005/pom.xml"),
//                new File("./chapter_005/pom.zip")
//        );
        ArgZip params = new ArgZip(args);
        if (params.valid()) {
            new Zip().packFiles(
                    listString2File(
                            Search.search(
                                Path.of(params.directory()),
                                path -> !(path.getFileName().toString().endsWith(params.exclude())))),
                    new File(params.output()));
        }
    }

//    public static void main(String[] args) {
//        int_main("-d j:\\Work\\tmp\\ziptest\\XLA260\\ -e docx -o j:\\Work\\tmp\\ziptest\\xla260.zip".split(" "));
//    }
}
