/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.gui;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import eu.muses.sim.Outcome;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.opportunity.Opportunity;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpportunityPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OpportunityPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewAsset = new JLabel("New Opportunity");
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewAsset.gridwidth = 16;
		gbc_lblNewAsset.gridx = 0;
		gbc_lblNewAsset.gridy = 0;
		lblNewAsset.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblNewAsset, gbc_lblNewAsset);

		JLabel lblAddAThreat = new JLabel("Add an Opportunity Description:");
		GridBagConstraints gbc_lblAddAThreat = new GridBagConstraints();
		gbc_lblAddAThreat.anchor = GridBagConstraints.WEST;
		gbc_lblAddAThreat.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddAThreat.gridx = 0;
		gbc_lblAddAThreat.gridy = 1;
		lblAddAThreat.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblAddAThreat, gbc_lblAddAThreat);

		final JTextField textField = new JTextField();
		textField
				.setToolTipText("Add a textual description of the opportunity");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 13;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblAttachAnOutcome = new JLabel(
				"Attach an Outcome to the Opportunity:");
		GridBagConstraints gbc_lblAttachAnOutcome = new GridBagConstraints();
		gbc_lblAttachAnOutcome.anchor = GridBagConstraints.WEST;
		gbc_lblAttachAnOutcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttachAnOutcome.gridx = 0;
		gbc_lblAttachAnOutcome.gridy = 3;
		lblAttachAnOutcome.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblAttachAnOutcome, gbc_lblAttachAnOutcome);

		final JComboBox<Outcome> comboBox = new JComboBox<Outcome>();
		if (GuiMain.getPersistenceManager().getOutcomes() != null
				&& !GuiMain.getPersistenceManager().getOutcomes().isEmpty()) {
			for (Outcome o : GuiMain.getPersistenceManager().getOutcomes()) {
				comboBox.addItem(o);
			}
		} else {
			comboBox.setModel(new DefaultComboBoxModel(
					new String[] { "ADD OUTCOMES FIRST" }));
		}

		JButton btnSaveThreat = new JButton("Save Opportunity");
		btnSaveThreat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (textField.getText().isEmpty())
						throw new Exception();
					Opportunity op = new Opportunity(textField.getText(),
							new Probability(0.5), (Outcome) comboBox
									.getSelectedItem());
					GuiMain.getPersistenceManager().setOpportunities(
							new ArrayList<Opportunity>(Arrays.asList(op)));
					GuiMain.initializeHomePanel();
					JPanel mainPanel = GuiMain.getMainPanel();
					GuiMain.switchPanel(mainPanel);
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showConfirmDialog(null,
							"Input should be correctly filled", "Wrong Input",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		GridBagConstraints gbc_btnSaveThreat = new GridBagConstraints();
		gbc_btnSaveThreat.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaveThreat.gridx = 12;
		gbc_btnSaveThreat.gridy = 3;
		add(btnSaveThreat, gbc_btnSaveThreat);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 4;
		add(comboBox, gbc_comboBox);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 10;
		gbc_verticalStrut.gridy = 5;
		add(verticalStrut, gbc_verticalStrut);
	}

}
