package br.univel.patterns.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class MementoAdapter {

	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	private Cliente clienteAtual;

	public MementoAdapter() {
	}

	public Cliente anterior() {
		int idx = listaCliente.indexOf(clienteAtual);
		if (idx == 0) {
			throw new RuntimeException("Não há anterior.");
		}
		clienteAtual = listaCliente.get(idx - 1);
		return clienteAtual;
	}

	public Cliente proximo() {
		int idx = listaCliente.indexOf(clienteAtual);
		if (idx == listaCliente.size() - 1) {
			throw new RuntimeException("Não há próximo.");
		}
		clienteAtual = listaCliente.get(idx + 1);
		return clienteAtual;
	}

	public Cliente inicializar() {
		clienteAtual = new Cliente();
		listaCliente.add(clienteAtual);
		return clienteAtual;
	}

	public Cliente salvar() {
		int idx = listaCliente.indexOf(clienteAtual);
		if (idx != listaCliente.size() -1) {
			while (idx < listaCliente.size() - 1) {
				listaCliente.remove(idx + 1);
			}
		}
		listaCliente.add(clienteAtual.cloneCliente());
		clienteAtual = listaCliente.get(listaCliente.size()-1);
		return clienteAtual;
	}
}
