package br.univel.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class RankingTableModel extends AbstractTableModel{
	
	private List<Sort> list = new ArrayList<Sort>();

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}
	
	public String getColumnName(int column) {
		switch (column) {
		case 0: return "Posicao";
		case 1: return "Ordenador";
		case 2: return "Tempo";
		default:
			return null;
		}
	};

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Sort sort = list.get(rowIndex);
		switch (columnIndex) {
		case 0: return (rowIndex+1);
		case 1: return sort.getName();
		case 2: return sort.getTime()+" "+(Sort.numbers.size() > 10000 ? "Milissegundos" : "Nanossegundos");
			
		default:
			return null;
		}
	}

	public void startSorters(List<Sort> sorters) {
		this.list.clear();
		this.fireTableDataChanged();
		for (int i = 0; i < sorters.size(); i++) {
			Sort sort = sorters.get(i);
			Sort.countTime(sort);
			this.list.add(sort);
		}
		Collections.sort(this.list);
		this.fireTableDataChanged();
		
	}
	
	

}
