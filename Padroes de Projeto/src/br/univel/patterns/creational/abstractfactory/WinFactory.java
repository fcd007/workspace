package br.univel.patterns.creational.abstractfactory;

class WinFactory implements GUIFactory {

	public Botao criarBotao() {
		return new BotaoWindows();
	}
}