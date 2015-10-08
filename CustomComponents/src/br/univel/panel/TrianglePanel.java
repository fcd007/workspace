package br.univel.panel;

import java.awt.Graphics;
import java.awt.Graphics2D;


public class TrianglePanel extends AbstractPanel {
	// alt+s
	/**
	 * Create the panel.
	 */

	public TrianglePanel(int separation, boolean fade) {
		super(separation, fade);
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g2 = (Graphics2D) graphics;
		g2.setColor(getRandomColor());
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

}
