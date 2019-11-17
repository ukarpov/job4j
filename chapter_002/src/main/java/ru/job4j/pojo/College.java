package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student stud = new Student();
        stud.setFullName("Yuriy Karpov");
        stud.setGroupNum("ВВ-31-98");
        stud.setStartDate(new Date(System.currentTimeMillis()));

        System.out.println("Student " + stud.getFullName() + " from group " + stud.getGroupNum() + " started on " + stud.getStartDate());
    }
}
