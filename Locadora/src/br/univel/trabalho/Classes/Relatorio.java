/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univel.trabalho.Classes;

import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 *
 * @author Cettrans
 */
public class Relatorio {
	private int id, filme;
	private String nome, situacao;
	private double valor;
	private GregorianCalendar emprestimo;
	private GregorianCalendar devolucao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public int getFilme() {
		return filme;
	}

	public void setFilme(int filme) {
		this.filme = filme;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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

}
