package br.univel.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Sorter {
	private String betterName = "";
	private long betterValue = 0;

	public String getBetterName() {
		return betterName;
	}

	public ArrayList<Integer> randomNumbersGenerator(int size) {
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			randomNumbers.add(r.nextInt(size));
		}
		return randomNumbers;
	}
	
	public ArrayList<Integer> generateNumbers(int size){
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			numbers.add(i);
		}
		return numbers;
	}

	public ArrayList<Object> selectPrimes(ArrayList<Integer> randomNumbers) {
		ArrayList<Object> primes = new ArrayList<>();
		for (int i : randomNumbers) {
			if (isPrime(i))
				primes.add(i);
		}
		return primes;
	}
	
	 public int quickSort(ArrayList array) {
		 Object[] a = array.toArray();
		 int count=0;
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
	            	count++;
				}
	            a[left] = pivot;
	        }
	        return count;
	 }

	public boolean isPrime(int i) {
		if (i < 2)
			return false;
		int j = 0;
		for (j = 2; j < i; j++) {
			if (i % j == 0)
				break;
		}
		if (j == i)
			return true;
		else
			return false;
	}

	public void ordena(ArrayList<Object> array) {
//		int cont = 0;
		Object[] numbers = array.toArray();
		int aux = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - 1; j++) {
				if ((int)numbers[j] > (int)numbers[j+1]) {
					aux = (int)numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1]= aux;
				}
//				cont++;

			}
		}
//		return cont;
	}
	
	public ArrayList<Integer> shuffle(ArrayList<Integer>list ){
		Collections.shuffle(list);
		return list;
	}

	public void ordenaOtimizado(ArrayList<Integer> array) {
		Object[] numbers = array.toArray();
		int aux = 0;
//		int cont = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = numbers.length - 1; j > i; j--) {
				if ((int)numbers[j] < (int)numbers[j-1]) {
					aux = (int)numbers[j];
					numbers[j]= numbers[j-1];
					numbers[j-1] = aux;
				}
//				cont++;

			}
		}
//		return cont;
	}

	public void selectionSort(ArrayList<Integer> array) {
		Object[] numbers = array.toArray();
		int aux = 0;
		int idx = 0;
//		int count = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			aux = (int)numbers[i];
			idx = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (aux > (int)numbers[j]) {
					aux = (int)numbers[j];
					idx = j;

				}
			}
			if (aux != (int)numbers[i]) {
//				count++;
				numbers[idx]= numbers[i];
				numbers[i]=aux;
			}
		}
//		return count;
	}

	public void cocktailSort(ArrayList<Integer> array) {
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

	public long betterValue(String betterName, long betterValue) {
		if (this.betterValue == 0) {
			this.betterValue = betterValue;
		} else if (betterValue < this.betterValue) {
			this.betterValue = betterValue;
			this.betterName = betterName;
		}
		return betterValue;
	}

}
