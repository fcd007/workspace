package br.univel.threadsync;

public class Emissor implements Runnable {
	private Receptor receptor;
	private String str;

	public Emissor(Receptor receptor, String str) {
		this.receptor = receptor;
		this.str = str;
		new Thread(this).start();
	}

	@Override
	public void run() {

		synchronized (receptor) {
		
			receptor.recebe("<");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			receptor.recebe(str);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			receptor.recebe(">\n");
		}
			
	}
}
