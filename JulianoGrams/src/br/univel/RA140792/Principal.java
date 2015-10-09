package br.univel.RA140792;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		int option = 1;
		String expression = "";
		while (option < 2 || option < 1) {
			System.out.println("Insira 1 para Adicionar a expressao");
			System.out.println("Insira 2 para Validar a expressao");
			option =Integer.parseInt(JOptionPane.showInputDialog("Insira 1 para Adicionar a expressao\n Insira 2 para Validar a expressao"));
			switch (option) {
			case 1: {
				expression = JOptionPane.showInputDialog("Digite a expressao: ");
				break;
			}
			case 2:
				System.out.print("\n Validando");
				try {
					for (int i = 0; i < 3; i++) {
						Thread.sleep(300);
						System.out.print('.');
					}
					System.out.print('\n');
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(validade(expression));

			default:
				break;
			}
		}

	}

	public static String validade(String expression) {
		Pile pile = new Pile();
		boolean error = true;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(' || expression.charAt(i) == '{'
					|| expression.charAt(i) == '[') {
				pile.push(expression.charAt(i));
			} else if (expression.charAt(i) == ')'
					|| expression.charAt(i) == '}'
					|| expression.charAt(i) == ']') {
				if (closeVerify(expression.charAt(i), pile.getTop()))
					pile.pop();
				else
					error = false;
			}
		}
		if (error && pile.length() == 0)
			return "Expressão Válida!";
		else
			return "Expressão não é valida!";
	}

	private static boolean closeVerify(char charClosing, char charOpening) {
		if (charClosing == ')' && charOpening == '(')
			return true;
		if (charClosing == '}' && charOpening == '{')
			return true;
		if (charClosing == ']' && charOpening == '[')
			return true;
		return false;
	}

}
