package br.univel.threadexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Teste {
	public static void main(String[] args) {
		int cores=Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(cores);
		System.out.println("Enviando 1000 taredas para o executor");
		for (int i = 0; i < 1000; i++) {
				executor.execute(new Tarefa(i));
				
			
		}
		System.out.println("Todas as taredas foram adicionadas");
		//Pode desligar apos processar
		executor.shutdown();
		System.out.println("Aguardando processamento");
		
		try {
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Terminado");
	}
}
