package br.univel.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ServicoEmailRmi extends Remote {
	
	public static final String NOME = "MeuServicoEmailRmi";

	public void enviar(Mensagem msg) throws RemoteException;

	public List<Mensagem> buscar(String email) throws RemoteException;

}
