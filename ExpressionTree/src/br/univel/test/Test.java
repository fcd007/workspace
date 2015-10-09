package br.univel.test;

import br.univel.expression_tree.Parser;
import br.univel.expression_tree.ParserException;

public class Test {
	public static void main(String[] args) throws ParserException {
		Parser p = new Parser("1+(2*3)/4+5");
		System.out.println("OK");
	}
}
