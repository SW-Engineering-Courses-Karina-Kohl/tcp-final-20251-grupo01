package br.ufrgs.inf.tcp.tcheorganiza;


import br.ufrgs.inf.tcp.tcheorganiza.model.courses.*;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.*;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    
    private Course course;
    private Course empty_course;
    private List<Teacher> teachers;
    private List<Schedule> schedules;
    private List<Task> tasks;
    private  Office office;
    private Schedule schedule1;
    private Schedule schedule2;
    private Teacher teacher;
    private Task task;

    @BeforeEach
    public void setUp() {
        
        office = new Office(218, 43424);
        schedule1 = new Schedule("terça", office, LocalTime.of(10, 30), LocalTime.of(12, 10));
        schedule2 = new Schedule("quinta", office, LocalTime.of(10, 30), LocalTime.of(12, 10));

        teacher = new Teacher("Karina Kohl", "karina.kohl@inf.ufrgs.br", office);

        course = new Course("INF01120","TCP",4);
        empty_course = new Course();

        tasks = new ArrayList<>(List.of(new Task("study", "description", 15, false)));  
        task = new Task("lab", "lab5", 15, false);  
    }

    @Test
    public void testGetters() {

        assertEquals("INF01120", course.getCode());
        assertEquals("TCP", course.getName());
        assertEquals(4, course.getCredits());
        assertTrue(course.getTeachers().isEmpty()); 
        assertTrue(course.getSchedules().isEmpty());
        assertTrue(course.getTasks().isEmpty());
        assertEquals("link_moodle", course.getLinkMoodle());   

    }

    @Test
    public void testSetters() {

        empty_course.setCode("INF01120");
        empty_course.setName("TCP");
        empty_course.setCredits(4);
        empty_course.setTeachers(new ArrayList<>());
        empty_course.setSchedules(new ArrayList<>());
        empty_course.setTasks(tasks);
        empty_course.setLinkMoodle("https://moodle.ufrgs.br/course/view.php?id=142154");


        assertEquals("INF01120", empty_course.getCode());
        assertEquals("TCP", empty_course.getName());
        assertEquals(4, empty_course.getCredits());
        assertTrue(empty_course.getTeachers().isEmpty()); 
        assertTrue(empty_course.getSchedules().isEmpty());
        assertEquals(tasks, empty_course.getTasks());
        assertEquals("https://moodle.ufrgs.br/course/view.php?id=142154", empty_course.getLinkMoodle());   

    }

    @Test
    public void testMethods() {

        empty_course = new Course("INF01120", "TCP", 4, new ArrayList<>(), new ArrayList<>());

        empty_course.addSchedule(schedule1);
        empty_course.addSchedule(schedule2);

        empty_course.addTask(task);

        empty_course.addTeacher(teacher);

        assertEquals("INF01120", empty_course.getCode());
        assertEquals("TCP", empty_course.getName());
        assertEquals(4, empty_course.getCredits());
        assertEquals(List.of(teacher), empty_course.getTeachers()); 
        assertEquals(List.of(schedule1, schedule2), empty_course.getSchedules());
        assertEquals(List.of(task),empty_course.getTasks());
        assertEquals("link_moodle", empty_course.getLinkMoodle());   

    }
}
