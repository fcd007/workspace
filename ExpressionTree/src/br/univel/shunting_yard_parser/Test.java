package br.univel.shunting_yard_parser;

import br.univel.expression_tree.ASTNode;
import br.univel.expression_tree.Evaluator;
import br.univel.expression_tree.EvaluatorException;
import br.univel.expression_tree.Parser;
import br.univel.expression_tree.ParserException;

public class Test {
	public static void main(String[] args) throws ParserException, EvaluatorException {
		Parser p = new Parser();
		ASTNode ast = p.parse("1+2*3");
		
		double val = new Evaluator().evaluate(ast);
		System.out.println(val);
	}
}
