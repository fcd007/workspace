package br.univel.correcao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

public class Download{
	private String origem, destino;
	private FileOutputStream fos;
	private ReadableByteChannel rbc;
	private int readSoFar;
	private float progress;
	private List<DownloadInformation> observerList = new ArrayList<DownloadInformation>();

	public int getReadSoFar() {
		return readSoFar;
	}

	public void setReadSoFar(int readSoFar) {
		this.readSoFar = readSoFar;
	}

	public float getProgress() {
		return progress;
	}

	public void setProgress(float progress) {
		this.progress = progress;
	}

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
			rbc = new ProgressoDecoratorImpl(Channels.newChannel(url
					.openStream()), contentLength(url), getGeneral());
			fos = new FileOutputStream(localPath);

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.observerList.add(new DownloadInformation() {
			
			@Override
			public void informarProgresso(long readSoFar, long progress) {
				System.out.println(progress);
				
			}
		});
	}

	private DownloadInformation getGeneral() {

		return new DownloadInformation() {

			@Override
			public void informarProgresso(long readSoFar, long progress) {
				for (DownloadInformation downloadInformation : observerList) {
					downloadInformation.informarProgresso(readSoFar, progress);
				}

			}
		};
	}

	/**
	 * Inicia o Download.
	 * 
	 * @throws IOException
	 */

	public void informarProgresso(long readSoFar, double progress) {

	}

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
	 * @return o tamanho do conteúdo, se não conseguir ou não tiver
	 *         disponível (indeterminado) retorna -1.
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

	// @Override
	// public void run() {
	// iniciarDownload();
	//
	// }

	public void iniciarDownloadNewThread() {
		// new Thread(this).start();

		// new Thread( new Runnable() {
		//
		// @Override
		// public void run() {
		// iniciarDownload();
		//
		// }
		// }).start();
		// }

		new Thread(() -> iniciarDownload()).start();
	}

	public void addDownloadInformation(DownloadInformation downloadInformation) {
		this.observerList.add(downloadInformation);
	}

}
