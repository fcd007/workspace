package br.univel.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Painel extends JPanel {
	// alt+s
	/**
	 * Create the panel.
	 */
	int r, g, b = 0;
	boolean swap;
	Color color;
	Color before;

	public Painel() {
		setBackground(Color.BLACK);

	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g2 = (Graphics2D) graphics;
//		int r = this.r;
//		int g = this.g;
//		int b = this.b;

		g2.setColor(color);
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

	private Color getRandomColor(int c) {
		int r, g, b;

		r = (int) ((Math.random() * 100) % 254);
		g = (int) ((Math.random() * 100) % 254);
		b = (int) ((Math.random() * 100) % 254);
		System.out.println(r + " " + g + " " + " " + b);
		return new Color(r, g, b);

	}

	@Override
	public void repaint() {
		if (r < 255 && g < 255 && b < 255 && swap) {
			r = g = ++b;
		} else {
			swap = false;
			r = g = --b;
			if (r < 2 && g < 2 && b < 2)
				this.swap = true;
			if (swap) {
				before = color;
				color = getRandomColor((int) (Math.random() * 10));
				while (before == color) {
					color = getRandomColor((int) (Math.random() * 10));

				}
			}

		}

		super.repaint();
	}

}
