/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univel.trabalho.Classes.DAO;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import br.univel.trabalho.Classes.Banco;
import br.univel.trabalho.Classes.Cliente;
import br.univel.trabalho.Classes.Endereco;

/**
 *
 * @author Cettrans
 */
public class DAOCliente {

	public static void setCliente(String nome, String rua, String bairro,
			String cidade, String estado, String cep, int numero, String nasc) {
		Cliente c = new Cliente();
		Endereco e = new Endereco();
		c.setNome(nome);
		e.setRua(rua);
		e.setBairro(bairro);
		e.setCep(cep);
		e.setCidade(cidade);
		e.setEstado(estado);
		e.setNumero(numero);
		c.setEndereco(e);
		String aux[] = nasc.split("/");
		GregorianCalendar n = new GregorianCalendar();
		n.set(Integer.parseInt(aux[2]), Integer.parseInt(aux[1]) - 1,
				Integer.parseInt(aux[0]));
		c.setNasc(n);
		Banco.getHash("Cliente").put(c.getId(), c);
		Banco.saveBanco();
	}

	public static Cliente getCliente(int i) {
		Set s = Banco.getHash("Cliente").keySet();
		Object o[] = s.toArray();
		Cliente c = (Cliente) Banco.getHash("Cliente").get(o[i]);
		return c;
	}

	public static void updateCliente(String nome, String rua, String bairro,
			String cidade, String estado, String cep, int numero, String nasc,
			Cliente c) {
		Endereco e = new Endereco();
		c.setNome(nome);
		e.setRua(rua);
		e.setBairro(bairro);
		e.setCep(cep);
		e.setNumero(numero);
		e.setCidade(cidade);
		e.setEstado(estado);
		c.setEndereco(e);
		String aux[] = nasc.split("/");
		GregorianCalendar n = new GregorianCalendar(Integer.parseInt(aux[2]),
				Integer.parseInt(aux[1]) - 1, Integer.parseInt(aux[0]));
		c.setNasc(n);
		Banco.getHash("Cliente").remove(c.getId());
		Banco.getHash("Cliente").put(c.getId(), c);
		Banco.saveBanco();
	}

	public static void deleteCliente(Cliente c) {
		Banco.getHash("Cliente").remove(c.getId());
		Banco.saveBanco();
	}

	public static boolean verificaData(String data) {
		GregorianCalendar g = new GregorianCalendar(1500, 1, 1);
		Date d = new Date();
		GregorianCalendar g3 = new GregorianCalendar();
		// g3.setTime(d);

		GregorianCalendar g2 = Banco.getData(data);
		if (g2.getTimeInMillis() < g.getTimeInMillis()
				|| g2.getTimeInMillis() > g3.getTimeInMillis())
			return false;
		else
			return true;
	}
}
