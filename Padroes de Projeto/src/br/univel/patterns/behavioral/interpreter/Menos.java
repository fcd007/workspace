package br.univel.patterns.behavioral.interpreter;

import java.util.Map;

class Menos implements Expressao {

	private Expressao operadorEsquerdo;
	private Expressao operadorDireito;

	public Menos(Expressao esquerda, Expressao direita) {
		operadorEsquerdo = esquerda;
		operadorDireito = direita;
	}

	public int interpret(Map<String, Expressao> variaveis) {
		return operadorEsquerdo.interpret(variaveis)
				- operadorDireito.interpret(variaveis);
	}
}