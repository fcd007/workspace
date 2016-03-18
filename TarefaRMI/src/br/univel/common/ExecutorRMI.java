package br.univel.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ExecutorRMI extends Remote {

	public static final String NOME = "ExecutorRMI";
	
	public <P, R> R executar(Tarefa<P, R> tarefa, P p) 
			throws RemoteException;

}
