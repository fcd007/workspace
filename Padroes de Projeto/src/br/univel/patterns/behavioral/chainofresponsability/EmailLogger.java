package br.univel.patterns.behavioral.chainofresponsability;

class EmailLogger extends Logger {

	public EmailLogger(int mask) {
		this.mask = mask;
	}

	protected void writeMessage(String msg) {
		System.out.println("Enviando email: " + msg);
	}
}