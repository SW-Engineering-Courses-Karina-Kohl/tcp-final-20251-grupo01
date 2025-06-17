package test;
import tasks.Exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExamTest {
    
    private Exam exam;

    @BeforeEach
    public void setUp() {
        exam = new Exam("final exam", "all of the semester", java.time.LocalDate.of(2025, 6, 17), false, "101", "chapter 1 a 5");
    }

    @Test
    public void testInheritedAttributes() {
        assertEquals("final exam", exam.getName());
        assertEquals("all of the semester", exam.getDescription());
        assertEquals(java.time.LocalDate.of(2025, 6, 17), exam.getDate());
        assertFalse(exam.getStatus());
    }

    @Test
    public void testRoomAndContent() {
        assertEquals("101", exam.getRoom());
        assertEquals("chapter 1 a 5", exam.getContent());

        exam.setRoom("202");
        exam.setContent("chapter 6");

        assertEquals("202", exam.getRoom());
        assertEquals("chapter 6", exam.getContent());
    }
}
