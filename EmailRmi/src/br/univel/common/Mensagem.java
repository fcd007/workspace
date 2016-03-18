package br.univel.common;

import java.io.Serializable;

public class Mensagem implements Serializable {

	private static final long serialVersionUID = -4902904363309761012L;
	
	private String remetente;
	private String destinatario;
	private String assunto;
	private String texto;

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Mensagem [remetente=" + remetente + ", destinatario="
				+ destinatario + ", assunto=" + assunto + ", texto=" + texto
				+ "]";
	}

}
