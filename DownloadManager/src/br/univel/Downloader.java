package br.univel;

/**
 * @author Juliano Grams 15/09/2015
 */
import java.io.FileOutputStream;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Downloader extends DownloadInformation {

	private FileOutputStream fos;
	private ReadableByteChannel rbc;

	/**
	 * 
	 * @param localPath
	 * @param remoteURL
	 */
	public Downloader(String localPath, String remoteURL) {

		URL url;

		try {
			url = new URL(remoteURL);
			rbc = new ProgressoDecoratorImpl(Channels.newChannel(url.openStream()), contentLength(url), this);
			fos = new FileOutputStream(localPath);

		} catch (Exception e) {
			e.printStackTrace();
		}
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

}
