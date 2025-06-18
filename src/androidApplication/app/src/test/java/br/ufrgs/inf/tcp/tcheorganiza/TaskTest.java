package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Task;

import static org.junit.jupiter.api.Assertions.*;


public class TaskTest {
    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("study", "description", 15072025, false);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("study", task.getName());
        assertEquals("description", task.getDescription());
        assertEquals(15072025, task.getDate());
        assertFalse(task.getDone());
    }

    @Test
    public void testSetters() {
        task.setName("trainning");
        task.setDescription("running");
        task.setDate(17072025);
        task.setDone(true);

        assertEquals("trainning", task.getName());
        assertEquals("running", task.getDescription());
        assertEquals(17072025, task.getDate());
        assertTrue(task.getDone());
    }
}