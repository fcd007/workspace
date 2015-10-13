package br.univel.cadastro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoH2Impl implements ClienteDao {

	private static Connection con;
	String url = "jdbc:h2:.\\database\\aula";
	String user = "admin";
	String pass = "admin";

	private Connection getConnection() throws SQLException {

		// synchronized (con) {
		if (con == null) {
			con = DriverManager.getConnection(url, user, pass);
		}
		return con;
		// }
	}

	@Override
	public void create(Cliente c) {
		String sql = "INSERT INTO teste VALUES(?, ?)";
		// String sql =
		// "CREATE TABLE TESTE(id int PRIMARY KEY, nome VARCHAR(255))";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, c.getId());
			ps.setString(2, c.getNome());

			int res = ps.executeUpdate();
			ps.close();
			System.out.println(res + "Registros alterados");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Cliente c, int id) throws SQLException {
		String sql = "UPDATE teste SET ID = ?, NOME = ? WHERE ID = ?";
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, c.getId());
		ps.setString(2, c.getNome());
		ps.setInt(3, id);
	
		int res=ps.executeUpdate();
		ps.close();
	System.out.println(res+"Registros alterados");

	}

	@Override
	public void delete(Cliente c) throws SQLException {
		String sql = "DELETE FROM teste WHERE ID = ?";
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, c.getId());
		
		int res=ps.executeUpdate();
		ps.close();
		System.out.println(res+"Registros alterados");

	}

	@Override
	public Cliente searchByExample(Cliente c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> list() throws SQLException {
		List<Cliente> clientes = new ArrayList<>();
		Statement st = getConnection().createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM teste");
		while (result.next()) {
			Cliente cliente = new Cliente();
			cliente.setId(result.getInt(1));
			cliente.setNome(result.getString("nome"));
			clientes.add(cliente);
		}
		return clientes;
	}

	@Override
	public Cliente read(int id) throws SQLException {
		Cliente cliente = new Cliente();
		Statement st = getConnection().createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM teste WHERE id = "
				+ id);
		while (result.next()) {
			cliente.setId(result.getInt(1));
			cliente.setNome(result.getString("nome"));
		}
		return cliente;
	}

}