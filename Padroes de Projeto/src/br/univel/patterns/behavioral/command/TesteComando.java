package br.univel.patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class TesteComando {

	public static void main(String[] args) {
		
		for (Comando c : getComandos()) {
			
			c.executar();
		}
		
	}

	private static List<Comando> getComandos() {
		List<Comando> lista = new ArrayList<Comando>();
		
		lista.add(new ComandoAbrir());
		lista.add(new ComandoImprimir());
		lista.add(new ComandoFechar());
		
		return lista;
	}
	
}
