package br.ufrgs.inf.tcp.tcheorganiza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.threeten.bp.LocalDate;

import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Task;

import static org.junit.jupiter.api.Assertions.*;


public class TaskTest {
    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("study", "description", LocalDate.parse("2025-05-30"), false);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("study", task.getName());
        assertEquals("description", task.getDescription());
        assertEquals(LocalDate.parse("2025-05-30"), task.getDate());
        assertFalse(task.getStatus());

    }

    @Test
    public void testSetters() {
        task.setName("trainning");
        task.setDescription("running");
        task.setDate(LocalDate.parse("2025-05-30"));
        task.setStatus(true);


        assertEquals("trainning", task.getName());
        assertEquals("running", task.getDescription());
        assertEquals(LocalDate.parse("2025-05-30"), task.getDate());
        assertTrue(task.getStatus());

    }
}