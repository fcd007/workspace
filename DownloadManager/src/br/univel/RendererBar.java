package br.univel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RendererBar extends JProgressBar implements TableCellRenderer{

	public RendererBar() {
		setStringPainted(true);
		setBackground(Color.WHITE);
		setForeground(Color.BLUE);
		setBorder(null);
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Float f = (float) value;
		super.setValue(f.intValue());
		return this;
	}
	

}
