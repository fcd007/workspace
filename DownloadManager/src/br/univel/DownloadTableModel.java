package br.univel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class DownloadTableModel extends AbstractTableModel {

	public List<Download> lista = new ArrayList<>();

	@Override
	public int getColumnCount() {
		return Download.class.getDeclaredFields().length - 2;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public String getColumnName(int column) {
		String name = Download.class.getDeclaredFields()[column].getName();
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return lista.get(rowIndex).getDestino();
		case 1:
			return lista.get(rowIndex).getOrigem();
		case 2:
			return lista.get(rowIndex).getProgress();

		default:
			System.err.println("Deu ruim");
		}

		return null;
	}

	public void insertDownload(Download d) {
		this.lista.add(d);
		d.setStatus(DownloadStatus.RUNNING);
		DownloadTableModel me = this;
		super.fireTableDataChanged();
		int row = lista.size() - 1;

		new Thread(new Runnable() {
			
			public void run() {
				Downloader downloader = new Downloader(d.getDestino(), d.getOrigem());
				downloader.setTable(me, row, Download.PROGRESS_NUMER);
				downloader.iniciarDownload();

			}
		}).start();

	}

}
