package br.univel.patterns.behavioral.templatemethod;

public class ListaDeClientes extends BaseReport {

	@Override
	String getCabecalho() {
		return "Listagem de Clientes";
	}

	@Override
	String getCorpo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Hugo").append('\n');
		sb.append("Jose").append('\n');
		sb.append("Luiz").append('\n');
		return sb.toString();
	}

	@Override
	String getRodape() {
		return "Gerado por MeuSystem";
	}

}
