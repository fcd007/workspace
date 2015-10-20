package br.univel.simple_report;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.univel.cadastro.model.ClienteDaoH2Impl;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class SimpleReport {

	private String arq = "C:/Users/jmgrams/Documents/JaspersoftWorkspace/MyReports/simples_jdbc.jasper";

	public SimpleReport() throws SQLException {
		
		TableModel tableModel = getTableModel();
		Map<String, Object> map = new HashMap<>();
		map.put("empresa", "Univel");
		map.put("telefone","000-000");
		JasperPrint jasperPrint = null;
		ClienteDaoH2Impl clienteDao = new ClienteDaoH2Impl();
		getTableModel();
		try {
			jasperPrint = JasperFillManager.fillReport(arq, null, clienteDao.getConnection());
//					new JRTableModelDataSource(tableModel));
			
			JasperViewer jasperViewer = new JasperViewer(jasperPrint);
			jasperViewer.setVisible(true);
			
		} catch (JRException ex) {
			ex.printStackTrace();
		}
	}

	private TableModel getTableModel() {
		String[] columnNames = { "Id", "Nome", "Departamento", "Email" };
		
		String[][] data = {
				{ "1", "Hugo", "Financeiro", "hugod@univel.br" },
				{ "2", "José", "Comercial",  "josed@univel.br" },
				{ "3", "Juliano", "Contábil",   "luizd@univel.br" },
				{ "4", "Jane", "Contábil",   "luizd@univel.br" },
				{ "5", "Teste", "Contábil",   "luizd@univel.br" },
				{ "6", "Francinaldo", "Contábil",   "luizd@univel.br" }
		};
		
	
		
		return new DefaultTableModel(data, columnNames);
	}

	public static void main(String[] args) throws SQLException {
		new SimpleReport();
	}
}