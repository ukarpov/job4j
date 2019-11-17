package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String fullName;
    private String groupNum;
    private Date startDate;

    public Student() {
    }

    public Student(String fullName, String groupNum, Date startDate) {
        this.fullName = fullName;
        this.groupNum = groupNum;
        this.startDate = startDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
