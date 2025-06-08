package test;
import tasks.Work;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkTest {

    private Work work;

    @BeforeEach
    public void setUp() {
        work = new Work("project", "implements x", 30, false, "build logic");
    }

    @Test
    public void testInheritedAttributes() {
        assertEquals("project", work.getName());
        assertEquals("implements x", work.getDescription());
        assertEquals(30, work.getDate());
        assertFalse(work.getStatus());
    }

    @Test
    public void testToDoAttribute() {
        assertEquals("build logic", work.getToDo());

        work.setToDo("adjust database");
        assertEquals("adjust database", work.getToDo());
    }

}