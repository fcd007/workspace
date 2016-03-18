package br.univel.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.univel.common.ServicoEmailRmi;

public abstract class Cliente {

	protected ServicoEmailRmi servico;

	public Cliente() {

		Registry registry;
		try {
			registry = LocateRegistry.getRegistry("127.0.0.1", 1818);
			servico = (ServicoEmailRmi) registry.lookup(ServicoEmailRmi.NOME);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

}
