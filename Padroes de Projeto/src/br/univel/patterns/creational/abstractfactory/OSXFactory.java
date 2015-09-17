package br.univel.patterns.creational.abstractfactory;

class OSXFactory implements GUIFactory {

	public Botao criarBotao() {
		return new BotaoOXS();
	}
}