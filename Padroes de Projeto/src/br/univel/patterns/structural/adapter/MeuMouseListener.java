package br.univel.patterns.structural.adapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MeuMouseListener extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click");
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		System.out.println("scroll");
	}

}
