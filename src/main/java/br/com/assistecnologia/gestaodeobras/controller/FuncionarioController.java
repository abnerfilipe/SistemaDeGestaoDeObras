package br.com.assistecnologia.gestaodeobras.controller;

import br.com.assistecnologia.gestaodeobras.model.*;
import br.com.assistecnologia.gestaodeobras.model.dao.CargoDAO;
import br.com.assistecnologia.gestaodeobras.model.dao.EnderecoDAO;
import br.com.assistecnologia.gestaodeobras.model.dao.FuncionarioDAO;
import br.com.assistecnologia.gestaodeobras.model.dao.ObraDAO;
import br.com.assistecnologia.gestaodeobras.model.dao.UsuarioDAO;

import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {


    public List<Funcionario> index() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.all();
    }

    public Funcionario show(long id) {
        if(id <= 0 ){
            System.err.println("O id nao pode ser nulo!");
            return null;
        }
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return  funcionarioDAO.read(id).get();
    }
    
    public Funcionario edit(
        long id, 
        String nome,
        String cpf,
        String matricula,
        Usuario usuario,
        Endereco endereco,
        Sexo sexo,
        Obra obra,
        Cargo cargo
    ){
        try {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            EnderecoDAO enderecoDAO =new EnderecoDAO();
            ObraDAO obraDAO = new ObraDAO();
            CargoDAO cargoDAO = new CargoDAO();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            
            boolean passed = false;
            if(id > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O id nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(nome != null && nome.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O nome nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(cpf != null && cpf.length() >= 11 &&cpf.length() <= 14){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O cpf nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(matricula != null && matricula.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O descricao nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(sexo != null ){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O sexo nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(usuarioDAO.read(usuario.getId()).isPresent()){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O usuario nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(cargoDAO.read(cargo.getId()).isPresent()){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O cargo nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(obraDAO.read(obra.getId()).isPresent()){
                passed = true;
            }
            if(passed == false){
                throw new Exception("A obra nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(cargoDAO.read(cargo.getId()).isPresent()){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O cargo nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(enderecoDAO.read(endereco.getId()).isPresent()){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O endereco nao pode ser nulo e deve ser valido!");
            }

            Funcionario item= new Funcionario(
                id, 
                nome,
                cpf,
                matricula,
                usuario,
                endereco,
                sexo,
                obra,
                cargo
            );
            return funcionarioDAO.edit(item);
        } catch (Exception e) {
            System.err.println("Erro ao editar :\t" + e.getMessage());
            return null;
        }
    }
    public Funcionario create(
        String nome,
        String cpf,
        String matricula,
        Usuario usuario,
        Endereco endereco,
        Sexo sexo,
        Obra obra,
        Cargo cargo
    ){
        try {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            EnderecoDAO enderecoDAO =new EnderecoDAO();
            ObraDAO obraDAO = new ObraDAO();
            CargoDAO cargoDAO = new CargoDAO();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            
            boolean passed = false;
            passed = false;
            if(nome != null && nome.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O nome nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(cpf != null && cpf.length() >= 11 &&cpf.length() <= 14){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O cpf nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(matricula != null && matricula.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O descricao nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(sexo != null){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O sexo nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(usuarioDAO.read(usuario.getId()).isPresent()){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O usuario nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(cargoDAO.read(cargo.getId()).isPresent()){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O cargo nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(obraDAO.read(obra.getId()).isPresent()){
                passed = true;
            }
            if(passed == false){
                throw new Exception("A obra nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(cargoDAO.read(cargo.getId()).isPresent()){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O cargo nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(enderecoDAO.read(endereco.getId()).isPresent()){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O endereco nao pode ser nulo e deve ser valido!");
            }

            Funcionario item= new Funcionario(nome,cpf,matricula,usuario,endereco,sexo,obra,cargo);
            return funcionarioDAO.create(item);
        } catch (Exception e) {
            System.err.println("Erro ao criar :\t" + e.getMessage());
            return null;
        }
    }
  

    public boolean delete(long id) {
        if(id <= 0){
            System.err.println("O id nao pode ser nulo ou inexistente!");
            return false;
        }
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.delete(id);
    }
}
