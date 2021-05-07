package br.com.assistecnologia.gestaodeobras.model;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.google.protobuf.Option;

import br.com.assistecnologia.gestaodeobras.model.dao.MaterialDAO;

public class Material {
    private long id;
    private String nome;
    private Double peso;
    private String descricao;
    private String observacao;
    private Almoxarifado almoxarifado;
    private MaterialDAO materialDAO;

    public Material() {
        this.materialDAO = new MaterialDAO();
    }

    public Material(
        long id, 
        String nome, 
        Double peso, 
        String descricao, 
        String observacao, 
        Almoxarifado almoxarifado
    ){
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.descricao = descricao;
        this.observacao = observacao;
        this.almoxarifado = almoxarifado;
        this.materialDAO = new MaterialDAO();
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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Almoxarifado getAlmoxarifado() {
        return almoxarifado;
    }

    public void setAlmoxarifado(Almoxarifado almoxarifado) {
        this.almoxarifado = almoxarifado;
    }

    public MaterialDAO getMaterialDAO() {
        return materialDAO;
    }

    public void setMaterialDAO(MaterialDAO materialDAO) {
        this.materialDAO = materialDAO;
    }


    // Overrides


    @Override
    public String toString() {
        return "Material [id=" + id + ", almoxarifado=" + almoxarifado.toString() + ", descricao=" + descricao + ", nome=" + nome
                + ", observacao=" + observacao + ", peso=" + peso + "]";
    }

    // Methods
    public boolean criar() {
        return this.getMaterialDAO().create(this);
    }

    public boolean editar() {
        return this.getMaterialDAO().edit(this);
    }
    public static List<Material> listar() {
        Material item = new Material();
        return item.getMaterialDAO().all();
    }
    public static Optional<Material> buscar(long id){
        Material item = new Material();
        return item.getMaterialDAO().read(id);
    }
    public static boolean excluir(long id){
        Material item = new Material();
        return item.getMaterialDAO().delete(id);
    }
}
