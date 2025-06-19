import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    private Ticket ticket;

    @BeforeEach
    void setUp() {
        ticket = new Ticket("ABC123", LocalDate.of(2025, 6, 15), 3);
    }

    @Test
    void testGetCodigo() {
        assertEquals("ABC123", ticket.getCodigo());
    }

    @Test
    void testSetCodigo() {
        ticket.setCodigo("XYZ789");
        assertEquals("XYZ789", ticket.getCodigo());
    }

    @Test
    void testGetDataCompra() {
        assertEquals(LocalDate.of(2025, 6, 15), ticket.getDataCompra());
    }

    @Test
    void testSetDataCompra() {
        LocalDate novaData = LocalDate.of(2025, 6, 18);
        ticket.setDataCompra(novaData);
        assertEquals(novaData, ticket.getDataCompra());
    }

    @Test
    void testGetQuantidade() {
        assertEquals(3, ticket.getQuantidade());
    }

    @Test
    void testSetQuantidade() {
        ticket.setQuantidade(5);
        assertEquals(5, ticket.getQuantidade());
    }

    @Test
    void testGetNumUsosInicial() {
        assertEquals(0, ticket.getNumUsos());
    }

    @Test
    void testSetNumUsos() {
        ticket.setNumUsos(2);
        assertEquals(2, ticket.getNumUsos());
    }

    @Test
    void testAtualizarNumUsos() {
        ticket.atualizarNumUsos();
        assertEquals(1, ticket.getNumUsos());
        ticket.atualizarNumUsos();
        assertEquals(2, ticket.getNumUsos());
    }

    @Test
    void testUsarTicketComUsosDisponiveis() {
        ticket.setNumUsos(1);
        assertTrue(ticket.usarTicket());
    }

    @Test
    void testUsarTicketSemUsosDisponiveis() {
        ticket.setNumUsos(3);
        assertFalse(ticket.usarTicket());
    }

    @Test
    void testUsarTicketNoLimite() {
        ticket.setNumUsos(2);
        assertTrue(ticket.usarTicket()); // Ainda há 1 uso restante
        ticket.atualizarNumUsos(); // usa o último
        assertFalse(ticket.usarTicket()); // Agora não deve mais permitir
    }
}
