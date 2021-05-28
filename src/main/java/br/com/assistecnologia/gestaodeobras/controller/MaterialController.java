package br.com.assistecnologia.gestaodeobras.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.assistecnologia.gestaodeobras.model.Almoxarifado;
import br.com.assistecnologia.gestaodeobras.model.Material;
import br.com.assistecnologia.gestaodeobras.model.dao.AlmoxarifadoDAO;
import br.com.assistecnologia.gestaodeobras.model.dao.MaterialDAO;

public class MaterialController {


    public List<Material> index() {
        MaterialDAO materialDAO = new MaterialDAO();
        return materialDAO.all();
    }

    public List<Material> showFrom(Almoxarifado almoxarifado) {
        MaterialDAO materialDAO = new MaterialDAO();
        AlmoxarifadoDAO almoxarifadoDAO = new AlmoxarifadoDAO();
        if(almoxarifado.getId() <= 0 || almoxarifadoDAO.read(almoxarifado.getId()).isEmpty()){
            System.err.println("O id nao pode ser nulo ou inexistente!");
            return null;
        }
        return materialDAO.allFromAlmoxarifado(almoxarifado.getId());
    }
    public Material show(long id){
        if(id <= 0 ){
            System.err.println("O id nao pode ser nulo!");
            return null;
        }
        MaterialDAO materialDAO = new MaterialDAO();
        return materialDAO.read(id).get();
    }

    public Material edit(
            Long id,
            String nome,
            Double peso,
            String descricao,
            String observacao,
            Almoxarifado almoxarifado
    ){
        try {
            MaterialDAO materialDAO = new MaterialDAO();
            AlmoxarifadoDAO almoxarifadoDAO = new AlmoxarifadoDAO();
            boolean passed = false;
            if(id != null && id > 0){
                passed = true;
            }
            if(passed == false){
                System.err.println("O id nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(nome != null && nome.length() > 0){
                passed = true;
            };
            if(passed == false){
                System.err.println("O nome nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(peso >= 0.0){
                passed = true;
            };
            if(passed == false){
                System.err.println("O peso nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(descricao != null && descricao.length() > 0){
                passed = true;
            };
            if(passed == false){
                System.err.println("A descricao nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(observacao != null && observacao.length() > 0){
                passed = true;
            };
            if(passed == false){
                System.err.println("A observacao nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(almoxarifadoDAO.read(almoxarifado.getId()).isPresent()){
                passed = true;
            };
            if(passed == false){
                System.err.println("O almoxarifado nao pode ser nulo e deve ser valido!");
            }
           
            Material item= new Material(id,nome,peso,descricao, observacao,almoxarifado);
            return materialDAO.edit(item);
        } catch (Exception e) {
            System.err.println("Erro ao editar :\t" + e.getMessage());
            return null;
        }
    }
    public Material create(String nome, double peso, String descricao, String observacao, Almoxarifado almoxarifado){
        try {
            MaterialDAO materialDAO = new MaterialDAO();
            AlmoxarifadoDAO almoxarifadoDAO = new AlmoxarifadoDAO();
            boolean passed = false;
            if(nome != null && nome.length() > 0){
                passed = true;
            };
            if(passed == false){
                System.err.println("O nome nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if( peso >= 0){
                passed = true;
            };
            if(passed == false){
                System.err.println("O peso nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(descricao != null && descricao.length() > 0){
                passed = true;
            };
            if(passed == false){
                System.err.println("A descricao nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(observacao != null && observacao.length() > 0){
                passed = true;
            };
            if(passed == false){
                System.err.println("A observacao nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(almoxarifadoDAO.read(almoxarifado.getId()).isPresent()){
                passed = true;
            };
            if(passed == false){
                System.err.println("O almoxarifado nao pode ser nulo e deve ser valido!");
            }
           
            Material item = new Material(nome,peso,descricao, observacao,almoxarifado);
            return materialDAO.create(item);
        } catch (Exception e) {
            System.err.println("Erro ao criar :" + e.getMessage());
            return null;
        }
    }
  
    public boolean delete(long id) {
        MaterialDAO materialDAO = new MaterialDAO();
        if(id <= 0  || materialDAO.read(id).isEmpty()){
            System.err.println("O id nao pode ser nulo ou vazio!");
            return false;
        }
        return materialDAO.delete(id);
    }

}
