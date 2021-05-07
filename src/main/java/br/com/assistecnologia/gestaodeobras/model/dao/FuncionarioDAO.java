package br.com.assistecnologia.gestaodeobras.model.dao;

import br.com.assistecnologia.gestaodeobras.model.Funcionario;
import br.com.assistecnologia.gestaodeobras.model.Usuario;
import br.com.assistecnologia.gestaodeobras.model.enderecoDAO;
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

public class FuncionarioDAO {
    Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	EnderecoDAO enderecoDAO;
	UsuarioDAO usuarioDAO;
	ObraDAO obraDAO;
	CargoDAO cargoDAO;


	public FuncionarioDAO()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
		enderecoDAO = new EnderecoDAO();
		usuarioDAO = new UsuarioDAO();
		obraDAO = new ObraDAO();
		cargoDAO = new CargoDAO();
	}
  
	public List<Funcionario> all(){
		List<Funcionario> data = new ArrayList();
		ResultSet set;
	
		try {
			statement = con.createStatement();
			set = statement.executeQuery("select * from funcionario;");
					
					while (set.next()) {
						Funcionario item = new Funcionario();
						item.setId(set.getInt("id"));
						item.setNome(set.getString("nome"));
						item.setCpf(set.getString("cpf"));
						item.setMatricula(set.getString("matricula"));
						item.setSexo(set.getString("sexo"));
						item.setCargo(cargoDAO.read(set.getLong(cargo_id)).get());
						item.setEndereco(enderecoDAO.read(set.getLong(cargo_id)).get());
						item.setObra(obraDAO.read(set.getLong(obra_id)).get());
						item.setUsuario(usuarioDAO.read(set.getLong(usuario_id)).get());
						data.add(item);
					}
		}
		catch(Exception e) {
			
			System.err.println("erro ao listar item" + e.getMessage());
			
		}
		con.close();
		return data;
	}
	public Optional<Funcionario> read(long id){
		try {
			String query = "select * from funcionario where id = ?;";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1, id);
			ResultSet set = preparedStatement.executeQuery();
			set.next();
			Funcionario item = new Funcionario();
			item.setId(set.getInt("id"));
			item.setNome(set.getString("nome"));
			item.setCpf(set.getString("cpf"));
			item.setMatricula(set.getString("matricula"));
			item.setSexo(set.getString("sexo"));
			item.setCargo(cargoDAO.read(set.getLong(cargo_id)).get());
			item.setEndereco(enderecoDAO.read(set.getLong(cargo_id)).get());
			item.setObra(obraDAO.read(set.getLong(obra_id)).get());
			item.setUsuario(usuarioDAO.read(set.getLong(usuario_id)).get());
			Optional<Funcionario> res = Optional.ofNullable(item);
			con.close();
			return res;
		}
		catch(Exception e) {
			System.err.println("erro ao mostrar item:  " + e.getMessage());
			con.close();
			return Optional.empty();
		}
	}
		  // private long id;
		// private String nome;
		// private String cpf;
		// private String matricula;
		// private Usuario usuario;
		// private Endereco endereco;
		// private Sexo sexo;
		// private Obra obra;
		// private Cargo cargo;
	public boolean create(Funcionario item) {	
		boolean isSalvo = false;
		try {
			String query = "insert into funcionario (nome, cpf, matricula, usuario_id, endereco_id, sexo, obra_id, cargo_id)"+
			"values(?,?,?,?,?,?,?,?);";
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(queryUsuario);
			preparedStatement.setString(1, item.getNome());
			preparedStatement.setString(2, item.getCpf());
			preparedStatement.setString(3, item.getMatricula());
			preparedStatement.setLong(4, item.getUsuario().getId());
			preparedStatement.setLong(5, item.getEndereco().getId());
			preparedStatement.setString(6, item.getSexo());
			preparedStatement.setLong(7, item.getObra().getId());
			preparedStatement.setLong(8, item.getCargo().get());
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
	
	public boolean edit(Funcionario item) {
		boolean isSalvo = false;
		
		 String query = "UPDATE funcionario "
				+ "SET nome = ?,"
				+ "cpf = ?,"
				+ "matricula = ?,"
				+ "usuario_id = ?,"
				+ "endereco_id = ?,"
				+ "sexo = ?,"
				+ "obrad_id = ?,"
				+ "cargo_id = ?,"
				+ "WHERE id = ?";	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, item.getNome());
			preparedStatement.setString(2, item.getCpf());
			preparedStatement.setString(3, item.getMatricula());
			preparedStatement.setLong(4, item.getUsuario().getId());
			preparedStatement.setLong(5, item.getEndereco().getId());
			preparedStatement.setString(6, item.getSexo());
			preparedStatement.setLong(7, item.getObra().getId());
			preparedStatement.setLong(8, item.getCargo().get());
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
		
		 String query = "delete from funcionario where id = ?";

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

}
