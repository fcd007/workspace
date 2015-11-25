package br.univel;

import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtCity;
	private DefaultListModel<String> model;
	private JButton btnAdicionarCidade_1;
	private JTextField txtDistancia;
	private JList<String> list;
	Graph g;
	private JButton btnCalculate;
	private JList<String> list_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		txtCity = new JTextField();
		GridBagConstraints gbc_txtCity = new GridBagConstraints();
		gbc_txtCity.insets = new Insets(0, 0, 5, 5);
		gbc_txtCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCity.gridx = 0;
		gbc_txtCity.gridy = 0;
		contentPane.add(txtCity, gbc_txtCity);
		txtCity.setColumns(10);

		JButton btnAdicionarCidade = new JButton("Adicionar Cidade");
		btnAdicionarCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCity();
			}
		});
		GridBagConstraints gbc_btnAdicionarCidade = new GridBagConstraints();
		gbc_btnAdicionarCidade.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdicionarCidade.gridx = 1;
		gbc_btnAdicionarCidade.gridy = 0;
		contentPane.add(btnAdicionarCidade, gbc_btnAdicionarCidade);

		// User
		model = new DefaultListModel<String>();

		txtDistancia = new JTextField();
		txtDistancia.setText("City1 TO City2 DISTANCE 5");
		txtDistancia.setToolTipText("");
		GridBagConstraints gbc_txtDistancia = new GridBagConstraints();
		gbc_txtDistancia.insets = new Insets(0, 0, 5, 5);
		gbc_txtDistancia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDistancia.gridx = 0;
		gbc_txtDistancia.gridy = 1;
		contentPane.add(txtDistancia, gbc_txtDistancia);
		txtDistancia.setColumns(10);

		btnAdicionarCidade_1 = new JButton("Adicionar Distancia");
		btnAdicionarCidade_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDistance();
			}
		});
		GridBagConstraints gbc_btnAdicionarCidade_1 = new GridBagConstraints();
		gbc_btnAdicionarCidade_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdicionarCidade_1.gridx = 1;
		gbc_btnAdicionarCidade_1.gridy = 1;
		contentPane.add(btnAdicionarCidade_1, gbc_btnAdicionarCidade_1);

		list = new JList<String>(model);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 2;
		contentPane.add(list, gbc_list);
		
		btnCalculate = new JButton("Calcular");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();
			}
		});
		
		list_1 = new JList<String>(model);
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.insets = new Insets(0, 0, 5, 0);
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 1;
		gbc_list_1.gridy = 2;
		contentPane.add(list_1, gbc_list_1);
		GridBagConstraints gbc_btnCalculate = new GridBagConstraints();
		gbc_btnCalculate.anchor = GridBagConstraints.NORTH;
		gbc_btnCalculate.gridx = 1;
		gbc_btnCalculate.gridy = 3;
		contentPane.add(btnCalculate, gbc_btnCalculate);

		g = new Graph();
	}

	protected void calculate() {
		JOptionPane.showMessageDialog(null, g.getShortestPath(model.get(list.getSelectedIndex()), model.get(list_1.getSelectedIndex())));
//		System.out.println(g.getShortestPath("Cascavel", "Curitiba"));
		for(String distance : g.getResult().keySet()){
			System.out.println(distance+" -- "+g.getResult().get(distance));
		}
	}

	protected void addDistance() {
		String[] values = txtDistancia.getText().split(" TO ");
		String city1 = model.get(list.getSelectedIndex());
		String city2 = model.get(list_1.getSelectedIndex());
		Integer distance = Integer.parseInt(txtDistancia.getText());
		if (model.contains(city1) && model.contains(city2)) {
			g.addVertex(city1, Arrays.asList(new Vertex(city2, distance)));
			g.addVertex(city2, Arrays.asList(new Vertex(city1, distance)));
			System.out.println(distance);
		} else {
			System.out.println("Formato Incorreto");
		}
	}

	protected void addCity() {
		String string = txtCity.getText();
		if (!string.equals("") && !model.contains(string)
				&& !g.getVertices().containsKey(txtCity.getText())) {
			model.addElement(txtCity.getText().trim());
		}
		txtCity.setText("");
	}

	public boolean validate(String string, int position) {
		String[] values = string.split("-");
		return !string.equals("")
				&& ((position == 0 ? !model.contains(values[position])
						: values.length <= 1));
	}
}
