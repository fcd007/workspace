package br.univel.correcao.agostini;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DownloadTableModel extends AbstractTableModel {

	private List<Download> lista;
	
	public DownloadTableModel() {
		lista = new ArrayList<Download>();
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {

		Download download = lista.get(arg0);
		switch (arg1) {
		case 0:
			return download.getOrigem();
		case 1:
			return download.getProgress();
		case 2:
			return download.getDestino();
		}
		return null;
	}

	public void adicionar(Download d) {

		d.addDownloadInformation(new DownloadInformation() {
			@Override
			public void informarProgresso(long readSoFar, double progress) {
				// d.setReadSoFar(readSoFar);
				d.setProgress(progress);
				DownloadTableModel.this.fireTableCellUpdated(lista.indexOf(d), 1);
			}
		});

		this.lista.add(d);
		
		d.iniciarDownloadNovaThread();
		super.fireTableRowsInserted(lista.size()-1, lista.size()-1);
	}
}
