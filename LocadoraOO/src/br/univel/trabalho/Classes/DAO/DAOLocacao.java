/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univel.trabalho.Classes.DAO;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Set;
import br.univel.trabalho.Classes.Banco;
import br.univel.trabalho.Classes.Cliente;
import br.univel.trabalho.Classes.Filme;
import br.univel.trabalho.Classes.Locacao;

/**
 *
 * @author USER
 */
public class DAOLocacao {
	/*
	 * Método para Inserir uma locação no HashMap locacoes
	 */
	public static void setLocacao(Cliente cliente, LinkedList<Filme> filmes,
			String dtaDevolucao, int Situacao, double vTotal, double vPago) {
		Locacao l = new Locacao();
		LinkedList<Filme> aux3 = new LinkedList<>();
		/*
		 * Adicione os filmes 1 a 1 na lista aux3, para que ele não envie a
		 * referência da lista para o objeto locação
		 */
		for (Filme filme : filmes) {
			aux3.add(filme);
			filme.setQtdDisponivel(filme.getQtdDisponivel() - 1);
		}

		l.setC(cliente);
		l.setSituacao(Situacao);
		/*
		 * Converte a String obtida no formulário e converte para
		 * GregorianCalendar
		 */
		String aux[] = dtaDevolucao.split("/");
		GregorianCalendar n = new GregorianCalendar();
		n.set(Integer.parseInt(aux[2]), Integer.parseInt(aux[1]) - 1,
				Integer.parseInt(aux[0]));
		l.setDevolucao(n);
		/*
		 * Instanciamos um date novo, para que ele pegue a data do SO
		 */
		Date d = new Date();
		GregorianCalendar aux2 = new GregorianCalendar();
		/*
		 * Define ao GregorianCalendar a data contida no d(Date)
		 */
		aux2.setTime(d);
		l.setEmprestimo(aux2);
		l.setVlrtotal(vTotal);
		l.setVlrfinal(vPago);
		l.setFilmes(aux3);
		Banco.getHash("Locacao").put(l.getKey(), l);
		Banco.saveBanco();
	}

	public static double calculaFilmes(LinkedList<Filme> l,
			GregorianCalendar devolucao, GregorianCalendar emprestimo) {
		double total = 0;
		Date d = new Date();
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(d);
		/*
		 * Verifica se existe alguma configuração pré-cadastrada, e caso não
		 * haja, não executa o código abaixo.
		 */
		if (!Banco.verificaConfig()) {
			for (Filme l1 : l) {
				long aux;
				if (l1.isLancamento()) {
					aux = (devolucao.getTimeInMillis() - emprestimo
							.getTimeInMillis()) / 86400000;
					if (aux < 1)
						total += Banco.getConfiguracao().getVlrL();
					else
						total += Banco.getConfiguracao().getVlrL() * aux;
				} else {
					aux = (devolucao.getTimeInMillis() - emprestimo
							.getTimeInMillis()) / 86400000;
					if (aux < 1)
						total += Banco.getConfiguracao().getVlrD();
					else
						total += Banco.getConfiguracao().getVlrD() * aux;
				}
			}
			/*
			 * Verifica se a data de Devolução contém atrasor, e caso tenha,
			 * adiciona o valor da multa ao valor final da locação. 86400000
			 * é o tempo em milissegundos de 1 dia. A conta
			 * "g.getTimeInMillis() - (d.getTime() + 86400000" Diminui o tempo
			 * da Devolução pelo tempo atual, retirado do Sistema Operacional,
			 * e adiciona o valor de 1 dia, para que não haja multa caso o
			 * cliente devolva no mesmo dia da Devolução.
			 */
			if (devolucao != null
					&& (devolucao.getTimeInMillis() - (g.getTimeInMillis() + 86400000)) < 0) {
				long x = (g.getTimeInMillis() - devolucao.getTimeInMillis()) / 86400000;
				total += Banco.getConfiguracao().getMulta() * x;
			}
		}
		return total;
	}

	public static void deleteLocacao(Locacao l) {
		Banco.getHash("Locacao").remove(l.getKey());
		Banco.saveBanco();
	}

	/*
	 * O Set se usa para criar uma "lista" de chaves de um HashMap. Então
	 * convertemos isso para um array, para termos uma ordem de chaves, e assim
	 * ter o controle da posição de um objeto no HashMap
	 */
	public static Locacao getLocacao(int i) {
		try {
			Set s = Banco.getHash("Locacao").keySet();
			Object o[] = s.toArray();
			Locacao l = (Locacao) Banco.getHash("Locacao").get(o[i]);
			l.setVlrtotal(calculaFilmes(l.getFilmes(), l.getDevolucao(),
					l.getEmprestimo()));
			return l;
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	public static Locacao getLocacaoAtivo(int i) {
		try {
			Set s = Banco.getHashAtivo().keySet();
			Object o[] = s.toArray();
			Locacao l = (Locacao) Banco.getHashAtivo().get(o[i]);
			l.setVlrtotal(calculaFilmes(l.getFilmes(), l.getDevolucao(),
					l.getEmprestimo()));
			return l;
		} catch (ArrayIndexOutOfBoundsException e) {

			return null;
		}
	}

	/*
	 * Converte a String obtida no formulário e converte para GregorianCalendar
	 */
	public static GregorianCalendar getData(String data) {
		String aux[] = data.split("/");
		GregorianCalendar n = new GregorianCalendar();
		n.set(Integer.parseInt(aux[2]), Integer.parseInt(aux[1]) - 1,
				Integer.parseInt(aux[0]));
		return n;
	}

	public static void updateLocacao(Cliente cliente, LinkedList<Filme> filmes,
			String dtaDevolucao, String dtaEmprestimo, int Situacao,
			double vTotal, double vPago, Locacao loc) {
		Locacao l = loc;
		LinkedList<Filme> aux3 = new LinkedList<>();
		/*
		 * Adicione os filmes 1 a 1 na lista aux3, para que ele não envie a
		 * referência da lista para o objeto locação
		 */
		for (Filme filme : filmes)
			aux3.add(filme);

		l.setC(cliente);
		l.setSituacao(Situacao);

		l.setDevolucao(getData(dtaDevolucao));
		/*
		 * Instanciamos um date novo, para que ele pegue a data do SO
		 */
		Date d = new Date();
		GregorianCalendar aux2 = new GregorianCalendar();
		/*
		 * Define ao GregorianCalendar a data contida no d(Date)
		 */
		aux2.setTime(d);
		l.setEmprestimo(getData(dtaEmprestimo));
		l.setVlrtotal(vTotal);
		l.setVlrfinal(vPago);
		l.setFilmes(aux3);
		Banco.getHash("Locacao").remove(l.getKey());
		Banco.getHash("Locacao").put(l.getKey(), l);
		Banco.saveBanco();
	}
}
