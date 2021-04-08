package br.com.assistecnologia.gestaodeobras.model;

import java.util.Date;

public class Material {
    private long id;
    private String nome;
    private Double peso;
    private Date validade;
    private String descricao;
    private String observacao;

    public Material() {
    }

    public Material(long id, String nome, Double peso, Date validade, String descricao, String observacao) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.validade = validade;
        this.descricao = descricao;
        this.observacao = observacao;
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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
