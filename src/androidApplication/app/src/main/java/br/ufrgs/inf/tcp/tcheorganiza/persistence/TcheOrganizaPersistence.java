package br.ufrgs.inf.tcp.tcheorganiza.persistence;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Course;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Office;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Schedule;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Teacher;
import br.ufrgs.inf.tcp.tcheorganiza.model.ru.RegistroTickets;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Exam;

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


    
}

// Exemplo de uso
/*

import br.ufrgs.inf.tcp.tcheorganiza.persistence.TcheOrganizaPersistence;
import br.ufrgs.inf.tcp.tcheorganiza.persistence.RegistroTickets;

public class Main {
    public static void main(String[] args) {
        // Obtendo a instância única
        TcheOrganizaPersistence persistence = TcheOrganizaPersistence.getInstance();

        // Usando o atributo compartilhado
        RegistroTickets tickets = persistence.registroTickets;

        // Listando os tickets
        System.out.println("Tickets registrados:");
        for (String ticket : tickets.getListaTickets()) {
            System.out.println(ticket);
        }
    }
}

 */