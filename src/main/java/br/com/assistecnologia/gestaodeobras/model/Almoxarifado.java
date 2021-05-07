package br.com.assistecnologia.gestaodeobras.model;

import java.util.ArrayList;

import br.com.assistecnologia.gestaodeobras.model.dao.AlmoxarifadoDAO;

public class Almoxarifado {
    private long id;
    private Obra obra;
    private ArrayList<Material> materiais;
    private AlmoxarifadoDAO almoxarifadoDAO;

    public Almoxarifado() {
        this.almoxarifadoDAO = new AlmoxarifadoDAO();
    }

    public Almoxarifado(long id, ArrayList<Funcionario> funcionarios, ArrayList<Material> materiais, Obra obra) {
        this.id = id;
        this.funcionarios = funcionarios;
        this.materiais = materiais;
        this.obra = obra;
        this.almoxarifadoDAO = new AlmoxarifadoDAO();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(ArrayList<Material> materiais) {
        this.materiais = materiais;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    @Override
    public String toString() {
        return "Almoxarifado [id=" + id + ", obra=" + obra + "]";
    }
    

    
    // methods
}
