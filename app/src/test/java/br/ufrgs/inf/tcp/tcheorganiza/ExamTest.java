package br.ufrgs.inf.tcp.tcheorganiza;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Office;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.threeten.bp.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ExamTest {
    
    private Exam exam;
    private LocalDate date = LocalDate.of(2025, 6, 12);
    private Office office = new Office(112, 43425);
    private Office officeTest = new Office(116, 43425);

    @BeforeEach
    public void setUp() {
        exam = new Exam("final exam", "all of the semester", date, false, office, "chapter 1 a 5");
    }

    @Test
    public void testInheritedAttributes() {
        assertEquals("final exam", exam.getName());
        assertEquals("all of the semester", exam.getDescription());
        assertEquals(date, exam.getDate());
        assertFalse(exam.getStatus());
    }

    @Test
    public void testRoomAndContent() {
        assertEquals(office, exam.getRoom());
        assertEquals("chapter 1 a 5", exam.getContent());

        exam.setRoom(officeTest);
        exam.setContent("chapter 6");

        assertEquals(officeTest, exam.getRoom());
        assertEquals("chapter 6", exam.getContent());
    }
}
