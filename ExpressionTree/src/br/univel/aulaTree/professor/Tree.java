package br.univel.aulaTree.professor;

public class Tree {
	private Node root;
	private Tree left;
	private Tree right;

	public class Node {
		private int value;

		public Node(int value) {
			this.setValue(value);
		}

		private void setValue(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

	}

	public void insertNode(int value) {
		this.insert(new Node(value));
	}

	private void insert(Node node) {
		if (this.root == null) {
			this.root = node;
		} else {
			if (node.getValue() < this.root.getValue()) {
				if (this.left == null)
					this.left = new Tree();
				this.left.insert(node);
			} else if (node.getValue() > this.root.getValue()) {
				if (this.right == null)
					this.right = new Tree();
				this.right.insert(node);
			}
		}
	}
	
	public void showPreOrder(){
		if(this.root==null){
			throw new RuntimeException("Deu pau");
		}
		System.out.println(this.root.getValue());
		if(this.left != null){
			this.left.showPreOrder();
		}
		if(this.right != null){
			this.right.showPreOrder();
		}
	}
}
