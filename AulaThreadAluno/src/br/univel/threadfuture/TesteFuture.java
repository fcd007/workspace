package br.univel.threadfuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TesteFuture {
	
	public static void main(String[] args) {
		
		Tarefa t1 = new Tarefa(1000);
		Tarefa t2 = new Tarefa(2000);
		
		FutureTask<Integer> ft1 = new FutureTask<>(t1);
		// ft1.run(); // Não inicia nova thread!
		new Thread(ft1).start(); // Executa em nova Thread!
		
		FutureTask<Integer> ft2 = new FutureTask<>(t2);
		// ft2.run();
		new Thread(ft2).start();

		try {
			// Independentemente da ordem de término mostrar
			// o resultado do 2 antes. Se nesse ponto o 2
			// não tiver terminado o .get() abaixo trava o
			// a execuçãoo e o aguarda terminar.
			System.out.println(ft2.get());
			System.out.println(ft1.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		
	}
}
