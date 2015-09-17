package br.univel.patterns.structural.proxy;

import javax.swing.JFrame;

public class SistemaControle implements Sistema {

	@Override
	public void abrir() {
		JFrame frame = new JFrame();
		frame.setTitle("Sistema de Controle");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
