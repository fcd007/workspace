package br.univel.sorter;

import java.util.ArrayList;

public class BubbleSort1 extends Sort{
	
	public BubbleSort1() {
		this.setName("Bubble Sort 1");
	}
	
	@Override
	public void sort(ArrayList<Integer> array) {
		bubbleSort1(Sort.convertIntegers(array));
	}
	
	public void bubbleSort1(int[] numbers){
//		int cont = 0;
		int aux = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - 1; j++) {
				if (numbers[j] > numbers[j+1]) {
					aux = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1]= aux;
				}
//				cont++;

			}
		}
//		return cont;
	}

}
