package br.grams.Teste;

import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine().trim());
		float result=0;
		for (int i = 0; i < n	; i++) {
			String[] stringArray = s.nextLine().trim().split(" ");
			int[] intArray = new int[stringArray.length];
			for (int j = 0; j < stringArray.length; j++) {
				intArray[j] = Integer.parseInt(stringArray[j]);
			}
			result += (Math.pow((intArray[0]-intArray[2]), 2)+(Math.pow((intArray[1]-intArray[3]),2)));
			
			
		}
		System.out.println(result);
		
	}
}
