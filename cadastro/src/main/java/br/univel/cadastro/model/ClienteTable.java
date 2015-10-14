package br.univel.cadastro.model;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ClienteTable extends AbstractTableModel {
	List<Cliente> clientes;
	public List<Cliente> getClientes() {
		return clientes;
	}

	ClienteDaoH2Impl dao = new ClienteDaoH2Impl();
	String[] names;

	public ClienteTable() throws SQLException {
		clientes = dao.list();
		loadFieldNames();

	}
	
	public void reload() throws SQLException{
		clientes = dao.list();
		super.fireTableDataChanged();
	}

	private void loadFieldNames() {
		Field[] fields= Cliente.class.getDeclaredFields();
		names = new String[fields.length];
		for(int i=0; i<Cliente.class.getDeclaredFields().length;i++)
			names[i] = fields[i].getName();
	}

	@Override
	public int getColumnCount() {
		return Cliente.class.getDeclaredFields().length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return clientes.size();
	}
	
	@Override
	public String getColumnName(int column) {
		
		return names[column];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Cliente cliente = clientes.get(row);
		switch (col) {
		case 0:
			return cliente.getId();
		case 1:
			return cliente.getNome();
		default:
			return "";
		}
	}

}
