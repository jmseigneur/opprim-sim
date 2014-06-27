/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.gui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;

import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.RiskValue;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class RiskPolicyPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public RiskPolicyPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 225, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewAsset = new JLabel("New Risk Policy");
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewAsset.gridwidth = 16;
		gbc_lblNewAsset.gridx = 0;
		gbc_lblNewAsset.gridy = 0;
		lblNewAsset.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblNewAsset, gbc_lblNewAsset);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);

		JTextPane txtpnInOrderTo = new JTextPane();
		txtpnInOrderTo
				.setText("In order to define a custom Risk Policy, the Risk Value of such policy should be first defined in the interval [0...1]. \r\n\r\nA Risk Value of 1.0 implies that the policy user is not allowed or willing to take any risk, whereas a Risk Value of 0.0 implies that the policy user is allowed or willing to take any existing risk.\r\n\r\nThe policy name is the custom name for this particular policy being defined.");
		txtpnInOrderTo.setEditable(false);
		scrollPane.setViewportView(txtpnInOrderTo);

		JLabel lblAddRiskValue = new JLabel("Add Risk Value:");
		GridBagConstraints gbc_lblAddRiskValue = new GridBagConstraints();
		gbc_lblAddRiskValue.anchor = GridBagConstraints.WEST;
		gbc_lblAddRiskValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddRiskValue.gridx = 0;
		gbc_lblAddRiskValue.gridy = 2;
		lblAddRiskValue.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblAddRiskValue, gbc_lblAddRiskValue);

		textField = new JTextField();
		textField.setToolTipText("Add a risk value [0..1]");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblAddPolicyName = new JLabel("Add Policy Name:");
		GridBagConstraints gbc_lblAddPolicyName = new GridBagConstraints();
		gbc_lblAddPolicyName.anchor = GridBagConstraints.WEST;
		gbc_lblAddPolicyName.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddPolicyName.gridx = 0;
		gbc_lblAddPolicyName.gridy = 4;
		lblAddPolicyName.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblAddPolicyName, gbc_lblAddPolicyName);

		textField_1 = new JTextField();
		textField_1.setToolTipText("Name your policy");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 5;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JButton btnSavePolicy = new JButton("Save Policy");
		btnSavePolicy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (textField.getText().isEmpty()
							|| textField_1.getText().isEmpty())
						throw new InputMismatchException();
					if (Double.parseDouble(textField.getText()) > 1.0)
						throw new NumberFormatException();

					RiskPolicy rp = new RiskPolicy(new RiskValue(Double
							.parseDouble(textField.getText()), textField_1
							.getText()), null);
					GuiMain.getPersistenceManager().setRiskPolicies(
							new ArrayList<RiskPolicy>(Arrays.asList(rp)));
					GuiMain.initializeHomePanel();
					JPanel mainPanel = GuiMain.getMainPanel();
					GuiMain.switchPanel(mainPanel);
				} catch (InputMismatchException iEx) {

					JOptionPane.showConfirmDialog(null,
							"All input fields should be filled",
							"Missing Input", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException nEx) {
					JOptionPane.showConfirmDialog(null,
							"Input should be a number between 0 and 1",
							"Wrong Input", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnSavePolicy = new GridBagConstraints();
		gbc_btnSavePolicy.anchor = GridBagConstraints.EAST;
		gbc_btnSavePolicy.insets = new Insets(0, 0, 5, 5);
		gbc_btnSavePolicy.gridx = 1;
		gbc_btnSavePolicy.gridy = 5;
		add(btnSavePolicy, gbc_btnSavePolicy);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 4;
		gbc_verticalStrut_1.gridy = 6;
		add(verticalStrut_1, gbc_verticalStrut_1);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 10;
		gbc_verticalStrut.gridy = 6;
		add(verticalStrut, gbc_verticalStrut);

	}

}
