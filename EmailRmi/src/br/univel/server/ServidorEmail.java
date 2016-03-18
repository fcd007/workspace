package br.univel.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.univel.common.Mensagem;
import br.univel.common.ServicoEmailRmi;

public class ServidorEmail implements ServicoEmailRmi {

	private Map<String, List<Mensagem>> inbox = new HashMap<String, List<Mensagem>>();
	
	@Override
	public void enviar(Mensagem msg) throws RemoteException {
		List<Mensagem> lista = inbox.get(msg.getDestinatario());
		if (lista == null) {
			lista = new ArrayList<Mensagem>();
			inbox.put(msg.getDestinatario(), lista);
		}
		lista.add(msg);
	}

	@Override
	public List<Mensagem> buscar(String email) throws RemoteException {

		List<Mensagem> lista = inbox.get(email);
		
		if (lista == null) {
			lista = new ArrayList<Mensagem>();
		}
		
		return lista;
	}

	public static void main(String[] args) {

		System.out.println("Iniciando o server...");

		ServidorEmail s = new ServidorEmail();
		ServicoEmailRmi servico;
		try {
			servico = (ServicoEmailRmi) UnicastRemoteObject.exportObject(s, 0);
			Registry registry = LocateRegistry.createRegistry(1818);
			registry.rebind(ServicoEmailRmi.NOME, servico);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
