package br.univel.patterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class Tocador {

	protected List<Musica>	lista	= new ArrayList<>();

	public void tocar() {
		for (Musica m : lista) {
			System.out.println("Tocando " + m);
		}
	}
}
