package br.univel.Sorters;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		int[] sizes = { 32, 300, 5000 };

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sizes.length; i++) {
			Sorter s = new Sorter();
			ArrayList<Integer> randomNumbers = s
					.randomNumbersGenerator(sizes[i]);
			sb.append("Array Gerado com " + sizes[i] + " numeros e "
					+ s.selectPrimes(randomNumbers).size()
					+ " n�meros primos\n");
			
			ArrayList<Object> teste;
			teste = s.selectPrimes(randomNumbers);
			long startTime = 0;
			long time = 0;
			startTime = System.nanoTime();
			s.ordena((ArrayList)teste.clone());
			time = System.nanoTime() - startTime;
			sb.append("BUBBLE SORT 1: "+ s.betterValue("BUBBLE 1",time)+"\n");
			
			startTime = System.nanoTime();
			s.ordenaOtimizado((ArrayList)teste.clone());
			time = System.nanoTime() - startTime;
			sb.append("BUBBLE SORT 2: "+ s.betterValue("BUBBLE 2",time)+"\n");
			
			startTime = System.nanoTime();
			s.selectionSort((ArrayList)teste.clone());
			time = System.nanoTime() - startTime;
			sb.append("SELECTION SORT: "+ s.betterValue("SELECTION SORT",time)+"\n");
			
			startTime = System.nanoTime();
			s.cocktailSort((ArrayList)teste.clone());
			time = System.nanoTime() - startTime;
			sb.append("COCKTAIL SORT: "+ s.betterValue("COCKTAIL SORT",time)+"\n");
			
			startTime = System.nanoTime();
			s.quickSort((ArrayList)teste.clone());
			time = System.nanoTime() - startTime;
			sb.append("QUICK SORT: "+ s.betterValue("QUICK SORT",time)+"\n");
			
			startTime = System.nanoTime();
			Collections.sort((ArrayList)teste.clone());
			time = System.nanoTime() - startTime;
			sb.append("JAVA COLLECTIONS: "+ s.betterValue("JAVA COLLECTIONS",time)+"\n");

			sb.append("O MELHOR ALGORITMO e " + s.getBetterName() + "\n\n");
			

		}
		JOptionPane.showMessageDialog(null, sb);

	}
}
