package br.univel.correcao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DownloadTableModel extends AbstractTableModel{
	private List<Download> list;
	
	public DownloadTableModel() {
		list = new ArrayList<Download>();
	}
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Download d = list.get(rowIndex);
		switch (columnIndex) {
		case 0: return d.getOrigem();
		case 1: return d.getDestino();
		case 2: return d.getDestino();
		

		default:
			break;
		}
		return null;
	}
	public void adicionar(Download d) {
		
		d.addDownloadInformation(new DownloadInformation() {
			
			@Override
			public void informarProgresso(long readSoFar, double progress) {
//				d.setReadSoFar(readSoFar);
				d.setProgress(progress);
				DownloadTableModel.this.fireTableCellUpdated(list.indexOf(d), 2);
				
			}
		});
//		d.setDownloadInformation(new DownloadInformation() {
//			
//			@Override
//			public void informarProgresso(ProgressoDecoratorImpl rbc, double progress) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		list.add(d);
		d.iniciarDownloadNewThread();
		super.fireTableRowsInserted(list.size()-1, list.size()-1);
	}

}
