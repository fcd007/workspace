package br.univel.correcao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;


import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;


import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableWindow extends JFrame {

	private JPanel contentPane;
	private DownloadTableModel dtm = new DownloadTableModel();
	private JTextField txtUrl;
	private JTextField txtArquivo;
	private JTable table;
	private DownloadTableModel tableModel= new DownloadTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableWindow frame = new TableWindow();
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
	public TableWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblUrl = new JLabel("URL:");
		GridBagConstraints gbc_lblUrl = new GridBagConstraints();
		gbc_lblUrl.anchor = GridBagConstraints.EAST;
		gbc_lblUrl.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrl.gridx = 0;
		gbc_lblUrl.gridy = 0;
		contentPane.add(lblUrl, gbc_lblUrl);

		txtUrl = new JTextField();
		txtUrl.setText("http://centos.ufes.br/7/isos/x86_64/CentOS-7-x86_64-DVD-1503-01.iso");
		GridBagConstraints gbc_txtUrl = new GridBagConstraints();
		gbc_txtUrl.insets = new Insets(0, 0, 5, 0);
		gbc_txtUrl.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUrl.gridx = 1;
		gbc_txtUrl.gridy = 0;
		contentPane.add(txtUrl, gbc_txtUrl);
		txtUrl.setColumns(10);

		JLabel lblNomeDoArquivo = new JLabel("Nome do Arquivo:");
		GridBagConstraints gbc_lblNomeDoArquivo = new GridBagConstraints();
		gbc_lblNomeDoArquivo.anchor = GridBagConstraints.EAST;
		gbc_lblNomeDoArquivo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeDoArquivo.gridx = 0;
		gbc_lblNomeDoArquivo.gridy = 1;
		contentPane.add(lblNomeDoArquivo, gbc_lblNomeDoArquivo);

		txtArquivo = new JTextField();
		GridBagConstraints gbc_txtArquivo = new GridBagConstraints();
		gbc_txtArquivo.insets = new Insets(0, 0, 5, 0);
		gbc_txtArquivo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtArquivo.gridx = 1;
		gbc_txtArquivo.gridy = 1;
		contentPane.add(txtArquivo, gbc_txtArquivo);
		txtArquivo.setColumns(10);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnDownload = new JButton("Download");
		panel.add(btnDownload);
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				download();
			}
		});
		panel.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		contentPane.add(scrollPane, gbc_scrollPane);


		table = new JTable();
		table.setModel(this.tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setViewportView(table);

	}
	private int cont=0;

	protected void download() {
		String origem = txtUrl.getText().trim();
		String destino = origem.substring(origem.lastIndexOf('/')+1)+".zip";
		if (cont++ > 0) {
			String nome = destino.substring(0, destino.lastIndexOf('.')-1);
			String ext = destino.substring(0, destino.lastIndexOf('.')+1);
			
			destino  = nome+ "("+cont+")"+"."+ext;
		}
		Download d = new Download(destino, origem);
		tableModel.adicionar(d);
	}

}
