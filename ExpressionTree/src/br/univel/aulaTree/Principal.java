package br.univel.aulaTree;

public class Principal {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(5);
		tree.insert(4);
		tree.insert(4);
		tree.insert(2);
		tree.insert(10);
		tree.showPrefix();
	}
}
