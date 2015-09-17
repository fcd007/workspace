package br.univel.patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class Servidor implements Mediator {

	private List<Cliente>	clientes;

	public Servidor() {
		clientes = new ArrayList<Cliente>();
	}

	@Override
	public void enviar(String msg, Cliente origem) {
		for (Cliente c : clientes) {
			if (c != origem) {
				c.receber(msg);
			}
		}
	}

	public void addCliente(Cliente cliente) {
		clientes.add(cliente);

	}

}
