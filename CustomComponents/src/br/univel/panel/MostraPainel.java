package br.univel.panel;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MostraPainel {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setSize(500, 500);
		// Centraliza
		jf.setLocationRelativeTo(null);
		Painel painel = new Painel();
		jf.setContentPane(painel);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		Timer timer = new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painel.repaint();
				
			}
		});
		timer.start();
	}
}
