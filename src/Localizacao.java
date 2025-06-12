// Localizacao.java
public class Localizacao {
    private String campus;
    private String rua;
    private String numero;
    private String bairro;
    
    public Localizacao(String campus, String rua, String numero, String bairro) {
        this.campus = campus;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
    }

    // Getters e Setters
    public String getCampus() { 
        return this.campus;
    }

    public String getRua() {
        return this.rua;
    }

    public String getNumero() {
        return this.numero;
    }

    public String getBairro() { 
        return this.bairro; 
    }

    @Override
    public String toString() {
        return this.rua + ", " + this.numero + " - " + this.bairro + " (" + this.campus + ")";
    }
}
