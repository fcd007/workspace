package br.univel.patterns.behavioral.command;

class ComandoFechar implements Comando {

	@Override
	public void executar() {
		System.out.println("Chamado comando fechar.");
	}

}
