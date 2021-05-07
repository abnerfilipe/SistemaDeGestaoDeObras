package br.com.assistecnologia.gestaodeobras;

import br.com.assistecnologia.gestaodeobras.controller.UsuarioController;
import br.com.assistecnologia.gestaodeobras.model.Material;

public class App {
    public static void main(String[] args) throws Exception {
        UsuarioController usuarioController = new UsuarioController();
        // if(usuarioController.create("Filipe","filipe@email.com","filipeabner")) System.out.println("usuario criado com sucesso!");
        // if(usuarioController.edit(1L,"Filipe Abner","filipe@email.com","filipeabner")) System.out.println("usuario editado com sucesso!");
        
        // System.out.println("Usuario: "+usuarioController.show(1));
        // if(usuarioController.delete(1)) System.out.println("usuario excluido com sucesso!");
        
        // if(usuarioController.index().isEmpty()) System.out.println("Nenhum usuario encontrado!");
        // else  System.out.println("Usuarios: "); usuarioController.index().forEach(item -> System.out.println(item.toString()));
        Material material = new Material();
        System.out.println(material.buscar(1));
    }
}
