package br.univel.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.univel.common.ServicoRMI;

public class Client {

	public static void main(String[] args) {
		Client client = new Client();
		for (int i = 2; i < 255; i++) { 
			client.sendRequest(i);
		}
	}

	public void sendRequest(int i) {
		new Runnable() {

			@Override
			public void run() {
				Registry registry;
				try {
					System.out.println("Tentativa "+i);
					registry = LocateRegistry.getRegistry("192.168.103." + i,
							1818);
					ServicoRMI servico = (ServicoRMI) registry
							.lookup(ServicoRMI.NOME);
					String retorno = servico.greet("HELLO");
					System.out.println(retorno);

				} catch (RemoteException e) {
//					e.printStackTrace();
				} catch (NotBoundException e) {
//					e.printStackTrace();
				}
			}
		}.run();;

	}
}