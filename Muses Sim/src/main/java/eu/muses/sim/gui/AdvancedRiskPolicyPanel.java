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
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;

import eu.muses.sim.Outcome;
import eu.muses.sim.decision.Decision;
import eu.muses.sim.riskman.complexpolicy.Argument;
import eu.muses.sim.riskman.complexpolicy.ComplexPolicy;
import eu.muses.sim.riskman.complexpolicy.Operator;
import eu.muses.wp5.Clue;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class AdvancedRiskPolicyPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private ComplexPolicy cPolicy = new ComplexPolicy();
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public AdvancedRiskPolicyPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 0.0,
				0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
		JLabel lblDecision = new JLabel("Decision:");
		lblDecision.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblDecision = new GridBagConstraints();
		gbc_lblDecision.anchor = GridBagConstraints.WEST;
		gbc_lblDecision.insets = new Insets(0, 0, 5, 5);
		gbc_lblDecision.gridx = 3;
		gbc_lblDecision.gridy = 1;
		add(lblDecision, gbc_lblDecision);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 15;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 9;
		add(scrollPane, gbc_scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		final Document document = textPane.getDocument();

		JLabel lblNewAsset = new JLabel("New Advanced Policy");
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewAsset.gridwidth = 17;
		gbc_lblNewAsset.gridx = 0;
		gbc_lblNewAsset.gridy = 0;
		lblNewAsset.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblNewAsset, gbc_lblNewAsset);

		JLabel lblAddClue = new JLabel("Arguments:");
		GridBagConstraints gbc_lblAddClue = new GridBagConstraints();
		gbc_lblAddClue.anchor = GridBagConstraints.WEST;
		gbc_lblAddClue.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddClue.gridx = 0;
		gbc_lblAddClue.gridy = 1;
		lblAddClue.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblAddClue, gbc_lblAddClue);
		
		JLabel lblOperators = new JLabel("Operators:");
		lblOperators.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblOperators = new GridBagConstraints();
		gbc_lblOperators.anchor = GridBagConstraints.WEST;
		gbc_lblOperators.insets = new Insets(0, 0, 5, 5);
		gbc_lblOperators.gridx = 1;
		gbc_lblOperators.gridy = 1;
		add(lblOperators, gbc_lblOperators);
		
		JLabel lblValue = new JLabel("Value:");
		lblValue.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblValue = new GridBagConstraints();
		gbc_lblValue.anchor = GridBagConstraints.WEST;
		gbc_lblValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblValue.gridx = 2;
		gbc_lblValue.gridy = 1;
		add(lblValue, gbc_lblValue);
		
		final JComboBox<Argument> comboBox = new JComboBox<Argument>();
		
		comboBox.addItem(Argument.C_OPP_THREATS_MAX);
		comboBox.addItem(Argument.P_OPP_THREATS_MAX);
		comboBox.addItem(Argument.B_OPP__MAX);
		comboBox.addItem(Argument.P_OPP_MAX);
		comboBox.addItem(Argument.P_BENEFIT_COST);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		
		final JComboBox<Operator> comboBox_1 = new JComboBox<Operator>();
		
		comboBox_1.addItem(Operator.EQUAL);
		comboBox_1.addItem(Operator.DIFFERENT);
		comboBox_1.addItem(Operator.LOWER);
		comboBox_1.addItem(Operator.LOWER_EQUAL);
		comboBox_1.addItem(Operator.GREATER);
		comboBox_1.addItem(Operator.GREATER_EQUAL);
		comboBox_1.addItem(Operator.PLUS);
		comboBox_1.addItem(Operator.MINUS);
		comboBox_1.addItem(Operator.AND);
		comboBox_1.addItem(Operator.OR);
		comboBox_1.addItem(Operator.NOT);
		comboBox_1.addItem(Operator.IF);
		comboBox_1.addItem(Operator.THEN);
		comboBox_1.addItem(Operator.ELSE);
		comboBox_1.addItem(Operator.OP_PAR);
		comboBox_1.addItem(Operator.CL_PAR);
		
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 2;
		add(comboBox_1, gbc_comboBox_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnAddArgument = new JButton("Add Argument");
		btnAddArgument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					document.insertString(document.getLength(), ((Argument)comboBox.getSelectedItem()).toString() + " ", null);
					cPolicy.editTextPolicy(((Argument)comboBox.getSelectedItem()).toString() + " ");
					cPolicy.editLogicalPolicy(((Argument)comboBox.getSelectedItem()).getLogical_representation());
					cPolicy.addArgument((Argument)comboBox.getSelectedItem());
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnAddArgument = new GridBagConstraints();
		gbc_btnAddArgument.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddArgument.gridx = 0;
		gbc_btnAddArgument.gridy = 3;
		add(btnAddArgument, gbc_btnAddArgument);
		
		JButton btnAddOperator = new JButton("Add Operator");
		btnAddOperator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					document.insertString(document.getLength(), ((Operator)comboBox_1.getSelectedItem()).toString() + " ", null);
					cPolicy.editTextPolicy(((Operator)comboBox_1.getSelectedItem()).toString() + " ");
					if(!((Operator)comboBox_1.getSelectedItem()).getTextualRepresentation().matches("IF|THEN|ELSE")){
					cPolicy.editLogicalPolicy(((Operator)comboBox_1.getSelectedItem()).getLogical_representation());
					}
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnAddOperator = new GridBagConstraints();
		gbc_btnAddOperator.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddOperator.gridx = 1;
		gbc_btnAddOperator.gridy = 3;
		add(btnAddOperator, gbc_btnAddOperator);
		
		JButton btnAddValue = new JButton("Add Value");
		btnAddValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					document.insertString(document.getLength(), textField.getText() + " ", null);
					cPolicy.editTextPolicy(textField.getText() + " ");
					cPolicy.editLogicalPolicy(textField.getText());
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnAddValue = new GridBagConstraints();
		gbc_btnAddValue.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddValue.gridx = 2;
		gbc_btnAddValue.gridy = 3;
		add(btnAddValue, gbc_btnAddValue);
		
		final JComboBox<Decision> comboBox_2 = new JComboBox<Decision>();
		
		comboBox_2.addItem(Decision.ALLOW_ACCESS);
		comboBox_2.addItem(Decision.STRONG_DENY_ACCESS);
		comboBox_2.addItem(Decision.MAYBE_ACCESS);
		comboBox_2.addItem(Decision.ON_YOUR_RISK_ACCESS);
		
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 3;
		gbc_comboBox_2.gridy = 2;
		add(comboBox_2, gbc_comboBox_2);
		
		JButton btnAddDecision = new JButton("Add Decision");
		btnAddDecision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					document.insertString(document.getLength(), ((Decision)comboBox_2.getSelectedItem()).toString() + " ", null);
					cPolicy.editTextPolicy(((Decision)comboBox_2.getSelectedItem()).toString() + " ");
					cPolicy.addDecision((Decision)comboBox_2.getSelectedItem());
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnAddDecision = new GridBagConstraints();
		gbc_btnAddDecision.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddDecision.gridx = 3;
		gbc_btnAddDecision.gridy = 3;
		add(btnAddDecision, gbc_btnAddDecision);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 13;
		gbc_verticalStrut_1.gridy = 3;
		add(verticalStrut_1, gbc_verticalStrut_1);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 13;
		gbc_verticalStrut.gridy = 4;
		add(verticalStrut, gbc_verticalStrut);
						
		JLabel lblPolicyName = new JLabel("Policy Name:");
		GridBagConstraints gbc_lblPolicyName = new GridBagConstraints();
		gbc_lblPolicyName.anchor = GridBagConstraints.EAST;
		gbc_lblPolicyName.insets = new Insets(0, 0, 5, 5);
		gbc_lblPolicyName.gridx = 1;
		gbc_lblPolicyName.gridy = 11;
		add(lblPolicyName, gbc_lblPolicyName);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 11;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
								JButton btnSaveClue = new JButton("Save Policy");
								btnSaveClue.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										try {
											cPolicy.setName(textField_1.getText());
											GuiMain.getPersistenceManager().setComplexPolicies(
													new ArrayList<ComplexPolicy>(Arrays.asList(cPolicy)));
											JPanel policyEvalPanel = new ComplexPolicyEvaluationPanel();
											GuiMain.switchPanel(policyEvalPanel);
										} catch (Exception ex) {
											ex.printStackTrace();
											JOptionPane.showConfirmDialog(null,
													"Input should be correctly filled", "Wrong Input",
													JOptionPane.OK_CANCEL_OPTION,
													JOptionPane.ERROR_MESSAGE);
										}

									}
								});
								
								GridBagConstraints gbc_btnSaveClue = new GridBagConstraints();
								gbc_btnSaveClue.anchor = GridBagConstraints.EAST;
								gbc_btnSaveClue.insets = new Insets(0, 0, 5, 5);
								gbc_btnSaveClue.gridx = 6;
								gbc_btnSaveClue.gridy = 11;
								add(btnSaveClue, gbc_btnSaveClue);
	}

}
