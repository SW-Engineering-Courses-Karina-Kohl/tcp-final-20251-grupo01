package br.ufrgs.inf.tcp.tcheorganiza;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Office;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OfficeTest {
    
    private Office office;

    @BeforeEach
    public void setUp() {
        office = new Office(218, 43424);
    }

    @Test
    public void testGetters() {
        assertEquals(218, office.getRoom());
        assertEquals(43424, office.getBuilding());
    }

    @Test
    public void testSetters() {
        office.setRoom(219);
        office.setBuilding(43425);

        assertEquals(219, office.getRoom());
        assertEquals(43425, office.getBuilding());
    }

    @Test
    public void testGetOfficeDetails() {
        assertEquals("Sala 218, Predio 43424", office.getOfficeDetails()); 
    }
}
