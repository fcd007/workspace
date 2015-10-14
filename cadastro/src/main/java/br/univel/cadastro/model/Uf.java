package br.univel.cadastro.model;

public enum Uf {
	PR("Paraná"),
	SP("São Paulo"),
	SC("Santa Catarina");
	
	private String nome;
	
	private Uf(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
}
