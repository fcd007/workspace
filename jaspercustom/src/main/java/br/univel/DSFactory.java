package br.univel;

import net.sf.jasperreports.engine.JRDataSource;

public class DSFactory {
	public static JRDataSource create(){
		return new CustomDs();
	}
}
