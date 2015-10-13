package br.univel.cadastro.model;

import java.util.List;

public interface ClienteDao {
	public void create(Cliente c);
	public void update(Cliente c);
	public void read(int id);
	public void delete(Cliente c);
	public List<Cliente> search(int id);
	public List<Cliente> listar();
	public Cliente searchByExample(Cliente c);
}
