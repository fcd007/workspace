package br.univel.sorter;

import java.util.ArrayList;

public class BubbleSort2 extends Sort {
	
	public BubbleSort2() {
		this.setName("Bubble Sort 2");
	}
	@Override
	public void sort(ArrayList array) {
		Object[] numbers = array.toArray();
		int aux = 0;
		// int cont = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = numbers.length - 1; j > i; j--) {
				if ((int) numbers[j] < (int) numbers[j - 1]) {
					aux = (int) numbers[j];
					numbers[j] = numbers[j - 1];
					numbers[j - 1] = aux;
				}
				// cont++;

			}
		}
		// return cont;
	}
}
