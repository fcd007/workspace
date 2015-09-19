package br.univel;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public abstract class DownloadInformation {
	DownloadTableModel model;
	float progress;
	int row,col;
	
	public void setTable(DownloadTableModel model, int row, int col){
		this.model=model;
		this.row=row;
		this.col=col;
	}
	public void informarProgresso(ProgressoDecoratorImpl rbc, double progress){
		model.lista.get(this.row).setProgress((float)progress);
		model.fireTableCellUpdated(this.row, this.col);
	}
	
}