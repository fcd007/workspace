package br.univel.patterns.structural.decorator2;

public class ParagrafoItalico extends Paragrafo {

	public ParagrafoItalico(Paragrafo par) {
		super(par);
	}

	@Override
	public String getTexto() {
		return "<i>" + super.getTexto() + "</i>";
	}
}
