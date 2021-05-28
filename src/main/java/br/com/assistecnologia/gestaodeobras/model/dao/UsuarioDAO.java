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
public class UsuarioDAO {
    Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	public UsuarioDAO()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
	}
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
			String queryUsuario = "select * from usuario where id = ?;";
			preparedStatement = con.prepareStatement(queryUsuario);
			preparedStatement.setLong(1, id);
			set = preparedStatement.executeQuery();
			
			if(set.next()){
				Usuario usuario = new Usuario();
				usuario.setId(set.getInt("id"));
				usuario.setName(set.getString("name"));
				usuario.setEmail(set.getString("email"));
				usuario.setUsername(set.getString("username"));
				Optional<Usuario> res = Optional.ofNullable(usuario);
				return res;
			}
			return Optional.empty();
		}
		catch(Exception e) {
			System.err.println("erro ao mostrar usuario:  " + e.getMessage());
			return Optional.empty();
		}
	}
	public Usuario create(Usuario item) {
		try {
			String query = "insert into usuario (name,email,username)"
					+ "values(?,?,?);";
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, item.getName());
			preparedStatement.setString(2, item.getEmail());
			preparedStatement.setString(3, item.getUsername());
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
			System.out.println("Erro ao inserir usuario:" + e.getMessage());		
		}
		return null;
	}
	public Usuario edit(Usuario item) {
		boolean isSalvo = false;
		 String query = "UPDATE usuario "
				+ "SET name = ?,"
				+ "email = ?,"
				+ "username = ? "
				+ "WHERE id = ?";	
		try {
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, item.getName());
			preparedStatement.setString(2, item.getEmail());
			preparedStatement.setString(3, item.getUsername());
			preparedStatement.setLong(4,item.getId());
			preparedStatement.executeUpdate();
			con.commit();
			return item;
		}
		catch(Exception e){
			System.out.println("Erro ao EDITAR usuario:" + e.getMessage());
			return null;
		}
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
}
