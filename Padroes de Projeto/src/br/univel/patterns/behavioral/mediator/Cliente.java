package br.univel.patterns.behavioral.mediator;

public abstract class Cliente {
	
	private Mediator	mediator;

	public Cliente(Mediator m) {
		mediator = m;
	}

	public void send(String msg) {
		mediator.enviar(msg, this);
	}

	public Mediator getMediator() {
		return mediator;
	}

	public abstract void receber(String msg);

}
