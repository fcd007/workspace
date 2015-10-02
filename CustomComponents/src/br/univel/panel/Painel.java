package br.univel.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Painel extends JPanel {
	// alt+s
	/**
	 * Create the panel.
	 */
	int cont = 0;

	public Painel() {
		setBackground(Color.BLACK);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// System.out.println(cont);
		g2.setColor(new Color(cont, cont, cont));
		int w = getWidth() - 1;
		int h = getHeight() - 1;
		int widthQ = w / 8;
		int heightQ = h / 8;
		int size = 0;
		int cont = 0;
		for (int j = heightQ; j < getHeight(); j += (2 * heightQ)) {

			for (int i = size; i < getWidth(); i += (2 * widthQ)) {
				if (cont == 0)
					g2.fillRect(i + widthQ, 0, widthQ, heightQ);
				g2.fillRect(i + widthQ, j + heightQ, widthQ, heightQ);
				g2.fillRect(i, j, widthQ, heightQ);
			}
			cont++;
		}

	}

	@Override
	public void repaint() {
		if (this.cont < 255)
			cont++;
		super.repaint();
	}

}
