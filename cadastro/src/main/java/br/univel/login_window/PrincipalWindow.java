package br.univel.login_window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrincipalWindow extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalWindow frame = new PrincipalWindow();
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
	public PrincipalWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openWindow();
			}

			private void openWindow() {
				TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
				ActionListener action = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						tabbedPane.remove(telaCadastroCliente);
						
					}
				};
//				telaCadastroCliente.setCloseAction(action);
				telaCadastroCliente.setCloseAction(e -> tabbedPane.remove(telaCadastroCliente));
				tabbedPane.addTab("Cliente", telaCadastroCliente);
			}
		});
		mnCadastro.add(mntmCliente);
		
		JMenuItem mntmGenero = new JMenuItem("Genero");
		mntmGenero.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				openGeneroTab();
			}
		});
		mnCadastro.add(mntmGenero);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	protected void openGeneroTab() {
		TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroCliente);
				
			}
		};
//		telaCadastroCliente.setCloseAction(action);
		telaCadastroCliente.setCloseAction(e -> tabbedPane.remove(telaCadastroCliente));
		tabbedPane.addTab("Cliente", telaCadastroCliente);
		
	}
	

}
