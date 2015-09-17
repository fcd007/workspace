package br.univel.patterns.behavioral.interpreter;

import java.util.Map;
import java.util.Stack;

class Avaliador implements Expressao {

	private Expressao expressaoCompleta;

	public Avaliador(String expression) {

		Stack<Expressao> pilha = new Stack<Expressao>();

		for (String token : expression.split(" ")) {

			if (token.equals("+")) {
				Expressao subExpressao = new Mais(pilha.pop(), pilha.pop());
				pilha.push(subExpressao);

			} else if (token.equals("-")) {
				Expressao right = pilha.pop();
				Expressao left = pilha.pop();

				Expressao subExpression = new Menos(left, right);
				pilha.push(subExpression);

			} else if (token.matches("[0-9]+")) {
				pilha.push(new Numero(Integer.parseInt(token)));

			} else if (token.matches("[abcde]+")) {
				pilha.push(new Variavel(token));

			} else {
				throw new RuntimeException("Erro na expressao.");

			}

		}

		expressaoCompleta = pilha.pop();
	}

	public int interpret(Map<String, Expressao> contexto) {
		return expressaoCompleta.interpret(contexto);
	}
}