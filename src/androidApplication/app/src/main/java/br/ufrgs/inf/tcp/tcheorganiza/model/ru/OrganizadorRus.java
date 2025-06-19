package br.ufrgs.inf.tcp.tcheorganiza.model.ru;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.time.LocalTime;

import java.io.IOException;
import java.util.*;

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

    private DiaDaSemana padronizaDia(String texto) {
        String base = texto.toUpperCase()
            .replace("-FEIRA", "")    // remove "-FEIRA"
            .replace("Ç", "C")        // remove cedilha
            .replace("Á", "A")
            .replace("É", "E")
            .replace("Ê", "E")
            .replace("Í", "I")
            .replace("Ó", "O")
            .replace("Ú", "U")
            .replace("Ã", "A")
            .replace("Õ", "O")
            .trim();
    
        return DiaDaSemana.valueOf(base);
    }

    public void carregarRusDoSite(String url) {
        try {
            // Garante que a lista de RUs está vazia antes de adicionar os RUs do site
            this.listaRus.clear();

            // Extrai HTML e tabelas da página
            Document doc = Jsoup.connect(url).get();
            Elements tables = doc.select("table");
    
            int ruIndex = 0;
            boolean isAlmoco = true;
            int tabelasExtras = 0;
    
            Ru ruAtual = null;
    
            for (int i = tabelasExtras; i < tables.size(); i++) {
                Element table = tables.get(i);

                // Linhas da tabela
                Elements rows = table.select("tr");
    
                if (rows.isEmpty()) continue;
    
                // Extrai os dias da semana da primeira linha da tabela (header) 
                List<String> diasSemana = new ArrayList<>();
                Elements celulasDias = rows.get(0).select("td, th");
                for (Element celula : celulasDias) {
                    String diaSemana = celula.text().trim(); // Remove apenas espaços em branco
                    diasSemana.add(diaSemana);
                }
    
                // Converte dias da semana para o padrão Enum
                Map<DiaDaSemana, List<String>> itensCardapio = new HashMap<>();
                List<DiaDaSemana> diasPadrao = new ArrayList<>(); 
    
                for (String dia : diasSemana) {
                    try {
                        DiaDaSemana diaEnum = padronizaDia(dia);
                        itensCardapio.put(diaEnum, new ArrayList<>());
                        diasPadrao.add(diaEnum);
                    } catch (IllegalArgumentException e) {
                        diasPadrao.add(null); // marca posição inválida
                    }
                }
    
                // Extrai intens do cardápio populando itensCardapio
                for (int r = 1; r < rows.size(); r++) {
                    Elements celulasItens = rows.get(r).select("td, th"); 
                    for (int c = 0; c < celulasItens.size() && c < diasPadrao.size(); c++) {
                        DiaDaSemana dia = diasPadrao.get(c);
                        if (dia != null) {
                            String item = celulasItens.get(c).text().trim();
                            if (!item.isEmpty()) {
                                itensCardapio.get(dia).add(item);
                            }
                        }
                    }
                }
    
                Cardapio cardapio = new Cardapio(itensCardapio);
    
                // Verifica se o cardárpio criado é de almoço ou janta
                if (isAlmoco) {
                    ruIndex++;
                    String nomeRU = String.format("RU%02d", ruIndex);
                    ruAtual = new Ru(nomeRU, null, null, null);
                    ruAtual.setCardapioAlmoco(cardapio);
                } else {
                    if (ruAtual != null) {
                        ruAtual.setCardapioJanta(cardapio);
                        this.adicionarRu(ruAtual);
                    }
                }
    
                isAlmoco = !isAlmoco;
    
            }
        } catch (IOException e) {
            System.out.println("Erro ao acessar o site: " + e.getMessage());
        }
    }

    public void atualizarDadosRUs() {
        for (Ru ru : this.listaRus) {
            String nome = ru.getNome();
    
            // Define localização conforme nome do Ru
            Localizacao local = new Localizacao(null, null, null, null);
            if (nome.equals("RU01")) {
                local = new Localizacao("Campus Centro", "Av. João Pessoa", "41", "Centro");
            } else if (nome.equals("RU02")) {
                local = new Localizacao("Campus Saúde", "Av. Ramiro Barcelo", "2500", "Santa Cecília");
            } else if (nome.equals("RU03")) {
                local = new Localizacao("Campus do Vale", "Av. Bento Gonçalves", "9500", "Agronomia");
            } else if (nome.equals("RU04")) {
                local = new Localizacao("Campus Agronomia", "Av. Bento Gonçalves", "7712", "Agronomia");
            } else if (nome.equals("RU05")) {
                local = new Localizacao("Campus ESEFID", "Felizardo", "750", "Jardim Botânico");
            } else if (nome.equals("RU06")) {
                local = new Localizacao("Campus do Vale", "Av. Bento Gonçalves", "9500", "Agronomia");
            }              
    
            // Define horários padrão para todos Rus
            HorarioFuncionamento horarioAlmoco = new HorarioFuncionamento(
                LocalTime.of(11, 0),
                LocalTime.of(14, 0)
            );

            HorarioFuncionamento horarioJanta = new HorarioFuncionamento(
                LocalTime.of(17, 30),
                LocalTime.of(19, 0)
            );

            // Atualiza os dados no RU
            ru.setLocalizacao(local);
            ru.setHorarioAlmoco(horarioAlmoco);
            ru.setHorarioJanta(horarioJanta);
        }
    }
     
}

