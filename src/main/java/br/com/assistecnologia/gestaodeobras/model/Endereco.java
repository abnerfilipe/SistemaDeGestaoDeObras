package br.com.assistecnologia.gestaodeobras.model;

import java.util.List;
import java.util.Optional;

import br.com.assistecnologia.gestaodeobras.model.dao.EnderecoDAO;

public class Endereco {
    private long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private EnderecoDAO enderecoDAO;
    
    public Endereco() {
        this.enderecoDAO = new EnderecoDAO();
    }

    public Endereco(long id, String logradouro, String numero, String complemento, String bairro, String cidade,String estado) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.enderecoDAO = new EnderecoDAO();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    public EnderecoDAO getEnderecoDAO() {
        return enderecoDAO;
    }

    public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
        this.enderecoDAO = enderecoDAO;
    }

    //Overrides 
    @Override
    public String toString() {
        return "Endereco [id=" + id + ",bairro=" + bairro + ", cidade=" + cidade + ", complemento=" + complemento + ", estado="
                + estado + ", logradouro=" + logradouro + ", numero=" + numero + "]";
    } 


    // methods
    public boolean criar() {
        return this.getEnderecoDAO().create(this);
    }
    public boolean editar() {
        return this.getEnderecoDAO().edit(this);
    }
    public static List<Endereco> listar() {
        Endereco item = new Endereco();
        return item.getEnderecoDAO().all();
    }
    public static Optional<Endereco> buscar(long id){
        Endereco item = new Endereco();
        return item.getEnderecoDAO().read(id);
    }
    public static boolean excluir(long id){
        Endereco item = new Endereco();
        return item.getEnderecoDAO().delete(id);
    }

}
