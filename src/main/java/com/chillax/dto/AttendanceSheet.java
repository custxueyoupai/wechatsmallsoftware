package com.chillax.dto;

import java.util.Date;

import org.joda.time.DateTime;

public class AttendanceSheet {
    private String stuName;

    private String stuId;

    private String wId;
    
    private String checkInDate;
    
    private String checkInTime;

    private String checkOutTime;

    private Integer punchCardResult;

    private String note;

    private String ip;
    
    
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId == null ? null : wId.trim();
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Integer getPunchCardResult() {
        return punchCardResult;
    }

    public void setPunchCardResult(Integer punchCardResult) {
        this.punchCardResult = punchCardResult;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
//    private String testData;
//
//    public String getTestDate() {
//        return testData;
//    }
//
//    public void setTestData(String testData) {
//        this.testData = testData == null ? null : testData.trim();
//    }
    /**
     * 主键部分
     */


    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }
    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }
}