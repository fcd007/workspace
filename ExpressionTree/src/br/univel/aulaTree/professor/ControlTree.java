package br.univel.aulaTree.professor;

import java.util.Scanner;

public class ControlTree {

	private static Tree tree;

	private void menu() {

		int opcao;

		Scanner entradaUsuario = new Scanner(System.in);

		System.out.println("\nMENU DE OP��ES\n");
		System.out.println("1 - Inserir n�");
		System.out.println("2 - Percorrer Pr�-ordem");
		System.out.println("5 - Exibir Arvore");
		System.out.println("6 - Limpar Arvore");
		System.out.println("9 - Sair");
		System.out.print("Digite sua op��o:");
		opcao = entradaUsuario.nextInt();

		switch (opcao) {

		case 1:
			Scanner vlr = new Scanner(System.in);

			System.out.println("\nINFORME UM VALOR INTEIRO");
			opcao = entradaUsuario.nextInt();

			tree.insertNode(opcao);
			this.menu();

			break;

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
			System.out.println("\nOP��O INVALIDA, TENTE NOVAMENTE...\n");
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
