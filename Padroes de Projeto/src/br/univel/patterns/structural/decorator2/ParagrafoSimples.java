package br.univel.patterns.structural.decorator2;

public class ParagrafoSimples extends Paragrafo {

	public ParagrafoSimples(Paragrafo par) {
		super(par);
	}

	@Override
	public String getTexto() {
		return "Texto qualquer";
	}
	
	
	

}
