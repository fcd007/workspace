package br.univel.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Painel extends JPanel {
	// alt+s
	/**
	 * Create the panel.
	 */
	Graphics2D g2;
	public Painel() {
		setBackground(Color.BLACK);
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 1000; i++) {
					try {
						Thread.sleep(2000);
//						g2.setColor(new Color(100, 80, 56));
						repaint();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();

	}

	@Override
	protected void paintComponent(Graphics g) {
		
		g2 = g2 == null ? (Graphics2D)g : g2;
		super.paintComponent(g);
		g2.setColor(Color.WHITE);
		int w = getWidth() - 1;
		int h = getHeight() - 1;
		int widthQ = w / 8;
		int heightQ = h / 8;
		int size = 0;
		int cont = 0;
//		g2.setColor(Color.BLACK);
		g2.setColor(new Color(100, 80, 56));
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

}
