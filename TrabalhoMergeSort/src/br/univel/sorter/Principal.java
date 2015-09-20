package br.univel.sorter;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		 int size = 15000;

		StringBuilder sb = new StringBuilder();
			Sorter s = new Sorter();
			ArrayList<Integer> numbers = s.shuffle(s.generateNumbers(size));
			sb.append("Array Gerado com " + size + " numeros.\n");
			
			long startTime = 0;
			long time = 0;
			startTime = System.currentTimeMillis();
			s.ordena((ArrayList)numbers.clone());
			time = System.currentTimeMillis() - startTime;
			sb.append("BUBBLE SORT 1: "+ s.betterValue("BUBBLE 1",time)+"\n");
			
			startTime = System.currentTimeMillis();
			s.ordenaOtimizado((ArrayList)numbers.clone());
			time = System.currentTimeMillis() - startTime;
			sb.append("BUBBLE SORT 2: "+ s.betterValue("BUBBLE 2",time)+"\n");
			
			startTime = System.currentTimeMillis();
			s.selectionSort((ArrayList)numbers.clone());
			time = System.currentTimeMillis() - startTime;
			sb.append("SELECTION SORT: "+ s.betterValue("SELECTION SORT",time)+"\n");
			
			startTime = System.currentTimeMillis();
			s.cocktailSort((ArrayList)numbers.clone());
			time = System.currentTimeMillis() - startTime;
			sb.append("COCKTAIL SORT: "+ s.betterValue("COCKTAIL SORT",time)+"\n");
			
			startTime = System.currentTimeMillis();
			s.quickSort((ArrayList)numbers.clone());
			time = System.currentTimeMillis() - startTime;
			sb.append("QUICK SORT: "+ s.betterValue("QUICK SORT",time)+"\n");
			
			startTime = System.currentTimeMillis();
			Collections.sort((ArrayList)numbers.clone());
			time = System.currentTimeMillis() - startTime;
			sb.append("JAVA COLLECTIONS: "+ s.betterValue("JAVA COLLECTIONS",time)+"\n");

			sb.append("O MELHOR ALGORITMO e " + s.getBetterName() + "\n\n");
			

		JOptionPane.showMessageDialog(null, sb);

	}
}
