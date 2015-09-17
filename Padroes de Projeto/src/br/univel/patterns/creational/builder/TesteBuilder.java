package br.univel.patterns.creational.builder;

public class TesteBuilder {

	public static void main(String[] args) {

		Director director = new Director();

		director.setBuilder(new RelatorioCliente());
		
		// director.setBuilder(new RelatorioFornecedor());
		//director.setBuilder(new RelatorioVendas());

		director.imprimir();
		Relatorio relatorio = director.getRelatorio();

		System.out.println(relatorio.toString());

	}

}
