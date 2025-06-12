import java.util.ArrayList;
import java.util.List;

public class RegistroTickets {

    private List<Ticket> listaTickets;
    private int numTicketsDisponiveis; 

    public RegistroTickets() {
        this.listaTickets = new ArrayList<>();
        this.numTicketsDisponiveis = 0;
    }

    // Setters
    public List<Ticket> getListaTickets() {
        return this.listaTickets;
    }

    public int getNumeroTotalTicketsDisponiveis() {
        return this.numTicketsDisponiveis;
    }

    public void registrarTickets(Ticket ticket) {
        this.listaTickets.add(ticket);
        numTicketsDisponiveis += ticket.getQuantidade();
    }

    public boolean utilizarTicket(String codigoTicket) {
        for (Ticket ticket : listaTickets) {
            if (ticket.getCodigo() == codigoTicket) {
                if (ticket.usarTicket()) { 
                    numTicketsDisponiveis--;
                    return true;
                }
            }
        }
        return false;
    }

    public void removerUtilizados() {
        for (int i = this.listaTickets.size() - 1; i >= 0; i--) {
            Ticket ticket = this.listaTickets.get(i);

            if (ticket.getNumUsos() <= 0) {
                this.listaTickets.remove(i); 
            }
        }
    }
}
