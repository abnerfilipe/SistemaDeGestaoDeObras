package br.com.assistecnologia.gestaodeobras.model;

public class Modelo {
    long id;
    String nome;
    Fabricante fabricante;

    public Modelo(long id, String nome, Fabricante fabricante) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
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

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
