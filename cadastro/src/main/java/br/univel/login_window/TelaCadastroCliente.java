package br.univel.login_window;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaCadastroCliente extends AbstractModel {

	/**
	 * Create the panel.
	 */
	public TelaCadastroCliente() {
		super();
	}

	@Override
	protected void configureInnerPanel() {
		super.add(new InnerPanel(), BorderLayout.CENTER);
		
	}

}
