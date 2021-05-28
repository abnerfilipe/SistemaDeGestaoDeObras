package br.com.assistecnologia.gestaodeobras.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.assistecnologia.gestaodeobras.controller.AlmoxarifadoController;
import br.com.assistecnologia.gestaodeobras.controller.MaterialController;
import br.com.assistecnologia.gestaodeobras.controller.ObraController;
import br.com.assistecnologia.gestaodeobras.model.Almoxarifado;
import br.com.assistecnologia.gestaodeobras.model.Material;
import br.com.assistecnologia.gestaodeobras.model.Obra;

public class ViewObra {
    ObraController controller = null;
    AlmoxarifadoController almoxarifadoController = null;
    MaterialController materialController = null;
    Scanner scanner = null;

    public ViewObra() {
        this.controller = new ObraController();
        this.almoxarifadoController = new AlmoxarifadoController();
        this.materialController = new MaterialController();
        this.scanner = new Scanner(System.in);
    }


    public void listar() {
        System.out.println("----------------Listar Obras---------------------");
        System.out.println("Aguarde...");
        List<Obra> items = this.controller.index();
        if(items.isEmpty()) System.out.println("Nenhum obra cadastrada!");
        else  System.out.println("Obras: "); items.forEach(item -> System.out.println(item.toString()));
        System.out.println("--------------------------------------------------------");
    }
    public void criar() {
        System.out.println("----------------Criar Nova Obra---------------------");
        System.out.println("Informe o nome: ");
        String nome = this.scanner.nextLine();
        System.out.println("Informe o codigo: ");
        String codigo = this.scanner.nextLine();
        System.out.println("Informe o descricao: ");
        String descricao = this.scanner.nextLine();
        System.out.println("Aguarde...");
        Obra obra = this.controller.create(nome, codigo, descricao);
        if(obra!=null) System.out.println("obra criada com sucesso!");
        System.out.println(obra);
        System.out.println("--------------------------------------------------------");
    }

    public void editar() {
        System.out.println("----------------Editar Obra---------------------");
        System.out.println("Informe o id: ");
        long id =  this.scanner.nextLong();
        this.scanner.nextLine();
        System.out.println("Informe o nome: ");
        String nome = this.scanner.nextLine();
        System.out.println("Informe o codigo: ");
        String codigo = this.scanner.nextLine();
        System.out.println("Informe o descricao: ");
        String descricao = this.scanner.nextLine();
        System.out.println("Aguarde...");
        Obra obra = this.controller.edit(id, nome, codigo, descricao);
        if(obra!=null) System.out.println("obra editado com sucesso!");
        System.out.println(obra);
        System.out.println("--------------------------------------------------------");
    }
    public void buscar() {
        System.out.println("----------------Buscar Obra---------------------");
        System.out.println("Informe o id: ");
        long id = this.scanner.nextLong();
        System.out.println("Aguarde...");
        Obra obra = this.controller.show(id);
        if(obra != null)System.out.println("Obra Encontrado: "+obra);
        else System.out.println("Obra Não Encontrado");
        System.out.println("--------------------------------------------------------");
    }
    public void excluir() {

        System.out.println("----------------Excluir Obra---------------------");
        System.out.println("Informe o id: ");
        long id = this.scanner.nextLong();
        System.out.println("Aguarde...");
        if(this.controller.delete(id)) System.out.println("Obra excluida com sucesso!");
        else System.out.println("Obra não excluida!");
        System.out.println("--------------------------------------------------------");

    }

//    Almoxarifado


    public void listarAlmoxarifado(Obra obra){
        System.out.println("----------------Listar Almoxarifado---------------------");
        System.out.println("Aguarde...");
        List<Almoxarifado> items = this.almoxarifadoController.showFrom(obra);
        if(items.isEmpty()) System.out.println("Nenhum almoxarifado cadastrado!");
        else  System.out.println("Almoxarifados: "); items.forEach(item -> System.out.println(item.toString()));
        System.out.println("--------------------------------------------------------");
    }
    public void criarAlmoxarifado(Obra obra){
        System.out.println("----------------Adicionar Novo Almoxarifado---------------------");
        System.out.println("Informe o nome: ");
        String nome = scanner.nextLine();
        System.out.println("Aguarde...");
        Almoxarifado almoxarifado = this.almoxarifadoController.create(nome, obra);
        if(almoxarifado != null) System.out.println("almoxarifado criado com sucesso!");
        System.out.println("--------------------------------------------------------");
    }
    public void editarAlmoxarifado(Obra obra) {
        System.out.println("----------------Editar Almoxarifado---------------------");
        System.out.println("Informe o id: ");
        long id =  scanner.nextLong();
        scanner.nextLine();
        System.out.println("Informe o nome: ");
        String nome = scanner.nextLine();
        System.out.println("Aguarde...");
        Almoxarifado almoxarifado = this.almoxarifadoController.edit(id, nome, obra);
        if(almoxarifado!=null) System.out.println("almoxarifado editado com sucesso!");
        System.out.println("--------------------------------------------------------");
    }
    public void buscarAlmoxarifado(){
        System.out.println("----------------Buscar Almoxarifado---------------------");
        System.out.println("Informe o id: ");
        long id = scanner.nextLong();
        System.out.println("Aguarde...");
        Almoxarifado almoxarifado = this.almoxarifadoController.show(id);
        if(almoxarifado != null)System.out.println("Almoxarifado Encontrado: "+almoxarifado);
        else System.out.println("Almoxarifado Não Encontrado");
        System.out.println("--------------------------------------------------------");

    }
    public void excluirAlmoxarifado() {
        System.out.println("----------------Excluir Almoxarifado---------------------");
        System.out.println("Informe o id: ");
        long id = scanner.nextLong();
        System.out.println("Aguarde...");
        if(this.almoxarifadoController.delete(id)) System.out.println("Almoxarifado excluido com sucesso!");
        else System.out.println("Almoxarifado não excluido!");
        System.out.println("--------------------------------------------------------");

    }


//   Material

    public void listarMateriais(Almoxarifado almoxarifado) throws SQLException {
        System.out.println("----------------Listar Materiais---------------------");
        System.out.println("Aguarde...");
        List<Material> items = this.materialController.showFrom(almoxarifado);
        if(items.isEmpty()) System.out.println("Nenhum material cadastrado!");
        else  System.out.println("Cargos: "); items.forEach(item -> System.out.println(item.toString()));
        System.out.println("--------------------------------------------------------");
    }

    // descricao
    // nome
    // observacao
    // peso
    // almoxarifado_id

    public void adicionarNovoMaterial(Almoxarifado almoxarifado){
        System.out.println("----------------Adicionar Novo Material---------------------");
        System.out.println("Informe o nome: ");
        String nome = scanner.nextLine();
        System.out.println("Informe o descricao: ");
        String descricao = scanner.nextLine();
        System.out.println("Informe o observacao: ");
        String observacao = scanner.nextLine();
        System.out.println("Informe o peso: ");
        double peso = scanner.nextDouble();
        System.out.println("Aguarde...");
        Material material = this.materialController.create(nome, peso, descricao, observacao, almoxarifado);
        if(material != null) System.out.println("material criado com sucesso!");
        System.out.println("--------------------------------------------------------");
        scanner.close();
    }
    public void editarMaterial(Almoxarifado almoxarifado) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------Editar Material---------------------");
        System.out.println("Informe o id: ");
        long id =  scanner.nextLong();
        scanner.nextLine();
        System.out.println("Informe o nome: ");
        String nome = scanner.nextLine();
        System.out.println("Informe o descricao: ");
        String descricao = scanner.nextLine();
        System.out.println("Informe o observacao: ");
        String observacao = scanner.nextLine();
        System.out.println("Informe o peso: ");
        double peso = scanner.nextDouble();
        System.out.println("Aguarde...");
        Material material = this.materialController.edit(id ,nome, peso, descricao, observacao, almoxarifado);
        if(material != null) System.out.println("material editado com sucesso!");
        System.out.println("--------------------------------------------------------");
        scanner.close();

    }
    public void buscarMaterial() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------Buscar Material---------------------");
        System.out.println("Informe o id: ");
        long id = scanner.nextLong();
        System.out.println("Aguarde...");
        Material material = (Material) this.controller.index();
        if(material != null)System.out.println("Material Encontrado: "+material);
        else System.out.println("Material Não Encontrado");
        System.out.println("--------------------------------------------------------");
        scanner.close();

    }
    public void excluirMaterial() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------Excluir Material---------------------");
        System.out.println("Informe o id: ");
        long id = scanner.nextLong();
        System.out.println("Aguarde...");
        if(this.controller.delete(id)) System.out.println("Material excluido com sucesso!");
        else System.out.println("Material não excluido!");
        System.out.println("--------------------------------------------------------");
        scanner.close();
    }
} 
