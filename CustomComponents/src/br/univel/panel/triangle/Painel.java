package br.univel.panel.triangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Painel extends JPanel {
	// alt+s
	/**
	 * Create the panel.
	 */
	private int r, g, b, cont = 0;
	private boolean swap;
	private int color;
	private int before;

	public Painel() {
		setBackground(Color.BLACK);

	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g2 = (Graphics2D) graphics;

		// g2.setColor(getRandomColor(color));
		int w = getWidth() - 1;
		int h = getHeight() - 1;
		int widthQ = w / 8;
		g2.setColor(Color.WHITE);
		int heightQ = h / 8;
		int size = 0;
		int cont = 0;
		int x[] = new int[3];
		int y[] = new int[3];
		int n = 3;
		// g2.fillPolygon(new Polygon(x, y, n));

		for (int j = 0; j < getHeight(); j++) {
			for (int i = 0; i < getWidth(); i++) {
				if (j % 2 == 0) {
					g2.fillPolygon(	new int[] { i*widthQ, (i*widthQ)+(widthQ/2),(widthQ*i)+widthQ },
									new int[] { heightQ+(heightQ*j), j*heightQ, heightQ+(heightQ*j) }, n);
				}else{
					g2.fillPolygon(	new int[] { (i*widthQ)+widthQ/2, ((i*widthQ)+(widthQ/2))+widthQ/2,((widthQ*i)+widthQ)+widthQ/2 },
									new int[] { heightQ+(heightQ*j), j*heightQ, heightQ+(heightQ*j) }, n);
				}
				
//				g2.fillPolygon(
//						new int[] { 0 + i, (widthQ / 2) + i, widthQ + i },
//						new int[] { heightQ, 0, heightQ }, n);
//				g2.fillPolygon(new int[] { widthQ + i,
//						(widthQ + (widthQ / 2)) + i, (widthQ * 2) + i },
//						new int[] { heightQ + j, j, heightQ + j }, n);
//				g2.fillPolygon(new int[] { i, (widthQ / 2) + i, (widthQ) + i },
//						new int[] { j, j - heightQ, j }, n);
			}
			cont++;
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
		// if (r < 255 && g < 255 && b < 255 && swap) {
		// r = g = b = ++cont;
		// } else {
		// swap = false;
		// r = g = b = --cont;
		// if (r < 2 && g < 2 && b < 2)
		// this.swap = true;
		// if (swap) {
		// before = color;
		// color = (int) (Math.random() * 10) % 7;
		// while (before == color) {
		// color = (int) (Math.random() * 10) % 7;
		//
		// }
		// }
		//
		// }

		super.repaint();
		// Toolkit.getDefaultToolkit().sync();
	}

}
