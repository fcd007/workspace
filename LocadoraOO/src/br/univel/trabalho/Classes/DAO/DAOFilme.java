/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univel.trabalho.Classes.DAO;

import java.util.Set;
import br.univel.trabalho.Classes.Banco;
import br.univel.trabalho.Classes.Filme;
import br.univel.trabalho.Classes.Genero;

/**
 *
 * @author Cettrans
 */
public class DAOFilme {
	public static void setFilme(String titulo, String censura,
			boolean lancamento, Genero genero, int dlancamento, int qtd) {
		Filme f = new Filme();
		f.setTitulo(titulo);
		f.setCensura(censura);
		f.setLancamento(lancamento);
		f.setGenero(genero);
		f.setDatalancamento(dlancamento);
		f.setQtd(qtd);
		f.setQtdDisponivel(qtd);
		Banco.getHash("Filme").put(f.getKey(), f);
		Banco.saveBanco();
	}

	public static Filme getFilme(int i) {
		Set s = Banco.getHash("Filme").keySet();
		Object o[] = s.toArray();
		Filme f = (Filme) Banco.getHash("Filme").get(o[i]);
		return f;
	}

	public static void updateFilme(String titulo, String censura,
			boolean lancamento, Genero genero, int dlancamento, int qtd, Filme f) {

		f.setTitulo(titulo);
		f.setCensura(censura);
		f.setLancamento(lancamento);
		f.setGenero(genero);
		f.setDatalancamento(dlancamento);
		int aux = f.getQtd();
		f.setQtd(qtd);
		f.setQtdDisponivel(qtd - aux + f.getQtdDisponivel());
		Banco.getHash("Filme").remove(f.getKey());
		Banco.getHash("Filme").put(f.getKey(), f);
		Banco.saveBanco();
	}

	public static void deleteFilme(Filme f) {
		Banco.getHash("Filme").remove(f.getKey());
		Banco.saveBanco();
	}
}
