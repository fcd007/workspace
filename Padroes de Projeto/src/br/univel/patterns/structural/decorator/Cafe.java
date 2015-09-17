package br.univel.patterns.structural.decorator;

public class Cafe implements Produto {

	@Override
	public String getDescricao() {
		return "Caf�";
	}

	@Override
	public float getPreco() {
		return 0.7f;
	}

}
