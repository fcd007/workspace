package br.univel.patterns.behavioral.chainofresponsability;

abstract class Logger {

	public static int ERRO = 3;
	public static int INFO = 5;
	public static int DEBUG = 7;
	
	protected int mask;

	protected Logger next;

	public Logger setNext(Logger log) {
		next = log;
		return log;
	}

	public void message(String msg, int priority) {
		
		if (priority == mask) {
			writeMessage(msg);
			return;
		}
		
		if (next != null) {
			next.message(msg, priority);
		}
	}

	abstract protected void writeMessage(String msg);
}