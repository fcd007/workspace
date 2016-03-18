package br.univel.client;

import java.io.Serializable;

import br.univel.common.Tarefa;

class CalculoDemorado 
		implements Tarefa<Integer, Integer>,
		Serializable {

	@Override
	public Integer executar(Integer p) {
		System.out.println("T Iniciando executao.");
		try {
			for (int i = 0; i < 10; i++) {
				System.out.print(".");
				Thread.sleep(1_000);
			}
			System.out.println("");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("T Terminando executao.");
		return p * 2;
	}

}
