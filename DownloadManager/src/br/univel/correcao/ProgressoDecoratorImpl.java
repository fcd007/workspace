package br.univel.correcao;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

public class ProgressoDecoratorImpl implements ReadableByteChannel {

	private DownloadInformation delegate;
	private ReadableByteChannel rbc;

	private long tamanhoEsperado;
	private long lido;

	ProgressoDecoratorImpl(ReadableByteChannel rbc, long tamanhoEsperado,
			DownloadInformation delegate) {
		this.delegate = delegate;

		this.tamanhoEsperado = tamanhoEsperado;
		this.rbc = rbc;
	}

	public void close() throws IOException {
		rbc.close();
	}

	public long getReadSoFar() {
		return lido;
	}

	public boolean isOpen() {
		return rbc.isOpen();
	}

	public int read(ByteBuffer bb) throws IOException {
		int n;
		double progresso;

		if ((n = rbc.read(bb)) > 0) {
			lido += n;
			progresso = tamanhoEsperado > 0 ? (double) lido / (double) tamanhoEsperado * 100.0 : -1.0;
			delegate.informarProgresso(this.getReadSoFar(), progresso);
		}

		return n;
	}
}