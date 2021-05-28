package br.com.assistecnologia.gestaodeobras.controller;

import br.com.assistecnologia.gestaodeobras.model.Almoxarifado;
import br.com.assistecnologia.gestaodeobras.model.Material;
import br.com.assistecnologia.gestaodeobras.model.Obra;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MaterialControllerTest {
    static MaterialController materialController = new MaterialController();
    static ObraController obraController = new ObraController();
    static AlmoxarifadoController almoxarifadoController = new AlmoxarifadoController();
    private static Almoxarifado almoxarifado;
    private static Obra obra;

    @Test
    @BeforeAll
    public static void setupUp(){
        Random random = new Random();
        int codigo = random.nextInt();
        obra = obraController.create("Obra teste", Integer.toString(codigo),"Descricao Obra");
        assertNotNull(obra);
        almoxarifado = almoxarifadoController.create("Almoxarifado Teste",obra);
        assertNotNull(almoxarifado);
    }


    @Test
    @Order(1)
    @DisplayName("Devera criar um Material no almoxarifado")
    void create() {
//        criar
        Material material = materialController.create(
                "Material Teste",
                20.0,
                "Descricao ",
                "Observacao",
                almoxarifado);
        assertNotNull(material);
    }

    @Test
    @Order(2)
    @DisplayName("Devera listar Materiais, mostrar, editar e deletar um Material")
    void list() {
//        listar obras
        List<Material> materials = materialController.showFrom(almoxarifado);
        assertTrue(materials.size()>0);
//        mostrar obra
        Material material = materialController.show(materials.get(0).getId());
        assertEquals(material.getNome(),materials.get(0).getNome());
//        Editar obra
        String value = "Material Editado";
        material = materialController.edit(material.getId(),value,20.0,"Descricao ","Observacao",almoxarifado);
        assertTrue(material.getNome() == value);
//        deletar obra
        boolean deleted = materialController.delete(material.getId());
        assertTrue(deleted);
    }
    @Test
    @AfterAll
    public static void setupDown(){

        almoxarifadoController.delete(almoxarifado.getId());
        obraController.delete(obra.getId());
    }
}