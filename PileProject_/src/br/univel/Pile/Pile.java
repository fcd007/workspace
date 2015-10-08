package br.univel.Pile;

public class Pile{
	class Node{
		private Node next;
		private char value;
		Node(char value){
			this.value = value;
		}
		
	}
	private Node top;
	public void addItem(char value){
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
		return top.value;
	}
	
	public boolean isNull(){
		if (top == null) {
			return true;
		}else
			return false;
	}
	


}
