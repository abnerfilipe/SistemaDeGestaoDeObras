package br.com.assistecnologia.gestaodeobras.controller;

import br.com.assistecnologia.gestaodeobras.model.Obra;
import br.com.assistecnologia.gestaodeobras.model.dao.ObraDAO;

import java.sql.SQLException;
import java.util.List;

public class ObraController {

    public List<Obra> index(){
        ObraDAO obraDAO = new ObraDAO();
        return obraDAO.all();
    }

    public Obra show(long id){
        ObraDAO obraDAO = new ObraDAO();
        if(id <= 0 || obraDAO.read(id).isEmpty()){
            System.err.println("O id nao pode ser nulo ou inexistente!");
            return null;
        }
        return obraDAO.read(id).get();
    }

    public Obra edit(Long id, String nome, String codigo, String descricao){
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
            }
            if(passed == false){
                throw new Exception("O nome nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(codigo != null && codigo.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O codigo nao pode ser nulo e deve ser valido!");
            }
            if(descricao != null && descricao.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O descricao nao pode ser nulo ou vazio!");
            }
            ObraDAO obraDAO = new ObraDAO();
            Obra item = new Obra(id,nome,codigo,descricao);
            return obraDAO.edit(item);
        } catch (Exception e) {
            System.err.println("Erro ao editar :\t" + e.getMessage());
            return null;
        }
    }
    public Obra create(String nome, String codigo, String descricao){
        try {
            boolean passed = false;
            if(nome != null && nome.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O nome nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(codigo != null && codigo.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O codigo nao pode ser nulo e deve ser valido!");
            }
            if(descricao != null && descricao.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O descricao nao pode ser nulo ou vazio!");
            }
            ObraDAO obraDAO = new ObraDAO();
            Obra item = new Obra(nome,codigo, descricao);
            return obraDAO.create(item);
        } catch (Exception e) {
            System.err.println("Erro ao criar :\t" + e.getMessage());
            return null;
        }
    }
  

    public boolean delete(long id) {
        ObraDAO obraDAO = new ObraDAO();
        if(id <= 0 || obraDAO.read(id).isEmpty()){
            System.err.println("O id nao pode ser nulo ou inexistente!");
            return false;
        }
        return obraDAO.delete(id);
    }


}
