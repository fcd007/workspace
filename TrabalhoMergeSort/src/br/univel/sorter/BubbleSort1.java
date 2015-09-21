package br.univel.sorter;

import java.util.ArrayList;

public class BubbleSort1 extends Sort{
	
	public BubbleSort1() {
		this.setName("Bubble Sort 1");
	}
	
	@Override
	public void sort(ArrayList array) {
//		int cont = 0;
		Object[] numbers = array.toArray();
		int aux = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - 1; j++) {
				if ((int)numbers[j] > (int)numbers[j+1]) {
					aux = (int)numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1]= aux;
				}
//				cont++;

			}
		}
//		return cont;
	}

}
