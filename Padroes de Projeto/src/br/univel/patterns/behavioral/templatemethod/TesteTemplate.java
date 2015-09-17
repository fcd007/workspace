package br.univel.patterns.behavioral.templatemethod;

public class TesteTemplate {

	public static void main(String[] args) {
		BaseReport b1 = new ListaDeClientes();
		System.out.println(b1.imprimir());;
		
		System.out.println("\n\n\n\n");
		
		BaseReport b2 = new RelatorioVendas();
		System.out.println(b2.imprimir());;
	}
	
}
