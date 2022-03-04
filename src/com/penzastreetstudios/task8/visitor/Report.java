package com.penzastreetstudios.task8.visitor;


import java.time.LocalDate;

public class Report {
    public String deviceType;
    public String state;
    public LocalDate date;
    public int code;

    public Report(String deviceType, String state, LocalDate date, int code) {
        this.deviceType = deviceType;
        this.state = state;
        this.date = date;
        this.code = code;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Report{" +
                "device: " + deviceType + ", " +
                "state: " + state + ", " +
                "date: " + date +
                ", code: " + code +
                "}";
    }
}
