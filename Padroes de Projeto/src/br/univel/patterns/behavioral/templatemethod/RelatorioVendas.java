package br.univel.patterns.behavioral.templatemethod;

public class RelatorioVendas extends BaseReport {

	@Override
	String getCabecalho() {
		return "Relatório de Vendas";
	}

	@Override
	String getCorpo() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("%-10s\t%-40s%20s\n", "01/01/2012","Banana","R$ 10,00"));
		sb.append(String.format("%-10s\t%-40s%20s\n", "01/01/2012","Abacate","R$ 10,00"));
		sb.append(String.format("%-10s\t%-40s%20s\n", "01/01/2012","Beterraba","R$ 10,00"));
		sb.append(String.format("%-10s\t%-40s%20s\n", "01/01/2012","Cenoura","R$ 10,00"));
		sb.append(String.format("%-10s\t%-40s%20s\n", "01/01/2012","Arroz","R$ 10,00"));
		
		return sb.toString();
	}

	@Override
	String getRodape() {
		return "Total R$ 50,00";
	}

}
