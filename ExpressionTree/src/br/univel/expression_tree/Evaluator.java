package br.univel.expression_tree;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import br.univel.expression_tree.ASTNode.ASTNodeType;

public class Evaluator {

	public double evaluate(ASTNode ast) throws EvaluatorException {
		if (ast == null) {
			throw new EvaluatorException("Invalid Abstract Syntax Tree");
		}
		return evaluateSubTree(ast);
	}

	private double evaluateSubTree(ASTNode ast) throws EvaluatorException {
		if (ast == null) {
			throw new EvaluatorException("Invalida Abstract Syntax Tree");
		}

		if (ast.getType() == ASTNodeType.NUMBERVALUE) {
			return ast.getValue();
		} else if (ast.getType() == ASTNodeType.UNARYMINUS) {
			return evaluateSubTree(ast.getLeft());
		} else {
			double v1 = evaluateSubTree(ast.getLeft());
			double v2 = evaluateSubTree(ast.getRight());
			switch (ast.getType()) {
			case OPERATORPLUS:
				return v1 + v2;
			case OPERATORMINUS:
				return v1 - v2;
			case OPERATORDIV:
				return v1 / v2;
			case OPERATORMUL:
				return v1 * v2;
			default: {
				throw new EvaluatorException("Invalid Abstract Syntax Tree");
			}
			}
		}
	}

}
