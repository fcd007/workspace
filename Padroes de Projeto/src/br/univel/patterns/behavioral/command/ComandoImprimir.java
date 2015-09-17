package br.univel.patterns.behavioral.command;

public class ComandoImprimir implements Comando {

	@Override
	public void executar() {
		System.out.println("Chamado comando imprimir.");
	}

}
