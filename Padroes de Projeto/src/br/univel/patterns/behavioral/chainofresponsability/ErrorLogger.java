package br.univel.patterns.behavioral.chainofresponsability;

class ErrorLogger extends Logger {

	public ErrorLogger(int mask) {
		this.mask = mask;
	}

	protected void writeMessage(String msg) {
		System.err.println("ERRO: " + msg);
	}
}