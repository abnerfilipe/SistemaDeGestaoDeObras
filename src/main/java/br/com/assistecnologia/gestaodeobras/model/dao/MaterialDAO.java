package br.com.assistecnologia.gestaodeobras.model.dao;

import br.com.assistecnologia.gestaodeobras.model.Almoxarifado;
import br.com.assistecnologia.gestaodeobras.model.Material;
import br.com.assistecnologia.gestaodeobras.model.Obra;
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

public class MaterialDAO {
    Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	ObraDAO obraDAO;
	AlmoxarifadoDAO almoxarifadoDAO;
	
	public MaterialDAO()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
		obraDAO = new ObraDAO();
		almoxarifadoDAO = new AlmoxarifadoDAO();
	}

	public List<Material> all(){
		List<Material> data = new ArrayList();
		try {
			statement = con.createStatement();
			ResultSet set = statement.executeQuery("select * from material;");
					
					while (set.next()) {
						Material item = new Material();
						item.setId(set.getLong("id"));
						item.setNome(set.getString("nome"));
						item.setDescricao(set.getString("descricao"));
						item.setObservacao(set.getString("observacao"));
						item.setPeso(set.getDouble("peso"));
						ResultSet set2 = statement.executeQuery("select * from almoxarifado where id = "+set.getString("id")+";");
						Almoxarifado almoxarifado = new Almoxarifado();
						almoxarifado.setId(set2.getLong("id"));
						ResultSet set3 = statement.executeQuery("select * from obra where id = "+set2.getLong("obra_id")+";");
						Obra obra = new Obra();
						obra.setId(set3.getLong("id"));
						obra.setCodigo(set3.getString("codigo"));
						obra.setDescricao(set3.getString("descricao"));
						obra.setNome(set3.getString("nome"));
						almoxarifado.setObra(obra);
						item.setAlmoxarifado(almoxarifado);
						data.add(item);
					}
		}
		catch(Exception e) {
			
			System.err.println("erro ao listar item" + e.getMessage());
			
		}
		con.close();
		return data;
	}
	public List<Material> allFromAlmoxarifado(long id){
		List<Material> data = new ArrayList();
		try {
			statement = con.createStatement();
			ResultSet set = statement.executeQuery("select * from material where almoxarifado_id = "+id);
					
					while (set.next()) {
						Material item = new Material();
						item.setId(set.getLong("id"));
						item.setNome(set.getString("nome"));
						item.setDescricao(set.getString("descricao"));
						item.setObservacao(set.getString("observacao"));
						item.setPeso(set.getDouble("peso"));
						ResultSet set2 = statement.executeQuery("select * from almoxarifado where id = "+set.getString("id")+";");
						Almoxarifado almoxarifado = new Almoxarifado();
						almoxarifado.setId(set2.getLong("id"));
						ResultSet set3 = statement.executeQuery("select * from obra where id = "+set2.getLong("obra_id")+";");
						Obra obra = new Obra();
						obra.setId(set3.getLong("id"));
						obra.setCodigo(set3.getString("codigo"));
						obra.setDescricao(set3.getString("descricao"));
						obra.setNome(set3.getString("nome"));
						almoxarifado.setObra(obra);
						item.setAlmoxarifado(almoxarifado);
						data.add(item);
					}
		}
		catch(Exception e) {
			
			System.err.println("erro ao listar item" + e.getMessage());
			
		}
		con.close();
		return data;
	}
	public Optional<Material> read(long id){
		try {
			ResultSet set;
			// statement = con.createStatement();
			// set = statement.executeQuery("select * from item where id = "+id+";");

			String query = "select * from material where id = ?;";
			// con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1, id);
			set = preparedStatement.executeQuery();
			// con.commit();	
			// set.beforeFirst();
			set.next();
			// System.out.println(set.getInt("id"));
			Material item = new Material();
			item.setId(set.getInt("id"));
			item.setNome(set.getString("nome"));
			item.setDescricao(set.getString("descricao"));
			item.setObservacao(set.getString("observacao"));
			item.setPeso(set.getDouble("peso"));

	
			// String queryAlmoxarifado = "select * from almoxarifado where id = ?;";
			// preparedStatement = con.prepareStatement(queryAlmoxarifado);
			// preparedStatement.setLong(1, set.getLong("almoxarifado_id"));
			// ResultSet set2 = preparedStatement.executeQuery();
			// set2.next();
			// Almoxarifado almoxarifado = new Almoxarifado();
			// almoxarifado.setId(set2.getLong("id"));
			// Optional<Almoxarifado> almoxarifado = almoxarifadoDAO.read(set.getLong("almoxarifado_id").get());
			// Optional<Obra> obra = obraDAO.read(set2.getLong("obra_id"));
			
			// almoxarifado.setObra(obra.get());
			// item.setAlmoxarifado(almoxarifado);
			
			Optional<Material> res = Optional.ofNullable(item);
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
	
	public boolean create(Material item) {	
		boolean isSalvo = false;
		try {
			String query = "insert into material (nome) values(?);";
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, item.getNome());
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
	
	public boolean edit(Material item) {
		boolean isSalvo = false;
		
		 String query = "UPDATE material "
				+ "SET nome = ?,"
				+ "WHERE id = ?";	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, item.getNome());
            // preparedStatement.setString(2, item.getId());
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
		
		 String query = "delete from material where id = ?";

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
