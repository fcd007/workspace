package br.univel.patterns.notgof.fluentinterface;

public class ConstrutorCarro {
	
	private int id;
	private String cor;
	private String marca;
	private String modelo;
	private String ano;
	private String portas;
	private String ar;
	private String direcao;
	
	public ConstrutorCarro id(int id) {
		this.id = id;
		return this;
	}
	
	public ConstrutorCarro cor(String cor) {
		this.cor = cor;
		return this;
	}
	
	public ConstrutorCarro marca(String marca) {
		this.marca = marca;
		return this;
	}
	
	public ConstrutorCarro modelo(String modelo) {
		this.modelo = modelo;
		return this;
	}
	
	public ConstrutorCarro ano(String ano) {
		this.ano = ano;
		return this;
	}
	
	public ConstrutorCarro portas(String portas) {
		this.portas = portas;
		return this;
	}
	
	public ConstrutorCarro ar(String ar) {
		this.ar = ar;
		return this;
	}
	
	public ConstrutorCarro direcao(String direcao) {
		this.direcao = direcao;
		return this;
	}
	
	public Carro construir() {
		return new Carro(id, cor, marca, modelo, ano, portas, ar, direcao);
	}
	
	
}
