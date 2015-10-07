package br.univel.panel.triangle;

import java.awt.Color;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MostraPainel {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setSize(499, 493);
		jf.setResizable(false);
		// Centraliza
		jf.setLocationRelativeTo(null);
		JPanel trianglePanel = new TrianglePanel(8,true);
		JPanel squarePanel = new SquarePanel();
		jf.setContentPane(trianglePanel);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		Timer timer = new Timer(2, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.getContentPane().repaint();
				
			}
		});
//		timer.setInitialDelay(0);
		timer.start();
	}
}
