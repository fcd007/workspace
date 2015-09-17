package br.univel.patterns.behavioral.mediator;

public class ClienteRemoto extends Cliente {

	public ClienteRemoto(Mediator m) {
		super(m);
	}

	@Override
	public void receber(String msg) {
		System.out.println("Cliente remoto recebeu: " + msg);
	}

}
