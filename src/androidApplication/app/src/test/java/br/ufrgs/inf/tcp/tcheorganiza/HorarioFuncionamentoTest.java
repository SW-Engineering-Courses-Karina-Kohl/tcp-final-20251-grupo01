package br.ufrgs.inf.tcp.tcheorganiza;

import br.ufrgs.inf.tcp.tcheorganiza.model.ru.*;

import org.junit.jupiter.api.Test;
import org.threeten.bp.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class HorarioFuncionamentoTest {

    @Test
    public void testGettersAndSetters() {
        LocalTime abertura = LocalTime.of(8, 0);
        LocalTime fechamento = LocalTime.of(18, 0);
        HorarioFuncionamento horario = new HorarioFuncionamento(abertura, fechamento);

        assertEquals(abertura, horario.getHorarioAbertura());
        assertEquals(fechamento, horario.getHorarioFechamento());

        // Alterar horários
        LocalTime novaAbertura = LocalTime.of(9, 0);
        LocalTime novoFechamento = LocalTime.of(17, 30);
        horario.setHorarioAbertura(novaAbertura);
        horario.setHorarioFechamento(novoFechamento);

        assertEquals(novaAbertura, horario.getHorarioAbertura());
        assertEquals(novoFechamento, horario.getHorarioFechamento());
    }

    @Test
    public void testIsDentroDoHorario() {
        HorarioFuncionamento horario = new HorarioFuncionamento(
            LocalTime.of(10, 0),
            LocalTime.of(14, 0)
        );

        // Hora dentro do intervalo
        assertTrue(horario.isDentroDoHorario(LocalTime.of(10, 0)));
        assertTrue(horario.isDentroDoHorario(LocalTime.of(13, 59)));

        // Hora fora do intervalo
        assertFalse(horario.isDentroDoHorario(LocalTime.of(9, 59)));
        assertFalse(horario.isDentroDoHorario(LocalTime.of(14, 0)));
        assertFalse(horario.isDentroDoHorario(LocalTime.of(15, 0)));
    }

    @Test
    public void testToStringFormat() {
        HorarioFuncionamento horario = new HorarioFuncionamento(
            LocalTime.of(11, 30),
            LocalTime.of(13, 15)
        );
        assertEquals("11:30 - 13:15", horario.toString());
    }
}
