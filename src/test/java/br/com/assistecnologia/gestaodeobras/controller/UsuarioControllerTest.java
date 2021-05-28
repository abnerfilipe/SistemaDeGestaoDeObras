package br.com.assistecnologia.gestaodeobras.controller;

import br.com.assistecnologia.gestaodeobras.model.Obra;
import br.com.assistecnologia.gestaodeobras.model.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioControllerTest {
    UsuarioController usuarioController =new UsuarioController();

    @Test
    @Order(1)
    @DisplayName("Devera criar um usuario")
    void create() {
        Usuario usuario = usuarioController.create("Usuario Teste","emailteste@teste.com","usuarioteste");
        assertNotNull(usuario);
    }

    @Test
    @Order(2)
    @DisplayName("Devera listar usuarios, mostrar, editar e deletar um usuario")
    void list() {
//        listar
        List<Usuario> usuarios = usuarioController.index();
        assertTrue(usuarios.size()>0);
//        mostrar
        Usuario usuario = usuarioController.show(usuarios.get(0).getId());
        assertEquals(usuario.getEmail(),usuarios.get(0).getEmail());
//        Editar
        String value = "emaileditado@teste.com";
        usuario = usuarioController.edit(usuario.getId(),"Usuario Teste",value,"usuarioteste");
        assertTrue(usuario.getEmail() == value);
//        deletar
        boolean deleted = usuarioController.delete(usuario.getId());
        assertTrue(deleted);
    }
}