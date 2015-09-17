package br.univel.patterns.behavioral.iterator;


class TesteIteradorCustom {

	public static void main(String[] args) {
		ListaDeNumeros lista = new ListaDeNumeros();
		Iterador<Integer> it = lista.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
}
