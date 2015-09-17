package br.univel.patterns.behavioral.interpreter;

import java.util.Stack;

public class TestePilha {

	public static void main(String[] args) {
		
		Stack<Integer> pilha = new Stack<Integer>();
		
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		
		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
		
	}
	
}
