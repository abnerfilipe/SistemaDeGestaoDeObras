package br.com.assistecnologia.gestaodeobras.model;


import java.util.List;
import java.util.Optional;

import br.com.assistecnologia.gestaodeobras.model.dao.UsuarioDAO;

public class Usuario {
    private long id;
    private String name;
    private String email;
    private String username;

    public Usuario(String name, String email, String username) {
        this.name = name;
        this.email = email;
        this.username = username;
    }
    public Usuario(Long id,String name, String email, String username) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public Usuario() {

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



    @Override
    public String toString() {
        return "[id: " + id + ", email: " + email + ", name: " + name + ", username: " + username + "]";
    }

}
