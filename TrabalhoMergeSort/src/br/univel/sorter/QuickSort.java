package br.univel.sorter;

import java.util.ArrayList;

public class QuickSort extends Sort {

	public QuickSort() {
		this.setName("Quick Sort");
	}

	@Override
	public void sort(ArrayList array) {

		int[] numbers = Sort.convertIntegers(array);
		quickSort(numbers);
	}

	private void quickSort(int[] arr) {
		int[] skip = new int[arr.length+1];
	      int i, j, sortedCount = 0;
	      while (sortedCount < arr.length) {
	        for (i=0; i<arr.length; i++)
	          if (skip[i] == 0) {
	            for (j=i; (j<arr.length-1) && (skip[j+1] == 0); j++) ;
	            for ( ; i<=j; i++) {
	              skip[i = partition(arr,i,j)] = 1;
	              sortedCount++;
	            }
	          }
	          else {
	            // skip[i] += skip[i + skip[i]];
	            while ((j = skip[i+skip[i]]) > 0) skip[i] += j;
	            i += skip[i]-1;
	          }
	      }

	}

	private int partition(int[] numbers, int left, int right) {

		
        if (left == right) return left;
        int i = left - 1;
        int j = right;
        while (true) {
            while (numbers[++i] < numbers[right]);                        
            while (numbers[right] < numbers[--j])     
                if (j == left) break;     
            if (i >= j) break;              
            swap(numbers, i, j);                
        }
        swap(numbers, i, right);                
        return i;
	}
	
	private void swap(int[] a, int i, int j) {
	      int temp = a[i];
	      a[i] = a[j];
	      a[j] = temp;
	    }

}
