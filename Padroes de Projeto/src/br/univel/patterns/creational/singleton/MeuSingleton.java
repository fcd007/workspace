package br.univel.patterns.creational.singleton;

public final class MeuSingleton {

	private static MeuSingleton self;
	//Construtor deve ser privado
	private MeuSingleton() {
	}
	// garante que a mesma instancia será retornada
	//Synchronized permite que apenas uma thread por vez use a instancia, caso seja o feito, a thread fica em espera.
	public final synchronized static MeuSingleton getInstance() {
		if (self == null) {
			self = new MeuSingleton();
		}
		return self;
	}

	//Nao e possivel clonar a instancia 
	@Override
	protected final Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
