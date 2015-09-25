package br.univel.sorter;

import java.util.ArrayList;


public class MergeSort extends Sort{
	
	public MergeSort() {
		this.setName("Merge Sort");
	}
	@Override
	public void sort(ArrayList array) {
		
		Object[] numbers = array.toArray();
		int start = 0;
		int end = numbers.length-1;
		mergeSort(numbers, start, end);
		
	}
	
	public void mergeSort(Object[] numbers, int start, int end){
		if (end <= start) {
			return;
		}
		int middle = (start + end) >> 1;
		mergeSort(numbers, start, middle);
		mergeSort(numbers, middle + 1, end);
		int[] left = new int[middle - start + 1];
		int[] right = new int[end - middle];
		for (int i = 0; i <= middle - start; i++) {

			left[i] = (int)numbers[start + i];
		}
		for (int i = 0; i <= end - middle - 1; i++) {
			right[i] = (int)numbers[middle + 1 + i];

		}
		int i = 0;
		int j = 0;
		for (int k = start; k <= end; k++) {
			if (i < left.length && j < right.length) {
				if (left[i] < right[j]) {
					numbers[k] = left[i++];
				} else {
					numbers[k] = right[j++];
				}
			} else if (i < left.length) {
				numbers[k] = left[i++];
			} else if (j < right.length) {
				numbers[k] = right[j++];
			}
		}
	}
}
