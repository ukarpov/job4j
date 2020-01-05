package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        TreeSet<String> tmp = new TreeSet<>();
        for (String value : deps) {
            String dep = "";
            for (String el : value.split("/")) {
                dep += (dep.equals("") ? "" : "/") + el;
                tmp.add(dep);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
