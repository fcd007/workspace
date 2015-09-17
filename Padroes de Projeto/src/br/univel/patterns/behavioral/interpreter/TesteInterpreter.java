package br.univel.patterns.behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

public class TesteInterpreter {

	public static void main(String[] args) {
    
		String expressao = "a b + c +";
        
		Avaliador avaliador = new Avaliador(expressao);
        
        Map<String,Expressao> vars = new HashMap<String,Expressao>();
        vars.put("a", new Numero(2));
        vars.put("b", new Numero(4));
        vars.put("c", new Numero(6));
        
        int resultado = avaliador.interpret(vars);
        
        System.out.println("Resultado: " + resultado);
        
    }
	
}