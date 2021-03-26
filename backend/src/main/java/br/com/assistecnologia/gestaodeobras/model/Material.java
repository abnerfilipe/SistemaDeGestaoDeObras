package br.com.assistecnologia.gestaodeobras.model;

import java.util.Date;

public class Material {
    long id;
    String nome;
    Double peso;
    Date validade;
    TipoMaterial tipoMaterial;

    public Material(long id, String nome, Double peso, Date validade, TipoMaterial tipoMaterial) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.validade = validade;
        this.tipoMaterial = tipoMaterial;
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

    public TipoMaterial getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(TipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }
}
