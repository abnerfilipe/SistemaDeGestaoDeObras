package br.com.assistecnologia.gestaodeobras.model;

import java.util.ArrayList;

public class Almoxarifado {
    private long id;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Material> materiais;


    public Almoxarifado() {
    }

    public Almoxarifado(long id, ArrayList<Funcionario> funcionarios, ArrayList<Material> materiais) {
        this.id = id;
        this.funcionarios = funcionarios;
        this.materiais = materiais;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(ArrayList<Material> materiais) {
        this.materiais = materiais;
    }
}
