package br.univel.correcao.agostini;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

public class Download {

	private String origem;
	private String destino;
	private int readSoFar;
	private double progress;
	
	
	
	
	
	
	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getProgress() {
		return progress;
	}

	public void setProgress(double progress) {
		this.progress = progress;
	}
	
	
	

	private FileOutputStream fos;
	private ReadableByteChannel rbc;
	private List<DownloadInformation> listaObservers = new ArrayList<DownloadInformation>();

	/**
	 * 
	 * @param localPath
	 * @param remoteURL
	 */
	public Download(String localPath, String remoteURL) {

		this.origem = remoteURL;
		this.destino = localPath;
		
		URL url;

		try {
			url = new URL(remoteURL);
			 rbc = new ProgressoDecoratorImpl(Channels.newChannel(url.openStream()),
					 contentLength(url), getGeneral());
//			rbc = Channels.newChannel(url.openStream());
			fos = new FileOutputStream(localPath);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		this.listaObservers.add(new DownloadInformation() {
//			@Override
//			public void informarProgresso(long readSoFar, double progress) {
//				System.out.println(String.format(
//						"Progresso %d bytes recebidos, %.02f%%", readSoFar,
//						progress));
//			}			
//		});
		
	}

	private DownloadInformation getGeneral() {
		return new DownloadInformation() {
			@Override
			public void informarProgresso(long readSoFar, double progress) {
				for (DownloadInformation d : listaObservers) {
					d.informarProgresso(readSoFar, progress);
				}
			}
		};
	}

	/**
	 * 
	 */
	public void iniciarDownloadNovaThread() {
		// new Thread(this).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				iniciarDownload();
			}
		}).start();
	}

	
	/**
	 * Chamado pela Thread.
	 * @Override
	 */
	public void run() {
		iniciarDownload();
	}


	/**
	 * Inicia o Download.
	 * 
	 * @throws IOException
	 */
	public void iniciarDownload() {
		try {
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			rbc.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	/**
	 * Retorna o tamanho do conteúdo.
	 * 
	 * @param url
	 * 
	 * @return o tamanho do conteúdo, se não conseguir ou não tiver disponível
	 *         (indeterminado) retorna -1.
	 */
	private int contentLength(URL url) {
		HttpURLConnection connection;
		int contentLength = -1;
		try {

			HttpURLConnection.setFollowRedirects(false);

			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("HEAD");

			contentLength = connection.getContentLength();

		} catch (Exception e) {
			// vazio de propósito.
		}
		return contentLength;
	}

	public void addDownloadInformation(DownloadInformation downloadInformation) {
		this.listaObservers.add(downloadInformation);
	}



	
}
