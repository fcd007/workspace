package br.univel.patterns.creational.builder;

public class Director {

	private RelatorioBuilder	builder;

	public Director() {
	}

	public void imprimir() {
		builder.cabecalho();
		builder.corpo();
		builder.rodape();
	}

	public Relatorio getRelatorio() {
		return builder.getRelatorio();
	}

	public RelatorioBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(RelatorioBuilder builder) {
		this.builder = builder;
	}

}
