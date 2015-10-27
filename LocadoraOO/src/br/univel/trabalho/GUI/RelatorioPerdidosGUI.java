/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel.trabalho.GUI;

import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;
import br.univel.trabalho.Classes.Banco;
import br.univel.trabalho.Classes.DAO.DAORelatorio;
import br.univel.trabalho.Classes.Relatorio;

/**
 *
 * @author USER
 */
public class RelatorioPerdidosGUI extends javax.swing.JDialog {

	TPerdidos m = new TPerdidos();
	static LinkedList<Relatorio> relatorio;

	public RelatorioPerdidosGUI(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		relatorio = new LinkedList<>();
		DAORelatorio.GetRelatorioPerdidos(relatorio);
		tbSemanal.setModel(m);
		m.fireTableDataChanged();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		tbSemanal = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		tbSemanal.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(tbSemanal);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addContainerGap(63, Short.MAX_VALUE)
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 237,
								javax.swing.GroupLayout.PREFERRED_SIZE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(
					RelatorioSemanalGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(
					RelatorioSemanalGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(
					RelatorioSemanalGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(
					RelatorioSemanalGUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				RelatorioSemanalGUI dialog = new RelatorioSemanalGUI(
						new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tbSemanal;
	// End of variables declaration//GEN-END:variables
}

class TPerdidos extends AbstractTableModel {

	@Override
	public int getRowCount() {
		return RelatorioPerdidosGUI.relatorio.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public String getColumnName(int i) {
		switch (i) {
		case 0:
			return "Id";
		case 1:
			return "Nome";
		case 2:
			return "Emprestimo";
		case 3:
			return "Devolução";
		case 4:
			return "Situação";
		case 5:
			return "Valor Pago";
		default:
			return "Filmes Locados";
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Relatorio r = RelatorioPerdidosGUI.relatorio.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return r.getId();
		case 1:
			return r.getNome();
		case 2:
			return Banco.getDataString(r.getEmprestimo());
		case 3:
			return Banco.getDataString(r.getDevolucao());
		case 4:
			return r.getSituacao();
		case 5:
			return r.getValor();
		default:
			return r.getFilme();

		}
	}

}
