package br.ufrgs.inf.tcp.tcheorganiza.model.tasks;

import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Course;

import java.lang.ref.WeakReference;

public class TupleTaskCourse {
    private final Task task;
    private final String courseName;

    public TupleTaskCourse(Task task, Course course) {
        this.task = task;
        this.courseName = course.getName();
    }

    public TupleTaskCourse(Task task, String courseName) {
        this.task = task;
        this.courseName = courseName;
    }

    public Task getTask() {
        return task;
    }

    public String getCourseName() {
        return courseName;
    }
}