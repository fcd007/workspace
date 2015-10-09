package br.univel.expression_tree;


public class Stack{
	class Node{
		private Node next;
		private char value;
		Node(char value){
			this.value = value;
		}
		
	}
	private Node top;
	public void push(char value){
		Node n = new Node(value);
		if (top == null) {
			top = n;
		}else{
			n.next=top;
			top=n;
		}
		
	}
	
	public void showAll(){
		Node current = top;
		while (current != null){
			System.out.println(current.value+"\n");
			current = current.next;
		}
	}
	
	public void pop(){
		top = top.next;
	}
	
	public char getTop(){
		if (isNull()) {
			return ' ';
		} else {
			return top.value;
		}
	}
	
	public boolean isNull(){
		if (top == null) {
			return true;
		}else
			return false;
	}
	
	public int length(){
		Node current = top;
		int result = 0;
		while (current != null) {
			result++;
			current = current.next;
		}
		return result;
	}
	


}
