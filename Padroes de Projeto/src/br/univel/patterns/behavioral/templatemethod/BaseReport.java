package br.univel.patterns.behavioral.templatemethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

abstract class BaseReport {

	String imprimir() {
		DateFormat sdf = SimpleDateFormat.getDateInstance();

		char[] line = new char[80];
		Arrays.fill(line, '-');

		StringBuilder sb = new StringBuilder();
		sb.append(line).append('\n');
		sb.append(sdf.format(new Date())).append('\n');
		sb.append(line).append('\n');
		sb.append(getCabecalho()).append('\n');
		sb.append(line).append('\n');
		sb.append(getCorpo()).append('\n');
		sb.append(line).append('\n');
		sb.append(getRodape()).append('\n');
		sb.append(line).append('\n');

		return sb.toString();
	}

	abstract String getCabecalho();

	abstract String getCorpo();

	abstract String getRodape();

}
