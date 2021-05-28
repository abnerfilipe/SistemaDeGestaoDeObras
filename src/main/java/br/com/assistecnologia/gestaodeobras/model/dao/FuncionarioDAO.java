package br.com.assistecnologia.gestaodeobras.model.dao;

import br.com.assistecnologia.gestaodeobras.model.Funcionario;
import br.com.assistecnologia.gestaodeobras.model.Sexo;
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

public class FuncionarioDAO {
	Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;



	public FuncionarioDAO() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
	}

	public List < Funcionario > all() {
			List < Funcionario > data = new ArrayList();
			ResultSet set;

			try {
				statement = con.createStatement();
				EnderecoDAO enderecoDAO = new EnderecoDAO();
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				ObraDAO obraDAO = new ObraDAO();
				CargoDAO cargoDAO = new CargoDAO();
				set = statement.executeQuery("select * from funcionario;");

				while (set.next()) {
					Funcionario item = new Funcionario();
					item.setId(set.getInt("id"));
					item.setNome(set.getString("nome"));
					item.setCpf(set.getString("cpf"));
					item.setMatricula(set.getString("matricula"));
					if (set.getString("sexo") == Sexo.Feminino.getDescricao()) {
						item.setSexo(Sexo.Feminino);
					} else {
						item.setSexo(Sexo.Masculino);
					}
					item.setCargo(cargoDAO.read(set.getLong("cargo_id")).get());
					item.setEndereco(enderecoDAO.read(set.getLong("cargo_id")).get());
					item.setObra(obraDAO.read(set.getLong("obra_id")).get());
					item.setUsuario(usuarioDAO.read(set.getLong("usuario_id")).get());
					data.add(item);
				}
		}
		catch(SQLException e) {
			
			System.err.println("erro ao listar item" + e.getMessage());
			
		}
		return data;
	}
	public Optional<Funcionario> read(long id) {
		try {
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			ObraDAO obraDAO = new ObraDAO();
			CargoDAO cargoDAO = new CargoDAO();
			preparedStatement = con.prepareStatement("select * from funcionario where id = ?;");
			preparedStatement.setLong(1, id);
			ResultSet set = preparedStatement.executeQuery();
			if(set.next()){
				Funcionario item = new Funcionario();
				item.setId(set.getInt("id"));
				item.setNome(set.getString("nome"));
				item.setCpf(set.getString("cpf"));
				item.setMatricula(set.getString("matricula"));
//				item.setSexo(set.getString("sexo"));
				item.setCargo(cargoDAO.read(set.getLong("cargo_id")).get());
				item.setEndereco(enderecoDAO.read(set.getLong("cargo_id")).get());
				item.setObra(obraDAO.read(set.getLong("obra_id")).get());
				item.setUsuario(usuarioDAO.read(set.getLong("usuario_id")).get());
				Optional<Funcionario> res = Optional.ofNullable(item);
				return res;
			}
			return Optional.empty();
		}
		catch(SQLException e) {
			System.err.println("erro ao mostrar item:  " + e.getMessage());
			return Optional.empty();
		}
	}

	public Funcionario create(Funcionario item) throws SQLException {	
		boolean isSalvo = false;
		try {
			String query = "insert into funcionario (nome, cpf, matricula, usuario_id, endereco_id, sexo, obra_id, cargo_id)"+
			"values(?,?,?,?,?,?,?,?);";
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, item.getNome());
			preparedStatement.setString(2, item.getCpf());
			preparedStatement.setString(3, item.getMatricula());
			preparedStatement.setLong(4, item.getUsuario().getId());
			preparedStatement.setLong(5, item.getEndereco().getId());
			preparedStatement.setString(6, item.getSexo().getDescricao());
			preparedStatement.setLong(7, item.getObra().getId());
			preparedStatement.setLong(8, item.getCargo().getId());
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
			// isSalvo = false;			
		}
		return null;
	}
	
	public Funcionario edit(Funcionario item) throws SQLException {
		try {
		 	String query = "UPDATE funcionario SET nome = ?,cpf = ?,matricula = ?,usuario_id = ?,endereco_id = ?,sexo = ?,obra_id = ?,cargo_id = ? WHERE id = ?";
		
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, item.getNome());
			preparedStatement.setString(2, item.getCpf());
			preparedStatement.setString(3, item.getMatricula());
			preparedStatement.setLong(4, item.getUsuario().getId());
			preparedStatement.setLong(5, item.getEndereco().getId());
			preparedStatement.setString(6, item.getSexo().getDescricao());
			preparedStatement.setLong(7, item.getObra().getId());
			preparedStatement.setLong(8, item.getCargo().getId());
			preparedStatement.setLong(9, item.getId());
			preparedStatement.executeUpdate();
			con.commit();
			return item;
		}catch(SQLException e) {

			System.err.println("erro ao listar funcionario" + e.getMessage());

		}
		return null;
	}
	public boolean delete(long id) {
		boolean isSalvo = false;
		try {
		 	String query = "delete from funcionario where id = ?";
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

}
