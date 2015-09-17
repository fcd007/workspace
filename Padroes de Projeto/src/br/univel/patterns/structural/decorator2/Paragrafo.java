package br.univel.patterns.structural.decorator2;

public abstract class Paragrafo {

	private Paragrafo par;

	public Paragrafo(Paragrafo par) {
		this.par = par;
	}
	
	public String getTexto() {
		return par.getTexto();
	}
	
}
