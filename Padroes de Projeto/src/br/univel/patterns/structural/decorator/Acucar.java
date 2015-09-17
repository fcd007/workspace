package br.univel.patterns.structural.decorator;

public class Acucar implements Produto {

	private Produto produto;

	public Acucar(Produto p) {
		this.produto = p;
	}
	
	@Override
	public String getDescricao() {
		return "Açúcar" + " " + produto.getDescricao();
	}

	@Override
	public float getPreco() {
		return 0.07f + produto.getPreco();
	}

}
