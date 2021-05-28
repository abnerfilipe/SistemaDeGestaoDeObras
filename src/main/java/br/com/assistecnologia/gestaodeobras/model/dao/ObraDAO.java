package br.com.assistecnologia.gestaodeobras.model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.assistecnologia.gestaodeobras.model.Obra;
import br.com.assistecnologia.gestaodeobras.model.dao.utilDao.ConnectionFactory;
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
		List<Obra> items = new ArrayList<Obra>();
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
			String query = "select * from obra where id = ?;";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1, id);
			set = preparedStatement.executeQuery();
			if(set.next()){
				Obra item = new Obra();
				item.setId(set.getInt("id"));
				item.setNome(set.getString("nome"));
				item.setCodigo(set.getString("codigo"));
				item.setDescricao(set.getString("descricao"));
				Optional<Obra> res = Optional.ofNullable(item);
				return res;
			}
			return Optional.empty();
		}
		catch(Exception e) {
			System.err.println("erro ao mostrar item:  " + e.getMessage());
			return Optional.empty();
		}
	}
	public Obra create(Obra item) {	
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
	public Obra edit(Obra obra) {
		try {
			String query = "UPDATE obra SET nome = ?,codigo = ?,descricao = ? WHERE id = ?;";
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, obra.getNome());
			preparedStatement.setString(2, obra.getCodigo());
			preparedStatement.setString(3, obra.getDescricao());
			preparedStatement.setLong(4, obra.getId());

			preparedStatement.executeUpdate();
			con.commit();
			return obra;
		}
		catch(Exception e){
			System.out.println("Erro ao editar item:" + e.getMessage());			
		}
		return null;
	}
	public boolean delete(long id) {
		boolean isSalvo = false;
		try {
			String query = "delete from obra where id = ?";
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
}
