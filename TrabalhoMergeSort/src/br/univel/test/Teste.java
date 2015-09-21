package br.univel.test;

import br.univel.sorter.MergeSort;
import br.univel.sorter.Sort;

public class Teste {
	public static void main(String[] args) {
		Sort.generateNumbers(5000);
		Sort.shuffle();
		new MergeSort().sort(Sort.numbers);
	}
}
