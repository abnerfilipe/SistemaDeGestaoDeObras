package br.com.assistecnologia.gestaodeobras.model;

import java.util.List;
import java.util.Optional;

import br.com.assistecnologia.gestaodeobras.model.dao.CargoDAO;

public class Cargo {
    private long id;
    private String nome;
    private CargoDAO cargoDAO;

    public Cargo() {
        this.cargoDAO = new CargoDAO();
    }

    public Cargo(String nome) {
        this.cargoDAO = new CargoDAO();
        this.nome = nome;
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
    public CargoDAO getCargoDAO() {
        return cargoDAO;
    }

    public void setCargoDAO(CargoDAO cargoDAO) {
        this.cargoDAO = cargoDAO;
    }

  // methods
    public boolean criar() {
        return this.getCargoDAO().create(this);
    }

    public boolean editar() {
        return this.getCargoDAO().edit(this);
    }
    public static List<Cargo> listar() {
        Cargo item = new Cargo();
        return item.getCargoDAO().all();
    }
    public static Optional<Cargo> buscar(long id){
        Cargo item = new Cargo();
        return item.getCargoDAO().read(id);
    }
    public static boolean excluir(long id){
        Cargo item = new Cargo();
        return item.getCargoDAO().delete(id);
    }

    // Overrides
    @Override
    public String toString() {
        return "Cargo [id=" + id + ", nome=" + nome + "]";
    }

  
} 
