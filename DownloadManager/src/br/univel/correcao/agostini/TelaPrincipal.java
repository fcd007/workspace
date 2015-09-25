package br.univel.correcao.agostini;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textOrigem;
	private JTable table;
	private DownloadTableModel tableModel = new DownloadTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblOrigem = new JLabel("Origem");
		GridBagConstraints gbc_lblOrigem = new GridBagConstraints();
		gbc_lblOrigem.insets = new Insets(0, 0, 5, 0);
		gbc_lblOrigem.gridx = 0;
		gbc_lblOrigem.gridy = 0;
		contentPane.add(lblOrigem, gbc_lblOrigem);
		
		textOrigem = new JTextField();
		textOrigem.setText("http://eclipse.c3sl.ufpr.br/technology/epp/downloads/release/mars/R/eclipse-jee-mars-R-win32-x86_64.zip");
		GridBagConstraints gbc_textOrigem = new GridBagConstraints();
		gbc_textOrigem.insets = new Insets(0, 0, 5, 0);
		gbc_textOrigem.fill = GridBagConstraints.HORIZONTAL;
		gbc_textOrigem.gridx = 0;
		gbc_textOrigem.gridy = 1;
		contentPane.add(textOrigem, gbc_textOrigem);
		textOrigem.setColumns(10);
		
		JButton btnDownload = new JButton("Download");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionarDownload();
			}
		});
		GridBagConstraints gbc_btnDownload = new GridBagConstraints();
		gbc_btnDownload.insets = new Insets(0, 0, 5, 0);
		gbc_btnDownload.gridx = 0;
		gbc_btnDownload.gridy = 2;
		contentPane.add(btnDownload, gbc_btnDownload);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setModel(this.tableModel );
		scrollPane.setViewportView(table);
	}

	
	private int contador = 0;
	
	protected void adicionarDownload() {

		String origem = textOrigem.getText().trim();

		String nomeArquivo = origem
				.substring(origem.lastIndexOf('/')+1);
		
		if (contador++ > 0) {
			String nome = nomeArquivo.substring(0, nomeArquivo.lastIndexOf('.') -1);
			String ext = nomeArquivo.substring(nomeArquivo.lastIndexOf('.') +1);
			
			nomeArquivo = nome + "(" + contador + ")" + "." + ext;
		}

		Download d = new Download(nomeArquivo, origem);
		
		tableModel.adicionar(d);
		
		
	}

}
