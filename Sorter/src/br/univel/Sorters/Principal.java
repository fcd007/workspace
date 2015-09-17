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
					+ " números primos\n");
			
			ArrayList<Integer> teste = new ArrayList<Integer>();
			teste = s.selectPrimes(randomNumbers);
			long startTime = 0;
			long time = 0;
			startTime = System.nanoTime();
			s.ordena(teste.clone());
			time = System.nanoTime() - startTime;
			sb.append("BUBBLE SORT 1: "+ s.betterValue("BUBBLE 1",time)+"\n");
			
			startTime = System.nanoTime();
			s.ordenaOtimizado(s.selectPrimes(randomNumbers));
			time = System.nanoTime() - startTime;
			sb.append("BUBBLE SORT 2: "+ s.betterValue("BUBBLE 2",time)+"\n");
			
			startTime = System.nanoTime();
			s.selectionSort(s.selectPrimes(randomNumbers));
			time = System.nanoTime() - startTime;
			sb.append("SELECTION SORT: "+ s.betterValue("SELECTION SORT",time)+"\n");
			
			startTime = System.nanoTime();
			s.cocktailSort(s.selectPrimes(randomNumbers));
			time = System.nanoTime() - startTime;
			sb.append("COCKTAIL SORT: "+ s.betterValue("COCKTAIL SORT",time)+"\n");
			
			startTime = System.nanoTime();
			s.quickSort(s.selectPrimes(randomNumbers));
			time = System.nanoTime() - startTime;
			sb.append("QUICK SORT: "+ s.betterValue("QUICK SORT",time)+"\n");
			
			startTime = System.nanoTime();
			Collections.sort(s.selectPrimes(randomNumbers));
			s.quickSort(s.selectPrimes(randomNumbers));
			time = System.nanoTime() - startTime;
			sb.append("JAVA COLLECTIONS: "+ s.betterValue("JAVA COLLECTIONS",time)+"\n");

			sb.append("O MELHOR ALGORITMO É " + s.getBetterName() + "\n\n");
			
//			sb.append("BUBBLE SORT 1: "
//					+ s.betterValue("BUBBLE 1",
//							s.ordena(s.selectPrimes(randomNumbers)))
//					+ " TROCAS" + "\n");
//			sb.append("BUBBLE SORT 2: "
//					+ s.betterValue("BUBBLE 2",
//							s.ordenaOtimizado(s.selectPrimes(randomNumbers)))
//					+ " TROCAS" + "\n");
//			sb.append("SELECTION SORT: "
//					+ s.betterValue("SELECTION SORT",
//							s.selectionSort(s.selectPrimes(randomNumbers)))
//					+ " TROCAS" + "\n");
//			sb.append("COCKTAIL SORT: "
//					+ s.betterValue("COCKTAIL SORT",
//							s.cocktailSort(s.selectPrimes(randomNumbers)))
//					+ " TROCAS" + "\n");
//			sb.append("QUICK SORT: "
//					+ s.betterValue("QUICK SORT",
//							s.quickSort(s.selectPrimes(randomNumbers)))
//					+ " TROCAS" + "\n");
//			sb.append("O MELHOR ALGORITMO É " + s.getBetterName() + "\n\n");

		}
		JOptionPane.showMessageDialog(null, sb);

	}
}
