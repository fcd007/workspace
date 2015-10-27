/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univel.trabalho.Classes;

import java.io.*;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import javax.swing.JOptionPane;
import br.univel.trabalho.Classes.DAO.DAOCliente;
import br.univel.trabalho.Classes.DAO.DAOFilme;
import br.univel.trabalho.Classes.DAO.DAOGenero;
import br.univel.trabalho.Classes.DAO.DAOLocacao;
import br.univel.trabalho.Principal;

/**
 *
 * @author Cettrans
 */
public class Banco implements Serializable {

	private HashMap<Integer, Cliente> clientes = new HashMap<>();
	private HashMap<Integer, Filme> filmes = new HashMap<>();
	private HashMap<Integer, Genero> generos = new HashMap<>();
	private HashMap<Integer, Locacao> locacoes = new HashMap<>();
	private Configuracao config;

	private static Banco b;

	private Banco() {
	}

	public static Banco getBanco() {
		if (b == null) {
			b = new Banco();
		}
		return b;

	}

	/*
	 * public void setHash(Object x){ if(x instanceof Cliente){ Cliente c =
	 * (Cliente)x; b.clientes.put(c.getId(), c); try{ FileOutputStream fos = new
	 * FileOutputStream("Clientes.dat"); ObjectOutputStream oos = new
	 * ObjectOutputStream(fos); oos.writeObject(b.clientes); oos.close();
	 * fos.close(); }catch(IOException e){ System.out.println("erro"+e); } }
	 * if(x instanceof Genero){ Genero g = (Genero)x; b.generos.put(g.getKey(),
	 * g); try{ FileOutputStream fos = new FileOutputStream("Generos.dat");
	 * ObjectOutputStream oos = new ObjectOutputStream(fos);
	 * oos.writeObject(b.generos); oos.close(); fos.close(); }catch(IOException
	 * e){ }
	 * 
	 * } }
	 */

	public static HashMap getHash(String x) {
		switch (x) {
		case "Cliente":
			return getBanco().clientes;
		case "Genero":
			return getBanco().generos;
		case "Filme":
			return getBanco().filmes;
		case "Locacao":
			return getBanco().locacoes;
		default:
			return null;
		}

	}

	/*
	 * public static void delHash(int i, String nome){
	 * if(nome.equals("Cliente")){ b.clientes.remove(i); } }
	 */

	/*
	 * public void carregaHash(Object o){ if(o instanceof ClienteGUI ){ try{
	 * FileInputStream fis = new FileInputStream("Clientes.dat");
	 * ObjectInputStream ois = new ObjectInputStream(fis); b.clientes =
	 * (HashMap<Integer, Cliente>)ois.readObject(); }catch(IOException e){
	 * b.setHash(o);
	 * 
	 * }catch(ClassNotFoundException e){ JOptionPane.showMessageDialog(null, e);
	 * } } if(o instanceof GeneroGUI){ try{ FileInputStream fis = new
	 * FileInputStream("Generos.dat"); ObjectInputStream ois = new
	 * ObjectInputStream(fis); b.generos = (HashMap<Integer,
	 * Genero>)ois.readObject(); }catch(IOException e){ b.setHash(o);
	 * }catch(ClassNotFoundException e){ JOptionPane.showMessageDialog(null, e);
	 * } }
	 * 
	 * }
	 */

	public static int getChave(String x) {
		switch (x) {
		case "Cliente": {
			for (int i = 0; i < getBanco().clientes.size(); i++)
				if (getBanco().clientes.get(i) == null)
					return i;
			return getBanco().clientes.size();
		}

		case "Genero": {
			for (int i = 0; i < getBanco().generos.size(); i++)
				if (getBanco().generos.get(i) == null)
					return i;
			return getBanco().generos.size();
		}

		case "Filme": {
			for (int i = 0; i < getBanco().filmes.size(); i++)
				if (getBanco().filmes.get(i) == null)
					return i;
			return getBanco().filmes.size();
		}

		case "Locacao": {
			for (int i = 0; i < getBanco().locacoes.size(); i++)
				if (getBanco().locacoes.get(i) == null)
					return i;
			return getBanco().locacoes.size();
		}

		default:
			return 0;
		}

	}

	public static void saveBanco() {
		try {
			FileOutputStream fos = new FileOutputStream("Dados.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(getBanco());
			oos.close();
			fos.close();
			GerarRelatorio();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não pôde ser criado"
					+ " " + e);
		}
	}

	public static void loadBanco() {
		try {
			FileInputStream fis = new FileInputStream("Dados.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			b = (Banco) ois.readObject();
			ois.close();
			fis.close();
		} catch (ClassNotFoundException e) {
		} catch (IOException e) {
			saveBanco();
		}
	}

	public static void listCbx(javax.swing.JComboBox c, String s) {
		switch (s) {
		case "Genero": {
			c.addItem("Nenhum");
			try {
				for (int i = 0; i < getBanco().generos.size(); i++) {
					c.addItem(DAOGenero.getGenero(i));
				}
				return;
			} catch (NullPointerException e) {
				return;
			}
		}
		case "Cliente": {
			c.addItem("Nenhum");
			try {
				for (int i = 0; i < getBanco().clientes.size(); i++) {
					c.addItem(DAOCliente.getCliente(i));
				}
				return;
			} catch (NullPointerException e) {
				return;
			}
		}
		case "Filme": {
			c.addItem("Nenhum");
			try {
				for (int i = 0; i < getBanco().filmes.size(); i++) {
					if (!(DAOFilme.getFilme(i).getQtdDisponivel() == 0))
						c.addItem(DAOFilme.getFilme(i));
				}
			} catch (NullPointerException e) {
			}
		}
		}
	}

	public static boolean verificaConfig() {
		return getBanco().config == null;
	}

	public static Configuracao getConfiguracao() {

		return getBanco().config;
	}

	public static void setConfiguracao(Configuracao c) {
		getBanco().config = c;
	}

	public static void carregaConfig() {
		Principal.nome.setText(getBanco().config.getNome());
		Principal.telefone.setText(getBanco().config.getTelefone());
	}

	/*
	 * Verifica se os campos de dia e mês possuem 1 dígito ou 2, pois para
	 * inserilo no campo de texto, ele deve ter um numero exato de caracteres
	 */
	public static String getDataString(GregorianCalendar data) {
		if (data.get(5) < 10 && !((data.get(2) + 1) < 10)) {
			return "0" + data.get(5) + "/" + (data.get(2) + 1) + "/"
					+ data.get(1);
		} else if ((data.get(2) + 1) < 10 && !(data.get(5) < 10)) {
			return data.get(5) + "/0" + (data.get(2) + 1) + "/" + data.get(1);
		} else if (data.get(5) < 10 && (data.get(2) + 1) < 10) {
			return "0" + data.get(5) + "/0" + (data.get(2) + 1) + "/"
					+ data.get(1);
		} else {
			return (data.get(5) + "/" + (data.get(2) + 1) + "/" + data.get(1));
		}
	}

	public static HashMap getHashAtivo() {
		HashMap<Integer, Locacao> h = new HashMap<>();
		Set s = Banco.getHash("Locacao").keySet();
		Object o[] = s.toArray();
		for (int i = 0; i < getBanco().locacoes.size(); i++) {
			if (getBanco().locacoes.get(o[i]) != null) {
				if (getBanco().locacoes.get(o[i]).getSituacao() == 3) {
					Locacao l = getBanco().locacoes.get(o[i]);
					h.put(l.getKey(), l);
				}
			}
		}
		return h;
	}

	/*
	 * Retorna data em GregorianCalendar
	 */
	public static GregorianCalendar getData(String data) {
		String aux[] = data.split("/");
		GregorianCalendar n = new GregorianCalendar();
		n.set(Integer.parseInt(aux[2]), Integer.parseInt(aux[1]) - 1,
				Integer.parseInt(aux[0]));
		return n;
	}

	/*
	 * Verifica se o filme está locado
	 */
	public static boolean verificaFilme(Filme f) {
		for (int i = 0; i < getBanco().locacoes.size(); i++) {
			if (getBanco().locacoes.get(i) != null) {
				for (int j = 0; j < getBanco().locacoes.get(i).getFilmes()
						.size(); j++) {
					if (getBanco().locacoes.get(i).getFilmes().get(j) == f
							&& getBanco().locacoes.get(i).getSituacao() == 3) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean verificaCliente(Cliente c) {
		for (int i = 0; i < getBanco().locacoes.size(); i++) {
			if (getBanco().locacoes.get(i) != null
					&& getBanco().locacoes.get(i).getC() == c
					&& getBanco().locacoes.get(i).getSituacao() == 3) {
				return true;
			}
		}
		return false;
	}

	public static void GerarRelatorio() {
		FileWriter fw;
		try {
			fw = new FileWriter("Relatorio.txt");
			PrintWriter pw = new PrintWriter(fw);
			for (int i = 0; i < getBanco().locacoes.size(); i++) {
				Locacao l = DAOLocacao.getLocacao(i);
				pw.print(l.getC().getId() + ";" + l.getC() + ";"
						+ getDataString(l.getEmprestimo()) + ";"
						+ getDataString(l.getDevolucao()) + ";"
						+ l.getSituacao() + ";" + l.getVlrfinal() + ";"
						+ l.getFilmes().size() + ";");
				pw.println();
			}
			pw.close();
			fw.close();

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	public static void LerRelatorio(LinkedList r) {
		int id, filme;
		String nome, situacao;
		double valor;
		try {
			FileReader fr = new FileReader("Relatorio.txt");
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				try {
					GregorianCalendar emprestimo = new GregorianCalendar();
					GregorianCalendar devolucao = new GregorianCalendar();
					String s[] = br.readLine().split(";");
					id = Integer.parseInt(s[0]);
					nome = s[1];
					emprestimo.setTimeInMillis(getData(s[2]).getTimeInMillis());
					devolucao.setTimeInMillis(getData(s[3]).getTimeInMillis());
					int aux = Integer.parseInt(s[4]);
					switch (aux) {
					case 0: {
						situacao = "Cancelado";
						break;
					}
					case 1: {
						situacao = "Entregue";
						break;
					}
					case 2: {
						situacao = "Perdido";
						break;
					}
					default: {
						situacao = "Ativo";
					}
					}
					valor = Double.parseDouble(s[5]);
					Relatorio relatorio = new Relatorio();
					relatorio.setNome(nome);
					relatorio.setFilme(Integer.parseInt(s[6]));
					relatorio.setDevolucao(devolucao);
					relatorio.setEmprestimo(emprestimo);
					relatorio.setId(id);
					relatorio.setSituacao(situacao);
					relatorio.setValor(valor);
					r.add(relatorio);
				} catch (NullPointerException e) {
					break;
				}
			}
			br.close();
			fr.close();

		} catch (FileNotFoundException ex) {
			GerarRelatorio();
		} catch (IOException e) {

		}
	}
}
