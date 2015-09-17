package br.univel.patterns.behavioral.memento;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = -5243157010907529576L;
	
	private JPanel contentPane;
	private JTextField txfId;
	private JTextField txfNome;
	private JTextField txfTelefone;
	
	
	private MementoAdapter mA = new MementoAdapter();
	private Cliente cliente;

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
		this.cliente = mA.inicializar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Id");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txfId = new JTextField();
		GridBagConstraints gbc_txfId = new GridBagConstraints();
		gbc_txfId.insets = new Insets(0, 0, 5, 0);
		gbc_txfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfId.gridx = 1;
		gbc_txfId.gridy = 0;
		contentPane.add(txfId, gbc_txfId);
		txfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txfNome = new JTextField();
		GridBagConstraints gbc_txfNome = new GridBagConstraints();
		gbc_txfNome.insets = new Insets(0, 0, 5, 0);
		gbc_txfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNome.gridx = 1;
		gbc_txfNome.gridy = 1;
		contentPane.add(txfNome, gbc_txfNome);
		txfNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txfTelefone = new JTextField();
		GridBagConstraints gbc_txfTelefone = new GridBagConstraints();
		gbc_txfTelefone.insets = new Insets(0, 0, 5, 0);
		gbc_txfTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfTelefone.gridx = 1;
		gbc_txfTelefone.gridy = 2;
		contentPane.add(txfTelefone, gbc_txfTelefone);
		txfTelefone.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anterior();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton(">");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proximo();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 0;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
	}
	
	
	protected void proximo() {
		try {
			cliente = mA.proximo();
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			return;
		}
		atualizaCampos();
	}

	protected void anterior() {
		try {
			cliente = mA.anterior();
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			return;
		}
		atualizaCampos();
	}

	protected void salvar() {
		cliente = mA.salvar();
		cliente.setId(Integer.parseInt(txfId.getText()));
		cliente.setNome(txfNome.getText());
		cliente.setTelefone(txfTelefone.getText());
	}

	private void atualizaCampos() {
		txfId.setText(String.valueOf(cliente.getId()));
		txfNome.setText(cliente.getNome());
		txfTelefone.setText(cliente.getTelefone());
	}

}
