import java.util.List;
import java.util.Map;
import java.util.HashMap; 

enum DiaDaSemana {
    SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA
}

public class Cardapio {
    private Map<DiaDaSemana, List<String>> itens;

    public Cardapio(Map<DiaDaSemana, List<String>> itens) {
        this.itens = new HashMap<>(itens);;
    }

    //Getters e Setters
    public void setItens(Map<DiaDaSemana, List<String>> itens) {
        this.itens = new HashMap<>(itens); // Cria uma nova HashMap para segurança
    }

    public Map<DiaDaSemana, List<String>> getItens() {
        return new HashMap<>(this.itens);
    }
}