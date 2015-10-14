package br.univel.cadastro.model;

public enum Uf {
	PR("Paran�"),
	SP("S�o Paulo"),
	SC("Santa Catarina");
	
	private String nome;
	
	private Uf(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
}
