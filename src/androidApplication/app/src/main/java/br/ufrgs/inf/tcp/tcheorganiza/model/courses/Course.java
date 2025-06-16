package br.ufrgs.inf.tcp.tcheorganiza.model.courses;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.*;

public class Course {

    private String code;
    private String name;
    private int credits;
    private List<Teacher> teachers;
    private List<Schedule> schedules;
    private List<Task> tasks;
    private String link_moodle;

    @NonNull
    @Override
    public String toString(){
        return name;
    }

    // METHODS =========================================================
    
    public void addSchedule(Schedule schedule) {
        if (schedule == null) {
            throw new IllegalArgumentException("A schedule must be a non-null value");
        }
        this.schedules.add(schedule);
    }

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("A task must be a non-null value");
        }
        this.tasks.add(task);
    }

    public void addTeacher(Teacher teacher) {
        if (teacher == null) {
            throw new IllegalArgumentException("A teacher must be a non-null value");
        }
        this.teachers.add(teacher);
    }

    // CONSTUCTORS =========================================================

    public Course(String code, String name, int credits, List<Teacher> teachers, List<Schedule> schedules) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.teachers = teachers;
        this.link_moodle = "link_moodle";
        this.schedules = schedules;
        this.tasks = new ArrayList<>();
    }

    public Course(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.teachers = new ArrayList<>();
        this.link_moodle = "link_moodle";
        this.schedules = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public Course(String name, List<Teacher> teachers, List<Schedule> schedules) {
        this.code = "";
        this.name = name;
        this.credits = -1;
        this.teachers = teachers;
        this.link_moodle = "link_moodle";
        this.schedules = schedules;
        this.tasks = new ArrayList<>();
    }

    public Course() {
        this.code = "";
        this.name = "";
        this.credits = -1;
        this.teachers = new ArrayList<>();
        this.link_moodle = "link_moodle";
        this.schedules = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    // SETTERS =============================================================
    public void setCode(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        this.code = code;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setCredits(int credits) {
        if (credits <= 0) {
            throw new IllegalArgumentException("Credits must be a positive integer");
        }
        this.credits = credits;
    }

    public void setTeachers(List<Teacher> teachers) {
        if (teachers == null) {
            throw new IllegalArgumentException("Teachers cannot be null");
        }
        this.teachers = teachers;
    }

    public void setSchedules(List<Schedule> schedules) {
        if (schedules == null) {
            throw new IllegalArgumentException("Schedules cannot be null");
        }
        this.schedules = schedules;
    }

    public void setTasks(List<Task> tasks) {
        if (tasks == null) {
            throw new IllegalArgumentException("Tasks cannot be null");
        }
        this.tasks = tasks;
    }

    public void setLinkMoodle(String link_moodle) {
        if (link_moodle == null || link_moodle.isEmpty()) {
            throw new IllegalArgumentException("Link Moodle cannot be null or empty");
        }
        this.link_moodle = link_moodle;
    }

    // GETTERS =============================================================
    public String getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getLinkMoodle() {
        return link_moodle;
    }

}