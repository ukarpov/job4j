package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Analizy {

    private boolean isServerAvailable(String status) {
        return !(status.equals("400") || status.equals("500"));
    }

    public void unavailable(String source, String target) {
        StringJoiner in = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            read.lines().forEach(in::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] lines = in.toString().split(System.lineSeparator());
        boolean serverAvailable = false;
        boolean srvStatusInited = false;
        String startTime = "";
        List<String> resultLines = new ArrayList();
        for (String l : lines) {
            String[] serverRec = l.split(" ");
            String srvStatus = serverRec[0];
            String srvTime = serverRec[1];
            boolean isSrvAvlblNow = isServerAvailable(srvStatus);
            if (!srvStatusInited) {
                serverAvailable = isSrvAvlblNow;
                if (!serverAvailable) {
                    startTime = srvTime;
                }
                srvStatusInited = true;
            }
            if (serverAvailable != isSrvAvlblNow) {
                // status change
                if (serverAvailable) {
                    startTime = srvTime;
                } else {
                    resultLines.add(startTime + ";" + srvTime);
                }
                serverAvailable = isSrvAvlblNow;
            }
        }
        // if period not closed
        if (!serverAvailable) {
            resultLines.add(startTime + ";");
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            resultLines.stream().forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
//            out.println("15:01:30;15:02:32");
//            out.println("15:10:30;23:12:32");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //Analizy a = new Analizy();
        //a.unavailable("c:\\projects\\job4j\\chapter_006\\data\\server.log", "c:\\projects\\job4j\\chapter_006\\data\\unavailable.csv");
        //a.unavailable("././data/server.log", "c:\\projects\\job4j\\chapter_006\\data\\unavailable.csv");
    }
}
