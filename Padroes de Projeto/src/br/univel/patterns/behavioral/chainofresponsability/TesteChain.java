package br.univel.patterns.behavioral.chainofresponsability;

public class TesteChain {
	public static void main(String[] args) {

		Logger logger = new ConsoleLogger(Logger.DEBUG);

		Logger logger1 = logger.setNext(new EmailLogger(Logger.INFO));

		logger1.setNext(new ErrorLogger(Logger.ERRO));

		logger.message("Executando busca.", Logger.DEBUG);

		logger.message("Relatório gerado com sucesso.", Logger.INFO);

		logger.message("Erro no processo.", Logger.ERRO);
	}
}