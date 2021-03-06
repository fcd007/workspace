package br.univel.panel;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JPanel;

public abstract class AbstractPanel extends JPanel{
	private int r, g, b, cont;
	private boolean swap=true;
	protected int color = -1;
	private int before;
	protected final int size;
	private boolean fade;

	public AbstractPanel(int separation, boolean fade) {
		setBackground(Color.BLACK);
		this.size = separation;
		this.fade = fade;
		r = g = b = cont = 0;
	}
	
	
	protected Color getRandomColor() {
		switch (color) {
		case -1:{
			r =g =b =255;
			break;
		}

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
			if (r < 1 && g < 1 && b < 1)
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
