package br.univel.patterns.structural.decorator;

public class TestadorDecorator {
	
	public static void main(String[] args) {
//		Cafe cafe = new Cafe();
//		
//		System.out.println(cafe.getDescricao());
//		System.out.println(cafe.getPreco());
//		Leite leite = new Leite();
//		Acucar acucar = new Acucar();
//		Adocante adocante = new Adocante();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Cafe com leite
		Produto p1 = new Cafe();
		p1 = new Leite(p1);
		System.out.println(p1.getDescricao());
		System.out.println(p1.getPreco());
		System.out.println("----------------------------");
		
		// Cafe e açúcar
		Produto p2 = new Cafe();
		p2 = new Acucar(p2);
		System.out.println(p2.getDescricao());
		System.out.println(p2.getPreco());
		System.out.println("----------------------------");
		
		// Todos juntos
		Produto p3 = new Cafe();
		p3 = new Leite(p3);
		p3 = new Acucar(p3);
		p3 = new Adocante(p3);
		System.out.println(p3.getDescricao());
		System.out.println(p3.getPreco());
		System.out.println("----------------------------");
		
	}
}
