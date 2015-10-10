package br.univel.expression_tree;

public class ASTNode {
	enum ASTNodeType{
		UNDEFINED,
		OPERATORPLUS,
		OPERATORMINUS,
		OPERATORMUL,
		OPERATORDIV,
		UNARYMINUS,
		NUMBERVALUE,
		SIMBOL
	}
	
	ASTNodeType type;
	double value;
	ASTNode left;
	ASTNode right;
	
	public ASTNode() {
		this.type = ASTNodeType.UNDEFINED;
		this.value=0;
		this.left=null;
		this.right=null;
	}

	public ASTNodeType getType() {
		return type;
	}

	public void setType(ASTNodeType type) {
		this.type = type;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public ASTNode getLeft() {
		return left;
	}

	public void setLeft(ASTNode left) {
		this.left = left;
	}

	public ASTNode getRight() {
		return right;
	}

	public void setRight(ASTNode rigth) {
		this.right = rigth;
	}
}
