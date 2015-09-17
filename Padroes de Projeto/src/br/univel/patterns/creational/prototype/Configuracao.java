package br.univel.patterns.creational.prototype;

public class Configuracao implements Cloneable {

	private double	numero;
	//Conceito e a partir dele voce multiplicar, fazer clones
	//Criar copias e mais rapido do criar novamente o mesmo
	public Configuracao() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.numero = Math.random();
	}

	public double getNumero() {
		return numero;
	}
	//So funciona se implementar Clonable e sobrescrever este método
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
