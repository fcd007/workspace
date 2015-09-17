package br.univel.patterns.creational.builder;

public class Relatorio {

	private String	cabecalho;
	private String	corpo;
	private String	rodape;

	public String getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(String cabecalho) {
		this.cabecalho = cabecalho;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public String getRodape() {
		return rodape;
	}

	public void setRodape(String rodape) {
		this.rodape = rodape;
	}

	@Override
	public String toString() {
		return cabecalho +
				"\n" + 
				corpo + 
				"\n" + 
				rodape;
	}

	
	
}
