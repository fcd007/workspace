package br.univel.patterns.creational.builder;

public class RelatorioFornecedor extends RelatorioBuilder {


	public RelatorioFornecedor() {
		relatorio = new Relatorio();
	}
	
	@Override
	public void cabecalho() {
		relatorio.setCabecalho("Relatorio de Fornecedores");
	}

	@Override
	public void corpo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Fornecedor 1")
			.append("\n")
		    .append("Fornecedor 2")
		    .append("\n")
		    .append("Fornecedor 3");
		relatorio.setCorpo(sb.toString());
	}

	@Override
	public void rodape() {
		relatorio.setRodape("======================");
	}

}
