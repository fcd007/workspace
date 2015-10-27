/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univel.trabalho.Classes;

import java.io.Serializable;

/**
 *
 * @author Cettrans
 */
public class Filme implements Serializable {
	private String titulo, censura;
	private int qtd, key, datalancamento, qtdDisponivel;
	private boolean lancamento;
	private Genero genero;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getQtdDisponivel() {
		return qtdDisponivel;
	}

	public void setQtdDisponivel(int qtdDisponivel) {
		this.qtdDisponivel = qtdDisponivel;
	}

	public String getCensura() {
		return censura;
	}

	public void setCensura(String censura) {
		this.censura = censura;
	}

	public int getDatalancamento() {
		return datalancamento;
	}

	public void setDatalancamento(int datalancamento) {
		this.datalancamento = datalancamento;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public boolean isLancamento() {
		return lancamento;
	}

	public void setLancamento(boolean lancamento) {
		this.lancamento = lancamento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getKey() {
		return key;
	}

	public Filme() {
		this.key = Banco.getChave("Filme");
	}

	@Override
	public String toString() {
		return titulo;
	}

}
