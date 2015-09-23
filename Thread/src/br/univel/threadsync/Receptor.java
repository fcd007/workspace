package br.univel.threadsync;

public class Receptor implements Runnable{
	private Receptor receptor;
	private String str;
	
	
	public Receptor(Receptor receptor, String str) {
		this.receptor = receptor;
		this.str = str;
		new Thread(this).start();
	}
	
	public Receptor() {
		// TODO Auto-generated constructor stub
	}

	public void recebe(String str){
		System.out.println(str);
	}

	@Override
	public void run() {
		synchronized (receptor){
			receptor.recebe("<");
			try {
				Thread.sleep(500);
				receptor.recebe(str);
				Thread.sleep(500);
				receptor.recebe(">\n");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
