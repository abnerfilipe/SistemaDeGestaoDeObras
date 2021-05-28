package br.com.assistecnologia.gestaodeobras.controller;

import br.com.assistecnologia.gestaodeobras.model.Cargo;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CargoControllerTest {
    CargoController cargoController = new CargoController();
    @Test
    @Order(1)
    @DisplayName("Cria um cargo")
    void create() {
        Cargo cargo = cargoController.create("Cargo Teste");
        assertNotNull(cargo);
//        System.out.println(cargo);
    }
    @Test
    @Order(2)
    @DisplayName("Mostrar todos os cargos e mostrar e edita uma obra")
    void index() {
//        Carrega e Mostra todos
        List<Cargo> cargos = cargoController.index();
        assertTrue(cargos.size()>0);
//        cargos.forEach(item-> System.out.println(item));
//        Mostra o primeiro
        Cargo cargo = cargoController.show(cargos.get(0).getId());
        assertEquals(cargo.getNome(),cargos.get(0).getNome());
//        System.out.println(cargo);
//        edita o primeiro
        String edicao = "Cargo Editado";
        cargo = cargoController.edit(cargo.getId(),edicao);
        assertEquals(cargo.getNome(),edicao);
//        System.out.println(cargo);
//      excluir
        Boolean excluido = cargoController.delete(cargo.getId());
        assertTrue(excluido);
    }



}