package br.univel.patterns.behavioral.strategy;

import java.util.List;

public class MelhorNota implements Estrategia {

	@Override
	public Aluno getMelhorAluno(List<Aluno> alunos) {

		Aluno melhor = null;
		for (Aluno aluno : alunos) {
			if (melhor == null) {
				melhor = aluno;
			} else if (aluno.getNota() > melhor.getNota()) {
				melhor = aluno;
			}
		}

		return melhor;

	}

}
