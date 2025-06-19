package br.ufrgs.inf.tcp.tcheorganiza;

import br.ufrgs.inf.tcp.tcheorganiza.model.ru.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CardapioTest {

    private Cardapio cardapio;
    private Map<DiaDaSemana, List<String>> dadosIniciais;

    @BeforeEach
    public void setUp() {
        dadosIniciais = new HashMap<>();
        dadosIniciais.put(DiaDaSemana.SEGUNDA, new ArrayList<>(Arrays.asList("Arroz", "Feijão", "Frango")));
        dadosIniciais.put(DiaDaSemana.TERCA, new ArrayList<>(Arrays.asList("Macarrão", "Carne Moída")));

        cardapio = new Cardapio(dadosIniciais);
    }

    @Test
    public void testGetItensRetornaCopia() {
        Map<DiaDaSemana, List<String>> itens = cardapio.getItens();

        // Modificar o mapa retornado não deve afetar o original
        itens.get(DiaDaSemana.SEGUNDA).add("Batata");

        assertNotEquals(itens, cardapio.getItens(), "Deve retornar uma cópia defensiva");
    }

    @Test
    public void testConstrutorCriaCopiaDefensiva() {
        dadosIniciais.get(DiaDaSemana.SEGUNDA).add("Farofa");
        Map<DiaDaSemana, List<String>> itens = cardapio.getItens();

        // A modificação em não deve afetar o cardápio
        assertFalse(itens.get(DiaDaSemana.SEGUNDA).contains("Farofa"));
    }
}
