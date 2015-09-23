package br.univel.threadexecutor;

public class Tarefa implements Runnable{
	private int id;
	public Tarefa(int id) {
		this.id=id;
	}
	@Override
	public void run() {
		System.out.println("Tarefa "+id+" iniciando.");
		try{
			Thread.sleep((long)(Math.random()*1000));
		}catch(Exception e){
			
		}
		System.out.println("Tarefa "+id+" terminado");
	}

}
