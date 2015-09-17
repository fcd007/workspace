package br.univel.patterns.behavioral.interpreter;

import java.util.Map;

class Variavel implements Expressao {

	private String nome;

	public Variavel(String nome) {
		this.nome = nome;
	}

	public int interpret(Map<String, Expressao> variaveis) {

		if (null == variaveis.get(nome))
			throw new RuntimeException("Variável " + nome + " sem atribuição.");

		return variaveis.get(nome).interpret(variaveis);
	}
}