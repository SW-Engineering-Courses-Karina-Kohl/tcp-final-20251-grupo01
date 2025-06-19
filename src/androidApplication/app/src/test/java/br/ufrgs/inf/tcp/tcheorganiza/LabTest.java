package br.ufrgs.inf.tcp.tcheorganiza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.threeten.bp.LocalDate;

import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Office;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Lab;

import static org.junit.jupiter.api.Assertions.*;

public class LabTest {
    private Lab lab;
    private Office office = new Office(112, 43425);
    private LocalDate date = LocalDate.of(2025, 6,12);

    @BeforeEach
    public void setUp() {
        lab = new Lab("Lab 1", "Bubble sort", date, false, office);
    }

    @Test
    public void testInheritedAttributes() {
        assertEquals("Lab 1", lab.getName());
        assertEquals("Bubble sort", lab.getDescription());
        assertEquals(date, lab.getDate());
        assertFalse(lab.getStatus());
    }

    @Test
    public void testRoomGetterAndSetter() {
        assertEquals(office, lab.getRoom());

        lab.setRoom(office);
        assertEquals(office, lab.getRoom());
    }
}
