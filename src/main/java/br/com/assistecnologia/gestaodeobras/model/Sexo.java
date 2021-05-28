package br.com.assistecnologia.gestaodeobras.model;

public enum Sexo {
    Feminino("Feminino"),
    Masculino("Masculino");

    private String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
