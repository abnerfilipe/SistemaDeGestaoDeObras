package br.com.assistecnologia.gestaodeobras.controller;

import br.com.assistecnologia.gestaodeobras.model.Obra;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ObraControllerTest {
    ObraController obraController = new ObraController();

    @Test
    @Order(1)
    @DisplayName("Devera criar uma obra")
    void create() {
//        criar obra
        Random random = new Random();
        int codigo = random.nextInt();
        Obra obra = obraController.create("Obra teste", Integer.toString(codigo),"Descricao Obra");
        assertNotNull(obra);

    }

    @Test
    @Order(2)
    @DisplayName("Devera listar obras, mostrar, editar e deletar uma Obra")
     void list() {
//        listar obras
        List<Obra> obras = obraController.index();
        assertTrue(obras.size()>0);
//        mostrar obra
        Obra obra = obraController.show(obras.get(0).getId());
        assertEquals(obra.getNome(),obras.get(0).getNome());
//        Editar obra
        String value = "Obra Teste Editado";
        obra = obraController.edit(obra.getId(), value,"123456","edited descricao");
        assertTrue(obra.getNome() == value);
//        deletar obra
        boolean deleted = obraController.delete(obra.getId());
        assertTrue(deleted);
    }




}