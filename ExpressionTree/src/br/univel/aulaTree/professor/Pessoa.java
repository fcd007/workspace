package br.univel.aulaTree.professor;

import java.math.BigInteger;

public class Pessoa {
	@Key
	BigInteger cpf;
	String nome;
	

	public BigInteger getCpf() {
		return cpf;
	}
	public void setCpf(BigInteger cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
