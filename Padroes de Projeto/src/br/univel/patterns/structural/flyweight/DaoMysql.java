package br.univel.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class DaoMysql {
	
	private Map<Integer, String> cache = new HashMap<Integer, String>();
	
	public String getNomeCidade(int codigo) {
		// Faz a busca do nome
		// da cidade no banco de dados.
		String nome = cache.get(codigo);
		if (nome == null) {
			nome = leNome(codigo);
			cache.put(codigo, nome);
		}
		return nome;
	}
	
	
	
	// Daqui em diante simula a busca
	// no banco
	private String leNome(int codigo) {
		System.out.println("Buscando no banco...");
		try {
			// Simulando demora com o banco.
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch (codigo) {
		case 1:
			return "Cascavel";
		case 2: 
			return "Toledo";
		case 3:
			return "Curitiba";
		default:
			return "nao encontrado";
		}
	}
}

