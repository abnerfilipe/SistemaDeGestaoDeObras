package br.com.assistecnologia.gestaodeobras.controller;

import br.com.assistecnologia.gestaodeobras.model.Almoxarifado;
import br.com.assistecnologia.gestaodeobras.model.Obra;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AlmoxarifadoControllerTest {
    static ObraController obraController = new ObraController();
    static AlmoxarifadoController almoxarifadoController = new AlmoxarifadoController();
    private static Obra obra;

    @Test
    @BeforeAll
    public static void setupUp(){
        Random random = new Random();
        int codigo = random.nextInt();
        obra = obraController.create("Obra teste", Integer.toString(codigo),"Descricao Obra");
        assertNotNull(obra);
    }


    @Test
    @Order(1)
    @DisplayName("Devera criar um almoxarifado")
    void create() {
//        criar
        Almoxarifado almoxarifado = almoxarifadoController.create("Almoxarifado Teste",obra);
        assertNotNull(almoxarifado);
    }

    @Test
    @Order(2)
    @DisplayName("Devera listar almoxarifados, mostrar, editar e deletar um Almoxarifado")
    void list() {
//        listar obras
        List<Almoxarifado> almoxarifados = almoxarifadoController.index();
        assertTrue(almoxarifados.size()>0);
//        mostrar obra
        Almoxarifado almoxarifado = almoxarifadoController.show(almoxarifados.get(0).getId());
        assertEquals(almoxarifado.getNome(),almoxarifados.get(0).getNome());
//        Editar obra
        String value = "Almoxarifado Editado";
        almoxarifado = almoxarifadoController.edit(almoxarifado.getId(),value,obra);
        assertTrue(almoxarifado.getNome() == value);
//        deletar obra
        boolean deleted = almoxarifadoController.delete(almoxarifado.getId());
        assertTrue(deleted);
    }
    @Test
    @AfterAll
    public static void setupDown(){
        obraController.delete(obra.getId());
    }
}