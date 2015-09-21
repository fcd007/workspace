package br.univel.sorter;

import java.util.ArrayList;

public class SelectionSort extends Sort{
	
	public SelectionSort() {
		this.setName("Selection Sort");
	}
	@Override
	public void sort(ArrayList array) {
		Object[] numbers = array.toArray();
		int aux = 0;
		int idx = 0;
//		int count = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			aux = (int)numbers[i];
			idx = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (aux > (int)numbers[j]) {
					aux = (int)numbers[j];
					idx = j;

				}
			}
			if (aux != (int)numbers[i]) {
//				count++;
				numbers[idx]= numbers[i];
				numbers[i]=aux;
			}
		}
//		return count;
	}
}
