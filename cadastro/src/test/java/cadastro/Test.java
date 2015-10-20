package cadastro;

import java.sql.SQLException;

import br.univel.cadastro.model.Cliente;
import br.univel.cadastro.model.ClienteDaoH2Impl;

public class Test {
	public static void main(String[] args) throws SQLException {
		ClienteDaoH2Impl c = new ClienteDaoH2Impl();
		Cliente cliente = new Cliente();
//		cliente.setNome("Francinaldo");
//		cliente.setId(3);
		c.create(cliente);
//		c.update(cliente, 2);
//		c.list().forEach(System.out::println);
//		c.delete(cliente);
//		System.out.println(c.read(1));
	}
	
}
