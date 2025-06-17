package test;
import courses.*;
import tasks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import subjectManager.SubjectManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubjectManagerTest {

    private SubjectManager manager;

    @BeforeEach
    void setUp() {
        manager = new SubjectManager();
    }

    @Test
    void testGetAllTasksOrdered_EmptyCourses() {
        List<Course> courses = new ArrayList<>();
        List<Task> result = manager.getAllTasksOrdered(courses);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetAllTasksOrdered() {
        Task t1 = new Task("study", "description", java.time.LocalDate.of(2025, 6, 17), false);
        Task t2 = new Task("exam", "description", java.time.LocalDate.of(2025, 6, 15), false);
        Course c1 = new Course("INF01120","TCP",4);
        c1.addTask(t1);
        c1.addTask(t2);
        List<Task> result = manager.getAllTasksOrdered(Arrays.asList(c1));
        assertEquals(2, result.size());
        assertEquals(t2, result.get(0));
        assertEquals(t1, result.get(1));
    }
}