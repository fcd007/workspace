package br.univel.expression_tree;

public class Token {
	TokenType type = TokenType.ERROR;
	private double value=0;
	private char symbol=0;
	
	public TokenType getType() {
		return type;
	}

	public void setType(TokenType type) {
		this.type = type;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public Token(double value, char symbol) {
		this.value = value;
		this.symbol=symbol;
	}
}
