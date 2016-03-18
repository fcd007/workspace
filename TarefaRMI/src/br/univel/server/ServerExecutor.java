package br.univel.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.univel.common.ExecutorRMI;
import br.univel.common.Tarefa;

public class ServerExecutor implements ExecutorRMI {

	@Override
	public <P, R> R executar(Tarefa<P, R> tarefa, P p) 
			throws RemoteException {
		System.out.println("S Recebendo tarefa.");
		R res = tarefa.executar(p);
		System.out.println("S Terminado de executar.");
		return res;
	}

	
	public static void main(String[] args) {

		System.out.println("Iniciando o server...");

		ServerExecutor s = new ServerExecutor();
		ExecutorRMI servico;
		try {
			servico = (ExecutorRMI) UnicastRemoteObject
					.exportObject(s, 0);
			Registry registry = LocateRegistry
					.createRegistry(1818);
			registry.rebind(ExecutorRMI.NOME, servico);
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
