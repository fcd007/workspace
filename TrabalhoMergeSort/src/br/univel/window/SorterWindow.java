package br.univel.window;

import java.awt.BorderLayout;
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
import br.univel.sorter.Sorter;

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
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class SorterWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtTxtelementos;
	private JButton btnGerarEOrdenar;
	private RankingTableModel model = new RankingTableModel();
	private JScrollPane scrollPane;
	private JTable table;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblElementos = new JLabel("Elementos:");
		GridBagConstraints gbc_lblElementos = new GridBagConstraints();
		gbc_lblElementos.insets = new Insets(0, 0, 5, 5);
		gbc_lblElementos.anchor = GridBagConstraints.WEST;
		gbc_lblElementos.gridx = 0;
		gbc_lblElementos.gridy = 0;
		contentPane.add(lblElementos, gbc_lblElementos);

		txtTxtelementos = new JTextField();
		txtTxtelementos.setMinimumSize(new Dimension(50, 19));
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
		gbc_btnGerarEOrdenar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGerarEOrdenar.anchor = GridBagConstraints.WEST;
		gbc_btnGerarEOrdenar.gridx = 2;
		gbc_btnGerarEOrdenar.gridy = 0;
		contentPane.add(btnGerarEOrdenar, gbc_btnGerarEOrdenar);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable(model);
		scrollPane.setViewportView(table);
	}

	protected void orderAndGenerate() {
		model.list.clear();
		Sort.sorters.clear();
		Sort.sorters.add(new BubbleSort1());
		Sort.sorters.add(new BubbleSort2());
		Sort.sorters.add(new SelectionSort());
		Sort.sorters.add(new CockTailSort());
		Sort.sorters.add(new QuickSort());
		Sort.sorters.add(new CollectionsSort());
		Sort.sorters.add(new MergeSort());

		Sort.generateNumbers(Integer.parseInt(txtTxtelementos.getText()));
		Sort.shuffle();
		btnGerarEOrdenar.setEnabled(false);
		int cores = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(cores);

		for (int i = 0; i < Sort.sorters.size(); i++) {
			Sort sorter = Sort.sorters.get(i);
			executor.execute(new Thread(new Runnable() {

				@Override
				public void run() {

					Sort.countTime(sorter);
					model.list.add(sorter);
					Collections.sort(model.list);
					model.fireTableDataChanged();

				}
			}));
		}
		executor.shutdown();
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btnGerarEOrdenar.setEnabled(true);

			}
		}).start();
		// Collections.sort(model.list);
		// model.fireTableDataChanged();

		// new Thread(new Runnable() {
		// @Override
		// public void run() {
		// for (int i = 0; i < Sort.sorters.size(); i++) {
		//
		// Sort.countTime(Sort.sorters.get(i));
		// }
		// btnGerarEOrdenar.setEnabled(true);
		// Collections.sort(Sort.sorters);
		// model.fireTableDataChanged();
		// }
		// }).start();

	}

}
