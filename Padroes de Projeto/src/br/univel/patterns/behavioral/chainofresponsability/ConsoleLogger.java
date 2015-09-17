package br.univel.patterns.behavioral.chainofresponsability;

class ConsoleLogger extends Logger {

	public ConsoleLogger(int mask) {
		this.mask = mask;
	}

	protected void writeMessage(String msg) {
		System.out.println("Console.out: " + msg);
	}
}