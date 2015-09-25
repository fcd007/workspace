package br.univel.threadexecutor;

public class Tarefa implements Runnable {

	private int id;

	public Tarefa(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Tarefa " + id + " iniciando.");
		// Simulando processamento.
		try {
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Tarefa " + id + " terminada.");
	}
}
