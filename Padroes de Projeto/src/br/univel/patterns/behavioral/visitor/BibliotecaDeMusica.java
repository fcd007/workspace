package br.univel.patterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

class BibliotecaDeMusica {

	private List<Musica>	musicas;

	public BibliotecaDeMusica() {
		this.musicas = carregarBancoDeDados();
	}

	// simulacao
	private List<Musica> carregarBancoDeDados() {
		List<Musica> lista = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			TipoMusica tipo = TipoMusica.random();
			String nome = "Nome " + tipo.toString() + " " + i;
			String album = "Album " + tipo.toString() + " " + i;
			String artista = "Artista " + tipo.toString() + " " + i;
			
			Musica m = new Musica(tipo, nome, album, artista);
			lista.add(m);
			System.out.println("Criando " + m);
		}

		return lista;
	}

	public void accept(VisitorMusica visitor) {
		for (Musica m : musicas) {
			visitor.visit(m);
		}
	}
}