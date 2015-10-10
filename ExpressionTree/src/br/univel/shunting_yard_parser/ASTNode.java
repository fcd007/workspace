package br.univel.shunting_yard_parser;

public class ASTNode {
	 private final char value;
	    private final ASTNode leftASTNode;
	    private final ASTNode rightASTNode;

	    /***
	     * Constructs a new AST node. There's no explicit specialization for leaf
	     * nodes. Leaves are denoted by nodes where both the left and right node
	     * is null.
	     *
	     * @param value The value held by the node.
	     * @param leftASTNode The left node, or <code>null</code> if there isn't one.
	     * @param rightASTNode The right node, or <code>null</code> if there isn't one.
	     */
	    public ASTNode(char value, ASTNode leftASTNode, ASTNode rightASTNode) {
	        this.value = value;
	        this.leftASTNode = leftASTNode;
	        this.rightASTNode = rightASTNode;
	    }

	    /***
	     *
	     * @return The value held by the node.
	     */
	    public char getValue() {
	        return value;
	    }

	    /***
	     *
	     * @return The left node, or <code>null</code> if there isn't one.
	     */
	    public ASTNode getLeftASTNode() {
	        return leftASTNode;
	    }

	    /***
	     *
	     * @return The right node, or <code>null</code> if there isn't one.
	     */
	    public ASTNode getRightASTNode() {
	        return rightASTNode;
	    }
}
