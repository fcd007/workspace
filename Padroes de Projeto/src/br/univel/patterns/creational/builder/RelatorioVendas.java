package br.univel.patterns.creational.builder;

public class RelatorioVendas extends RelatorioBuilder {


	public RelatorioVendas() {
		relatorio = new Relatorio();
	}
	
	@Override
	public void cabecalho() {
		relatorio.setCabecalho("Relatorio de Vendas");
	}

	@Override
	public void corpo() {
		relatorio.setCorpo("Venda 1\n" + 
						   "Venda 2\n" +
						   "Venda 3");
	}

	@Override
	public void rodape() {
		relatorio.setRodape("oooooooooooooooooooooo");
	}

}
