package br.com.assistecnologia.gestaodeobras.model.dao;

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

public class UsuarioDAO {
    Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	public UsuarioDAO()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
		
	}
    // private String name;
    // private String email;
    // private String username;

	public List<Usuario> all(){
		List<Usuario> usuarios = new ArrayList();
		ResultSet set;
		
		try {
			statement = con.createStatement();
			set = statement.executeQuery("select * from usuario;");
					
					while (set.next()) {
						Usuario usuario = new Usuario();
						usuario.setId(set.getInt("id"));
						usuario.setName(set.getString("name"));
						usuario.setEmail(set.getString("email"));
						usuario.setUsername(set.getString("username"));
						usuarios.add(usuario);
					}
			
		}
		catch(Exception e) {
			
			System.err.println("erro ao listar usuario" + e.getMessage());
			
		}
		return usuarios;
		
	}	

	public Optional<Usuario> read(long id){
		try {
			ResultSet set;
			// statement = con.createStatement();
			// set = statement.executeQuery("select * from usuario where id = "+id+";");

			String queryUsuario = "select * from usuario where id = ?;";
			// con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(queryUsuario);
			preparedStatement.setLong(1, id);
			set = preparedStatement.executeQuery();
			// con.commit();	
			// set.beforeFirst();
			set.next();
			// System.out.println(set.getInt("id"));
			Usuario usuario = new Usuario();
			usuario.setId(set.getInt("id"));
			usuario.setName(set.getString("name"));
			usuario.setEmail(set.getString("email"));
			usuario.setUsername(set.getString("username"));
			Optional<Usuario> res = Optional.ofNullable(usuario);
			return res;
			// return new Usuario();
		}
		catch(Exception e) {
			
			System.err.println("erro ao mostrar usuario:  " + e.getMessage());
			return Optional.empty();
		}
	}
	
	public boolean create(Usuario usuario) {	
		boolean isSalvo = false;
		try {
			String queryUsuario = "insert into usuario (name,email,username)"
					+ "values(?,?,?);";
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(queryUsuario);
			preparedStatement.setString(1, usuario.getName());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getUsername());
			preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao inserir usuario:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
	
	public boolean edit(Usuario usuario) {
		boolean isSalvo = false;
		
		 String query = "UPDATE usuario "
				+ "SET name = ?,"
				+ "email = ?,"
				+ "username = ? "
				+ "WHERE id = ?";	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, usuario.getName());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getUsername());
			preparedStatement.setLong(4,usuario.getId());
			preparedStatement.executeUpdate();
			con.commit();
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao EDITAR usuario:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
	public boolean delete(long id) {
		boolean isSalvo = false;
		
		 String query = "delete from usuario where id = ?";

		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1,id);
			preparedStatement.execute();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao DELETAR usuario:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}

	// public boolean salvarPessoaComEndereco(Pessoa usuario) {
	// 	boolean isSalvo = false;
	// 	String query = "insert into usuario (nome,cpf,email,telefone,sexo,dataNascimento)"
	// 			+ "values(?,?,?,?,?,?);";

	// 	try {
			
	// 		con.setAutoCommit(false);
	// 		preparedStatement = con.prepareStatement(query);
	// 		preparedStatement.setString(1, usuario.getNome());
	// 		preparedStatement.setString(2, usuario.getCpf());
	// 		preparedStatement.setString(3, usuario.getEmail());
	// 		preparedStatement.setString(4, usuario.getTelefone());
	// 		preparedStatement.setString(5, usuario.getSexo().getDescricao());
	// 		preparedStatement.setDate(6 ,java.sql.Date.valueOf(usuario.getDataNascimento()) );
			
	// 		//preparedStatement.execute(query);
	// 	//	preparedStatement.execute();
	// 		preparedStatement.executeUpdate();
	// 		con.commit();			
	// 		isSalvo = true;
			
	// 	}
	// 	catch(Exception e){
			
	// 		System.out.println("Errp ao inserrir usuario:" + e.getMessage());
	// 		isSalvo = false;			
				
	// 	}
		
	// 	return isSalvo;
	// }
	
	// public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	//     return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	// }
	
	



}
