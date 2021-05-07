package br.com.assistecnologia.gestaodeobras.controller;

public class CargoController {
    public List<Cargo> index(){
        return Cargo.listar();
    }

    public Cargo show(long id){
        if(id <= 0){
            System.err.println("O id nao pode ser nulo ou vazio!");
            return null;
        }
        return Cargo.buscar(id);
    }

    public boolean edit(Long id, String nome){
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
           
            Cargo itemPraEditar= new Cargo(id,nome);
            return itemPraEditar.editar();
        } catch (Exception e) {
            System.err.println("Erro ao criar :\t" + e.getMessage());
            return false;
        }
    }
    public boolean create(Long id, String nome){
        try {
            boolean passed = false;
            if(id != null && nome.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O id nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(nome != null && codigo.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O nome nao pode ser nulo e deve ser valido!");
            }
            Cargo item= new Cargo(id,nome,codigo, descricao);
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
        return Cargo.excluir(id);
    }

}
