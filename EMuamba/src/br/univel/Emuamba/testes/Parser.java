package br.univel.Emuamba.testes;
import br.univel.*;
import br.univel.Emuamba.Produto;

public class Parser {
	public static void main(String[] args) {
		String str = "72435.......XBOX ONE JOGO WARRIORS 3 ORACHI ULTIMATE.............................U$18,90";
		String code = str.substring(0, 12).replaceAll("\\.", "");
		System.out.println(code);
		String name = str.substring(12);
		name = name.substring(0, name.indexOf("...")).replaceAll("\\.", "");
		System.out.println(name);
		String price = str.substring(str.lastIndexOf("...")+5);
		System.out.println(price);
		
		Produto p = new Produto(name, code, price);
		
	}
}
