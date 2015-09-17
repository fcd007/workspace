package br.univel.patterns.behavioral.visitor;

enum TipoMusica {

	ROCK, POP, CLASSICA, DANCE, TECNO;

	public static TipoMusica random() {
		int j = (int) (Math.random() * 10);
		int i = values().length;
		return values()[j >= i ? j - i : j];
	}

}
