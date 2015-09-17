package br.univel.patterns.behavioral.visitor;

public class TesteVisitor {

	public static void main(String[] args) {

		BibliotecaDeMusica b = new BibliotecaDeMusica();
		
		System.out.println("\n\n-----------------------------\n\n");
		
		SelecionadorRock sr = new SelecionadorRock();
		b.accept(sr);
		sr.tocar();
		System.out.println("\n\n-----------------------------\n\n");
		
		SelecionadorFesta sf = new SelecionadorFesta();
		b.accept(sf);
		sf.tocar();
		
		System.out.println("\n\n-----------------------------\n\n");
		
		
	}
}
