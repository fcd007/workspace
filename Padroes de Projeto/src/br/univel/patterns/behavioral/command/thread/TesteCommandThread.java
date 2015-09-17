package br.univel.patterns.behavioral.command.thread;

public class TesteCommandThread {

	public static void main(String[] args) {

		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Olá");
			}
		});
		
		
		th1.start();
	}

}
