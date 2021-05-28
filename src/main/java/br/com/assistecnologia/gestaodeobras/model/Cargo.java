package br.com.assistecnologia.gestaodeobras.model;

import java.util.List;
import java.util.Optional;

import br.com.assistecnologia.gestaodeobras.model.dao.CargoDAO;

public class Cargo {
    private long id;
    private String nome;

    public Cargo() {

    }

    public Cargo(String nome) {

        this.nome = nome;
    }

    public Cargo(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

  

    // Overrides
    @Override
    public String toString() {
        return "[id: " + id + ", nome: " + nome + "]";
    }

  
} 
