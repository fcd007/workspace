package br.univel.threadexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Teste {

	public static void main(String[] args) {

		int cores = Runtime.getRuntime().availableProcessors();
		
		ExecutorService executor = Executors.newFixedThreadPool(cores);

		System.out.println("Enviando 1000 tarefas para o executor.");
		for (int i = 0; i < 1000; i++) {
			executor.execute(new Tarefa(i));
		}
		System.out.println("Todas as tarefas foram adicionadas.");
		executor.shutdown();
		System.out.println("Aguardando processamento.");
		try {
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Terminado.");
		
	}
}
