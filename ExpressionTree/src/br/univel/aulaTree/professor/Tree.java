package br.univel.aulaTree.professor;

import java.lang.reflect.Field;
import java.math.BigInteger;

public class Tree {
	private Node root;
	private Tree left;
	private Tree right;

	public class Node {
		private Object value;

		public Node(Object value) {
			this.setValue(value);
		}

		private void setValue(Object value) {
			this.value = value;
		}

		public Object getValue() {
			return value;
		}

	}

	public void insertNode(Object value) {
		this.insert(new Node(value));
	}

	private BigInteger getObjectKey(Object value) {
		for (int i = 0; i < value.getClass().getDeclaredFields().length; i++) {
			Field field = value.getClass().getDeclaredFields()[i];
			field.setAccessible(true);
			if (field.isAnnotationPresent(Key.class)) {
				System.out.println("sdf");
				try {
					return (BigInteger) field.get(value);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private void insert(Node node) {
		if (this.root == null) {
			this.root = node;
		} else {
			System.out.println(getObjectKey(node.getValue()));
			System.out.println(getObjectKey(node.getValue()).toString()+"Helloooooo");
			if (getObjectKey(node.getValue()).compareTo(getObjectKey(this.root.getValue())) < 0) {
				if (this.left == null)
					this.left = new Tree();
				this.left.insert(node);
			} else if (getObjectKey(node.getValue()).compareTo(
					getObjectKey(node.getValue())) > 0) {
				if (this.right == null)
					this.right = new Tree();
				this.right.insert(node);
			}
		}
	}

	public void showPreOrder() {
		if (this.root == null) {
			throw new RuntimeException("Deu pau");
		}
		System.out.println(getObjectKey(root.getValue()));
		if (this.left != null) {
			this.left.showPreOrder();
		}
		if (this.right != null) {
			this.right.showPreOrder();
		}
	}
}
