package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tasks.Task;

import static org.junit.jupiter.api.Assertions.*;


public class TaskTest {
    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("study", "description", java.time.LocalDate.of(2025, 6, 17), false);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("study", task.getName());
        assertEquals("description", task.getDescription());
        assertEquals(java.time.LocalDate.of(2025, 6, 17), task.getDate());
        assertFalse(task.getStatus());
    }

    @Test
    public void testSetters() {
        task.setName("trainning");
        task.setDescription("running");
        task.setDate(java.time.LocalDate.of(2025, 6, 15));
        task.setStatus(true);

        assertEquals("trainning", task.getName());
        assertEquals("running", task.getDescription());
        assertEquals(java.time.LocalDate.of(2025, 6, 15), task.getDate());
        assertTrue(task.getStatus());
    }
}