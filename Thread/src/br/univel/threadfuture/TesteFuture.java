package br.univel.threadfuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TesteFuture {
	public static void main(String[] args) {
		Tarefa t1 = new Tarefa(10);
		Tarefa t2 = new Tarefa(20);
		
		FutureTask<Integer> ft1 = new FutureTask<>(t1);
		new Thread(ft1).start();
		FutureTask<Integer> ft2 = new FutureTask<>(t2);
		new Thread(ft2).start();
		
		try{
			System.out.println(ft2.get());
			System.out.println(ft1.get());
		}catch(Exception e){
			
		}
		
		
	}
}
