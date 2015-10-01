package br.univel.panel;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class MostraPainel {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setSize(500, 500);
		// Centraliza
		jf.setLocationRelativeTo(null);
		Painel painel = new Painel();
		jf.setContentPane(painel);
		jf.setVisible(true);
		

	}
}
