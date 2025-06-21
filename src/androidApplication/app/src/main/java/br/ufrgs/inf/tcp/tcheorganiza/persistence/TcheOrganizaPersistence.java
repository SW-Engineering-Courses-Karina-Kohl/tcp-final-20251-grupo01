package br.ufrgs.inf.tcp.tcheorganiza.persistence;

import org.threeten.bp.LocalDate;

import org.threeten.bp.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Course;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Office;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Schedule;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Teacher;
import br.ufrgs.inf.tcp.tcheorganiza.model.ru.OrganizadorRus;
import br.ufrgs.inf.tcp.tcheorganiza.model.ru.RegistroTickets;
import br.ufrgs.inf.tcp.tcheorganiza.model.ru.Ru;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Exam;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Lab;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Task;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.TupleTaskCourse;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Work;

public class TcheOrganizaPersistence {

    // Singleton pattern 
    // https://refactoring.guru/design-patterns/singleton
    private static volatile TcheOrganizaPersistence instance;

    private TcheOrganizaPersistence() {
        new Thread(() -> {
            RUOrganizer.carregarRusDoSite(OrganizadorRus.URLCardapioPrae);
            List<Ru> ruList = RUOrganizer.getRus();
        }).start();
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

    public OrganizadorRus RUOrganizer = new OrganizadorRus();

    // TEACHERS
    //Adds the teachers to a list
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

    //TASKS
    public void addTask(Course course, String nameTask, String taskDescription, LocalDate taskDate, String taskType, String taskContent, int room, int building){
        switch (taskType){
            case "Prova":
                course.addTaskToList(new Exam(nameTask,taskDescription,taskDate,false,new Office(room, building), taskContent));
                break;
            case "Trabalho":
                course.addTaskToList(new Work(nameTask,taskDescription,taskDate, false, taskContent));
                break;
            case "Laboratório":
                course.addTaskToList(new Lab(nameTask,taskDescription,taskDate,false,new Office(room,building)));
                break;
            case "Tarefa":
                course.addTaskToList(new Task(nameTask,taskDescription,taskDate,false));
                break;
        }

    }
    public List<Task> getAllTasksOrdered() {
        List<Task> allTasksOrdered = new ArrayList<>();

        for(Course course: courses){
            allTasksOrdered.addAll(course.getTasks());
        }
        allTasksOrdered.sort(Comparator.comparing(Task::getDate));
        return allTasksOrdered;
    }

    public List<TupleTaskCourse> getAllTaskByTupleTaskCourse() {
        List<TupleTaskCourse> result = new ArrayList<>();

        for (Course course : courses) {
            for (Task task : course.getTasks()) {
                result.add(new TupleTaskCourse(task, course));
            }
        }

        result.sort(Comparator.comparing(tuple -> tuple.getTask().getDate()));

        return result;
    }
}