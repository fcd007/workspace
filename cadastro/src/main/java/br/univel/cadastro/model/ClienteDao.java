package br.univel.cadastro.model;

import java.sql.SQLException;
import java.util.List;

public interface ClienteDao {
	public void create(Cliente c);
	public void update(Cliente c, int id) throws SQLException;
	public Cliente read(int id) throws SQLException;
	public void delete(Cliente c) throws SQLException;
	public List<Cliente> list() throws SQLException;
	public Cliente searchByExample(Cliente c);
}
