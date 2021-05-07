package br.com.assistecnologia.gestaodeobras.model.dao;

import br.com.assistecnologia.gestaodeobras.model.Obra;
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

public class ObraDAO {
    Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	public ObraDAO()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
		
	}

	public List<Obra> all(){
		List<Obra> items = new ArrayList();
		ResultSet set;
		
		try {
			statement = con.createStatement();
			set = statement.executeQuery("select * from obra;");
					
					while (set.next()) {
						Obra item = new Obra();
						item.setId(set.getInt("id"));
						item.setNome(set.getString("nome"));
						item.setCodigo(set.getString("codigo"));
						item.setDescricao(set.getString("descricao"));
						items.add(item);
					}
			
		}
		catch(Exception e) {
			
			System.err.println("erro ao listar item" + e.getMessage());
			
		}
		return items;
		
	}
	public Optional<Obra> read(long id){
		try {
			ResultSet set;
			// statement = con.createStatement();
			// set = statement.executeQuery("select * from item where id = "+id+";");

			String query = "select * from obra where id = ?;";
			// con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1, id);
			set = preparedStatement.executeQuery();
			// con.commit();	
			// set.beforeFirst();
			set.next();
			// System.out.println(set.getInt("id"));
			Obra item = new Obra();
			item.setId(set.getInt("id"));
			item.setNome(set.getString("nome"));
			item.setCodigo(set.getString("codigo"));
			item.setDescricao(set.getString("descricao"));
			Optional<Obra> res = Optional.ofNullable(item);
			return res;
			// return new Obra();
		}
		catch(Exception e) {
			
			System.err.println("erro ao mostrar item:  " + e.getMessage());
			return Optional.empty();
		}finally{
			con.close();
		}
	}

	public boolean create(Obra item) {	
		boolean isSalvo = false;
		try {
			String query = "insert into obra (nome,codigo,descricao)"
					+ "values(?,?,?);";
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, item.getNome());
			preparedStatement.setString(2, item.getCodigo());
			preparedStatement.setString(3, item.getDescricao());
			preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao inserir item:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
	
	public boolean edit(Obra item) {
		boolean isSalvo = false;
		
		 String query = "UPDATE obra "
				+ "SET nome = ?,"
				+ "codigo = ?,"
				+ "descricao = ?,"
				+ "WHERE id = ?";	
		
		try {

			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, item.getNome());
			preparedStatement.setString(2, item.getCodigo());
			preparedStatement.setString(3, item.getDescricao());
			preparedStatement.setLong(4,item.getId());
			preparedStatement.executeUpdate();
			con.commit();
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao editar item:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
	public boolean delete(long id) {
		boolean isSalvo = false;
		
		 String query = "delete from obra where id = ?";

		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1,id);
			preparedStatement.execute();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao deletar item:" + e.getMessage());
			isSalvo = false;			
				
		}
		
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
