package br.univel.Pile;

import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		System.out.println("Digite a expressao");
		Scanner s = new Scanner(System.in);
		String expression = s.nextLine();
		if (validadeExpression(expression)) {
			System.out.println("Valido");
		}else
			System.out.println("Invalido");
		
	}

	private static boolean validadeExpression(String expression) {
		Pile p1 = new Pile();
		Pile p2 = new Pile();
		char[] e = expression.toCharArray();
		char[] e2 = new char[e.length];
		int x = 0;
		for (char c : e) {
			if (c == '(' || c == '[' ||c == '{') {
				p1.addItem(c);
				x++;
			}
			if (c == ')' || c == ']' || c == '}') {
				p1.addItem(c);
				x--;
			}
			
		}
		
		for (int i = 0; i < e2.length; i++) {
			e2[i] = e[e.length -1 -i];
		}
		
		for (char c : e2) {
			if (c == '(' || c == '[' ||c == '{' || c == ')' || c == ']' || c == '}') {
				p2.addItem(c);
			}
			
		}
		
		if (x == 0) {
			while (!p1.isNull()) {
				if ((p1.getTop() == '(' && p2.getTop() == ')') || (p1.getTop() == '[' && p2.getTop() == ']') || (p1.getTop() == '{' && p2.getTop() == '}')) {
					p1.pop();
					p2.pop();
				}else
					return false;
			}
			return true;
		}
		return false;
	}
}
