package br.univel.Sorters;

import java.util.ArrayList;
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

	public ArrayList<Integer> selectPrimes(ArrayList<Integer> randomNumbers) {
		ArrayList<Integer> primes = new ArrayList<>();
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
	            @SuppressWarnings("unchecked")
	            Comparable<Object> pivot = (Comparable) a[start];

	            int left = lo;
	            int right = start;
	            assert left <= right;
	            while (left < right) {
	                int mid = (left + right) >>> 1;
	                if (pivot.compareTo(a[mid]) < 0)
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
	            if (a[left] != pivot) {
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

	public int ordena(ArrayList<Integer> numbers) {
		int cont = 0;
		int aux = 0;
		for (int i = 0; i < numbers.size(); i++) {
			for (int j = 0; j < numbers.size() - 1; j++) {
				if (numbers.get(j) > numbers.get(j + 1)) {
					aux = numbers.get(j);
					numbers.set(j, numbers.get(j + 1));
					numbers.set(j + 1, aux);
				}
				cont++;

			}
		}
		return cont;
	}

	public int ordenaOtimizado(ArrayList<Integer> numbers) {
		int aux = 0;
		int cont = 0;
		for (int i = 0; i < numbers.size(); i++) {
			for (int j = numbers.size() - 1; j > i; j--) {
				if (numbers.get(j).compareTo(numbers.get(j - 1)) < 0) {
					aux = numbers.get(j);
					numbers.set(j, numbers.get(j - 1));
					numbers.set(j - 1, aux);
				}
				cont++;

			}
		}
		return cont;
	}

	public int selectionSort(ArrayList<Integer> numbers) {
		int aux = 0;
		int idx = 0;
		int count = 0;
		for (int i = 0; i < numbers.size() - 1; i++) {
			aux = numbers.get(i);
			idx = i;
			for (int j = i + 1; j < numbers.size(); j++) {
				if (aux > numbers.get(j)) {
					aux = numbers.get(j);
					idx = j;

				}
			}
			if (aux != numbers.get(i)) {
				count++;
				numbers.set(idx, numbers.get(i));
				numbers.set(i, aux);
			}
		}
		return count;
	}

	public int cocktailSort(ArrayList<Integer> numbers) {
		boolean swapped;
		int count = 0;
		do {
			swapped = false;
			for (int i = 0; i <= numbers.size() - 2; i++) {
				if (numbers.get(i) > numbers.get(i + 1)) {
					int temp = numbers.get(i);
					numbers.set(i, numbers.get(i + 1));
					numbers.set(i + 1, temp);
					swapped = true;
					count++;
				}
			}
			if (!swapped)
				break;
			swapped = false;
			for (int i = numbers.size() - 2; i >= 0; i--) {
				if (numbers.get(i) > numbers.get(i + 1)) {
					int temp = numbers.get(i);
					numbers.set(i, numbers.get(i + 1));
					numbers.set(i + 1, temp);
					swapped = true;
					count++;
				}
			}
		} while (swapped);
		return count;
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
