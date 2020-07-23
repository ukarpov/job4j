package ru.job4j.io;

import java.util.ArrayList;
import java.util.Arrays;

public class Shell {

    private ArrayList<String> current = new ArrayList();
    private int lastIndex = -1;

    public void cd(String path) {
        ArrayList<String> cdPath  = new ArrayList(Arrays.asList(path.split("/")));

        for (String el : cdPath) {
            if (el.equals("..")) {
                if (lastIndex >= 0) {
                    current.remove(lastIndex--);
                }
            } else {
                current.add(el);
                lastIndex++;
            }
        }
    }

    public String pwd() {
        return "/" + String.join("/", current);
    }

    public static void main(String[] args) {
        System.out.println("pwd = " + new Shell().pwd());
    }
}
