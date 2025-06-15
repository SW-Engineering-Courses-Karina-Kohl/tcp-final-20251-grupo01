package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Lab;

import static org.junit.jupiter.api.Assertions.*;

public class LabTest {
    private Lab lab;

    @BeforeEach
    public void setUp() {
        lab = new Lab("Lab 1", "Bubble sort", 12, false, "302");
    }

    @Test
    public void testInheritedAttributes() {
        assertEquals("Lab 1", lab.getName());
        assertEquals("Bubble sort", lab.getDescription());
        assertEquals(12, lab.getDate());
        assertFalse(lab.getStatus());
    }

    @Test
    public void testRoomGetterAndSetter() {
        assertEquals("302", lab.getRoom());

        lab.setRoom("405");
        assertEquals("405", lab.getRoom());
    }
}
