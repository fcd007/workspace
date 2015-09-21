package br.univel.sorter;

import java.util.ArrayList;

public class QuickSort extends Sort{
	
	public QuickSort() {
		this.setName("Quick Sort");
	}
	@Override
	public void sort(ArrayList array) {
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
}
