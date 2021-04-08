package br.com.assistecnologia.gestaodeobras.model;

import java.util.ArrayList;
import java.util.Date;

public class Condutor extends Funcionario{
    private String numeroCNH;
    private Date validadeCNH;
    private ArrayList<CategoriaCNH> categoriaCNH;

    public Condutor(long id, String nome, String cpf, String matricula, Usuario usuario, Endereco endereco, Sexo sexo, Obra obra) {
        super(id, nome, cpf, matricula, usuario, endereco, sexo, obra);
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public Date getValidadeCNH() {
        return validadeCNH;
    }

    public void setValidadeCNH(Date validadeCNH) {
        this.validadeCNH = validadeCNH;
    }

    public ArrayList<CategoriaCNH> getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(ArrayList<CategoriaCNH> categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
    }
}
