package br.univel.cadastro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClienteDaoH2Impl implements ClienteDao {

	private static Connection con;

	private Connection getConnection() {

		synchronized (con) {
			if (con == null) {
				// TODO
			}
			return con;
		}
	}

	@Override
	public void create(Cliente c) {
		String sql = "INSERT INTO....";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Cliente c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void read(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Cliente c) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cliente> search(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente searchByExample(Cliente c) {
		// TODO Auto-generated method stub
		return null;
	}

}