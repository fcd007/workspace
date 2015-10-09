package br.univel.expression_tree;

public class ExpressionTree {

	public void insert(String expression) {
		Node currentRoot = new Node('?');
		char[] simbols = expression.toCharArray();
		for (int i = 0; i < simbols.length; i++) {
			Stack parentesis = new Stack();
			if (isParentesis(simbols[i]) == 1) {

			} else if (isSimbol(simbols[i])) {
				currentRoot = new Node(simbols[i]);
			}
		}
	}
	
	public void expect(char token){
		
	}

	private boolean isSimbol(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/')
			return true;
		return false;
	}

	private int isParentesis(char c) {
		if (c == '(')
			return 1;
		else if (c == ')')
			return -1;
		else
			return 0;
	}

	class Node {
		private Node right;
		private Node left;
		private char value;

		public Node(char value) {
			this.value = value;
		}
	}
}
