package br.univel.patterns.structural.decorator2;

public class ParagrafoNegrito extends Paragrafo {

	public ParagrafoNegrito(Paragrafo par) {
		super(par);
	}

	@Override
	public String getTexto() {
		return "<b>" + super.getTexto() + "</b>";
	}

	
	
}
