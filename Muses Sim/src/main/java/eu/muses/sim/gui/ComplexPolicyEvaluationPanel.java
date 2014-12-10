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
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;

import eu.muses.sim.OpportunityDescriptor;
import eu.muses.sim.decision.CorporateUserAccessRequestDecision;
import eu.muses.sim.decision.Decision;
import eu.muses.sim.persistence.PersistenceManager;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.RiskTreatment;
import eu.muses.sim.riskman.RiskValue;
import eu.muses.sim.riskman.SecurityIncident;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.complexpolicy.ComplexPolicy;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.userman.action.AccessAction;
import eu.muses.sim.userman.action.GiveUpAction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.udojava.evalex.Expression;

public class ComplexPolicyEvaluationPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ComplexPolicy cp;
	private BigDecimal result = null;

	/**
	 * Create the panel.
	 */
	public ComplexPolicyEvaluationPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 1.0,
				0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 15;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);

		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

		final Document document = textPane.getDocument();

		JLabel lblNewAsset = new JLabel("Complex Policy Evaluation");
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewAsset.gridwidth = 17;
		gbc_lblNewAsset.gridx = 0;
		gbc_lblNewAsset.gridy = 0;
		lblNewAsset.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblNewAsset, gbc_lblNewAsset);

		JLabel lblSelectPolicy = new JLabel("Select Policy: ");
		GridBagConstraints gbc_lblSelectPolicy = new GridBagConstraints();
		gbc_lblSelectPolicy.anchor = GridBagConstraints.EAST;
		gbc_lblSelectPolicy.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectPolicy.gridx = 1;
		gbc_lblSelectPolicy.gridy = 1;
		add(lblSelectPolicy, gbc_lblSelectPolicy);

		final JComboBox<ComplexPolicy> comboBox = new JComboBox<ComplexPolicy>();

		if (!GuiMain.getPersistenceManager().getComplexPolicies().isEmpty()) {
			for (ComplexPolicy cp : GuiMain.getPersistenceManager()
					.getComplexPolicies()) {
				comboBox.addItem(cp);
			}
		} else {
			comboBox.setModel(new DefaultComboBoxModel(
					new String[] { "ADD COMPLEX RISK POLICIES FIRST" }));
		}

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cp = (ComplexPolicy) comboBox.getSelectedItem();
				try {
					document.insertString(document.getLength(),
							"Policy to evaluate: \n" + cp.getTextPolicy(), null);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		add(comboBox, gbc_comboBox);

		JLabel lblNewLabel = new JLabel("Max. threat cost (a):");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		textField.setText("0");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblMaxOppBenefit = new JLabel("Max. opp benefit (c):");
		GridBagConstraints gbc_lblMaxOppBenefit = new GridBagConstraints();
		gbc_lblMaxOppBenefit.anchor = GridBagConstraints.WEST;
		gbc_lblMaxOppBenefit.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxOppBenefit.gridx = 3;
		gbc_lblMaxOppBenefit.gridy = 2;
		add(lblMaxOppBenefit, gbc_lblMaxOppBenefit);

		textField_2 = new JTextField();
		textField_2.setText("0");
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 2;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Probability of benefit (e):");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 2;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		textField_4 = new JTextField();
		textField_4.setText("0");
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 6;
		gbc_textField_4.gridy = 2;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Max. threat prob (b):");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setText("0");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Max. opp prob (d):");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		textField_3 = new JTextField();
		textField_3.setText("0");
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 3;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 12;
		gbc_verticalStrut_1.gridy = 5;
		add(verticalStrut_1, gbc_verticalStrut_1);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 12;
		gbc_verticalStrut.gridy = 6;
		add(verticalStrut, gbc_verticalStrut);

		final JButton btnRunSimulation = new JButton("Evaluate Policy");

		GridBagConstraints gbc_btnRunSimulation = new GridBagConstraints();
		gbc_btnRunSimulation.insets = new Insets(0, 0, 5, 5);
		gbc_btnRunSimulation.gridx = 14;
		gbc_btnRunSimulation.gridy = 6;
		add(btnRunSimulation, gbc_btnRunSimulation);

		JButton btnSaveAsset = new JButton("Go Back");
		btnSaveAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GuiMain.initializeHomePanel();
					JPanel mainPanel = GuiMain.getMainPanel();
					GuiMain.switchPanel(mainPanel);
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showConfirmDialog(null,
							"Something went wrong with the simulation",
							"Error", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnSaveAsset = new GridBagConstraints();
		gbc_btnSaveAsset.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaveAsset.gridx = 15;
		gbc_btnSaveAsset.gridy = 6;
		add(btnSaveAsset, gbc_btnSaveAsset);

		btnRunSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					document.insertString(document.getLength(),
							"\n\nLogical format: \n" + cp.getLogicalPolicy(),
							null);
					result = new Expression(cp.getLogicalPolicy())
							.with("a", textField.getText())
							.and("b", textField_1.getText())
							.and("c", textField_2.getText())
							.and("d", textField_3.getText())
							.and("e", textField_4.getText()).eval();
					
					if(result.intValue() == 1){
					document.insertString(document.getLength(),
							"\n\nResult: \n TRUE" + "\n\nDecision: \n" + cp.getDecisions().get(0).toString(),
							null);
					}else{
						if(cp.getDecisions().size() < 2)
							cp.addDecision(Decision.STRONG_DENY_ACCESS);
						document.insertString(document.getLength(),
								"\n\nResult: \n FALSE" + "\n\nDecision: \n" + cp.getDecisions().get(1).toString(),
								null);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showConfirmDialog(null,
							"Something went wrong with the evaluation",
							"Error", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

}
