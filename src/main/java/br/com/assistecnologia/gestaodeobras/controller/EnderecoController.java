package br.com.assistecnologia.gestaodeobras.controller;

import br.com.assistecnologia.gestaodeobras.model.Endereco;

public class EnderecoController {
    public List<Endereco> index(){
        return Endereco.listar();
    }

    public Endereco show(long id) {
        if(id <= 0){
            System.err.println("O id nao pode ser nulo ou vazio!");
            return null;
        }
        return Endereco.buscar(id);
    }
    
    public boolean edit(
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
            if(id != null && id.length() > 0){
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
           
            Endereco itemPraEditar= new Endereco(id,logradouro,numero,complemento,bairro,cidade,estado);
            return itemPraEditar.editar();
        } catch (Exception e) {
            System.err.println("Erro ao criar :\t" + e.getMessage());
            return false;
        }
    }
    public boolean create(
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
       
        Endereco item = new Endereco(id,logradouro,numero,complemento,bairro,cidade,estado);
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
        return Endereco.excluir(id);
    }
}
