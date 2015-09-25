package br.univel.sorter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class RankingTableModel extends AbstractTableModel{
	
<<<<<<< HEAD
	public List<Sort> list = Sort.sorters;
=======
	public List<Sort> list = new ArrayList<Sort>();
>>>>>>> e81c5c865828d4086e62d82cb67d6553713cbd94

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
		switch (columnIndex) {
		case 0: return (rowIndex+1);
		case 1: return list.get(rowIndex).getName();
<<<<<<< HEAD
		case 2: return Sort.numbers.size() <= 10000 ? list.get(rowIndex).getTime()+" Nanosegundos" : list.get(rowIndex).getTime()+" Milisegundos";
=======
		case 2: return list.get(rowIndex).getTime()+" Milissegundos";
>>>>>>> e81c5c865828d4086e62d82cb67d6553713cbd94
			
		default:
			return null;
		}
	}
<<<<<<< HEAD
	
=======
>>>>>>> e81c5c865828d4086e62d82cb67d6553713cbd94

}
