package br.univel.patterns.behavioral.iterator.jse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TesteIteratorJse {

	public static void main(String[] args) {

		List<Integer> lista = new ArrayList<Integer>();

		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);

		Iterator<Integer> iterator = lista.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}
}
