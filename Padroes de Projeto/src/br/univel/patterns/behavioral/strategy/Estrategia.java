package br.univel.patterns.behavioral.strategy;

import java.util.List;

interface Estrategia {

	Aluno getMelhorAluno(List<Aluno> alunos);

}
