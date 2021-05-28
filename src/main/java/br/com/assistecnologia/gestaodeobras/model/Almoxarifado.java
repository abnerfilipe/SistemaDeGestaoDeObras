package br.com.assistecnologia.gestaodeobras.model;

import java.util.ArrayList;

import br.com.assistecnologia.gestaodeobras.model.dao.AlmoxarifadoDAO;

public class Almoxarifado {
    private long id;
    private String nome;
    private Obra obra;
    private ArrayList<Material> materiais;

    public Almoxarifado() {

    }

    public Almoxarifado(String nome, Obra obra) {
        this.nome = nome;
        this.obra = obra;
    }
    public Almoxarifado(Long id, String nome, Obra obra) {
        this.id = id;
        this.nome = nome;
        this.obra = obra;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
   @Override
    public String toString() {
        return "[id=" + id + ", nome=" + nome + ", obra=" + obra + "]";
    }

    
}
