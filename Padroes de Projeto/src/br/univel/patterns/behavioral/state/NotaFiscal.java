package br.univel.patterns.behavioral.state;

import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {

	private EnumEstado		estado	= EnumEstado.NOVA;
	private List<String>	itens;

	void abrir() {
		if (estado == EnumEstado.ABERTA) {
			throw new RuntimeException("Nota já aberta.");
		}
		
		if (estado == EnumEstado.FECHADA) {
			throw new RuntimeException("Nota já fechada.");
		}
		itens = new ArrayList<String>();
		this.estado = EnumEstado.ABERTA;
	}

	void adicionarItem(String item) {
		if (estado == EnumEstado.NOVA) {
			throw new RuntimeException("Precisa abrir a nota.");
		}
		if (estado == EnumEstado.FECHADA) {
			throw new RuntimeException("Nota já fechada.");
		}
		itens.add(item);
	}

	void fechar() {
		if (estado == EnumEstado.FECHADA) {
			throw new RuntimeException("Nota já fechada.");
		}
		this.estado = EnumEstado.FECHADA;
	}

}
