package br.univel;

public class Exemplo {
	public static void main(String[] args) {

		String destino = "eclipse-jee-mars-R-win32-x86_64.zip";
		String origem = "http://eclipse.c3sl.ufpr.br/technology/epp/downloads/release/mars/R/eclipse-jee-mars-R-win32-x86_64.zip";
		Downloader downloader = new Downloader(destino, origem);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				downloader.iniciarDownload();
				
			}
		}).start();
	}

}