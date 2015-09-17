package br.univel.patterns.creational.builder;

public class RelatorioCliente extends RelatorioBuilder {

	public RelatorioCliente() {
		// setRelatorio(new Relatorio());
		super.relatorio = new Relatorio();
	}
	
	@Override
	public void cabecalho() {
		super.relatorio
		.setCabecalho("Relatorio de Clientes");
	}

	@Override
	public void corpo() {
		getRelatorio().setCorpo("Cliente 1\n" + 
						   "Cliente 2\n" +
						   "Cliente 3");
	}

	@Override
	public void rodape() {
		getRelatorio().setRodape("----------------------");
	}

}
