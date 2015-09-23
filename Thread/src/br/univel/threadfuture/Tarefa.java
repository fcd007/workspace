package br.univel.threadfuture;

import java.util.concurrent.Callable;

public class Tarefa implements Callable<Integer>{
	int i;
	
	public Tarefa(int i) {
		this.i=i;
	} 
	@Override
	public Integer call() throws Exception {
		Thread.sleep(1000);
		return i;
	}
	
}
