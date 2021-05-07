package br.com.assistecnologia.gestaodeobras.model;

import java.util.List;
import java.util.Optional;

import br.com.assistecnologia.gestaodeobras.model.dao.ObraDAO;

public class Obra {
    private long id;
    private String nome;
    private String codigo;
    private String descricao;
    private ObraDAO obraDAO;

    public Obra(){
        this.obraDAO = new  ObraDAO();
    }

    public Obra(long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.obraDAO = new  ObraDAO();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ObraDAO getObraDAO() {
        return obraDAO;
    }

    public void setObraDAO(ObraDAO obraDAO) {
        this.obraDAO = obraDAO;
    }

    // Methods

  

    public boolean criar() {
        return this.getObraDAO().create(this);
    }

    public boolean editar() {
        return this.getObraDAO().edit(this);
    }
    public static List<Obra> listar() {
        Obra item = new Obra();
        return item.getObraDAO().all();
    }
    public static Optional<Obra> buscar(long id) {
        Obra item = new Obra();
        return item.getObraDAO().read(id);
    }
    public static boolean excluir(long id){
        Obra item = new Obra();
        return item.getObraDAO().delete(id);
    }

    @Override
    public String toString() {
        return "Obra [id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + ", nome=" + nome + "]";
    }

    // @Override
    // public String toString() {
    //     // TODO Auto-generated method stub
    //     return " Id: "+this.getId() +" | Nome: "+this.getNome() +" | Codigo: "+this.getCodigo() +" | Descricao: "+this.getDescricao();
    // }

    
}
