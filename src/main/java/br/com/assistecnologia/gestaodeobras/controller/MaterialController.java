package br.com.assistecnologia.gestaodeobras.controller;

import br.com.assistecnologia.gestaodeobras.model.Material;

public class MaterialController {
    public List<Material> index(){
        return Material.listar();
    }

    public Material show(long id){
        if(id <= 0){
            System.err.println("O id nao pode ser nulo ou vazio!");
            return null;
        }
        return Material.buscar(id);
    }

    public boolean edit(
        Long id, 
        String nome, 
        Double peso, 
        String descricao, 
        String observacao, 
        Almoxarifado almoxarifado
    ){
        try {
            boolean passed = false;
            if(id != null && id.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O id nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(nome != null && nome.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O nome nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(peso != null && peso >= 0.0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O peso nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(descricao != null && descricao.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("A descricao nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(observacao != null && observacao.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("A observacao nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(almoxarifado != null && almoxarifado.getId() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O almoxarifado nao pode ser nulo e deve ser valido!");
            }
           
            Material itemPraEditar= new Material(id,nome,peso,descricao, observacao,almoxarifado);
            return itemPraEditar.editar();
        } catch (Exception e) {
            System.err.println("Erro ao editar :\t" + e.getMessage());
            return false;
        }
    }
    public boolean create(
        String nome, 
        Double peso, 
        String descricao, 
        String observacao, 
        Almoxarifado almoxarifado
    ){
        try {
            boolean passed = false;
            if(id != null && id.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O id nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(nome != null && nome.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O nome nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(peso != null && peso >= 0.0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O peso nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(descricao != null && descricao.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("A descricao nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(observacao != null && observacao.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("A observacao nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(almoxarifado != null && almoxarifado.getId() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O almoxarifado nao pode ser nulo e deve ser valido!");
            }
           
            Material item= new Material(nome,peso,descricao, observacao,almoxarifado);
            return item.criar();
        } catch (Exception e) {
            System.err.println("Erro ao criar :\t" + e.getMessage());
            return false;
        }
    }
  
    public boolean delete(long id){
        if(id <= 0){
            System.err.println("O id nao pode ser nulo ou vazio!");
            return false;
        }
        return Material.excluir(id);
    }

}
