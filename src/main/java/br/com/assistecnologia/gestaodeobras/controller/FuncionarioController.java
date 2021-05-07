package br.com.assistecnologia.gestaodeobras.controller;

import br.com.assistecnologia.gestaodeobras.model.Usuario;

public class FuncionarioController {
    public List<Funcionario> index(){
        return Funcionario.listar();
    }

    public Funcionario show(long id){
        if(id <= 0){
            System.err.println("O id nao pode ser nulo ou vazio!");
            return null;
        }
        return Funcionario.buscar(id);
    }
    
    public boolean edit(
        long id, 
        String nome,
        String cpf,
        String matricula,
        Usuario usuario,
        Endereco endereco,
        Sexo sexo,
        Obra obra,
        Cargo cargo
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
            }
            if(passed == false){
                throw new Exception("O nome nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(cpf != null && cpf.length() >= 11 &&cpf.length() <= 14){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O cpf nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(matricula != null && matricula.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O descricao nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(sexo != null && sexo.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O sexo nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(usuario != null && usuario.getId() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O usuario nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(cargo != null && cargo.getId() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O cargo nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(obra != null && obra.getId() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("A obra nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(cargo != null && cargo.getId() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O cargo nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(endereco != null && endereco.getId() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O endereco nao pode ser nulo e deve ser valido!");
            }

            Funcionario itemPraEditar= new Funcionario(
                id, 
                nome,
                cpf,
                matricula,
                usuario,
                endereco,
                sexo,
                obra,
                cargo
            );
            return itemPraEditar.editar();
        } catch (Exception e) {
            System.err.println("Erro ao criar :\t" + e.getMessage());
            return false;
        }
    }
    public boolean create(
        String nome,
        String cpf,
        String matricula,
        Usuario usuario,
        Endereco endereco,
        Sexo sexo,
        Obra obra,
        Cargo cargo
    ){
        try {
            boolean passed = false;
    
            if(nome != null && nome.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O nome nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(cpf != null && cpf.length() >= 11 &&cpf.length() <= 14){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O cpf nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(matricula != null && matricula.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O descricao nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(sexo != null && sexo.length() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O sexo nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(usuario != null && usuario.getId() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O usuario nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(cargo != null && cargo.getId() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O cargo nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(obra != null && obra.getId() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("A obra nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(cargo != null && cargo.getId() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O cargo nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(endereco != null && endereco.getId() > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O endereco nao pode ser nulo e deve ser valido!");
            }

            Funcionario item= new Funcionario(
                nome,
                cpf,
                matricula,
                usuario,
                endereco,
                sexo,
                obra,
                cargo
            );
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
        return Funcionario.excluir(id);
    }

}
