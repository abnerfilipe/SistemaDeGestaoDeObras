package br.com.assistecnologia.gestaodeobras.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.assistecnologia.gestaodeobras.model.dao.FuncionarioDAO;

public class Funcionario {
    private long id;
    private String nome;
    private String cpf;
    private String matricula;
    private Usuario usuario;
    private Endereco endereco;
    private Sexo sexo;
    private Obra obra;
    private Cargo cargo;

    public Funcionario(){

    }

    public Funcionario(
        long id, 
        String nome, 
        String cpf, 
        String matricula, 
        Usuario usuario, 
        Endereco endereco,
        Sexo sexo, 
        Obra obra, 
        Cargo cargo
    ) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.usuario = usuario;
        this.endereco = endereco;
        this.sexo = sexo;
        this.obra = obra;
        this.cargo = cargo;

    }

    public Funcionario(String nome, String cpf, String matricula, Usuario usuario, Endereco endereco, Sexo sexo, Obra obra, Cargo cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.usuario = usuario;
        this.endereco = endereco;
        this.sexo = sexo;
        this.obra = obra;
        this.cargo = cargo;
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
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Sexo getSexo() {
        return sexo;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    public Obra getObra() {
        return obra;
    }
    public void setObra(Obra obra) {
        this.obra = obra;
    }
    public Cargo getCargo() {
        return cargo;
    }
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    // Override

    @Override
    public String toString() {
        return "[id: " + id + ", cargo: " + cargo + ", cpf: " + cpf + ", endereco: " + endereco + ", matricula: "
                + matricula + ", nome: " + nome + ", obra: " + obra + ", sexo: " + sexo + ", usuario: " + usuario + "]";
    }


}
