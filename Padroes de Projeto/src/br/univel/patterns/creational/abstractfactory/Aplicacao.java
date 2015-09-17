package br.univel.patterns.creational.abstractfactory;

class Aplicacao {
	//A aplica��o na sabe qual fabrica foi utilizada
	public Aplicacao(GUIFactory factory) {
		Botao botao = factory.criarBotao();
		botao.pintar();
	}
	
}