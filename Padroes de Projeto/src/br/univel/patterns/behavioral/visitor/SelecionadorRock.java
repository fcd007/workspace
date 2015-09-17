package br.univel.patterns.behavioral.visitor;

public class SelecionadorRock extends Tocador implements VisitorMusica {

	@Override
	public void visit(Musica musica) {
		if (musica.getTipo() == TipoMusica.ROCK) {
			lista.add(musica);
		}
	}

}
