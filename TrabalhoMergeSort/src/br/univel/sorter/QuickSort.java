package br.univel.sorter;

import java.util.ArrayList;

public class QuickSort extends Sort{
	
	public QuickSort() {
		this.setName("Quick Sort");
	}
	@Override
	public void sort(ArrayList array) {
		
		 quickSort(array.toArray(), 0, array.size()-1);
	}
	
	private void quickSort(Object[] arr, int left, int right){
		int idx = partition(arr, left, right);
		if(left < idx-1)
			quickSort(arr, left, idx-1);
		
		if(right > idx)
			quickSort(arr, idx, right);
	}
	private int partition(Object[] numbers, int left, int right) {
		
		int pivot = (int)numbers[left];
		
		while (left <= right) {
			while ((int)numbers[left] < pivot) {
				left++;
			}
			while ((int)numbers[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int tmp = (int)numbers[left];
				numbers[left] = numbers[right];
				numbers[right]=tmp;
				left++;
				right--;
			}
		}
		return left;
	}
	
}
