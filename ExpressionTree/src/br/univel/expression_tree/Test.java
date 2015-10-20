package br.univel.expression_tree;

public class Test {
	public static void main(String[] args) throws ParserException {
		ExpressionTree tree = new ExpressionTree();
		Parser parser = new Parser();
		ASTNode node = parser.parse("(1+2+3)*4*(5*6)");
		System.out.println(node);
	}
}
