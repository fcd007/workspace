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
	String url = "jdbc:postgresql://localhost:5432/univel";
	String user = "postgres";
	String pass = "univel";

	public Connection getConnection() throws SQLException {

		if (con == null) {
			con = DriverManager.getConnection(url, user, pass);
		}
		synchronized (con) {
			return con;

		}
	}

	@Override
	public void create(Cliente c) {
		String sql = "INSERT INTO cliente VALUES(?, ?,?,?)";
		// String sql =
		// "CREATE TABLE TESTE(id int PRIMARY KEY, nome VARCHAR(255))";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, 1000);
			ps.setInt(2, 1);
			ps.setString(3, "Juliano");
			ps.setString(4, "Rua");

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

		int res = ps.executeUpdate();
		ps.close();
		System.out.println(res + "Registros alterados");

	}

	@Override
	public void delete(Cliente c) throws SQLException {
		String sql = "DELETE FROM teste WHERE ID = ?";
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, c.getId());

		int res = ps.executeUpdate();
		ps.close();
		System.out.println(res + "Registros alterados");

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

	public int getMax() throws SQLException {
		int id=-1;
		Statement st = getConnection().createStatement();
		ResultSet result = st.executeQuery("SELECT MAX(id) FROM teste");
		while (result.next()) {
			id = result.getInt(1);
		}
		return id;
	}

}