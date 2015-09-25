package br.univel.threadsync;

public class Principal {

	public Principal() {
		Receptor receptor = new Receptor();
		new Emissor(receptor, "-");
		new Emissor(receptor, "+");
		new Emissor(receptor, "*");
	}

	public static void main(String[] args) {
		new Principal();
	}
	
}
