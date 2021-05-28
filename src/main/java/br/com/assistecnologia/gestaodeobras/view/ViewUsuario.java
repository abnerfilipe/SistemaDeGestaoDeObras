package br.com.assistecnologia.gestaodeobras.view;

import java.util.Scanner;

import br.com.assistecnologia.gestaodeobras.controller.UsuarioController;
import br.com.assistecnologia.gestaodeobras.model.Usuario;

public class ViewUsuario {
    UsuarioController controller = null;
    Scanner scanner = null;
    ViewUsuario(){
       this.controller = new UsuarioController();
       this.scanner = new Scanner(System.in);
    }
    public void listarUsuarios() {
        System.out.println("----------------Listar Usuarios---------------------");
        System.out.println("Aguarde...");
        if(this.controller.index().isEmpty()) System.out.println("Nenhum usuario cadastrado!");
        else  System.out.println("Usuarios: "); this.controller.index().forEach(item -> System.out.println(item.toString()));
        System.out.println("--------------------------------------------------------");

    }
    public void criarNovoUsuario() {
        System.out.println("----------------Criar Novo Usuario---------------------");
        System.out.println("Informe o nome: ");
        String nome = this.scanner.nextLine();
        System.out.println("Informe o email:");
        String email = this.scanner.nextLine();
        System.out.println("Informe o usuario");
        String username = this.scanner.nextLine();
        System.out.println("Aguarde...");
        Usuario usuario = this.controller.create(nome,email,username);
        if(usuario != null) System.out.println("usuario criado com sucesso!");
        System.out.println("--------------------------------------------------------");
        this.scanner.close();

    }
    public void editarUsuario() {
        System.out.println("----------------Editar Usuario---------------------");
        System.out.println("Informe o id: ");
        long id =  this.scanner.nextLong();
        this.scanner.nextLine();
        System.out.println("\nInforme o nome: ");
        String nome = this.scanner.nextLine();
        System.out.println("\nInforme o email:");
        String email = this.scanner.nextLine();
        System.out.println("\nInforme o usuario");
        String username = this.scanner.nextLine();
        System.out.println("Aguarde...");
        Usuario usuario = this.controller.edit(id,nome,email,username);
        if(usuario!=null) System.out.println("usuario editado com sucesso!");
        System.out.println("--------------------------------------------------------");
        this.scanner.close();

    }
    public void buscarUsuario() {
        System.out.println("----------------Buscar Usuario---------------------");
        System.out.println("Informe o id: ");
        long id = this.scanner.nextLong();
        System.out.println("Aguarde...");
        Usuario usuario = this.controller.show(id);
        if(usuario != null)System.out.println("Usuario Encontrado: "+usuario);
        else System.out.println("Usuario Não Encontrado");
        System.out.println("--------------------------------------------------------");
        this.scanner.close();

    }
    public void excluirUsuario() {
        System.out.println("----------------Excluir Usuario---------------------");
        System.out.println("Informe o id: ");
        long id = this.scanner.nextLong();
        System.out.println("Aguarde...");
        if(this.controller.delete(id)) System.out.println("Usuario excluido com sucesso!");
        else System.out.println("Usuario não excluido!");
        System.out.println("--------------------------------------------------------");
        this.scanner.close();

    }
 
} 
