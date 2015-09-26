package br.univel.window;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import br.univel.sorter.BubbleSort1;
import br.univel.sorter.BubbleSort2;
import br.univel.sorter.CockTailSort;
import br.univel.sorter.CollectionsSort;
import br.univel.sorter.MergeSort;
import br.univel.sorter.QuickSort;
import br.univel.sorter.RankingTableModel;
import br.univel.sorter.SelectionSort;
import br.univel.sorter.Sort;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.List;

public class SorterWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtTxtelementos;
	private JButton btnGerarEOrdenar;
	private RankingTableModel model = new RankingTableModel();
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel sortesPanel;
	private JScrollPane scrollPane_1;
	private JButton button;
	private JButton button_1;
	private JScrollPane scrollPane_2;
	private List lstAvaliableSorters;
	private List lstAddedSorters;
	private java.util.List<Sort> sorters;
	private JButton button_2;
	private JButton button_3;
	private JPanel buttonPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SorterWindow frame = new SorterWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SorterWindow() {
		setMinimumSize(new Dimension(529, 398));
		Sort.sorters.add(new BubbleSort1());
		Sort.sorters.add(new BubbleSort2());
		Sort.sorters.add(new SelectionSort());
		Sort.sorters.add(new CockTailSort());
		Sort.sorters.add(new QuickSort());
		Sort.sorters.add(new CollectionsSort());
		Sort.sorters.add(new MergeSort());
		sorters = new ArrayList<Sort>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblElementos = new JLabel("Elementos:");
		GridBagConstraints gbc_lblElementos = new GridBagConstraints();
		gbc_lblElementos.insets = new Insets(0, 0, 5, 5);
		gbc_lblElementos.anchor = GridBagConstraints.WEST;
		gbc_lblElementos.gridx = 0;
		gbc_lblElementos.gridy = 0;
		contentPane.add(lblElementos, gbc_lblElementos);

		txtTxtelementos = new JTextField();
		txtTxtelementos.setMinimumSize(new Dimension(100, 19));
		txtTxtelementos.setPreferredSize(new Dimension(50, 19));
		GridBagConstraints gbc_txtTxtelementos = new GridBagConstraints();
		gbc_txtTxtelementos.insets = new Insets(0, 0, 5, 5);
		gbc_txtTxtelementos.anchor = GridBagConstraints.WEST;
		gbc_txtTxtelementos.gridx = 1;
		gbc_txtTxtelementos.gridy = 0;
		contentPane.add(txtTxtelementos, gbc_txtTxtelementos);
		txtTxtelementos.setColumns(10);

		btnGerarEOrdenar = new JButton("Gerar e ordenar");
		btnGerarEOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderAndGenerate();
			}
		});
		GridBagConstraints gbc_btnGerarEOrdenar = new GridBagConstraints();
		gbc_btnGerarEOrdenar.insets = new Insets(0, 0, 5, 0);
		gbc_btnGerarEOrdenar.anchor = GridBagConstraints.WEST;
		gbc_btnGerarEOrdenar.gridx = 2;
		gbc_btnGerarEOrdenar.gridy = 0;
		contentPane.add(btnGerarEOrdenar, gbc_btnGerarEOrdenar);

		sortesPanel = new JPanel();
		sortesPanel.setMaximumSize(new Dimension(500, 150));
		sortesPanel.setMinimumSize(new Dimension(500, 150));
		GridBagConstraints gbc_sortesPanel = new GridBagConstraints();
		gbc_sortesPanel.gridwidth = 3;
		gbc_sortesPanel.insets = new Insets(0, 0, 5, 0);
		gbc_sortesPanel.fill = GridBagConstraints.BOTH;
		gbc_sortesPanel.gridx = 0;
		gbc_sortesPanel.gridy = 1;
		contentPane.add(sortesPanel, gbc_sortesPanel);
		GridBagLayout gbl_sortesPanel = new GridBagLayout();
		gbl_sortesPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_sortesPanel.rowHeights = new int[] { 0, 0 };
		gbl_sortesPanel.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_sortesPanel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		sortesPanel.setLayout(gbl_sortesPanel);

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		sortesPanel.add(scrollPane_1, gbc_scrollPane_1);

		lstAvaliableSorters = new List();
		scrollPane_1.setViewportView(lstAvaliableSorters);

		buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.insets = new Insets(0, 0, 0, 5);
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 1;
		gbc_buttonPanel.gridy = 0;
		sortesPanel.add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[] { 0, 0 };
		gbl_buttonPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_buttonPanel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_buttonPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		buttonPanel.setLayout(gbl_buttonPanel);

		button = new JButton(">");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		buttonPanel.add(button, gbc_button);

		button_1 = new JButton("<");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 1;
		buttonPanel.add(button_1, gbc_button_1);

		button_2 = new JButton(">>");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 2;
		buttonPanel.add(button_2, gbc_button_2);

		button_3 = new JButton("<<");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAllElements();
			}
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.gridx = 0;
		gbc_button_3.gridy = 3;
		buttonPanel.add(button_3, gbc_button_3);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAllSorters();
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAddedItem();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSorter();
			}
		});

		scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 2;
		gbc_scrollPane_2.gridy = 0;
		sortesPanel.add(scrollPane_2, gbc_scrollPane_2);

		lstAddedSorters = new List();
		scrollPane_2.setViewportView(lstAddedSorters);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);

		for (int i = 0; i < Sort.sorters.size(); i++) {
			lstAvaliableSorters.add(Sort.sorters.get(i).getName());
		}

		table = new JTable(model) {
			@Override
			public TableCellRenderer getCellRenderer(int row, int column) {
				if (row < 3)
					return new TableCellRenderer() {

						@Override
						public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
								boolean hasFocus, int row, int column) {
							JLabel label = new JLabel();
							label.setOpaque(true);
							label.setForeground(Color.BLACK);
							label.setText(value.toString());
							// label.
							switch (row) {
							case 0: {
								label.setBackground(Color.YELLOW);
								break;
							}
							case 1: {
								label.setBackground(Color.LIGHT_GRAY);
								break;
							}
							case 2: {
								label.setBackground(Color.ORANGE);
								break;
							}
							default:
							}
							return label;
							// return null;
						}
					};

				return super.getCellRenderer(row, column);
			}
		};
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		scrollPane.setViewportView(table);
	}

	protected void removeAllElements() {
		sorters.clear();
		lstAddedSorters.removeAll();
	}

	protected void addAllSorters() {
		sorters.clear();
		sorters.addAll(Sort.sorters);
		lstAddedSorters.removeAll();
		for (int i = 0; i < Sort.sorters.size(); i++) {
			lstAddedSorters.add(Sort.sorters.get(i).getName());
		}

	}

	protected void removeAddedItem() {
		if (lstAddedSorters.getSelectedIndex() != -1) {
			sorters.remove(lstAddedSorters.getSelectedIndex());
			lstAddedSorters.remove(lstAddedSorters.getSelectedIndex());
		}
	}

	private boolean isAlreadyAdded() {
		for (int i = 0; i < sorters.size(); i++) {
			if (lstAvaliableSorters.getSelectedItem().equals(sorters.get(i).getName())) {
				return true;
			}
		}
		return false;
	}

	protected void addSorter() {
		if (lstAvaliableSorters.getSelectedIndex() != -1 && !isAlreadyAdded()) {
			Sort sort = Sort.sorters.get(lstAvaliableSorters.getSelectedIndex());
			sorters.add(sort);
			lstAddedSorters.add(sort.getName());
		}

	}

	protected void orderAndGenerate() {
		Sort.generateNumbers(
				Integer.parseInt(txtTxtelementos.getText().matches("[0-9]+") ? txtTxtelementos.getText() : "0"));
		if (Sort.numbers.size() > 1) {
			Sort.shuffle();
			btnGerarEOrdenar.setEnabled(false);

			new Thread(new Runnable() {
				@Override
				public void run() {
					model.startSorters(sorters);
					btnGerarEOrdenar.setEnabled(true);
				}
			}).start();
		} else {
			JOptionPane.showMessageDialog(null, "Digite um número de elementos válido");
		}

	}

}
