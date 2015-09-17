package br.univel.patterns.behavioral.iterator;

class ListaDeNumeros {

	private int[]	ar;
	private int		idx;

	ListaDeNumeros() {
		ar = new int[10];
		idx = -1;
		
		for (int i = 0; i < ar.length; i++) {
			ar[i] = i;
		}
	}

	Iterador<Integer> iterator() {

		return new Iterador<Integer>() {

			@Override
			public boolean hasNext() {
				return idx < ar.length - 1;
			}

			@Override
			public Integer next() {
				idx++;
				return ar[idx];
			}
		};
		
	}
}
