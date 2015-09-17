package br.univel.patterns.behavioral.strategy;

public class TesteStrategy {

	public static void main(String[] args) {
		Classificador cla = new Classificador();

		cla.setEstrategia(new MelhorNota());
		Aluno al = cla.getMelhorAluno();
		System.out.println("Melhor Nota: " + al);
		
		cla.setEstrategia(new MenosFalta());
		al = cla.getMelhorAluno();
		System.out.println("Menos Falta: " + al);

		cla.setEstrategia(new MelhorNotaMenosFalta());
		al = cla.getMelhorAluno();
		System.out.println("Melhor Nota e Menos Faltas: " + al);

	}

}
