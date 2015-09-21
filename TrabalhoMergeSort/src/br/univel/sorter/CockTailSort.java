package br.univel.sorter;

import java.util.ArrayList;

public class CockTailSort extends Sort{
	
	public CockTailSort() {
		this.setName("Cocktail Sort");
	}
	@Override
	public void sort(ArrayList array) {
		Object[] numbers = array.toArray();
		boolean swapped;
//		int count = 0;
		do {
			swapped = false;
			for (int i = 0; i <= numbers.length - 2; i++) {
				if ((int)numbers[i] > (int)numbers[i+1]) {
					int temp = (int)numbers[i];
					numbers[i]=numbers[i+1];
					numbers[i+1]=temp;
					swapped = true;
//					count++;
				}
			}
			if (!swapped)
				break;
			swapped = false;
			for (int i = numbers.length - 2; i >= 0; i--) {
				if ((int)numbers[i] > (int)numbers[i+1]) {
					int temp = (int)numbers[i];
					numbers[i]= numbers[i + 1];
					numbers[i + 1]=temp;
					swapped = true;
//					count++;
				}
			}
		} while (swapped);
//		return count;
	}
}
