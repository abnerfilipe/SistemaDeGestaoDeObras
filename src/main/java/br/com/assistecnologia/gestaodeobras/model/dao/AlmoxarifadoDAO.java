package br.com.assistecnologia.gestaodeobras.model.dao;

import br.com.assistecnologia.gestaodeobras.model.Almoxarifado;
import br.com.assistecnologia.gestaodeobras.model.Usuario;
import br.com.assistecnologia.gestaodeobras.model.dao.utilDao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.google.protobuf.Option;

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

	public List<Almoxarifado> all(){
		List<Almoxarifado> data = new ArrayList();
		ResultSet set;
		
		try {
			statement = con.createStatement();
			set = statement.executeQuery("select * from almoxarifado;");
					
					while (set.next()) {
						Almoxarifado item = new Almoxarifado();
						item.setId(set.getInt("id"));
						item.setNome(set.getString("nome"));
						item.setObra(obraDAO.read(set.getString("obra_id")).get());
						item.setMateriais(materialDAO.allFromAlmoxarifado(set.getInt("id")));
						data.add(item);
					}
		}
		catch(Exception e) {
			
			System.err.println("erro ao listar item" + e.getMessage());
			
		}
		con.close();
		return data;
		
	}
	public Optional<Almoxarifado> read(long id){
		try {
			ResultSet set;
			String query = "select * from almoxarifado where id = ?;";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1, id);
			set = preparedStatement.executeQuery();
			set.next();
			Almoxarifado item = new Almoxarifado();
			item.setId(set.getInt("id"));
			item.setNome(set.getString("nome"));
			item.setObra(obraDAO.read(set.getString("obra_id")).get());
			item.setMateriais(materialDAO.allFromAlmoxarifado(set.getInt("id")));
			Optional<Almoxarifado> res = Optional.ofNullable(item);
			con.close();
			return res;
		}
		catch(Exception e) {
			System.err.println("erro ao mostrar item:  " + e.getMessage());
			con.close();
			return Optional.empty();
		}finally{
			con.close();
		}
	}
	
	public boolean create(Almoxarifado item) {	
		boolean isSalvo = false;
		try {
			String query = "insert into almoxarifado (nome,obra_id) values(?,?);";
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, item.getNome());
			preparedStatement.setLong(1, item.getObra().getId());
			preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
		}
		catch(Exception e){
			System.out.println("Erro ao inserir item:" + e.getMessage());
			isSalvo = false;			
		}
		con.close();
		return isSalvo;
	}
	
	public boolean edit(Almoxarifado item) {
		boolean isSalvo = false;
		
		 String query = "UPDATE almoxarifado "
				+ "SET nome = ?,"
				+ "SET obra_id = ?,"
				+ "WHERE id = ?";	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, item.getNome());
            preparedStatement.setString(2, item.getId());
            preparedStatement.setLong(2, item.getObra().getId());
			preparedStatement.executeUpdate();
			con.commit();
			isSalvo = true;
		}
		catch(Exception e){
			
			System.out.println("Erro ao editar item: " + e.getMessage());
			isSalvo = false;			
				
		}
		con.close();
		return isSalvo;
	}
	public boolean delete(long id) {
		boolean isSalvo = false;
		
		 String query = "delete from almoxarifado where id = ?";

		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1,id);
			preparedStatement.execute();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao excluir item:" + e.getMessage());
			isSalvo = false;			
				
		}
		con.close();
		return isSalvo;
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
