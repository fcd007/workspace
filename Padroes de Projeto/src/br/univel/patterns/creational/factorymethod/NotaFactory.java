package br.univel.patterns.creational.factorymethod;

public class NotaFactory {
	// retorna um objeto do tipo nota, nao importa qual  impelentação, importa apenas ser do tipo Nota
	public Nota getNota(EnumUF uf) {

		switch (uf) {
		
		case PR:
			return new NotaPR();
		
		case SP:
			return new NotaSP();
		
		default:
			throw new RuntimeException("Estado nao suportado.");
			
		}
		
	}

	public static void main(String[] args) {
		Nota n = new NotaFactory().getNota(EnumUF.PR);
		System.out.println(n.getClass().getCanonicalName());
	}
	
}
