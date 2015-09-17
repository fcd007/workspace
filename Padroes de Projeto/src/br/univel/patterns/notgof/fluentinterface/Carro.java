package br.univel.patterns.notgof.fluentinterface;

public class Carro {

	
	private int id;
	private String cor;
	private String marca;
	private String modelo;
	private String ano;
	private String portas;
	private String ar;
	private String direcao;
	
	public Carro(int id, String cor, String marca, String modelo, String ano,
			String portas, String ar, String direcao) {
		super();
		this.id = id;
		this.cor = cor;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.portas = portas;
		this.ar = ar;
		this.direcao = direcao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getPortas() {
		return portas;
	}
	public void setPortas(String portas) {
		this.portas = portas;
	}
	public String getAr() {
		return ar;
	}
	public void setAr(String ar) {
		this.ar = ar;
	}
	public String getDirecao() {
		return direcao;
	}
	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}
	
	
	
}
