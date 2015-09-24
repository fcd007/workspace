package br.univel.correcao;

import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public interface DownloadInformation {

	public void informarProgresso(long readSoFar, double progress);

}