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
		 int stack[] = new int[right - left + 1];
		 
		    // initialize top of stack
		    int top = -1;
		 
		    // push initial values of l and h to stack
		    stack[ ++top ] = left;
		    stack[ ++top ] = right;
		 
		    // Keep popping from stack while is not empty
		    while ( top >= 0 )
		    {
		        // Pop h and l
		        right = stack[ top-- ];
		        left = stack[ top-- ];
		 
		        // Set pivot element at its correct position in sorted array
		        int p = partition( arr, left, right );
		 
		        // If there are elements on left side of pivot, then push left
		        // side to stack
		        if ( p-1 > left )
		        {
		            stack[ ++top ] = left;
		            stack[ ++top ] = p - 1;
		        }
		 
		        // If there are elements on right side of pivot, then push right
		        // side to stack
		        if ( p+1 < right )
		        {
		            stack[ ++top ] = p + 1;
		            stack[ ++top ] = right;
		        }
		    }
		
	}
	private int partition(Object[] numbers, int left, int right) {
		
		int x = (int)numbers[right];
	    int i = (left - 1);
	 
	    for (int j = left; j <= right- 1; j++){
	        if ((int)numbers[j] <= x){
	            i++;
	            int tmp = (int)numbers[i];
	            numbers[i]= numbers[j];
	            numbers[j] = tmp;
	        }
	    }
	    int tmp = (int)numbers[i+1];
        numbers[i+1]= numbers[right];
        numbers[right] = tmp;
	    return (i + 1);
		
		
	}
	
}
