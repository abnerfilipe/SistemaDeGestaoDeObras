package br.com.assistecnologia.gestaodeobras.controller;

import java.util.List;

import br.com.assistecnologia.gestaodeobras.model.Cargo;
import br.com.assistecnologia.gestaodeobras.model.dao.CargoDAO;

public class CargoController {

    public List<Cargo> index(){
        CargoDAO itemDAO = new CargoDAO();
        return itemDAO.all();
    }

    public Cargo show(long id){
        if(id <= 0){
            System.err.println("O id nao pode ser nulo!");
            return null;
        }
        CargoDAO itemDAO = new CargoDAO();
        return itemDAO.read(id).get();
    }

    public Cargo edit(Long id, String nome){
        try {
            boolean passed = false;
            if(id != null && id > 0){
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
            CargoDAO itemDAO = new CargoDAO();
            Cargo item= new Cargo(id,nome);
            return itemDAO.edit(item);
        } catch (Exception e) {
            System.err.println("Erro ao editar :\t" + e.getMessage());
            return null;
        }
    }
    public Cargo create(String nome){
        try {
            boolean passed = false;
            if(nome != null && nome.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O nome nao pode ser nulo!");
            }
            CargoDAO itemDAO = new CargoDAO();
            Cargo item= new Cargo(nome);
            return itemDAO.create(item);
        } catch (Exception e) {
            System.err.println("Erro ao criar :\t" + e.getMessage());
            return null;
        }
    }
  

    public boolean delete(long id){
        if(id <= 0 ){
            System.err.println("O id nao pode ser nulo!");
            return false;
        }
        CargoDAO itemDAO = new CargoDAO();
        return itemDAO.delete(id);
    }

}
