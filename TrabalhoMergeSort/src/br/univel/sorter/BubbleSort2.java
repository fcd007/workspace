package br.univel.sorter;

import java.util.ArrayList;

public class BubbleSort2 extends Sort {
	
	public BubbleSort2() {
		this.setName("Bubble Sort 2");
	}
	@Override
	public void sort(ArrayList<Integer> array) {
		bubbleSort2(Sort.convertIntegers(array));
	}
	
	public void bubbleSort2(int[] numbers){
		int aux = 0;
		// int cont = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = numbers.length - 1; j > i; j--) {
				if ( numbers[j] <  numbers[j - 1]) {
					aux = numbers[j];
					numbers[j] = numbers[j - 1];
					numbers[j - 1] = aux;
				}
				// cont++;

			}
		}
		// return cont;
	}
}
