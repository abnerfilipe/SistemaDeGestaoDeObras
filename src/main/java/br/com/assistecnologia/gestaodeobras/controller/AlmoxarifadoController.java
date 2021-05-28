package br.com.assistecnologia.gestaodeobras.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.assistecnologia.gestaodeobras.model.Almoxarifado;
import br.com.assistecnologia.gestaodeobras.model.Obra;
import br.com.assistecnologia.gestaodeobras.model.dao.AlmoxarifadoDAO;
import br.com.assistecnologia.gestaodeobras.model.dao.ObraDAO;

public class AlmoxarifadoController {

    public List<Almoxarifado> index(){
        AlmoxarifadoDAO itemDAO = new AlmoxarifadoDAO();
        return itemDAO.all();
    }
    public List<Almoxarifado> showFrom(Obra obra){
        if(obra.getId() <= 0){
            System.err.println("O id nao pode ser nulo !");
            return null;
        }
        AlmoxarifadoDAO itemDAO = new AlmoxarifadoDAO();
        return itemDAO.allFromObra(obra.getId());
    }

    public Almoxarifado show(long id){
        if(id <= 0 ){
            System.err.println("O id nao pode ser nulo!");
            return null;
        }
        AlmoxarifadoDAO itemDAO = new AlmoxarifadoDAO();
        return itemDAO.read(id).get();
    }
  

    public Almoxarifado edit(Long id, String nome, Obra obra){
        try {
            AlmoxarifadoDAO almoxarifadoDAO = new AlmoxarifadoDAO();
            ObraDAO obraDAO = new ObraDAO();
            boolean passed = false;
            if(id != null && nome.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O id nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(nome != null && nome.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O nome nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(obraDAO.read(obra.getId()).isPresent()){
                passed = true;
            };
            if(passed == false){
                throw new Exception("A obra nao pode ser nulo e deve ser valido!");
            }
            Almoxarifado item= new Almoxarifado(id,nome,obra);
            return almoxarifadoDAO.edit(item);
        } catch (Exception e) {
            System.err.println("Erro ao editar :\t" + e.getMessage());
            return null;
        }
    }
    public Almoxarifado create(String nome, Obra obra){
        try {
            boolean passed = false;
            if(nome != null && nome.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O nome nao pode ser nulo !");
            }
            passed = false;
            if(obra.getId() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("A obra nao pode ser nulo !");
            }
            AlmoxarifadoDAO itemDAO = new AlmoxarifadoDAO();
            Almoxarifado item= new Almoxarifado(nome,obra);
            return itemDAO.create(item);
        } catch (Exception e) {
            System.err.println("Erro ao criar :\t" + e.getMessage());
            return null;
        }
    }
  

    public boolean delete(long id){
        
        if(id <= 0){
            System.err.println("O id nao pode ser nulo !");
            return false;
        }
        AlmoxarifadoDAO itemDAO = new AlmoxarifadoDAO();
        return itemDAO.delete(id);
    }


}
