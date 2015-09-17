package br.univel.patterns.structural.decorator;

public class Adocante implements Produto {

	private Produto produto;

	public Adocante(Produto p) {
		this.produto = p;
	}
	
	@Override
	public String getDescricao() {
		return "Adocante" + " " + produto.getDescricao();
	}

	@Override
	public float getPreco() {
		return 0.05f + produto.getPreco();
	}

}
