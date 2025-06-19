public class Ru {
    private String nome;
    private Localizacao localizacao;
    private HorarioFuncionamento horarioAlmoco;
    private HorarioFuncionamento horarioJanta;
    private Cardapio cardapioAlmoco;
    private Cardapio cardapioJanta;

    public Ru(String nome, Localizacao localizacao, HorarioFuncionamento horarioAlmoco, HorarioFuncionamento horarioJanta) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.horarioAlmoco = horarioAlmoco;
        this.horarioJanta = horarioJanta;
    }

    // Getters e Setters
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public String getNome() {
        return nome;
    }

    public void setLocalizacao(Localizacao novaLocalizacao) {
        this.localizacao = novaLocalizacao;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setHorarioAlmoco(HorarioFuncionamento novoHorarioAlomoco) {
        this.horarioAlmoco = novoHorarioAlomoco;
    }

    public HorarioFuncionamento getHorarioAlmoco() {
        return horarioAlmoco;
    }

    public void setHorarioJanta(HorarioFuncionamento novoHorarioJanta) {
        this.horarioJanta = novoHorarioJanta;
    }

    public HorarioFuncionamento getHorarioJanta() {
        return horarioJanta;
    }

    public void setCardapioAlmoco(Cardapio novoCardapioAlmoco) {
        this.cardapioAlmoco = novoCardapioAlmoco;
    }

    public Cardapio getCardapioAlmoco() {
        return cardapioAlmoco;
    }

    public void setCardapioJanta(Cardapio novoCardapioJanta) {
        this.cardapioJanta = novoCardapioJanta;
    }

    public Cardapio getCardapioJanta() {
        return cardapioJanta;
    }
}