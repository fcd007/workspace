package br.univel.patterns.behavioral.mediator;

public class TesteMediator {

	public static void main(String[] args) {
		
		Servidor servidor = new Servidor();

		Cliente cLocal = new ClienteLocal(servidor);
		Cliente cRemoto = new ClienteRemoto(servidor);
		Cliente cMovel = new ClienteMovel(servidor);

		servidor.addCliente(cLocal);
		servidor.addCliente(cRemoto);
		servidor.addCliente(cMovel);

		System.out.println("Cliente local enviando.");
		cLocal.send("Ola do cliente local!");
		
		System.out.println("\nCliente remoto enviando.");
		cRemoto.send("Ola do cliente remoto!");
		
		System.out.println("\nCliente movel enviando.");
		cMovel.send("Ola do cliente movel!");
		
	}
}