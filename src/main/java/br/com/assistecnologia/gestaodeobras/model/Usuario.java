package br.com.assistecnologia.gestaodeobras.model;


import java.util.List;
import java.util.Optional;

import br.com.assistecnologia.gestaodeobras.model.dao.UsuarioDAO;

public class Usuario {
    private long id;
    private String name;
    private String email;
    private String username;
    private UsuarioDAO usuarioDAO;

    public Usuario(long id, String name, String email, String username) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    // methods
    public boolean criar() {
        return this.getUsuarioDAO().create(this);
    }

    public boolean editar() {
        return this.getUsuarioDAO().edit(this);
    }
    public static Optional<Usuario> buscar(long id) {
        Usuario item = new Usuario();
        return item.getUsuarioDAO().read(id);
    }
    public static List<Usuario> listar() {
        Usuario item = new Usuario();
        return item.getUsuarioDAO().all();
    }
    public static boolean excluir(long id){
        Usuario item = new Usuario();
        return item.getUsuarioDAO().delete(id);
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", email=" + email + ", name=" + name + ", username=" + username + "]";
    }

    // 
    

}
