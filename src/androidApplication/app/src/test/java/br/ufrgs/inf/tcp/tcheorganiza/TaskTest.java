package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Task;

import static org.junit.jupiter.api.Assertions.*;


public class TaskTest {
    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("study", "description", 15, false);

    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("study", task.getName());
        assertEquals("description", task.getDescription());
        assertEquals(15, task.getDate());
        assertFalse(task.getStatus());

    }

    @Test
    public void testSetters() {
        task.setName("trainning");
        task.setDescription("running");
        task.setDate(20);
        task.setStatus(true);


        assertEquals("trainning", task.getName());
        assertEquals("running", task.getDescription());
        assertEquals(20, task.getDate());
        assertTrue(task.getStatus());

    }
}