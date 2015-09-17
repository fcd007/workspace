package br.univel.patterns.creational.abstractfactory;

public class ControladorAplicacao {

	private static final int WINDOWS = 0;
	private static final int MACOSX = 1;
	// Fabrica um conjunto de objetos, fabrica toda é abstrata, tem varias implementações
	//Cria uma fabrica para interface grafica indifrente do OS, 
	public static void main(String[] args) {
		// Aqui nao importa qual OS.
		new Aplicacao(criarFactory());
	}
	//Pussuem a mesma interface, esta é a fabrica
	public static GUIFactory criarFactory() {

		// int sistema = WINDOWS;
		int sistema = MACOSX;

		if (sistema == WINDOWS) {
			return new WinFactory();
		}
		if (sistema == MACOSX) {
			return new OSXFactory();
		}

		throw new RuntimeException("Sistema não suportado.");
	}
}