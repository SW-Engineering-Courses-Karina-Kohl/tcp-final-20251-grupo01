import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap; 

enum DiaDaSemana {
    SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA
}

public class Cardapio {
    private Map<DiaDaSemana, List<String>> itens;

    public Cardapio(Map<DiaDaSemana, List<String>> itens) {
        this.itens = new HashMap<>();
        for (Map.Entry<DiaDaSemana, List<String>> entry : itens.entrySet()) {
            this.itens.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
    }

    //Getters e Setters
    public void setItens(Map<DiaDaSemana, List<String>> itens) {
        this.itens = new HashMap<>(itens); // Cria uma nova HashMap para segurança
    }

    public Map<DiaDaSemana, List<String>> getItens() {
        Map<DiaDaSemana, List<String>> copia = new HashMap<>();
        for (Map.Entry<DiaDaSemana, List<String>> entry : this.itens.entrySet()) {
            copia.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        return copia;
    }
}