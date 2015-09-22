package br.univel;

import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public abstract class DownloadInformation {
	DownloadTableModel model;
	float progress;
	int row, col;

	public void setTable(DownloadTableModel model, int row, int col) {
		this.model = model;
		this.row = row;
		this.col = col;
	}

	public void informarProgresso(ProgressoDecoratorImpl rbc, double progress) {
		if (model.lista.get(this.row).getStatus() == DownloadStatus.CANCELLED) {
			try {
				rbc.close();
				progress = 100;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.lista.get(this.row).setProgress((float) progress);
		model.fireTableCellUpdated(this.row, this.col);
	}

}