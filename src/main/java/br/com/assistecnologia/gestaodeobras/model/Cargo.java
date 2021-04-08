package br.com.assistecnologia.gestaodeobras.model;

public class Cargo {
    private long id;
    private String nome;


    public Cargo() {
    }

    public Cargo(String nome) {
        this.nome = nome;
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
}
