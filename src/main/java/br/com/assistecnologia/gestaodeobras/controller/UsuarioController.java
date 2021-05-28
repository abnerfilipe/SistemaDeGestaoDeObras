package br.com.assistecnologia.gestaodeobras.controller;
import br.com.assistecnologia.gestaodeobras.model.dao.UsuarioDAO;
import java.util.List;

import br.com.assistecnologia.gestaodeobras.model.Usuario;

public class UsuarioController {

    public List<Usuario> index(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.all();
    }

    public Usuario show(long id){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(id <= 0 || usuarioDAO.read(id).isEmpty()){
            System.err.println("O id nao pode ser nulo ou inexistente!");
            return null;
        }
        return usuarioDAO.read(id).get();
    }
    public Usuario edit(Long id, String nome, String email, String username){
        try {
            boolean passed = false;
            // if(id != null && id > 0){
            //     passed = true;
            // }
            // if(passed == false){
            //     throw new Exception("O id nao pode ser nulo ou vazio!");
            // }
            // passed = false;
            // if(nome != null && nome.length() > 0){
            //     passed = true;
            // }
            // if(passed == false){
            //     throw new Exception("O nome nao pode ser nulo ou vazio!");
            // }
            passed = false;
            if(email != null && email.length() > 10 && email.contains("@")){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O email nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(username != null && username.length() > 0){
                    passed = true;
            }
            if(passed == false){
                throw new Exception("O username nao pode ser nulo ou vazio!");
            }
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario item = new Usuario(id,nome,email, username);
            return usuarioDAO.edit(item);
        } catch (Exception e) {
            System.err.println("Erro ao editar usuario:\t" + e.getMessage());
            return null;
        }
    }
    public Usuario create(String nome, String email,String username){
        try {
            boolean passed = false;
            if(nome != null && nome.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O nome nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(email != null && email.length() > 10 && email.contains("@")){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O email nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(username != null && username.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O username nao pode ser nulo e deve ser valido!");
            }
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario item = new Usuario(nome,email,username);
            return usuarioDAO.create(item);
        } catch (Exception e) {
            System.err.println("Erro ao criar usuario:\t" + e.getMessage());
            return null;
        }
    }

    public boolean delete(long id){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(id <= 0 || usuarioDAO.read(id).isEmpty()){
            System.err.println("O id nao pode ser nulo ou inexistente!");
            return false;
        }
        return usuarioDAO.delete(id);
    }

}
