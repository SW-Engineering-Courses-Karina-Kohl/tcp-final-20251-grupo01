package br.ufrgs.inf.tcp.tcheorganiza.model.ru;

import java.util.ArrayList;
import java.util.List;

public class RegistroTickets {

    private List<Ticket> listaTickets;
    private int numTicketsDisponiveis; 

    public RegistroTickets() {
        this.listaTickets = new ArrayList<>();
        this.numTicketsDisponiveis = 0;
    }

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
            if (ticket.getCodigo().equals(codigoTicket)) {
                if (ticket.usarTicket()) { 
                    ticket.atualizarNumUsos();  // <-- Adicione isto
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
    
            if (ticket.getNumUsos() >= ticket.getQuantidade()) {
                this.listaTickets.remove(i); 
            }
        }
    }
}
