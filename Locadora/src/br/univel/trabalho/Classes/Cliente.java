/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univel.trabalho.Classes;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 *
 * @author Cettrans
 */
public class Cliente implements Serializable {
	private String nome;
	GregorianCalendar nasc;
	private int id;
	Endereco endereco;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public GregorianCalendar getNasc() {
		return nasc;
	}

	public void setNasc(GregorianCalendar nasc) {
		this.nasc = nasc;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cliente() {
		this.id = Banco.getChave("Cliente");

	}

	@Override
	public String toString() {
		return nome;
	}

}
