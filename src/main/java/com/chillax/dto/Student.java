package com.chillax.dto;

import java.util.Date;

import org.joda.time.DateTime;

public class Student {
    private String stuid;

    private String stuname;

    private String stusex;

    private String wid;

    private String registrationtime;

    private String major;

    private String institute;

    public String getStuId() {
        return stuid;
    }

    public void setStuId(String stuId) {
        this.stuid = stuId;
    }

    public String getStuName() {
        return stuname;
    }

    public void setStuName(String stuName) {
        this.stuname = stuName;
    }

    public String getStuSex() {
        return stusex;
    }

    public void setStuSex(String stuSex) {
        this.stusex = stuSex;
    }

    public String getwId() {
        return wid;
    }

    public void setwId(String wId) {
        this.wid = wId;
    }

    public String getRegistrationTime() {
        return registrationtime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationtime = registrationTime;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }
}