package br.univel.patterns.behavioral.visitor;

import java.util.Collections;

public class SelecionadorFesta extends Tocador implements VisitorMusica {

	@Override
	public void visit(Musica musica) {
		switch (musica.getTipo()) {
		case DANCE:
		case POP:
			lista.add(musica);
		default:
			break;
		}
	}

	@Override
	public void tocar() {
		Collections.shuffle(lista);
		super.tocar();
	}
	
	

}
