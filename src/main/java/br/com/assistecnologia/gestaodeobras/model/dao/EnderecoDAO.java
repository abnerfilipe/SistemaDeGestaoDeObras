package br.com.assistecnologia.gestaodeobras.model.dao;

import br.com.assistecnologia.gestaodeobras.model.Endereco;
import br.com.assistecnologia.gestaodeobras.model.Endereco;
import br.com.assistecnologia.gestaodeobras.model.Usuario;
import br.com.assistecnologia.gestaodeobras.model.dao.utilDao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.google.protobuf.Option;

public class EnderecoDAO {
    Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	public EnderecoDAO()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
		
	}

	public List<Endereco> all(){
		List<Endereco> data = new ArrayList<Endereco>();
		ResultSet set;
	
		try {
			statement = con.createStatement();
			set = statement.executeQuery("SELECT * FROM endereco ORDER BY id DESC;");
					
					while (set.next()) {
						Endereco item = new Endereco();
						item.setId(set.getInt("id"));
						item.setLogradouro(set.getString("logradouro"));
						item.setNumero(set.getString("numero"));
						item.setComplemento(set.getString("complemento"));
						item.setBairro(set.getString("bairro"));
						item.setCidade(set.getString("cidade"));
						item.setEstado(set.getString("estado"));
						data.add(item);
					}
		}
		catch(Exception e) {
			
			System.err.println("erro ao listar item" + e.getMessage());
			
		}
		return data;
		
	}
	public Optional<Endereco> read(long id){
		try {
			ResultSet set;
			// statement = con.createStatement();
			// set = statement.executeQuery("select * from item where id = "+id+";");

			String query = "select * from endereco where id = ?;";
			// con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1, id);
			set = preparedStatement.executeQuery();
			if(set.next()){
				Endereco item = new Endereco();
				item.setId(set.getInt("id"));
				item.setNumero(set.getString("numero"));
				item.setBairro(set.getString("bairro"));
				item.setCidade(set.getString("cidade"));
				item.setEstado(set.getString("estado"));
				item.setLogradouro(set.getString("logradouro"));
				item.setComplemento(set.getString("complemento"));
				Optional<Endereco> res = Optional.ofNullable(item);
				return res;
			}
			return Optional.empty();
		}
	
		catch(Exception e) {
			System.err.println("erro ao mostrar item:  " + e.getMessage());
			return Optional.empty();
		}
	}


	public Endereco create(Endereco item){	
		try {
			String query = "insert into endereco (logradouro,numero,complemento,bairro,cidade,estado)"+
			"values(?,?,?,?,?,?);";
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, item.getLogradouro());
			preparedStatement.setString(2, item.getNumero());
			preparedStatement.setString(3, item.getComplemento());
			preparedStatement.setString(4, item.getBairro());
			preparedStatement.setString(5, item.getCidade());
			preparedStatement.setString(6, item.getEstado());
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
		catch(Exception e){
			System.out.println("Erro ao inserir item:" + e.getMessage());			
		}
		return null;
	}
	
	public Endereco edit(Endereco item) {
		try {
			String query = "UPDATE endereco "
			+ "SET logradouro = ?,"
			+ "numero = ?,"
			+ "complemento = ?,"
			+ "bairro = ?,"
			+ "cidade = ?,"
			+ "estado = ?"
			+ "WHERE id = ?";	
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, item.getLogradouro());
			preparedStatement.setString(2, item.getNumero());
			preparedStatement.setString(3, item.getComplemento());
			preparedStatement.setString(4, item.getBairro());
			preparedStatement.setString(5, item.getCidade());
			preparedStatement.setString(6, item.getEstado());
			preparedStatement.setLong(7, item.getId());
			preparedStatement.executeUpdate();
			con.commit();
			return item;
		}
		catch(Exception e){
			
			System.out.println("Erro ao editar item: " + e.getMessage());		
		}
		return null;
	}
	public boolean delete(long id) {
		boolean isSalvo = false;
		
		 String query = "delete from endereco where id = ?";

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
