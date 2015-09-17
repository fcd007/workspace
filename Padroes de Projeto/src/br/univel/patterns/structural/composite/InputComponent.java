package br.univel.patterns.structural.composite;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputComponent extends JComponent {

	private static final long serialVersionUID = -4012177609466865173L;

	private JLabel label;
	private JTextField textfield;

	public InputComponent() {
		setLayout(new BorderLayout());
		label = new JLabel("Nome");
		label.setOpaque(true);
		super.add(BorderLayout.WEST, label);

		textfield = new JTextField();
		super.add(BorderLayout.CENTER, textfield);
	}

	@Override
	public void setBackground(Color bg) {
		this.label.setBackground(bg);
		this.textfield.setBackground(bg);

	}

}
