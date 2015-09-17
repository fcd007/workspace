package br.univel.patterns.behavioral.strategy;

public class Aluno {
	private String nome;
	private int nota;
	private int faltas;

	public Aluno(String nome, int nota, int faltas) {
		super();
		this.nome = nome;
		this.nota = nota;
		this.faltas = faltas;
		
		System.out.println(this.toString());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", nota=" + nota + ", faltas=" + faltas
				+ "]";
	}

}
