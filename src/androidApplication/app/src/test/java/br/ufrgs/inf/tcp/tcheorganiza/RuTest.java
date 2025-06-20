package br.ufrgs.inf.tcp.tcheorganiza;

import br.ufrgs.inf.tcp.tcheorganiza.model.ru.DiaDaSemana;
import br.ufrgs.inf.tcp.tcheorganiza.model.ru.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class RuTest {

    private Ru ru;
    private Localizacao localizacao;
    private HorarioFuncionamento horarioAlmoco;
    private HorarioFuncionamento horarioJanta;
    private Cardapio cardapioAlmoco;
    private Cardapio cardapioJanta;

    @BeforeEach
    void setUp() {
        localizacao = new Localizacao("Campus Centro", "Av. Principal", "123", "Centro");
        horarioAlmoco = new HorarioFuncionamento(LocalTime.of(11, 0), LocalTime.of(14, 0));
        horarioJanta = new HorarioFuncionamento(LocalTime.of(18, 0), LocalTime.of(21, 0));

        Map<DiaDaSemana, List<String>> itensAlmoco = new HashMap<>();
        itensAlmoco.put(DiaDaSemana.SEGUNDA, Arrays.asList("Arroz", "Feijão", "Frango grelhado"));

        Map<DiaDaSemana, List<String>> itensJanta = new HashMap<>();
        itensJanta.put(DiaDaSemana.SEGUNDA, Arrays.asList("Sopa", "Pão", "Suco"));

        cardapioAlmoco = new Cardapio(itensAlmoco);
        cardapioJanta = new Cardapio(itensJanta);

        ru = new Ru("RU Central", localizacao, horarioAlmoco, horarioJanta);
    }

    @Test
    void testGetNome() {
        assertEquals("RU Central", ru.getNome());
    }

    @Test
    void testSetNome() {
        ru.setNome("RU Norte");
        assertEquals("RU Norte", ru.getNome());
    }

    @Test
    void testGetLocalizacao() {
        assertEquals("Campus Centro", ru.getLocalizacao().getCampus());
        assertEquals("Av. Principal", ru.getLocalizacao().getRua());
    }

    @Test
    void testSetLocalizacao() {
        Localizacao nova = new Localizacao("Campus Sul", "Rua Nova", "456", "Bairro Novo");
        ru.setLocalizacao(nova);
        assertEquals("Campus Sul", ru.getLocalizacao().getCampus());
    }

    @Test
    void testGetHorarioAlmoco() {
        assertEquals(LocalTime.of(11, 0), ru.getHorarioAlmoco().getHorarioAbertura());
    }

    @Test
    void testSetHorarioAlmoco() {
        HorarioFuncionamento novo = new HorarioFuncionamento(LocalTime.of(12, 0), LocalTime.of(15, 0));
        ru.setHorarioAlmoco(novo);
        assertEquals(LocalTime.of(12, 0), ru.getHorarioAlmoco().getHorarioAbertura());
    }

    @Test
    void testGetHorarioJanta() {
        assertEquals(LocalTime.of(18, 0), ru.getHorarioJanta().getHorarioAbertura());
    }

    @Test
    void testSetHorarioJanta() {
        HorarioFuncionamento novo = new HorarioFuncionamento(LocalTime.of(19, 0), LocalTime.of(22, 0));
        ru.setHorarioJanta(novo);
        assertEquals(LocalTime.of(19, 0), ru.getHorarioJanta().getHorarioAbertura());
    }

    @Test
    void testSetAndGetCardapioAlmoco() {
        ru.setCardapioAlmoco(cardapioAlmoco);
        Map<DiaDaSemana, List<String>> itens = ru.getCardapioAlmoco().getItens();
        assertTrue(itens.containsKey(DiaDaSemana.SEGUNDA));
        assertEquals(Arrays.asList("Arroz", "Feijão", "Frango grelhado"), itens.get(DiaDaSemana.SEGUNDA));
    }

    @Test
    void testSetAndGetCardapioJanta() {
        ru.setCardapioJanta(cardapioJanta);
        Map<DiaDaSemana, List<String>> itens = ru.getCardapioJanta().getItens();
        assertTrue(itens.containsKey(DiaDaSemana.SEGUNDA));
        assertEquals(Arrays.asList("Sopa", "Pão", "Suco"), itens.get(DiaDaSemana.SEGUNDA));
    }
}
