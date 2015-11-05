package br.univel.aulaTree.professor;

import java.math.BigInteger;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ControlTree {

	private static Tree tree;

	private void menu() {

		int opcao;

		StringBuilder sb = new StringBuilder();
		sb.append("\nMENU DE OPÇÕES\n");
		sb.append("1 - Inserir nó\n");
		sb.append("2 - Percorrer Pré-ordem\n");
		sb.append("5 - Exibir Arvore\n");
		sb.append("6 - Limpar Arvore\n");
		sb.append("9 - Sair\n");
		sb.append("Digite sua opção:\n");
		opcao = Integer.parseInt(JOptionPane.showInputDialog(sb.toString()));

		switch (opcao) {

		case 1: {
			// Scanner vlr = new Scanner(System.in);

			Pessoa pessoa = new Pessoa();
			pessoa.setCpf(new BigInteger(JOptionPane
					.showInputDialog("Insira Seu CPF")));
			pessoa.setNome(JOptionPane.showInputDialog("Insira Seu nome"));
			System.out.println(pessoa.getCpf().toString());
			tree.insertNode(pessoa);
			this.menu();

			break;
		}

		case 2:
			System.out.println("\n\n");
			tree.showPreOrder();
			System.out.println("\n\n");
			this.menu();
			break;

		case 6:
			this.menu();
			break;

		case 9:
			System.exit(0);

		default:
			System.out.println("\nOPÇÃO INVALIDA, TENTE NOVAMENTE...\n");
			menu();
			break;

		}
	}

	public static void main(String[] args) {
		tree = new Tree();
		ControlTree controle = new ControlTree();
		controle.menu();
	}

}
