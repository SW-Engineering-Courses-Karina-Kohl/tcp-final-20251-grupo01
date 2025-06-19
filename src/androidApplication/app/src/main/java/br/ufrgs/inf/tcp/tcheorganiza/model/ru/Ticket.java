import java.time.LocalDate;

public class Ticket {

    private String codigo; 
    private LocalDate dataCompra;
    private int quantidade;
    private int numUsos; 

    public Ticket(String codigo, LocalDate dataCompra, int quantidade) {
        this.codigo = codigo;
        this.dataCompra = dataCompra;
        this.quantidade = quantidade;
        this.numUsos = 0; 
    }

    // Getters e Setters
    public void setCodigo(String novoCodigo) {
        this.codigo = novoCodigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setDataCompra(LocalDate novaDataCompra) {
        this.dataCompra = novaDataCompra;
    }

    public LocalDate getDataCompra() {
        return this.dataCompra;
    }

    public void setQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setNumUsos(int novoNumUsos) {
        this.numUsos = novoNumUsos;
    }

    public int getNumUsos() {
        return this.numUsos;
    }

    public boolean usarTicket() {
        if(this.quantidade - this.numUsos > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void atualizarNumUsos() {
        this.numUsos ++;
    }
}
