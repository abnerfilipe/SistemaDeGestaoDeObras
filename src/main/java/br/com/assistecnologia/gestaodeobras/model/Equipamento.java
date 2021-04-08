package br.com.assistecnologia.gestaodeobras.model;

import java.util.ArrayList;

public class Equipamento {
    private long id;
    private String nome;
    private String identificacao;
    private  Double tanque;
    private Combustivel tipo_combustivel;
    private Obra obra;
    private Modelo modelo;
    private Categoria categoria;
    private EquipamentoStatus status;
    private ArrayList<Condutor> condutores;



    public Equipamento(long id, String nome, String identificacao, Double tanque, Combustivel tipo_combustivel, Obra obra, Modelo modelo, Categoria categoria, EquipamentoStatus status) {
        this.id = id;
        this.nome = nome;
        this.identificacao = identificacao;
        this.tanque = tanque;
        this.tipo_combustivel = tipo_combustivel;
        this.obra = obra;
        this.modelo = modelo;
        this.categoria = categoria;
        this.status = status;
    }

    public ArrayList<Condutor> getCondutores() {
        return condutores;
    }

    public void setCondutores(ArrayList<Condutor> condutores) {
        this.condutores = condutores;
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

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Double getTanque() {
        return tanque;
    }

    public void setTanque(Double tanque) {
        this.tanque = tanque;
    }

    public Combustivel getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(Combustivel tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public EquipamentoStatus getStatus() {
        return status;
    }

    public void setStatus(EquipamentoStatus status) {
        this.status = status;
    }
}
