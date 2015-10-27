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
public class Configuracao implements Serializable {
	private String nome, telefone;
	private double vlrD, multa, vlrL;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public double getVlrD() {
		return vlrD;
	}

	public void setVlrD(double vlrD) {
		this.vlrD = vlrD;
	}

	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		this.multa = multa;
	}

	public double getVlrL() {
		return vlrL;
	}

	public void setVlrL(double vlrL) {
		this.vlrL = vlrL;
	}

}
