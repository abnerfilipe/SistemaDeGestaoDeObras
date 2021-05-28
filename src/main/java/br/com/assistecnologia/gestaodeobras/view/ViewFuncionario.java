package br.com.assistecnologia.gestaodeobras.view;

import br.com.assistecnologia.gestaodeobras.controller.*;
import br.com.assistecnologia.gestaodeobras.model.*;

import java.util.Scanner;

public class ViewFuncionario {
    CargoController cargoController = null;
    FuncionarioController funcionarioController = null;
    EnderecoController enderecoController = null;
    ObraController obraController = null;
    UsuarioController usuarioController = null;
    Scanner scanner = null;

    public ViewFuncionario() {
        this.cargoController = new CargoController();
        this.funcionarioController = new FuncionarioController();
        this.enderecoController = new EnderecoController();
        this.obraController = new ObraController();
        this.usuarioController = new UsuarioController();
        this.scanner = new Scanner(System.in);
    }



    public void listarFuncionario() {
        System.out.println("----------------Listar Funcionarios---------------------");
        System.out.println("Aguarde...");
        if(this.funcionarioController.index().isEmpty()) System.out.println("Nenhum Funcionario cadastrado!");
        else  System.out.println("Funcionarios: "); this.funcionarioController.index().forEach(item -> System.out.println(item));
        System.out.println("--------------------------------------------------------");
    }
    public void criarNovoFuncionario() {
        System.out.println("----------------Criar Novo Funcionario---------------------");
//      obra
        System.out.println("Informe o id da Obra para ser associado: ");
        long idObra = scanner.nextLong();
        System.out.println("Aguarde...");
        Obra obra = this.obraController.show(idObra);
        if(obra==null) System.out.println("Obra nao encontrada");
//        usuario
        System.out.println("Informe o id do usuario para ser associado: ");
        long idUsuario = scanner.nextLong();
        Usuario usuario = this.usuarioController.show(idUsuario);
        if(usuario==null) System.out.println("Usuario nao encontrado");
//      cargo
        System.out.println("Informe o id do cargo para ser associado: ");
        long idCargo = scanner.nextLong();
        Cargo cargo = this.cargoController.show(idCargo);
        if(cargo==null) System.out.println("Cargo nao encontrado");
//      Endereco
        System.out.println("Informe o id do endereco para ser associado: ");
        long idEndereco = scanner.nextLong();
        Endereco endereco = this.enderecoController.show(idCargo);
        if(cargo==null) System.out.println("Endereco nao encontrado");
//        Funcionario
        System.out.println("Informe o nome do funcionario: ");
        String nome = scanner.nextLine();
        System.out.println("Informe o cpf do funcionario: ");
        String cpf = scanner.nextLine();
        System.out.println("Informe a Matricula do funcionario: ");
        String matricula = scanner.nextLine();
        System.out.println("Informe o sexo do funcionario: ");
        System.out.println("1 - Masculino");
        System.out.println("2 - Feminino");
        int idSexo = scanner.nextInt();
        Sexo sexo = null;
        if (idSexo > 2 || idSexo < 1) System.out.println("Sexo invalido");
        else if(idSexo == 1) sexo = Sexo.Masculino;
        else sexo = Sexo.Feminino;
        System.out.println("Aguarde...");
        Funcionario funcionario = this.funcionarioController.create(nome,cpf,matricula,usuario,endereco,sexo,obra,cargo);
        if(funcionario!=null) System.out.println("Funcionario criado com sucesso!");
        System.out.println("--------------------------------------------------------");
    }
    public void editarFuncionario() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------Editar Funcionario---------------------");
        System.out.println("Informe o id: ");
        long id =  scanner.nextLong();
        scanner.nextLine();
//      obra
        System.out.println("Informe o id da Obra para ser associado: ");
        long idObra = scanner.nextLong();
        System.out.println("Aguarde...");
        Obra obra = this.obraController.show(idObra);
        if(obra==null) System.out.println("Obra nao encontrada");
//        usuario
        System.out.println("Informe o id do usuario para ser associado: ");
        long idUsuario = scanner.nextLong();
        Usuario usuario = this.usuarioController.show(idUsuario);
        if(usuario==null) System.out.println("Usuario nao encontrado");
//      cargo
        System.out.println("Informe o id do cargo para ser associado: ");
        long idCargo = scanner.nextLong();
        Cargo cargo = this.cargoController.show(idCargo);
        if(cargo==null) System.out.println("Cargo nao encontrado");
//      Endereco
        System.out.println("Informe o id do endereco para ser associado: ");
        long idEndereco = scanner.nextLong();
        Endereco endereco = this.enderecoController.show(idCargo);
        if(cargo==null) System.out.println("Endereco nao encontrado");
//        Funcionario
        System.out.println("Informe o nome do funcionario: ");
        String nome = scanner.nextLine();
        System.out.println("Informe o cpf do funcionario: ");
        String cpf = scanner.nextLine();
        System.out.println("Informe a Matricula do funcionario: ");
        String matricula = scanner.nextLine();
        System.out.println("Informe o sexo do funcionario: ");
        System.out.println("1 - Masculino");
        System.out.println("2 - Feminino");
        int idSexo = scanner.nextInt();
        Sexo sexo = null;
        if (idSexo > 2 || idSexo < 1) System.out.println("Sexo invalido");
        else if(idSexo == 1) sexo = Sexo.Masculino;
        else sexo = Sexo.Feminino;
        System.out.println("Aguarde...");
        Funcionario funcionario = this.funcionarioController.edit(id,nome,cpf,matricula,usuario,endereco,sexo,obra,cargo);
        if(funcionario !=null) System.out.println("Funcionario editado com sucesso!");
        System.out.println("--------------------------------------------------------");
    }
    public void buscarFuncionario() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------Buscar Funcionario---------------------");
        System.out.println("Informe o id: ");
        long id = scanner.nextLong();
        System.out.println("Aguarde...");
        Funcionario funcionario = this.funcionarioController.show(id);
        if(funcionario != null)System.out.println("Funcionario Encontrado: "+funcionario);
        else System.out.println("Funcionario Não Encontrado");
        System.out.println("--------------------------------------------------------");
        

    }
    public void excluirFuncionario() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------Excluir Funcionario---------------------");
        System.out.println("Informe o id: ");
        long id = scanner.nextLong();
        System.out.println("Aguarde...");
        if(this.funcionarioController.delete(id)) System.out.println("Funcionario excluido com sucesso!");
        else System.out.println("Funcionario não excluido!");
        System.out.println("--------------------------------------------------------");
        
    }

//     Cargos
    public void listarCargos() {
        System.out.println("----------------Listar Cargos---------------------");
        System.out.println("Aguarde...");
        if(this.cargoController.index().isEmpty()) System.out.println("Nenhum cargo cadastrado!");
        else  System.out.println("Cargos: "); this.cargoController.index().forEach(item -> System.out.println(item.toString()));
        System.out.println("--------------------------------------------------------");
    }
    public void criarNovoCargo() {

        System.out.println("----------------Criar Novo Cargo---------------------");
        System.out.println("Informe o nome: ");
        String nome = scanner.nextLine();
        System.out.println("Aguarde...");
        Cargo cargo = this.cargoController.create(nome);
        if(cargo!=null) System.out.println("cargo criado com sucesso!");
        System.out.println("--------------------------------------------------------");
    }
    public void editarCargo() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------Editar Cargo---------------------");
        System.out.println("Informe o id: ");
        long id =  scanner.nextLong();
        scanner.nextLine();
        System.out.println("\nInforme o nome do cargo: ");
        String nome = scanner.nextLine();
        System.out.println("Aguarde...");
        Cargo cargo = this.cargoController.edit(id,nome);
        if(cargo !=null) System.out.println("cargo editado com sucesso!");
        System.out.println("--------------------------------------------------------");
        

    }
    public void buscarCargo() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------Buscar Cargo---------------------");
        System.out.println("Informe o id: ");
        long id = scanner.nextLong();
        System.out.println("Aguarde...");
        Cargo cargo = this.cargoController.show(id);
        if(cargo != null)System.out.println("Cargo Encontrado: "+cargo);
        else System.out.println("Cargo Não Encontrado");
        System.out.println("--------------------------------------------------------");
        

    }
    public void excluirCargo() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------Excluir Cargo---------------------");
        System.out.println("Informe o id: ");
        long id = scanner.nextLong();
        System.out.println("Aguarde...");
        if(this.cargoController.delete(id)) System.out.println("Cargo excluido com sucesso!");
        else System.out.println("Cargo não excluido!");
        System.out.println("--------------------------------------------------------");
        
    }


//Endereco
    public void listarEndereco() {

    System.out.println("----------------Listar Enderecos---------------------");
    System.out.println("Aguarde...");
    if(this.enderecoController.index().isEmpty()) System.out.println("Nenhum endereco cadastrado!");
    else  System.out.println("Enderecos: "); this.enderecoController.index().forEach(item -> System.out.println(item.toString()));
    System.out.println("--------------------------------------------------------");
}
    public  void criarNovoEndereco() {
        System.out.println("----------------Criar Novo Endereco---------------------");
        System.out.println("Informe o logradouro: ");
        String logradouro = scanner.nextLine();
        System.out.println("Informe o numero: ");
        String numero = scanner.nextLine();
        System.out.println("Informe o complemento: ");
        String complemento = scanner.nextLine();
        System.out.println("Informe o bairro: ");
        String bairro = scanner.nextLine();
        System.out.println("Informe o cidade: ");
        String cidade = scanner.nextLine();
        System.out.println("Informe o estado: ");
        String estado = scanner.nextLine();
        System.out.println("Aguarde...");
        Endereco endereco = this.enderecoController.create(logradouro, numero, complemento, bairro, cidade, estado);
        if(endereco != null) System.out.println("endereco criado com sucesso!");
        System.out.println(endereco);
        System.out.println("--------------------------------------------------------");

    }
    public  void editarEndereco() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------Editar Endereco---------------------");
        System.out.println("Informe o id: ");
        long id =  scanner.nextLong();
        scanner.nextLine();
        System.out.println("Informe o logradouro: ");
        String logradouro = scanner.nextLine();
        System.out.println("Informe o numero: ");
        String numero = scanner.nextLine();
        System.out.println("Informe o complemento: ");
        String complemento = scanner.nextLine();
        System.out.println("Informe o bairro: ");
        String bairro = scanner.nextLine();
        System.out.println("Informe o cidade: ");
        String cidade = scanner.nextLine();
        System.out.println("Informe o estado: ");
        String estado = scanner.nextLine();
        System.out.println("Aguarde...");
        if(this.enderecoController.edit(id, logradouro, numero, complemento, bairro, cidade, estado) != null) System.out.println("endereco editado com sucesso!");
        System.out.println("--------------------------------------------------------");

    }
    public  void buscarEndereco() {
        System.out.println("----------------Buscar Endereco---------------------");
        System.out.println("Informe o id: ");
        long id = scanner.nextLong();
        System.out.println("Aguarde...");
        Endereco endereco = this.enderecoController.show(id);
        if(endereco != null)System.out.println("Endereco Encontrado: "+endereco);
        else System.out.println("Endereco Não Encontrado");
        System.out.println("--------------------------------------------------------");
    }
    public  void excluirEndereco() {
        System.out.println("----------------Excluir Endereco---------------------");
        System.out.println("Informe o id: ");
        long id = scanner.nextLong();
        System.out.println("Aguarde...");
        if(this.enderecoController.delete(id)) System.out.println("Endereco excluido com sucesso!");
        else System.out.println("Endereco não excluido!");
        System.out.println("--------------------------------------------------------");

    }
}
