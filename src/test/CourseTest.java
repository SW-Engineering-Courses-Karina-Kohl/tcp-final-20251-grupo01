package test;
import courses.Course;
import tasks.Task;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    
    private Course course;
    private Course empty_course;
    private List<Task> tasks;

    @BeforeEach
    public void setUp() {
        course = new Course("INF01120","TCP",4);
        empty_course = new Course();
        tasks = new ArrayList<>(List.of(new Task("study", "description", 15, false)));    
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
}
