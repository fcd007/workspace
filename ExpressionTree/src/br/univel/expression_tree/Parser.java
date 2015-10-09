package br.univel.expression_tree;

import java.text.ParseException;

public class Parser {
	
	char[] chars;
	int index;
	Token currentToken;
	
	public Parser(String expression) throws ParserException {
		this.chars=expression.toCharArray();
		this.index=0;
		getNextToken();
		makeExpression();
	}
	
	public void makeExpression() throws ParserException{
		term();
		expression();
	}
	
	private void expression() throws ParserException {
		if(currentToken.getType() == TokenType.Plus || currentToken.getType() == TokenType.Minus){
			getNextToken();
			term();
			expression();
		}
	}

	private void term() throws ParserException {
		factor();
		term1();
		
	}

	private void term1() throws ParserException {
		if(currentToken.getType() == TokenType.Mul || currentToken.getType() == TokenType.Div){
			getNextToken();
			factor();
			term1();
		}
		
	}

	private void factor() throws ParserException {
		switch (currentToken.getType()) {
		case OpenParenthesis:
			getNextToken();
			makeExpression();
			match(')');
			break;
		case Minus:
			getNextToken();
			factor();
			break;
		case Number:
			getNextToken();
			break;
		default:
			String error = "Unexpected Token "+chars[index]+" at position "+index;
			throw new ParserException(error);
		}
		
	}

	private void match(char c) throws ParserException {
		if(chars[index-1]==c)
			getNextToken();
		else{
			String error = "Unexpected Token "+chars[index]+" at position "+index;
		throw new ParserException(error);
		}
	}

	private void skipWhiteSpaces(){
		while (index < chars.length && chars[index] == Character.SPACE_SEPARATOR){
			index++;
		}
	}
	
	private void getNextToken() throws ParserException{
		skipWhiteSpaces();
		
		currentToken=new Token(0, '0');
		
		if(index >= chars.length){
			currentToken.setType(TokenType.EndOfText);
			return;
		}
		
		if(Character.isDigit(chars[index])){
			currentToken.setType(TokenType.Number);
			currentToken.setValue(getNumber(chars[index]));
			return;
		}
		
		if(Character.isAlphabetic(chars[index])){
			currentToken.setType(TokenType.Var);
			currentToken.setSymbol(chars[index]);
			return;
		}
		
		currentToken.setType(TokenType.Error);
		
		switch (chars[index]) {
		case '+':
			currentToken.setType(TokenType.Plus);
			break;
			
		case '-':
			currentToken.setType(TokenType.Minus);
			break;
			
		case '*':
			currentToken.setType(TokenType.Mul);
			break;
			
		case '/':
			currentToken.setType(TokenType.Div);
			break;
			
		case '(':
			currentToken.setType(TokenType.OpenParenthesis);
			break;
			
		case ')':
			currentToken.setType(TokenType.ClosedParenthesis);
			break;
		

		default:
			break;
		}
		
		if (currentToken.getType() != TokenType.Error) {
			currentToken.setSymbol(chars[index++]);
		}else{
			String error = "Unexpected Token "+chars[index]+" at position "+index;
			throw new ParserException(error);
		}
		
	}

	private double getNumber(char c) {
		skipWhiteSpaces();
		int index = this.index;
		
		while(this.index < chars.length && Character.isDigit(chars[this.index])){
			this.index++;
		}
		
		if(index - this.index == 0){
			throw new RuntimeException();
		}
		
		return makeNumber(index);
	}

	private double makeNumber(int index) {
		int size = this.index-index;
		StringBuilder sb = new StringBuilder();
		for(int i=index;i<this.index;i++){
			sb.append(chars[i]);
		}
		return Double.parseDouble(sb.toString().trim());
	}
}
