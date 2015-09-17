package br.univel.patterns.structural.decorator;

public class Leite implements Produto {

	private Produto produto;

	public Leite(Produto p) {
		this.produto = p;
	}
	
	@Override
	public String getDescricao() {
		return "Leite" + " " + produto.getDescricao();
	}

	@Override
	public float getPreco() {
		return 0.8f + produto.getPreco();
	}

}
