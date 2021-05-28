package br.com.assistecnologia.gestaodeobras.controller;
import br.com.assistecnologia.gestaodeobras.model.dao.UsuarioDAO;
import java.util.List;
import java.util.Optional;

import br.com.assistecnologia.gestaodeobras.model.Usuario;

import javax.swing.text.html.Option;

public class UsuarioController {

    public List<Usuario> index(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.all();
    }

    public Usuario show(long id){
        if(id <= 0){
            System.err.println("O id nao pode ser nulo ou inexistente!");
            return null;
        }
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Optional<Usuario> usuario = usuarioDAO.read(id);
        if (usuario.isEmpty()) {
            System.out.println("Usuario nao encontrado!");
            return null;
        }
        return usuario.get();
    }
    public Usuario edit(Long id, String nome, String email, String username){
        try {
            boolean passed = false;
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (usuarioDAO.read(id).isEmpty()) {
                System.out.println("Usuario nao encontrado!");
            }
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
        Optional<Usuario> usuario = usuarioDAO.read(id);
        if (usuario.isEmpty()) {
            System.out.println("Usuario nao encontrado!");
            return false;
        }
        return usuarioDAO.delete(id);
    }

}
