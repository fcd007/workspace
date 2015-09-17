package br.univel.patterns.behavioral.mediator;

public class ClienteLocal extends Cliente {

	public ClienteLocal(Mediator m) {
		super(m);
	}

	@Override
	public void receber(String msg) {
		System.out.println("Cliente local recebeu: " + msg);
	}
}
