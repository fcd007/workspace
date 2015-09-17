package br.univel.patterns.creational.builder;

public abstract class RelatorioBuilder {

	protected Relatorio	relatorio;

	public abstract void cabecalho();

	public abstract void corpo();

	public abstract void rodape();

	public Relatorio getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}

}
