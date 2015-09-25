package br.univel.sorter;

import java.util.ArrayList;

public class QuickSort extends Sort{
	
	public QuickSort() {
		this.setName("Quick Sort");
	}
	@Override
	public void sort(ArrayList array) {
<<<<<<< HEAD
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
	
=======
		 Object[] a = array.toArray();
//		 int count=0;
		 int start = 0;
			int hi = a.length;
			int lo = start;
	        assert lo <= start && start <= hi;
	        if (start == lo)
	            start++;
	        for ( ; start < hi; start++) {
	            int pivot = (int) a[start];

	            int left = lo;
	            int right = start;
	            assert left <= right;
	            while (left < right) {
	                int mid = (left + right) >>> 1;
	                if (pivot < (int)a[mid])
	                    right = mid;
	                else
	                    left = mid + 1;
	            }
	            assert left == right;

	            int n = start - left;  

	            switch (n) {
	                case 2:  a[left + 2] = a[left + 1];
	                case 1:  a[left + 1] = a[left];
	                         break;
	                default: System.arraycopy(a, left, a, left + 1, n);
	            }
	            if ((int)a[left] != pivot) {
//	            	count++;
				}
	            a[left] = pivot;
	        }
//	        return count;
	}
>>>>>>> e81c5c865828d4086e62d82cb67d6553713cbd94
}
