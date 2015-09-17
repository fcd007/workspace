package br.univel.patterns.structural.flyweight;

public class TesteFlyweight {

	public static void main(String[] args) {

		DaoMysql dao = new DaoMysql();
		System.out.println(dao.getNomeCidade(1));
		System.out.println(dao.getNomeCidade(2));
		System.out.println(dao.getNomeCidade(3));
		System.out.println(dao.getNomeCidade(1));
		System.out.println(dao.getNomeCidade(2));
		System.out.println(dao.getNomeCidade(3));
		System.out.println(dao.getNomeCidade(1));
		System.out.println(dao.getNomeCidade(2));
		System.out.println(dao.getNomeCidade(3));
	}
}
