package br.com.assistecnologia.gestaodeobras.model;

import java.util.ArrayList;
import java.util.Date;

public class Condutor extends Funcionario{
    String numeroCNH;
    Date validadeCNH;
    ArrayList<CategoriaCNH> categoriaCNH;
    public Condutor(long id, String nome, String cpf, String matricula, Usuario usuario, Endereco endereco, Sexo sexo, Obra obra) {
        super(id, nome, cpf, matricula, usuario, endereco, sexo, obra);
    }
}
