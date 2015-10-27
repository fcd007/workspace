/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univel.trabalho.Classes.DAO;

import java.util.Set;
import br.univel.trabalho.Classes.Banco;
import br.univel.trabalho.Classes.Genero;

/**
 *
 * @author Cettrans
 */
public class DAOGenero {

	public static void setGenero(String nome) {
		Genero g = new Genero();
		g.setNome(nome);
		Banco.getHash("Genero").put(g.getKey(), g);
		Banco.saveBanco();
	}

	public static void updateGenero(String nome, Genero g) {
		g.setNome(nome);
		Banco.getHash("Genero").remove(g.getKey());
		Banco.getHash("Genero").put(g.getKey(), g);
		Banco.saveBanco();
	}

	public static Genero getGenero(int i) {
		Set s = Banco.getHash("Genero").keySet();
		Object o[] = s.toArray();
		Genero g = (Genero) Banco.getHash("Genero").get(o[i]);
		return g;
	}

	public static void deleteGenero(Genero g) {
		Banco.getHash("Genero").remove(g.getKey());
		Banco.saveBanco();
	}
}
