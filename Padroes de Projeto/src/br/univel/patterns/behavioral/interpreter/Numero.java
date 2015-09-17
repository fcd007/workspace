package br.univel.patterns.behavioral.interpreter;

import java.util.Map;

class Numero implements Expressao {

	private int numero;

	public Numero(int numero) {
		this.numero = numero;
	}

	public Numero(String numero) {
		this.numero = Integer.parseInt(numero);
	}

	public int interpret(Map<String, Expressao> variaveis) {
		return numero;
	}
}