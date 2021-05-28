package br.com.assistecnologia.gestaodeobras.view;

import java.util.Scanner;


import br.com.assistecnologia.gestaodeobras.controller.AlmoxarifadoController;
import br.com.assistecnologia.gestaodeobras.controller.ObraController;
import br.com.assistecnologia.gestaodeobras.model.Almoxarifado;
import br.com.assistecnologia.gestaodeobras.model.Obra;

import javax.swing.text.View;


public class App {
    public static void main(String[] args) throws Exception {
        int op = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("===========================================================================\n");
        System.out.print("====================Sistema de Gestao de Logistica=========================\n");
        System.out.println("===========================================================================\n");
        do {
            op = 0;
            System.out.println("\n\n>>>|Menu Principal|<<<");
            System.out.println("0 - Finalizar");
            System.out.println("1 - Usuario");
            System.out.println("2 - Obra");
            System.out.println("3 - Funcionario");
            System.out.print("Opcao: ");
            op = scanner.nextInt();
            switch (op) {
                case 0:
                    System.out.println("Programa sendo finalizado!....");
                    break;
                case 1:
                    ViewUsuario viewUsuario = new ViewUsuario();
                    do {
                        op = 0;
                        System.out.println("\n\n>>>|Menu Usuario|<<<");
                        System.out.println("0 - Voltar");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Buscar");
                        System.out.println("3 - Criar");
                        System.out.println("4 - Editar");
                        System.out.println("5 - Excluir");
                        System.out.print("Opcao: ");
                        op = scanner.nextInt();
                        switch (op) {
                            case 0:
                                System.out.println("voltando ao menu inicial....");
                                break;
                            case 1:
                                viewUsuario.listarUsuarios();
                                break;
                            case 2:
                                viewUsuario.buscarUsuario();
                                break;
                            case 3:
                                viewUsuario.criarNovoUsuario();
                                break;
                            case 4:
                                viewUsuario.editarUsuario();
                                break;
                            case 5:
                                viewUsuario.excluirUsuario();
                                break;
                            default:
                                break;
                        }
                    }while (op != 0);
                    op = 2;
                    break;
                case 2:
                    ViewObra viewObra = new ViewObra();
                    do {
                        op = 0;
                        System.out.println("\n\n>>>|Menu Obra|<<<");
                        System.out.println("0 - Voltar");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Buscar");
                        System.out.println("3 - Criar");
                        System.out.println("4 - Editar");
                        System.out.println("5 - Excluir");
                        System.out.println("6 - Almoxarifado");
                        System.out.print("Opcao: ");
                        op = scanner.nextInt();
                        switch (op) {
                            case 0:
                                System.out.println("voltando ao menu inicial....");
                                break;
                            case 1:
                                viewObra.listar();
                                break;
                            case 2:
                                viewObra.buscar();
                                break;
                            case 3:
                                viewObra.criar();
                                break;
                            case 4:
                                viewObra.editar();
                                break;
                            case 5:
                                viewObra.excluir();
                                break;
                            case 6:
                                System.out.println("----------------Selecionar Obra---------------------");
                                System.out.println("Informe o id: ");
                                long id = scanner.nextLong();
                                System.out.println("Aguarde...");
                                ObraController obraController = new ObraController();
                                Obra obra = obraController.show(id);
                                if(obra != null)System.out.println("Obra Encontrado: "+obra);
                                else System.out.println("Obra Não Encontrado");
                                System.out.println("--------------------------------------------------------");  
                                do {
                                    op = 0;
                                    System.out.println("\n\n>>>|Menu Almoxarifdao|<<<");
                                    System.out.println("0 - Voltar");
                                    System.out.println("1 - Listar");
                                    System.out.println("2 - Buscar");
                                    System.out.println("3 - Criar");
                                    System.out.println("4 - Editar");
                                    System.out.println("5 - Excluir");
                                    System.out.println("6 - Materiais");
                                    System.out.println("Opcao: ");
                                    op = scanner.nextInt();
                                    switch (op) {
                                        case 0:
                                            System.out.println("voltando ao menu inicial....");
                                            break;
                                        case 1:
                                            viewObra.listarAlmoxarifado(obra);
                                            break;
                                        case 2:
                                            viewObra.buscarAlmoxarifado();
                                            break;
                                        case 3:
                                            viewObra.criarAlmoxarifado(obra);
                                            break;
                                        case 4:
                                            viewObra.editarAlmoxarifado(obra);
                                            break;
                                        case 5:
                                            viewObra.excluirAlmoxarifado();
                                            break; 
                                        case 6:
                                            System.out.println("----------------Selecionar Almoxarifado---------------------");
                                            System.out.println("Informe o id: ");
                                            long idAlmoxarifado = scanner.nextLong();
                                            System.out.println("Aguarde...");
                                            AlmoxarifadoController almoxarifadoController = new AlmoxarifadoController();
                                            Almoxarifado almoxarifado = almoxarifadoController.show(idAlmoxarifado);
                                            if(almoxarifado != null)System.out.println("Almoxarifado Encontrado: "+almoxarifado);
                                            else System.out.println("almoxarifado Não Encontrado");
                                            System.out.println("--------------------------------------------------------");
                                            do {
                                                op = 0;
                                                System.out.println("\n\n>>>|Menu Materiais|<<<");
                                                System.out.println("0 - Voltar");
                                                System.out.println("1 - Listar");
                                                System.out.println("2 - Buscar");
                                                System.out.println("3 - Criar");
                                                System.out.println("4 - Editar");
                                                System.out.println("5 - Excluir");
                                                System.out.println("Opcao: ");
                                                op = scanner.nextInt();
                                                switch (op) {
                                                    case 0:
                                                        System.out.println("voltando ao menu inicial....");
                                                        break;
                                                    case 1:
                                                        viewObra.listarMateriais(almoxarifado);
                                                        break;
                                                    case 2:
                                                        viewObra.buscarMaterial();
                                                        break;
                                                    case 3:
                                                        viewObra.adicionarNovoMaterial(almoxarifado);
                                                        break;
                                                    case 4:
                                                        viewObra.editarMaterial(almoxarifado);
                                                        break;
                                                    case 5:
                                                        viewObra.excluirMaterial();
                                                        break;
                                                    default:
                                                        break;
                                                }
                                            } while (op != 0);
                                            op = 6;
                                            break;
                                        default:
                                            break;
                                    }
                                } while (op != 0);
                                op = 6;
                                break;
                            default:
                                break;
                        }
                    } while (op != 0);
                    op = 2;
                    break;
                case 3:
                    ViewFuncionario viewFuncionario = new ViewFuncionario();
                    do {
                        op = 0;
                        System.out.println("\n\n>>>|Menu Funcionario|<<<");
                        System.out.println("0 - Voltar");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Buscar");
                        System.out.println("3 - Criar");
                        System.out.println("4 - Editar");
                        System.out.println("5 - Excluir");
                        System.out.println("6 - Menu Cargos");
                        System.out.println("7 - Menu Enderecos");
                        System.out.print("Opcao: ");
                        op = scanner.nextInt();
                        switch (op) {
                            case 0:
                                System.out.println("voltando ao menu inicial....");
                                break;
                            case 1:
                                viewFuncionario.listarFuncionario();
                                break;
                            case 2:
                                viewFuncionario.buscarFuncionario();
                                break;
                            case 3:
                                viewFuncionario.criarNovoFuncionario();
                                break;
                            case 4:
                                viewFuncionario.editarFuncionario();
                                break;
                            case 5:
                                viewFuncionario.excluirFuncionario();
                                break;
                            case 6:
                                do {
                                    op = 0;
                                    System.out.println("\n\n>>>|Menu Cargos|<<<");
                                    System.out.println("0 - Voltar");
                                    System.out.println("1 - Listar");
                                    System.out.println("2 - Buscar");
                                    System.out.println("3 - Criar");
                                    System.out.println("4 - Editar");
                                    System.out.println("5 - Excluir");
                                    System.out.println("Opcao: ");
                                    op = scanner.nextInt();
                                    switch (op) {
                                        case 0:
                                            System.out.println("voltando ao menu inicial....");
                                            break;
                                        case 1:
                                            viewFuncionario.listarCargos();
                                            break;
                                        case 2:
                                            viewFuncionario.buscarCargo();
                                            break;
                                        case 3:
                                            viewFuncionario.criarNovoCargo();
                                            break;
                                        case 4:
                                            viewFuncionario.editarCargo();
                                            break;
                                        case 5:
                                            viewFuncionario.excluirCargo();
                                            break;
                                        default:
                                            break;
                                    }
                                } while (op != 0);
                                op = 6;
                                break;
                            case 7:
                                do {
                                    op = 0;
                                    System.out.println("\n\n>>>|Menu Enderecos|<<<");
                                    System.out.println("0 - Voltar");
                                    System.out.println("1 - Listar");
                                    System.out.println("2 - Buscar");
                                    System.out.println("3 - Criar");
                                    System.out.println("4 - Editar");
                                    System.out.println("5 - Excluir");
                                    System.out.println("Opcao: ");
                                    op = scanner.nextInt();
                                    switch (op) {
                                        case 0:
                                            System.out.println("voltando ao menu inicial....");
                                            break;
                                        case 1:
                                            viewFuncionario.listarCargos();
                                            break;
                                        case 2:
                                            viewFuncionario.buscarCargo();
                                            break;
                                        case 3:
                                            viewFuncionario.criarNovoCargo();
                                            break;
                                        case 4:
                                            viewFuncionario.editarCargo();
                                            break;
                                        case 5:
                                            viewFuncionario.excluirCargo();
                                            break;
                                        default:
                                            break;
                                    }
                                } while (op != 0);
                                op = 7;
                                break;
                            default:
                                break;
                        }
                    } while (op != 0);
                    op = 2;
                    break;
                default:
                    break;
            }

        } while (op != 0);
        scanner.close();
    }
}
