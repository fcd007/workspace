package br.univel.sorter;

import java.util.ArrayList;

public class QuickSort extends Sort {

	public QuickSort() {
		this.setName("Quick Sort");
	}

	@Override
	public void sort(ArrayList array) {
		
		int[] numbers = Sort.convertIntegers(array);
		int start = 0;
		int end = numbers.length-1;
		quickSort(numbers, start, end);
	}

	private void quickSort(int[] arr, int left, int right) {
		int idx = partition(arr, left, right);
		if (left < idx - 1) {
			quickSort(arr, left, idx - 1);
		}
		if (right > idx) {
			quickSort(arr, idx, right);
		}

	}

	private int partition(int[] numbers, int left, int right) {

		int pivot = numbers[left];
		while (left <= right) {
			while (numbers[left] < pivot) {
				left++;
			}
			while (numbers[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int tmp = numbers[left];
				numbers[left] = numbers[right];
				numbers[right] = tmp;
				left++;
				right--;
			}
		}
		return left;
	}

}
