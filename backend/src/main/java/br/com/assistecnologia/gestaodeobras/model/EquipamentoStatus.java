package br.com.assistecnologia.gestaodeobras.model;

public enum EquipamentoStatus {
    Garagem("Garagem"),
    EmServico("Em Serviço"),
    EmManutencao("Em Mantutenção"),
    EmTransferencia("Em Transferência");

    private String descricao;

    EquipamentoStatus(String descricao) {
        this.descricao =descricao;
    }

    public String getStatus() {
        return descricao;
    }
}
