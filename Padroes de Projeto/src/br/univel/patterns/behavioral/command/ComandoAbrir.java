package br.univel.patterns.behavioral.command;

class ComandoAbrir implements Comando {

	@Override
	public void executar() {
		System.out.println("Chamado comando abrir.");
	}

}
