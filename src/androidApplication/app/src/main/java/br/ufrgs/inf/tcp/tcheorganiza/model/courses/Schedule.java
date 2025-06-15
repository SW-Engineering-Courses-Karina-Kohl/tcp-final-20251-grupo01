package br.ufrgs.inf.tcp.tcheorganiza.model.courses;
import java.time.LocalTime;

public class Schedule{

    private String weekday;
    private Office office;
    private LocalTime begin_time;
    private LocalTime end_time;

    // METHODS ==================================================================
    public String getScheduleDetails() {
        return weekday + ", " + begin_time.toString() + " - " + end_time.toString() + ", " + office.getOfficeDetails();
    }

    // CONSTUCTORS ===============================================================

    public Schedule(String weekday, Office office, LocalTime begin_time, LocalTime end_time) {
        this.weekday = weekday;
        this.office = office;
        this.begin_time = begin_time;
        this.end_time = end_time;
    }

    // SETTERS ====================================================================
    public void setWeekday(String weekday) {
        if (weekday == null || weekday.isEmpty()) {
            throw new IllegalArgumentException("Weekday cannot be null or empty");
        }
        this.weekday = weekday;
    }

    public void setTime(LocalTime begin_time, LocalTime end_time) {
        if (begin_time == null || end_time == null) {
            throw new IllegalArgumentException("Time cannot be null");
        }
        if (begin_time.isAfter(end_time)) {
            throw new IllegalArgumentException("Begin time must be before end time");
        }
        this.begin_time = begin_time;
        this.end_time = end_time;
    }

    public void setOffice(Office office) {
        if (office == null) {
            throw new IllegalArgumentException("Office cannot be null");
        }
        this.office = office;
    }

    // GETTERS ====================================================================
    public String getWeekday() {
        return weekday;
    }

    public Office getOffice() {
        return office;
    }

    public LocalTime getBeginTime() {
        return begin_time;
    }

    public LocalTime getEndTime() {
        return end_time;
    }
}