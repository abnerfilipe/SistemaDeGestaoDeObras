package br.com.assistecnologia.gestaodeobras.controller;

import java.util.List;

import br.com.assistecnologia.gestaodeobras.model.Endereco;
import br.com.assistecnologia.gestaodeobras.model.dao.EnderecoDAO;

public class EnderecoController {
 


    public List<Endereco> index(){
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.all();
    }

    public Endereco show(long id) {
        if(id <= 0 ){
            System.err.println("O id nao pode ser nulo !");
            return null;
        }
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.read(id).get();
    }
    
    public Endereco edit(
        Long id,
        String logradouro,
        String numero,
        String complemento, 
        String bairro, 
        String cidade, 
        String estado
    ){
        try {
            boolean passed = false;
            if(id != null && id > 0){
                passed = true;
            }
            if(passed == false){
                throw new Exception("O id nao pode ser nulo ou vazio!");
            }
            passed = false;
            if(logradouro != null && logradouro.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O logradouro nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(numero != null && numero.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O numero nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(complemento != null && complemento.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O complemento nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(bairro != null && bairro.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O bairro nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(cidade != null && cidade.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O cidade nao pode ser nulo e deve ser valido!");
            }
            passed = false;
            if(estado != null && estado.length() > 0){
                passed = true;
            };
            if(passed == false){
                throw new Exception("O estado nao pode ser nulo e deve ser valido!");
            }
           
            Endereco item= new Endereco(id,logradouro,numero,complemento,bairro,cidade,estado);
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            return enderecoDAO.edit(item);
        } catch (Exception e) {
            System.err.println("Erro ao editar :\t" + e.getMessage());
            return null;
        }
    }

    public Endereco create(
        String logradouro,
        String numero,
        String complemento, 
        String bairro, 
        String cidade, 
        String estado
){
    try {
        boolean passed = false;
        passed = false;
        if(logradouro != null && logradouro.length() > 0){
            passed = true;
        };
        if(passed == false){
            throw new Exception("O logradouro nao pode ser nulo e deve ser valido!");
        }
        passed = false;
        if(numero != null && numero.length() > 0){
            passed = true;
        };
        if(passed == false){
            throw new Exception("O numero nao pode ser nulo e deve ser valido!");
        }
        passed = false;
        if(complemento != null && complemento.length() > 0){
            passed = true;
        };
        if(passed == false){
            throw new Exception("O complemento nao pode ser nulo e deve ser valido!");
        }
        passed = false;
        if(bairro != null && bairro.length() > 0){
            passed = true;
        };
        if(passed == false){
            throw new Exception("O bairro nao pode ser nulo e deve ser valido!");
        }
        passed = false;
        if(cidade != null && cidade.length() > 0){
            passed = true;
        };
        if(passed == false){
            throw new Exception("O cidade nao pode ser nulo e deve ser valido!");
        }
        passed = false;
        if(estado != null && estado.length() > 0){
            passed = true;
        };
        if(passed == false){
            throw new Exception("O estado nao pode ser nulo e deve ser valido!");
        }
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco item = new Endereco(logradouro,numero,complemento,bairro,cidade,estado);
        return enderecoDAO.create(item);
        } catch (Exception e) {
            System.err.println("Erro ao criar :\t" + e.getMessage());
            return null;
        }
    }

    public boolean delete(long id){
        
        if(id <= 0 ){
            System.err.println("O id nao pode ser nulo ou inexistente!");
            return false;
        }
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.delete(id);
    }
}
