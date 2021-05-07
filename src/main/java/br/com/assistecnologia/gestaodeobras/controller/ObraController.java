package br.com.assistecnologia.gestaodeobras.controller;

import br.com.assistecnologia.gestaodeobras.model.Obra;

public class ObraController {
    public List<Obra> index(){
        return Obra.listar();
    }

    public Obra show(long id){
        if(id <= 0){
            System.err.println("O id nao pode ser nulo ou vazio!");
            return null;
        }
        return Obra.buscar(id);
    }

    public boolean edit(Long id, String nome, String codigo, String descricao){
        try {
            boolean passed = false;
            if(id != null && id.length() > 0){
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
            if(username != null && descricao.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O descricao nao pode ser nulo ou vazio!");
            }

            Obra itemPraEditar= new Obra(id,nome,codigo, descricao);
            return itemPraEditar.editar();
        } catch (Exception e) {
            System.err.println("Erro ao criar :\t" + e.getMessage());
            return false;
        }
    }
    public boolean create(String nome, String codigo, String descricao){
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

            Obra item= new Obra(nome,codigo, descricao);
            return item.criar();
        } catch (Exception e) {
            System.err.println("Erro ao criar :\t" + e.getMessage());
            return false;
        }
    }
  

    public boolean delete(long id){
        if(id <= 0){
            System.err.println("O id nao pode ser nulo ou vazio!");
            return false;
        }
        return Obra.excluir(id);
    }


}
