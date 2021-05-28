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
import br.com.assistecnologia.gestaodeobras.model.Material;
import br.com.assistecnologia.gestaodeobras.model.Obra;
import br.com.assistecnologia.gestaodeobras.model.dao.utilDao.ConnectionFactory;

public class MaterialDAO {
    Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	// ObraDAO obraDAO;
	// AlmoxarifadoDAO almoxarifadoDAO;

	public MaterialDAO()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
	}

	public List<Material> all() {
		List<Material> data = new ArrayList();
		try {
			ObraDAO obraDAO = new ObraDAO();
			AlmoxarifadoDAO almoxarifadoDAO = new AlmoxarifadoDAO();
			statement = con.createStatement();
			ResultSet set = statement.executeQuery("select * from material;");

				while (set.next()) {
					Material item = new Material();
					item.setId(set.getLong("id"));
					item.setNome(set.getString("nome"));
					item.setDescricao(set.getString("descricao"));
					item.setObservacao(set.getString("observacao"));
					item.setPeso(set.getDouble("peso"));
					Almoxarifado almoxarifado = almoxarifadoDAO.read(set.getLong("almoxarifado_id")).get();
					Obra obra = obraDAO.read(almoxarifado.getObra().getId()).get();
					almoxarifado.setObra(obra);
					item.setAlmoxarifado(almoxarifado);
					data.add(item);
				}
		}
		catch(SQLException e) {

			System.err.println("erro ao listar item " + e.getMessage());

		}
		return data;
	}
	public ArrayList<Material> allFromAlmoxarifado(long id)  {
		ArrayList<Material> data = new ArrayList();
		try {
			statement = con.createStatement();
			ObraDAO obraDAO = new ObraDAO();
			AlmoxarifadoDAO almoxarifadoDAO = new AlmoxarifadoDAO();
			ResultSet set = statement.executeQuery("select * from material where almoxarifado_id = "+id);

					while (set.next()) {
						Material item = new Material();
						item.setId(set.getLong("id"));
						item.setNome(set.getString("nome"));
						item.setDescricao(set.getString("descricao"));
						item.setObservacao(set.getString("observacao"));
						item.setPeso(set.getDouble("peso"));
						Almoxarifado almoxarifado = almoxarifadoDAO.read(set.getLong("almoxarifado_id")).get();
						Obra obra = obraDAO.read(almoxarifado.getObra().getId()).get();
						almoxarifado.setObra(obra);
						item.setAlmoxarifado(almoxarifado);
						data.add(item);
					}
		}
		catch(SQLException e) {
			System.err.println("erro ao listar item" + e.getMessage());
		}
		return data;
	}

	public Optional<Material> read(long id) {
		try {
			ResultSet set;
			// statement = con.createStatement();
			// set = statement.executeQuery("select * from item where id = "+id+";");

			String query = "select * from material where id = ?;";
			// con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			ObraDAO obraDAO = new ObraDAO();
			AlmoxarifadoDAO almoxarifadoDAO = new AlmoxarifadoDAO();
			preparedStatement.setLong(1, id);
			set = preparedStatement.executeQuery();
			if(set.next()){
				Material item = new Material();
				item.setId(set.getInt("id"));
				item.setNome(set.getString("nome"));
				item.setDescricao(set.getString("descricao"));
				item.setObservacao(set.getString("observacao"));
				item.setPeso(set.getDouble("peso"));
				Almoxarifado almoxarifado = almoxarifadoDAO.read(set.getLong("almoxarifado_id")).get();
				Obra obra = obraDAO.read(almoxarifado.getObra().getId()).get();

				almoxarifado.setObra(obra);
				item.setAlmoxarifado(almoxarifado);

				Optional<Material> res = Optional.ofNullable(item);
				preparedStatement.close();
				return res;
			}
			return Optional.empty();
		}
		catch(SQLException e) {
			System.err.println("erro ao mostrar item:  " + e.getMessage());
			return Optional.empty();
		}
	}

	public Material create(Material item)   {
		try {
			String query = "insert into material (nome,descricao,observacao,peso,almoxarifado_id) values(?,?,?,?,?);";
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, item.getNome());
			preparedStatement.setString(2, item.getDescricao());
			preparedStatement.setString(3, item.getObservacao());
			preparedStatement.setDouble(4, item.getPeso());
			preparedStatement.setLong(5, item.getAlmoxarifado().getId());
			preparedStatement.executeUpdate();
			con.commit();
			int idTemp = 0;
			ResultSet set = preparedStatement.executeQuery("select last_insert_id() as id");
			while (set.next()) {
				idTemp = set.getInt("id");
			}
			item.setId(idTemp);
			return item;
		}
		catch(SQLException e){
			System.out.println("Erro ao inserir item:" + e.getMessage());
			return null;
		}
	}

	public Material edit(Material item)   {
		boolean isSalvo = false;

		try {
			String query = "UPDATE material SET nome = ?,descricao = ?,observacao= ?,peso= ?,almoxarifado_id= ? WHERE id = ?";
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, item.getNome());
			preparedStatement.setString(2, item.getDescricao());
			preparedStatement.setString(3, item.getObservacao());
			preparedStatement.setDouble(4, item.getPeso());
			preparedStatement.setLong(5, item.getAlmoxarifado().getId());
			preparedStatement.setLong(6, item.getId());
			preparedStatement.executeUpdate();
			con.commit();
			return item;
		}
		catch(SQLException e){

			System.out.println("Erro ao editar item: " + e.getMessage());
			return null;
		}
	}
	public boolean delete(long id)   {
		boolean isSalvo = false;
		try {
			String query = "delete from material where id = ?";
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1,id);
			preparedStatement.execute();
			con.commit();
			isSalvo = true;

		}
		catch(SQLException e){

			System.out.println("Erro ao excluir item:" + e.getMessage());
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
