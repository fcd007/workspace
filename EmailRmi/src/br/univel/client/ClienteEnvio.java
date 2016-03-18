package br.univel.client;

import java.rmi.RemoteException;

import br.univel.common.Mensagem;

public class ClienteEnvio extends Cliente {

	public ClienteEnvio() {
		super();

		Mensagem msg = new Mensagem();
		msg.setAssunto("Cobrança");
		msg.setDestinatario("hugo@disney.com");
		msg.setRemetente("luiz@disney.com");
		msg.setTexto("Ainda estou esperando o pagamento.");

		try {
			servico.enviar(msg);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ClienteEnvio();
	}

}
