package br.com.assistecnologia.gestaodeobras.model;

public class Material {
    private long id;
    private String nome;
    private double peso;
    private String descricao;
    private String observacao;
    private Almoxarifado almoxarifado;

    public Material(String nome, double peso, String descricao, String observacao, Almoxarifado almoxarifado){
        this.nome = nome;
        this.peso = peso;
        this.descricao = descricao;
        this.observacao = observacao;
        this.almoxarifado = almoxarifado;
    }

    public Material(
        long id, 
        String nome, 
        Double peso, 
        String descricao, 
        String observacao, 
        Almoxarifado almoxarifado
    ){
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.descricao = descricao;
        this.observacao = observacao;
        this.almoxarifado = almoxarifado;
    }

    public Material() {

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

    public Almoxarifado getAlmoxarifado() {
        return almoxarifado;
    }

    public void setAlmoxarifado(Almoxarifado almoxarifado) {
        this.almoxarifado = almoxarifado;
    }


    // Overrides


    @Override
    public String toString() {
        return "[id: " + id + ", almoxarifado: " + almoxarifado.toString() + ", descricao: " + descricao + ", nome: " + nome
                + ", observacao: " + observacao + ", peso: " + peso + "]";
    }


}
