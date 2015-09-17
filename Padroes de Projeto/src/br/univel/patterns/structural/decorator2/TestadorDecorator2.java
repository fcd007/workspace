package br.univel.patterns.structural.decorator2;

public class TestadorDecorator2 {

	public static void main(String[] args) {
		Paragrafo p = new ParagrafoSimples(null);
		p = new ParagrafoNegrito(p);
		p = new ParagrafoItalico(p);
		System.out.println(p.getTexto());
	}
	
}
