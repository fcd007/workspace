package br.unive.teste;

import java.util.ArrayList;
import java.util.List;

public class Teste {
	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		Teste teste = new Teste();
		lista.forEach(System.out::println); //referencia de metodo
		lista.forEach(teste::print);
		
		lista.forEach(e ->{
			System.out.println(e);
			System.out.println("hello");
			
		});
		//Interface Runnable, mas so pode ser com interfaces que necessitam de 1 metodo
		new Thread(() -> System.out.println("hehehe")).start();
		for (;;) {
			break;
		}
	
	}
	public void print(Integer s){
		System.out.println(s);
	}
}
