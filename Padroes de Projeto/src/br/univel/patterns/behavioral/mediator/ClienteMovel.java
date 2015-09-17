package br.univel.patterns.behavioral.mediator;

public class ClienteMovel extends Cliente {

	public ClienteMovel(Mediator m) {
		super(m);
	}

	@Override
	public void receber(String msg) {
		System.out.println("Cliente movel recebeu: " + msg);
	}
	
}
