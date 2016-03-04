package br.univel.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServicoRMI extends Remote {

	public static final String NOME = "SERVICO_RMI";
	
	public double somar(double a, double b);
	public double subtrair(double a, double b);
	public double multiplicar(double a, double b);
	public double dividir(double a, double b);
        
	
}
