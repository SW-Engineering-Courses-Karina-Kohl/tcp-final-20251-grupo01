package test;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Teacher;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Office;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {
    
    private Teacher teacher;
    private Office office;

    @BeforeEach
    public void setUp() {
        office = new Office(218, 43424);
        teacher = new Teacher("Karina Kohl", "karina.kohl@inf.ufrgs.br", office);
    }

    @Test
    public void testGetters() {
        assertEquals("Karina Kohl", teacher.getName());
        assertEquals("karina.kohl@inf.ufrgs.br", teacher.getEmail());
        assertEquals(office, teacher.getOffice());
    }

    @Test
    public void testSetters() {

        Office newOffice = new Office(219, 43425);
        teacher.setName("Joao Silva");
        teacher.setEmail("joao.silva@inf.ufrgs.br");
        teacher.setOffice(newOffice);

        assertEquals("Joao Silva", teacher.getName());
        assertEquals("joao.silva@inf.ufrgs.br", teacher.getEmail());
        assertEquals(newOffice, teacher.getOffice());
    }
}
