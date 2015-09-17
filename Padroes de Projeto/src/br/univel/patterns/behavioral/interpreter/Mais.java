package br.univel.patterns.behavioral.interpreter;

import java.util.Map;

class Mais implements Expressao {

	private Expressao operadorEsquerdo;
	private Expressao operadorDireito;

	public Mais(Expressao esquerda, Expressao direita) {
		operadorEsquerdo = esquerda;
		operadorDireito = direita;
	}

	public int interpret(Map<String, Expressao> variaveis) {
		return operadorEsquerdo.interpret(variaveis)
				+ operadorDireito.interpret(variaveis);
	}

}