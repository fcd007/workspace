package br.univel.patterns.creational.prototype;

public class TestePrototype {

	
	public static void main(String[] args) {
		
		System.out.println("Instancia 1");
		Configuracao c1 = new Configuracao();
		System.out.println("Instanciou 1 " + c1.getNumero());
		
		System.out.println("Instancia 2");
		Configuracao c2 = new Configuracao();
		System.out.println("Instanciou 2 " + c2.getNumero());
		
		
		System.out.println("Instancia 3");
		Configuracao c3 = null;
		try {
			c3 = (Configuracao) c1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println("Instanciou 3 " + c3.getNumero());
		
		
		System.out.println(c1 == c2);
		System.out.println(c1 == c3);
	}
	
}
