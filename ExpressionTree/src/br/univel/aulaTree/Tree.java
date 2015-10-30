package br.univel.aulaTree;

public class Tree {
	private Node root;

	public void insert(int value) {
		Node node = new Node(value);
		if (this.root == null) {
			this.root = node;
			return;
		}
		Node current = root;
		percorre(current, node);

	}
	
	public void showPrefix(){
		StringBuilder sb = new StringBuilder();
		makeString(sb, root);
	}

	private void makeString(StringBuilder sb, Node current) {
		if (current.left != null)
			makeString(sb, current.left);
		else
		if (current.right != null)
			makeString(sb, current.right);
		else{
			
		}
		
	}

	public void percorre(Node current, Node node) {
		if (current.value > node.value) {
			if (current.left != null)
				percorre(current.left, node);
			else
				current.left = node;
		} else {
			if (current.right != null)
				percorre(current.right, node);
			else
				current.right = node;
		}
	}

	public class Node {
		private Node left, right;
		private int value;
		
		public Node(int value) {
			this.value = value;
		}
	}
}
