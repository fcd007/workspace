package br.univel;

public class Download {
	private String origem;
	private String destino;
	private float progress;
	private DownloadStatus status;
	public DownloadStatus getStatus() {
		return status;
	}

	public void setStatus(DownloadStatus status) {
		this.status = status;
	}
	public static final int PROGRESS_NUMER = 2;
	
	public Download(String origem, String destino){
		this.origem = origem;
		this.destino = destino;
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
	public float getProgress() {
		return progress;
	}
	public void setProgress(float progress) {
		this.progress = progress;
	}
}
