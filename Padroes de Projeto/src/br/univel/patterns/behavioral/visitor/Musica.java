package br.univel.patterns.behavioral.visitor;

class Musica {

	private TipoMusica	tipo;
	private String		nome;
	private String		album;
	private String		artista;

	Musica(TipoMusica tipo, String nome, String album, String artista) {
		super();
		this.tipo = tipo;
		this.nome = nome;
		this.album = album;
		this.artista = artista;
	}

	public TipoMusica getTipo() {
		return tipo;
	}

	public void setTipo(TipoMusica tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	@Override
	public String toString() {
		return "Musica [tipo=" + tipo + ", nome=" + nome + ", album=" + album
				+ ", artista=" + artista + "]";
	}

}
