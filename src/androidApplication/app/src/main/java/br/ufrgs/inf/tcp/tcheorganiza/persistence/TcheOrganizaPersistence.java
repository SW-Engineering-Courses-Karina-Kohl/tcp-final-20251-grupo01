package br.ufrgs.inf.tcp.tcheorganiza.persistence;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Course;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Office;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Schedule;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Teacher;
import br.ufrgs.inf.tcp.tcheorganiza.model.ru.RegistroTickets;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Exam;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Task;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Work;

public class TcheOrganizaPersistence {

    // Singleton pattern 
    // https://refactoring.guru/design-patterns/singleton
    private static volatile TcheOrganizaPersistence instance;

    private TcheOrganizaPersistence() {
    }

    public static TcheOrganizaPersistence getInstance() {
        if (instance == null) {
            synchronized (TcheOrganizaPersistence.class) {
                if (instance == null) {
                    instance = new TcheOrganizaPersistence();
                }
            }
        }
        return instance;
    }

    // Atributos compartilhados
    public RegistroTickets registroTickets = new RegistroTickets();
    private List<Teacher> teachersList = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    private List<Task> taskList = new ArrayList<>();


    // TEACHERS
    //Adds the teachers to a list (best way I found to do it)
    public void addTeacherToList(String name, String email, int building, int room){
        teachersList.add(new Teacher(name, email,(new Office(room,building))));
    }

    //Gets list of teachers names to show in the dropdown in courses fragment
    public List<Teacher> getTeachersList(){
        return teachersList;
    }

    //COURSES
    public void addDisciplinaToList(String nameCourse, Teacher selectedTeacher, List<Schedule> scheduleList){
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(selectedTeacher);

        courses.add(new Course(nameCourse, teachers, scheduleList));
    }
    public List<Course> getDisciplinasList(){
        return courses;
    }

    public List<Task> getAllTasksOrdered() {
        List<Task> allTasksOrdered = new ArrayList<>();

        for(Course course: courses){
            allTasksOrdered.addAll(course.getTasks());
        }
        allTasksOrdered.sort(Comparator.comparingInt(Task::getDate));
        return allTasksOrdered;
    }
}