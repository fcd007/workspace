package br.univel.patterns.notgof.fluentinterface;

public class Teste {

	public static void main(String[] args) {
		new Carro(1, "Azul", 
				"Azul",
				"Azul", 
				"1999", 
				"3 portas", "nao", "sim");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		ConstrutorCarro cc = new ConstrutorCarro();
		
		Carro c1 = cc.id(1)
		   .cor("Azul")
		   .ano("1999")
		   .ar("Sim")
		   .direcao("")
		   .marca("Azul")
		   .modelo("Qualquer")
		   .construir();
		
		
		
	

	}
}
