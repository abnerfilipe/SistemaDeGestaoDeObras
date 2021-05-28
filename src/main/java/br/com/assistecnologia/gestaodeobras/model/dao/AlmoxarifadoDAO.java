package br.com.assistecnologia.gestaodeobras.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.assistecnologia.gestaodeobras.model.Almoxarifado;
import br.com.assistecnologia.gestaodeobras.model.dao.utilDao.ConnectionFactory;

public class AlmoxarifadoDAO {
    Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	ObraDAO obraDAO;
	MaterialDAO materialDAO;

	public AlmoxarifadoDAO()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
		obraDAO = new ObraDAO();
		materialDAO = new MaterialDAO();
	}

	public List<Almoxarifado> all() {
		List<Almoxarifado> data = new ArrayList<Almoxarifado>();
		ResultSet set;
		
		try {
			statement = con.createStatement();
			set = statement.executeQuery("select * from almoxarifado;");
					
					while (set.next()) {
						Almoxarifado item = new Almoxarifado();
						item.setId(set.getInt("id"));
						item.setNome(set.getString("nome"));
						item.setObra(obraDAO.read(set.getLong("obra_id")).get());
						item.setMateriais(materialDAO.allFromAlmoxarifado(set.getInt("id")));
						data.add(item);
					}
		}catch(Exception e) {
			
			System.err.println("erro ao listar item" + e.getMessage());
			
		}
		
		return data;
	}
	public ArrayList<Almoxarifado> allFromObra(long id){
		ArrayList<Almoxarifado> data = new ArrayList<Almoxarifado>();
		try {
			statement = con.createStatement();
			// ObraDAO obraDAO = new ObraDAO();
			// AlmoxarifadoDAO almoxarifadoDAO = new AlmoxarifadoDAO();
			ResultSet set = statement.executeQuery("select * from almoxarifado where obra_id = "+id);
					
					while (set.next()) {
						Almoxarifado item = new Almoxarifado();
						item.setId(set.getInt("id"));
						item.setNome(set.getString("nome"));
						item.setObra(obraDAO.read(set.getLong("obra_id")).get());
						item.setMateriais(materialDAO.allFromAlmoxarifado(set.getInt("id")));
						data.add(item);
					}
		}
		catch(Exception e) {
			System.err.println("erro ao listar item" + e.getMessage());
		}
		return data;
	}


	public Optional<Almoxarifado> read(long id){
		try {
			ResultSet set;
			String query = "select * from almoxarifado where id = ?;";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1, id);
			set = preparedStatement.executeQuery();
			if(set.next()){
				Almoxarifado item = new Almoxarifado();
				item.setId(set.getInt("id"));
				item.setNome(set.getString("nome"));
				item.setObra(obraDAO.read(set.getLong("obra_id")).get());
//				item.setMateriais(materialDAO.allFromAlmoxarifado(set.getInt("id")));
				Optional<Almoxarifado> res = Optional.ofNullable(item);

				return res;
			}
			return Optional.empty();
		}
		catch(Exception e) {
			System.err.println("erro ao mostrar item:  " + e.getMessage());
			return Optional.empty();
		}
	}
	
	public Almoxarifado create(Almoxarifado item){

		try {
			String query = "insert into almoxarifado (nome,obra_id) values(?,?);";
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, item.getNome());
			preparedStatement.setLong(2, item.getObra().getId());
			preparedStatement.executeUpdate();
			con.commit();			
			int idTemp = 0;
			ResultSet set = preparedStatement.executeQuery("select last_insert_id() as id");
			while (set.next()) {
				idTemp = set.getInt("id");
				
			}
			item.setId(idTemp);
			return item;
		}catch(Exception e){
			System.out.println("Erro ao inserir item:" + e.getMessage());
	
		}
		return null;
	}
	
	public Almoxarifado edit(Almoxarifado item) {
		try {
			String query = "UPDATE almoxarifado SET nome = ?, obra_id = ? WHERE id = ?";
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, item.getNome());
			preparedStatement.setLong(2, item.getObra().getId());
			preparedStatement.setLong(3, item.getId());
			preparedStatement.executeUpdate();
			con.commit();
			return item;
		}
		catch(Exception e){
			
			System.out.println("Erro ao editar item: " + e.getMessage());		
				
		}
		return null;
	}
	public boolean delete(long id){
	
		try {
			boolean isSalvo = false;
			String query = "delete from almoxarifado where id = ?";
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1,id);
			preparedStatement.execute();
			con.commit();			
			isSalvo = true;
			return isSalvo;
		}catch(Exception e){
			System.out.println("Erro ao excluir item:" + e.getMessage());
		}
		return false;
	}

	// public boolean salvarPessoaComEndereco(Pessoa item) {
	// 	boolean isSalvo = false;
	// 	String query = "insert into item (nome,cpf,email,telefone,sexo,dataNascimento)"
	// 			+ "values(?,?,?,?,?,?);";

	// 	try {
			
	// 		con.setAutoCommit(false);
	// 		preparedStatement = con.prepareStatement(query);
	// 		preparedStatement.setString(1, item.getNome());
	// 		preparedStatement.setString(2, item.getCpf());
	// 		preparedStatement.setString(3, item.getEmail());
	// 		preparedStatement.setString(4, item.getTelefone());
	// 		preparedStatement.setString(5, item.getSexo().getDescricao());
	// 		preparedStatement.setDate(6 ,java.sql.Date.valueOf(item.getDataNascimento()) );
			
	// 		//preparedStatement.execute(query);
	// 	//	preparedStatement.execute();
	// 		preparedStatement.executeUpdate();
	// 		con.commit();			
	// 		isSalvo = true;
			
	// 	}
	// 	catch(Exception e){
			
	// 		System.out.println("Errp ao inserrir item:" + e.getMessage());
	// 		isSalvo = false;			
				
	// 	}
		
	// 	return isSalvo;
	// }
	
	// public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	//     return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	// }
	
	



}
