package br.com.assistecnologia.gestaodeobras.controller;

import br.com.assistecnologia.gestaodeobras.model.Endereco;
import br.com.assistecnologia.gestaodeobras.model.Obra;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoControllerTest {
    EnderecoController enderecoController = new EnderecoController();
    @Test
    @Order(1)
    @DisplayName("Devera criar um endereco")
    void create() {
//        criar
        Endereco endereco = enderecoController.create("Avenida Castelo Branco","4770","101","Rodoviario","Goiania","Goias");
        assertNotNull(endereco);
    }

    @Test
    @Order(2)
    @DisplayName("Devera listar enderecos, mostrar, editar e deletar uma endereco")
    void list() {
//        listar
        List<Endereco> enderecos = enderecoController.index();
        assertTrue(enderecos.size()>0);
//        mostrar
        Endereco endereco = enderecoController.show(enderecos.get(0).getId());
        assertEquals(endereco.getLogradouro(),enderecos.get(0).getLogradouro());
//        Editar
        String value = "Avenida Consolacao";
        endereco = enderecoController.edit(
                endereco.getId(),
                value,
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado());
        assertTrue(endereco.getLogradouro() == value);
//        deletar
        boolean deleted = enderecoController.delete(endereco.getId());
        assertTrue(deleted);
    }
}