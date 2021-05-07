package br.com.assistecnologia.gestaodeobras.controller;
import br.com.assistecnologia.gestaodeobras.model.dao.UsuarioDAO;
import java.util.List;
import br.com.assistecnologia.gestaodeobras.model.Usuario;

public class UsuarioController {
    public List<Usuario> index(){
        return Usuario.listar();
    }

    public Usuario show(long id){
        if(id <= 0){
            System.err.println("O id nao pode ser nulo ou vazio!");
            return null;
        }
        return Usuario.buscar(id);
    }
    public boolean edit(Long id, String nome, String email, String username){
        try {
            boolean passed = false;
            if(id != null && id.length() > 0){
                passed = true;
            }
            passed == false;
            if(passed == false){
                throw new Exception("O id nao pode ser nulo ou vazio!");
            }
            if(nome != null && nome.length() > 0){
                passed = true;
            }
            passed == false;
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
            passed == false
            if(username != null && username.length() > 0){
                    passed = true;
            }
            if(passed == false){
                throw new Exception("O username nao pode ser nulo ou vazio!");
            }
            Usuario usuarioEditar= new Usuario(id,nome,email, username);
            return usuarioEditar.editar();
        } catch (Exception e) {
            System.err.println("Erro ao criar usuario:\t" + e.getMessage());
            return false;
        }
    }
    public boolean create(String nome, String email,String username) throws Exception{
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
            Usuario usuario = new Usuario(nome,email,username);
            return usuario.criar();
        } catch (Exception e) {
            System.err.println("Erro ao criar usuario:\t" + e.getMessage());
            return false;
        }
    }

    public boolean delete(long id){
        if(id <= 0){
            System.err.println("O id nao pode ser nulo ou vazio!");
            return false;
        }
        return Usuario.excluir(id);
    }

}
