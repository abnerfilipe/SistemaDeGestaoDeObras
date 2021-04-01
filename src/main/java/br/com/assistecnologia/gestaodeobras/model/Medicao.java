package br.com.assistecnologia.gestaodeobras.model;

public class Medicao {
    long id;
    String nome;
    String unidade;

    public Medicao(long id, String nome, String unidade) {
        this.id = id;
        this.nome = nome;
        this.unidade = unidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
