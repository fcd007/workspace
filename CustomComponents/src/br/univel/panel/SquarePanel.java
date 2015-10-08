package br.univel.panel;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class SquarePanel extends AbstractPanel {
	public SquarePanel(int separation, boolean fade) {
		super(separation, fade);
	}

	// alt+s
	/**
	 * Create the panel.
	 */

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g2 = (Graphics2D) graphics;
		g2.setColor(getRandomColor());
		int w = getWidth() - 1;
		int h = getHeight() - 1;
		int widthQ = w / size;
		int heightQ = h / size;

		for (int j = 0; j < size; j++) {
			for (int i = 0; i < size; i++) {
				if (j % 2 == 0)
					g2.fillRect((widthQ * i*2)+widthQ, heightQ*j, widthQ, heightQ);
				else{
					g2.fillRect((widthQ * i*2), heightQ*j, widthQ, heightQ);
				}
			}
		}

	}

}
