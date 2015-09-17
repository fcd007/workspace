package br.univel.patterns.structural.proxy;

import javax.swing.JOptionPane;

public class SistemaProxy implements Sistema {

	private Sistema sistema = null;
	
	
	@Override
	public void abrir() {
		String senha = JOptionPane.showInputDialog("Digite a senha:");
		if (senha.equals("1234")) {
			sistema = new SistemaControle();
			sistema.abrir();
		} else {
			throw new RuntimeException("Senha inválida!");
		}
		
	}

}
