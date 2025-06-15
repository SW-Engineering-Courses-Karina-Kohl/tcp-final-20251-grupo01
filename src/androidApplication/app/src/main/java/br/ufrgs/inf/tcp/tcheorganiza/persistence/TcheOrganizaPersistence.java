package br.ufrgs.inf.tcp.tcheorganiza.persistence;

public class TcheOrganizaPersistence {

    // Singleton pattern 
    // https://refactoring.guru/design-patterns/singleton
    private static volatile TcheOrganizaPersistence instance;

    private TcheOrganizaPersistence() {
    }

    public static TcheOrganizaPersistence getInstance() {
        if (instance == null) {
            synchronized (TcheOrganizaPersistence.class) {
                if (instance == null) {
                    instance = new TcheOrganizaPersistence();
                }
            }
        }
        return instance;
    }

    // Atributos compartilhados
    public RegistroTickets registroTickets = new RegistroTickets();
    
}

// Exemplo de uso
/*

import br.ufrgs.inf.tcp.tcheorganiza.persistence.TcheOrganizaPersistence;
import br.ufrgs.inf.tcp.tcheorganiza.persistence.RegistroTickets;

public class Main {
    public static void main(String[] args) {
        // Obtendo a instância única
        TcheOrganizaPersistence persistence = TcheOrganizaPersistence.getInstance();

        // Usando o atributo compartilhado
        RegistroTickets tickets = persistence.registroTickets;

        // Listando os tickets
        System.out.println("Tickets registrados:");
        for (String ticket : tickets.getListaTickets()) {
            System.out.println(ticket);
        }
    }
}

 */