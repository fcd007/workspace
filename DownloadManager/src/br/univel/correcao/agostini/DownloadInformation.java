package br.univel.correcao.agostini;

/**
 * 
 * Quem implementa essa interface recebe informações sobre o download, quem o
 * está fazendo e seu progresso atual.
 * 
 * @author Fernando D'Agostini - 15/09/2015 20:13:08
 *
 */
public interface DownloadInformation {

	public void informarProgresso(long readSoFar, double progress);

}