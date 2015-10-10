package br.univel.expression_tree;

import java.text.ParseException;

import br.univel.expression_tree.ASTNode.ASTNodeType;

public class Parser {

	char[] chars;
	int index;
	Token currentToken;

	public Parser() throws ParserException {
		this.index = 0;
	}
	
	public ASTNode parse(String expression) throws ParserException{
		this.chars = expression.toCharArray();
		getNextToken();
		return makeExpression();
	}

	private ASTNode makeExpression() throws ParserException {
		ASTNode termNode = term();
		ASTNode expressionNode = expression();

		return createNode(ASTNodeType.OPERATORPLUS, termNode, expressionNode);
	}

	private ASTNode createNode(ASTNodeType type, ASTNode left, ASTNode right) {
		ASTNode node = new ASTNode();
		node.setType(type);
		node.setLeft(left);
		node.setRight(right);
		return node;
	}

	private ASTNode expression() throws ParserException {
		ASTNode termNode;
		ASTNode expressionNode;

		switch (currentToken.getType()) {
		case PLUS:
			getNextToken();
			termNode = term();
			expressionNode = expression();
			return createNode(ASTNodeType.OPERATORPLUS, expressionNode, termNode);
		case MINUS:
			getNextToken();
			termNode = term();
			expressionNode = expression();
			return createNode(ASTNodeType.OPERATORMINUS, expressionNode, termNode);
		}
		return createNodeNumber(0);
	}

	private ASTNode createNodeNumber(double value) {
		ASTNode node=new ASTNode();
		node.setType(ASTNodeType.NUMBERVALUE);
		node.setValue(value);
		return node;
	}

	private ASTNode term() throws ParserException {
		ASTNode factorNode;
		ASTNode term1Node;

		factorNode = factor();
		term1Node = term1();

		return createNode(ASTNodeType.OPERATORMUL, factorNode, term1Node);

	}

	private ASTNode term1() throws ParserException {
		ASTNode factorNode;
		ASTNode term1Node;

		switch (currentToken.getType()) {
		case MUL:
			getNextToken();
			factorNode = factor();
			term1Node = term1();
			return createNode(ASTNodeType.OPERATORMUL, term1Node, factorNode);
		case DIV:
			getNextToken();
			factorNode = factor();
			term1Node = term1();
			return createNode(ASTNodeType.OPERATORDIV, term1Node, factorNode);

		}
		return createNodeNumber(1);

	}

	private ASTNode factor() throws ParserException {
		ASTNode node;
		switch (currentToken.getType()) {
		case OPENPARENTHESIS:
			getNextToken();
			node=makeExpression();
			match(')');
			return node;
		case MINUS:
			getNextToken();
			node=factor();
			return createUnaryNode(node);
		case NUMBER:
			double value = currentToken.getValue();
			getNextToken();
			return createNodeNumber(value);
		default:
			String error = "Unexpected Token " + chars[index] + " at position " + index;
			throw new ParserException(error);
		}

	}

	private ASTNode createUnaryNode(ASTNode left) {
		ASTNode node=new ASTNode();
		node.setType(ASTNodeType.UNARYMINUS);
		node.setLeft(left);
		node.setRight(null);
		return node;
	}

	private void match(char c) throws ParserException {
		if (chars[index - 1] == c)
			getNextToken();
		else {
			String error = "Unexpected Token " + chars[index] + " at position " + index;
			throw new ParserException(error);
		}
	}

	private void skipWhiteSpaces() {
		while (index < chars.length && chars[index] == Character.SPACE_SEPARATOR) {
			index++;
		}
	}

	private void getNextToken() throws ParserException {
		skipWhiteSpaces();

		currentToken = new Token(0, '0');

		if (index >= chars.length) {
			currentToken.setType(TokenType.ENDOFTEXT);
			return;
		}

		if (Character.isDigit(chars[index])) {
			currentToken.setType(TokenType.NUMBER);
			currentToken.setValue(getNumber(chars[index]));
			return;
		}
		// Ainda nao e utilizado
		if (Character.isAlphabetic(chars[index])) {
			currentToken.setType(TokenType.VAR);
			currentToken.setSymbol(chars[index]);
			return;
		}

		currentToken.setType(TokenType.ERROR);

		switch (chars[index]) {
		case '+':
			currentToken.setType(TokenType.PLUS);
			break;

		case '-':
			currentToken.setType(TokenType.MINUS);
			break;

		case '*':
			currentToken.setType(TokenType.MUL);
			break;

		case '/':
			currentToken.setType(TokenType.DIV);
			break;

		case '(':
			currentToken.setType(TokenType.OPENPARENTHESIS);
			break;

		case ')':
			currentToken.setType(TokenType.CLOSEDPARENTHESIS);
			break;
		}

		if (currentToken.getType() != TokenType.ERROR) {
			currentToken.setSymbol(chars[index++]);
		} else {
			String error = "Unexpected Token " + chars[index] + " at position " + index;
			throw new ParserException(error);
		}

	}

	private double getNumber(char c) {
		skipWhiteSpaces();
		int index = this.index;

		while (this.index < chars.length && Character.isDigit(chars[this.index])) {
			this.index++;
		}

		if (index - this.index == 0) {
			throw new RuntimeException();
		}

		return makeNumber(index);
	}

	private double makeNumber(int index) {
		int size = this.index - index;
		StringBuilder sb = new StringBuilder();
		for (int i = index; i < this.index; i++) {
			sb.append(chars[i]);
		}
		return Double.parseDouble(sb.toString().trim());
	}
}
