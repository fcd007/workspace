package br.univel.expression_tree;

public class Test {
	public static void main(String[] args) throws ParserException, EvaluatorException {
		Parser p = new Parser();
		ASTNode ast = p.parse("1+2");
		
		double val = new Evaluator().evaluate(ast);
		System.out.println(val);
	}
}
