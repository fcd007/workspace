package br.univel.client;

import java.rmi.RemoteException;
import java.util.List;

import br.univel.common.Mensagem;

public class ClienteRecebimento extends Cliente {

	public ClienteRecebimento() {
		super();

		try {
			List<Mensagem> lista = servico.buscar("hugo@disney.com");
			for (Mensagem mensagem : lista) {
				System.out.println(mensagem);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ClienteRecebimento();
	}
}
