package br.com.assistecnologia.gestaodeobras.model;

public class Categoria {
    long id;
    String nome;
    Boolean validar_valor_medicao;
    Medicao medicao;

    public Categoria(long id, String nome, Boolean validar_valor_medicao, Medicao medicao) {
        this.id = id;
        this.nome = nome;
        this.validar_valor_medicao = validar_valor_medicao;
        this.medicao = medicao;
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

    public Boolean getValidar_valor_medicao() {
        return validar_valor_medicao;
    }

    public void setValidar_valor_medicao(Boolean validar_valor_medicao) {
        this.validar_valor_medicao = validar_valor_medicao;
    }

    public Medicao getMedicao() {
        return medicao;
    }

    public void setMedicao(Medicao medicao) {
        this.medicao = medicao;
    }
}
