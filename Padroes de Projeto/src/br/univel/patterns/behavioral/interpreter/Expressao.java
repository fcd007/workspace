package br.univel.patterns.behavioral.interpreter;

import java.util.Map;

interface Expressao {

	public int interpret(Map<String, Expressao> variaveis);

}