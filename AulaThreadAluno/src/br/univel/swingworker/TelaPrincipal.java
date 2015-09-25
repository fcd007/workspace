package br.univel.swingworker;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

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
		contentPane.setLayout(new BorderLayout(0, 0));

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// processar();
				new TarefaSwing().execute();
			}
		});
		contentPane.add(btnNewButton, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

	protected void processar() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					int num = (int) (Math.random() * 1000);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					textArea.append(String.valueOf(num));
					textArea.append("'\n");
				}
			}
		}).start();

	}
	
	
	class TarefaSwing extends SwingWorker<String, Integer> {

		@Override
		protected String doInBackground() throws Exception {
			for (int i = 0; i < 100; i++) {
				int num = (int) (Math.random() * 1000);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				publish(num);
//				textArea.append(String.valueOf(num));
//				textArea.append("\n");
			}
			return "Pronto!";
		}

		@Override
		protected void process(List<Integer> chunks) {
			for (Integer num : chunks) {
				textArea.append(String.valueOf(num));
				textArea.append("\n");
			}
		}

		@Override
		protected void done() {
			try {
				String resultado = get();
				textArea.append(resultado);
				textArea.append("\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
