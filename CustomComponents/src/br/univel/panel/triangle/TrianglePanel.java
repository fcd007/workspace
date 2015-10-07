package br.univel.panel.triangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class TrianglePanel extends JPanel {
	// alt+s
	/**
	 * Create the panel.
	 */
	private int r, g, b, cont;
	private boolean swap=true;
	private int color = -1;
	private int before;
	private final int size;
	private boolean fade;

	public TrianglePanel(int separation, boolean fade) {
		setBackground(Color.BLACK);
		this.size = separation;
		this.fade = fade;
		r = g = b = cont = 0;
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g2 = (Graphics2D) graphics;
		g2.setColor(getRandomColor(color));
		// g2.setColor(Color.WHITE);
		int w = getWidth() - 1;
		int h = getHeight() - 1;
		int widthQ = w / size;
		int heightQ = h / size;
		int middleW = widthQ / 2;
		int x[] = new int[3];
		int y[] = new int[3];
		int n = 3;
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < size; i++) {
				if (j % 2 == 0) {
					x[0] = i * widthQ;
					x[1] = (i * widthQ) + middleW;
					x[2] = (widthQ * i) + widthQ;
					y[0] = heightQ + (heightQ * j);
					y[1] = j * heightQ;
					y[2] = heightQ + (heightQ * j);
					g2.fillPolygon(x, y, n);
				} else {
					if (i == 0) {
						x[0] = 0;
						x[1] = 0;
						x[2] = middleW;
						y[0] = heightQ + (heightQ * j);
						y[1] = j * heightQ;
						y[2] = heightQ + (heightQ * j);
						g2.fillPolygon(x, y, n);
					}

					x[0] = (i * widthQ) + middleW;
					x[1] = ((i * widthQ) + middleW) + middleW;
					x[2] = ((widthQ * i) + widthQ) + middleW;
					y[0] = heightQ + (heightQ * j);
					y[1] = j * heightQ;
					y[2] = heightQ + (heightQ * j);
					g2.fillPolygon(x, y, n);
				}
			}
		}

	}

	private Color getRandomColor(int c) {
		switch (c) {

		case 0: {
			r = b = 0;
			break;
		}
		case 1: {
			r = g = 0;
			break;
		}
		case 2: {
			g = b = 0;
			break;
		}
		case 3: {
			r = 0;
			break;
		}
		case 4: {
			g = 0;
			break;
		}
		case 5: {
			b = 0;
			break;
		}
		default:
			break;
		}
		return new Color(r, g, b);

	}

	@Override
	public void repaint() {
		if (fade)
			fade();
		super.repaint();
		Toolkit.getDefaultToolkit().sync();
	}

	private void fade() {
		if (r < 255 && g < 255 && b < 255 && swap) {
			r = g = b = ++cont;
		} else {
			swap = false;
			r = g = b = --cont;
			if (r < 2 && g < 2 && b < 2)
				this.swap = true;
			if (swap) {
				before = color;
				color = (int) (Math.random() * 10) % 7;
				while (before == color) {
					color = (int) (Math.random() * 10) % 7;

				}
			}

		}
	}

}
