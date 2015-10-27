/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univel.trabalho.Classes;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 *
 * @author Cettrans
 */
public class Locacao implements Serializable {
	private Cliente c;
	private LinkedList<Filme> filmes;
	private GregorianCalendar emprestimo, devolucao;
	private int situacao, key;
	private double vlrtotal, vlrfinal;

	public int getKey() {
		return key;
	}

	public Cliente getC() {
		return c;
	}

	public void setC(Cliente c) {
		this.c = c;
	}

	public LinkedList<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(LinkedList<Filme> filmes) {
		this.filmes = filmes;
	}

	public GregorianCalendar getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(GregorianCalendar emprestimo) {
		this.emprestimo = emprestimo;
	}

	public GregorianCalendar getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(GregorianCalendar devolucao) {
		this.devolucao = devolucao;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public double getVlrtotal() {
		return vlrtotal;
	}

	public void setVlrtotal(double vlrtotal) {
		this.vlrtotal = vlrtotal;
	}

	public double getVlrfinal() {
		return vlrfinal;
	}

	public void setVlrfinal(double vlrfinal) {
		this.vlrfinal = vlrfinal;
	}

	public Locacao() {
		this.key = Banco.getChave("Locacao");
	}

}
