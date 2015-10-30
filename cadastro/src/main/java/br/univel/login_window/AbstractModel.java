package br.univel.login_window;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Insets;
import java.awt.event.ActionListener;

public abstract class AbstractModel extends JPanel {
	private JButton btnClose;
	protected abstract void configureInnerPanel();
	public void setCloseAction(ActionListener action){
		btnClose.addActionListener(action);
	}

	/**
	 * Create the panel.
	 */
	public AbstractModel(){
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setMinimumSize(new Dimension(10, 100));
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblLabel = new JLabel("Label");
		GridBagConstraints gbc_lblLabel = new GridBagConstraints();
		gbc_lblLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblLabel.gridx = 0;
		gbc_lblLabel.gridy = 0;
		panel.add(lblLabel, gbc_lblLabel);
		
		btnClose = new JButton("Close");
		GridBagConstraints gbc_btnClose = new GridBagConstraints();
		gbc_btnClose.anchor = GridBagConstraints.EAST;
		gbc_btnClose.gridx = 1;
		gbc_btnClose.gridy = 0;
		panel.add(btnClose, gbc_btnClose);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		configureInnerPanel();
		
	}

}
