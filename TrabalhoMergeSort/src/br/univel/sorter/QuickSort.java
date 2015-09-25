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
	private void quickSort(Object[] numbers, int start, int end) {
		if (start < end){
	         int pivotPosition =split(numbers, start, end);
	         quickSort(numbers, start, pivotPosition - 1);
	         quickSort(numbers, pivotPosition + 1, end);
	      }
	}
	private int split(Object[] numbers, int start, int end) {
		
		 int pivot = (int) numbers[start];
	      int left = start + 1, rigth = end;
	      while (left <= rigth){
	         if ((int)numbers[left] <= pivot)
	            left++;
	         else if (pivot < (int)numbers[rigth])
	            rigth--;
	         else{
	            int troca = (int)numbers[left];
	            numbers[left] = numbers[rigth];
	            numbers[rigth] = troca;
	            left++;
	            rigth--;
	         }
	      }
	      numbers[start] = numbers[rigth];
	      numbers[rigth] = pivot;
	      return rigth;
	   }
	
}
