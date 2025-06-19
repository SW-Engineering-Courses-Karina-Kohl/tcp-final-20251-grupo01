import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HorarioFuncionamento {

    private LocalTime horarioAbertura;
    private LocalTime horarioFechamento;

    public HorarioFuncionamento(LocalTime horarioAbertura, LocalTime horarioFechamento) {
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
    }

    // Getters e Setters
    public void setHorarioAbertura(LocalTime novoHorarioAbertura) {
        this.horarioAbertura = novoHorarioAbertura;
    }

    public LocalTime getHorarioAbertura() {
        return horarioAbertura;
    }

    public void setHorarioFechamento(LocalTime novoHorarioFechamento) {
        this.horarioFechamento = novoHorarioFechamento;
    }

    public LocalTime getHorarioFechamento() {
        return horarioFechamento;
    }

    public boolean isDentroDoHorario(LocalTime hora) {
        return !hora.isBefore(horarioAbertura) && hora.isBefore(horarioFechamento);
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return horarioAbertura.format(formatter) + " - " + horarioFechamento.format(formatter);
    }
}
