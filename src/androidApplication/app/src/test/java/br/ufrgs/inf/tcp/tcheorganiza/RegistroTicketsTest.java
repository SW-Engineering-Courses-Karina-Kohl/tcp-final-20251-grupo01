import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RegistroTicketsTest {

    private RegistroTickets registro;

    @BeforeEach
    public void setUp() {
        registro = new RegistroTickets();
    }

    @Test
    public void testRegistrarTickets() {
        Ticket ticket = new Ticket("ABC123", LocalDate.now(), 3);
        registro.registrarTickets(ticket);

        List<Ticket> lista = registro.getListaTickets();
        assertEquals(1, lista.size());
        assertEquals(3, registro.getNumeroTotalTicketsDisponiveis());
    }

    @Test
    public void testUtilizarTicketComSucesso() {
        Ticket ticket = new Ticket("XYZ789", LocalDate.now(), 2);
        registro.registrarTickets(ticket);

        boolean usado1 = registro.utilizarTicket("XYZ789");
        boolean usado2 = registro.utilizarTicket("XYZ789");
        boolean usado3 = registro.utilizarTicket("XYZ789"); // Deve falhar

        assertTrue(usado1);
        assertTrue(usado2);
        assertFalse(usado3);

        assertEquals(0, registro.getNumeroTotalTicketsDisponiveis());
    }

    @Test
    public void testUtilizarTicketCodigoIncorreto() {
        Ticket ticket = new Ticket("VALIDO", LocalDate.now(), 1);
        registro.registrarTickets(ticket);

        boolean usado = registro.utilizarTicket("INVALIDO");

        assertFalse(usado);
        assertEquals(1, registro.getNumeroTotalTicketsDisponiveis());
    }

    @Test
    public void testRemoverTicketsUtilizados() {
        Ticket ticket1 = new Ticket("TICKET1", LocalDate.now(), 1);
        Ticket ticket2 = new Ticket("TICKET2", LocalDate.now(), 2);

        registro.registrarTickets(ticket1);
        registro.registrarTickets(ticket2);

        registro.utilizarTicket("TICKET1"); // Usar o único ticket disponível
        registro.removerUtilizados();

        List<Ticket> lista = registro.getListaTickets();
        assertEquals(1, lista.size());
        assertEquals("TICKET2", lista.get(0).getCodigo());
    }
}
