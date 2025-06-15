package br.ufrgs.inf.tcp.tcheorganiza.model.ru;


import java.util.List;
import java.util.ArrayList;
import java.util.Collections; 
import java.util.Comparator; 

public class OrganizadorRus {
    private List<Ru> listaRus;
    private String nomeRuFavorito;

    public OrganizadorRus() {
        this.listaRus = new ArrayList<>();
        this.nomeRuFavorito = null;
    }

    // Getters e Setters
    public void setNomeRuFavorito(String novoNomeRuFavorito) {
        this.nomeRuFavorito = novoNomeRuFavorito;
    }

    public String getNomeRuFavorito() {
        return this.nomeRuFavorito;
    }

    public List<Ru> getRus() {
        return this.listaRus;
    }

    public void adicionarRu(Ru novoRu) {
        this.listaRus.add(novoRu);

        // Ordena após adicionar um novo Ru
        Collections.sort(this.listaRus, new Comparator<Ru>() {
            @Override
            public int compare(Ru ru1, Ru ru2) {
                return ru1.getNome().compareTo(ru2.getNome());
            }
        });
    }

    public Ru buscarRU(String nomeRu) {
        Ru ruEncontrado = null;
    
        for (int i = 0; i < this.listaRus.size(); i++) {
            Ru ruAtual = this.listaRus.get(i);
            if (ruAtual.getNome().equals(nomeRu)) {
                ruEncontrado = ruAtual;
                return ruEncontrado;
            }
        }

        throw new RuNaoEncontradoException(nomeRu + " não existe");
    }

    public boolean removerRU(String nomeRu) {
        boolean removido = false;
    
        try {
            int indice = -1;
    
            for (int i = 0; i < this.listaRus.size(); i++) { // Considerando que não existem RUs repetidos
                Ru ruAtual = this.listaRus.get(i);
                if (ruAtual.getNome().equals(nomeRu)) {
                    indice = i;
                    break;
                }
            }
    
            this.listaRus.remove(indice);
            removido = true;
    
        } catch (IndexOutOfBoundsException e) {
            removido = false;
        } 
        
        return removido;
    }  
}

