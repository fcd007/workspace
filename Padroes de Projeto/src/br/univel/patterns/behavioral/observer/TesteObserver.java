package br.univel.patterns.behavioral.observer;

public class TesteObserver {

	public static void main(String[] args) {
	
		System.out.println("Digite a mensagem: ");

		LeitorDeComandos leitor = new LeitorDeComandos();

		
		ObsMostraMensagem mostrador = new ObsMostraMensagem();
		leitor.addObserver(mostrador);
		
		ObsGravaMensagem gravador = new ObsGravaMensagem();
		leitor.addObserver(gravador);

		
		leitor.iniciar();
	}
}