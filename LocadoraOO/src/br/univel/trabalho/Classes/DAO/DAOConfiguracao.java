/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univel.trabalho.Classes.DAO;

import br.univel.trabalho.Classes.Banco;
import br.univel.trabalho.Classes.Configuracao;

/**
 *
 * @author Cettrans
 */
public class DAOConfiguracao {
	public static String getNome() {
		if (Banco.verificaConfig())
			return "Sem Nome";
		else
			return Banco.getConfiguracao().getNome();
	}

	public static String getFone() {
		if (Banco.verificaConfig())
			return "Sem Telefone";
		else
			return Banco.getConfiguracao().getTelefone();
	}

	public static void setConfig(String nome, String fone, double vlrDiaria,
			double multa, double vlrLancamento) {
		Configuracao c = new Configuracao();
		c.setNome(nome);
		c.setTelefone(fone);
		c.setVlrD(vlrDiaria);
		c.setMulta(multa);
		c.setVlrL(vlrLancamento);
		Banco.setConfiguracao(c);
		Banco.saveBanco();
	}

}
