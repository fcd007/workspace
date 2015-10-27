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
public class Genero implements Serializable {
	private String nome;
	int key;

	public int getKey() {
		return key;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero() {
		Banco b = Banco.getBanco();
		this.key = Banco.getChave("Genero");
	}

	@Override
	public String toString() {
		return nome;
	}

}
