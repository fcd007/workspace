package br.univel.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Sort implements Comparable<Sort>{
	private String name;
	private long time;
	public static List<Sort> sorters = new ArrayList<>();
	public static ArrayList<Integer> numbers = null;
	
	public void sort(ArrayList array){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	public static ArrayList<Integer> generateNumbers(int size){
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			numbers.add(i);
		}
		Sort.numbers = numbers;
		return numbers;
	}
	
	public static void shuffle(){
		if (Sort.numbers != null) {
			Collections.shuffle(Sort.numbers);
		}
	}
	
	public static void countTime(Sort sort){
		if(Sort.numbers.size()> 10000){
			long startTime =  System.currentTimeMillis() ;
			sort.sort(Sort.numbers);
			sort.setTime(System.currentTimeMillis() - startTime); 
		}else{
			long startTime =  System.nanoTime();
			sort.sort(Sort.numbers);
			sort.setTime(System.nanoTime() - startTime); 
		}
	}
	
	@Override
	public int compareTo(Sort o) {
		if(this.getTime() > o.getTime())
			return 1;
		if(this.getTime() < o.getTime())
			return -1;
		return 0;
	}

}
