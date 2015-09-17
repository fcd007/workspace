package br.univel.patterns.structural.adapter;

import javax.swing.JTextArea;

public class NovaImpressora extends Impressora {

	private JTextArea txa;

	public NovaImpressora(JTextArea txa) {
		this.txa = txa;
	}
	
	@Override
	public void imprime(String palavra) {
		txa.append(palavra);
	}
	
}
