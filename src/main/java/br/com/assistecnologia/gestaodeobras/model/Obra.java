package br.com.assistecnologia.gestaodeobras.model;

public class Obra {
    private long id;
    private String nome;
    private String codigo;
    private String descricao;

    public Obra(){
    }

    public Obra(Long id, String nome,String codigo, String descricao) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Obra(String nome, String codigo, String descricao) {
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
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
    @Override
    public String toString() {
        return "[id: " + id + ", codigo: " + codigo + ", descricao: " + descricao + ", nome: " + nome + "]";
    }



    
}
