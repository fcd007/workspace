/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel.trabalho.Classes.DAO;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import br.univel.trabalho.Classes.Banco;
import br.univel.trabalho.Classes.Relatorio;

/**
 *
 * @author USER
 */
public class DAORelatorio {
	public static long getRelatorioMensal() {
		return 0;
	}

	public static double getRelatorioSemanal(LinkedList<Relatorio> aux) {
		LinkedList<Relatorio> aux2 = new LinkedList();
		aux.clear();
		double total = 0;
		Banco.LerRelatorio(aux2);
		GregorianCalendar g = new GregorianCalendar();
		Date d = new Date();
		g.setTime(d);
		for (Relatorio aux1 : aux2) {
			long data = g.getTimeInMillis()
					- aux1.getEmprestimo().getTimeInMillis();
			if (data <= 604800000) {
				aux.add(aux1);
				total += aux1.getValor();
			}
		}
		return total;
	}

	public static void GetRelatorioPerdidos(LinkedList aux) {
		LinkedList<Relatorio> aux2 = new LinkedList();
		aux.clear();
		Banco.LerRelatorio(aux2);
		for (Relatorio aux1 : aux2) {
			if (aux1.getSituacao().equals("Perdido")) {
				aux.add(aux1);
			}
		}
	}
}
