package br.univel.patterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

class Classificador {

	private Estrategia est = null;

	private List<Aluno> alunos;

	public Classificador() {
		alunos = new ArrayList<Aluno>();
		for (int i = 0; i < 100; i++) {
			Aluno al = new Aluno("Aluno " + (i + 1),
					(int) (Math.random() * 100), (int) (Math.random() * 10));
			alunos.add(al);
		}
	}

	public void setEstrategia(Estrategia est) {
		this.est = est;
	}

	public Aluno getMelhorAluno() {
		if (est == null)
			throw new RuntimeException("Estratégia não definida.");
		return est.getMelhorAluno(alunos);
	}

}
