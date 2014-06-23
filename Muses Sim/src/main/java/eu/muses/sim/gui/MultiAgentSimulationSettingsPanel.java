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
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;

import eu.muses.sim.OpportunityDescriptor;
import eu.muses.sim.Outcome;
import eu.muses.sim.persistence.InMemoryPersistenceManager;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.opportunity.Opportunity;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.userman.action.AccessAction;
import eu.muses.sim.userman.action.GiveUpAction;
import eu.muses.wp5.Clue;
import eu.muses.wp5.CluesThreatTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;

public class MultiAgentSimulationSettingsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	SimUser u;

	/**
	 * Create the panel.
	 */
	public MultiAgentSimulationSettingsPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewAsset = new JLabel("Multi-Agent Simulation Settings");
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewAsset.gridwidth = 17;
		gbc_lblNewAsset.gridx = 1;
		gbc_lblNewAsset.gridy = 0;
		lblNewAsset.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblNewAsset, gbc_lblNewAsset);

		JLabel lblAsset = new JLabel("Asset");
		lblAsset.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblAsset = new GridBagConstraints();
		gbc_lblAsset.anchor = GridBagConstraints.WEST;
		gbc_lblAsset.insets = new Insets(0, 0, 5, 5);
		gbc_lblAsset.gridx = 1;
		gbc_lblAsset.gridy = 1;
		add(lblAsset, gbc_lblAsset);

		final JComboBox<Asset> comboBox = new JComboBox<Asset>();
		if (!GuiMain.getPersistenceManager().getAssets().isEmpty()) {
			for (Asset a : GuiMain.getPersistenceManager().getAssets()) {
				comboBox.addItem(a);
			}
		} else {
			comboBox.setModel(new DefaultComboBoxModel(
					new String[] { "ADD ASSETS FIRST" }));
		}

		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.WEST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 4;
		gbc_lblUser.gridy = 1;
		add(lblUser, gbc_lblUser);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);

		final JComboBox<SimUser> comboBox_1 = new JComboBox<SimUser>();
		if (!GuiMain.getPersistenceManager().getSimUsers().isEmpty()) {
			for (SimUser u : GuiMain.getPersistenceManager().getSimUsers()) {
				comboBox_1.addItem(u);
			}
		} else {
			comboBox_1.setModel(new DefaultComboBoxModel(
					new String[] { "ADD USERS FIRST" }));
		}
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 2;
		add(comboBox_1, gbc_comboBox_1);

		JLabel lblOpportunity = new JLabel("Opportunity");
		lblOpportunity.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblOpportunity = new GridBagConstraints();
		gbc_lblOpportunity.anchor = GridBagConstraints.WEST;
		gbc_lblOpportunity.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpportunity.gridx = 1;
		gbc_lblOpportunity.gridy = 3;
		add(lblOpportunity, gbc_lblOpportunity);

		JLabel lblClues = new JLabel("Clues");
		lblClues.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblClues = new GridBagConstraints();
		gbc_lblClues.anchor = GridBagConstraints.WEST;
		gbc_lblClues.insets = new Insets(0, 0, 5, 5);
		gbc_lblClues.gridx = 4;
		gbc_lblClues.gridy = 3;
		add(lblClues, gbc_lblClues);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 14;
		gbc_verticalStrut_1.gridy = 3;
		add(verticalStrut_1, gbc_verticalStrut_1);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);

		final DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Opportunity Description");
		model.addColumn("Probability");

		for (Opportunity op : GuiMain.getPersistenceManager()
				.getOpportunities()) {
			model.addRow(new String[] { op.getDescription(),
					String.valueOf(op.getProbability().getProb()) });
		}

		table = new JTable(model);
		table.setToolTipText("Select an oportunity, you can select multiple items by holding Shift key");
		scrollPane.setViewportView(table);

		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u = (SimUser) comboBox_1.getSelectedItem();
				model.addRow(new String[] {
						"If user works the company will not lose "
								+ u.getHourlyCost() + " per hour of inactivity",
						String.valueOf(u.getTrustValue().getValue()) });
			}
		});

		DefaultTableModel model2 = new DefaultTableModel();
		model2.addColumn("Clue Name");

		for (Clue cl : GuiMain.getPersistenceManager().getClues()) {
			model2.addRow(new String[] { cl.getId() });
		}

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 4;
		gbc_scrollPane_1.gridy = 4;
		add(scrollPane_1, gbc_scrollPane_1);

		table_1 = new JTable(model2);
		table_1.setToolTipText("Select one or more clues, you can select multiple items by holding Shift key");
		scrollPane_1.setViewportView(table_1);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 14;
		gbc_verticalStrut.gridy = 4;
		add(verticalStrut, gbc_verticalStrut);

		JLabel lblRiskPolicy = new JLabel("Risk Policy");
		lblRiskPolicy.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblRiskPolicy = new GridBagConstraints();
		gbc_lblRiskPolicy.anchor = GridBagConstraints.WEST;
		gbc_lblRiskPolicy.insets = new Insets(0, 0, 5, 5);
		gbc_lblRiskPolicy.gridx = 1;
		gbc_lblRiskPolicy.gridy = 5;
		add(lblRiskPolicy, gbc_lblRiskPolicy);

		final JComboBox<RiskPolicy> comboBox_2 = new JComboBox<RiskPolicy>();
		if (!GuiMain.getPersistenceManager().getRiskPolicies().isEmpty()) {
			for (RiskPolicy rp : GuiMain.getPersistenceManager()
					.getRiskPolicies()) {
				comboBox_2.addItem(rp);
			}
		} else {
			comboBox_1.setModel(new DefaultComboBoxModel(
					new String[] { "ADD RISK POLICIES FIRST" }));
		}
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.gridwidth = 3;
		gbc_comboBox_2.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 1;
		gbc_comboBox_2.gridy = 6;
		add(comboBox_2, gbc_comboBox_2);

		final JCheckBox chckbxUserWillNot = new JCheckBox(
				"User will not acces the asset");
		chckbxUserWillNot
				.setToolTipText("Decides whether the user will finally give up accessing the asset or not in case of an ambiguous or risky access recommendation");
		GridBagConstraints gbc_chckbxUserWillNot = new GridBagConstraints();
		gbc_chckbxUserWillNot.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxUserWillNot.gridx = 4;
		gbc_chckbxUserWillNot.gridy = 6;
		add(chckbxUserWillNot, gbc_chckbxUserWillNot);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int opRow = table.getSelectedRow();
					int[] clueRows = table_1.getSelectedRows();
					AccessRequest accessRequest = SimUser
							.requestsAccessToAsset(GuiMain
									.getMaterialForPatentProposal());
					OpportunityDescriptor opportunityDescriptor = new OpportunityDescriptor();
					opportunityDescriptor.setDescription((String) table
							.getValueAt(opRow, 0));
					opportunityDescriptor.addOutcome(new Outcome((String) table
							.getValueAt(opRow, 0), u.getHourlyCost()));
					opportunityDescriptor.addRequestedAsset((Asset) comboBox
							.getSelectedItem());
					accessRequest
							.setOpportunityDescriptor(opportunityDescriptor);
					accessRequest.setUser((SimUser) comboBox_1
							.getSelectedItem());
					if (chckbxUserWillNot.isSelected()) {
						accessRequest.setUserAction(new GiveUpAction());
					} else {
						accessRequest.setUserAction(new AccessAction());
					}
					List<Clue> clues = new ArrayList<Clue>();
					for (int i : clueRows) {
						clues.add(new Clue((String) table_1.getValueAt(i, 0)));
					}
					GuiMain.getS2EventCorrelator().setClues(clues);
					GuiMain.setAccessRequest(accessRequest);
					GuiMain.getS2Rt2ae().setRiskPolicy(
							(RiskPolicy) comboBox_2.getSelectedItem());
					JPanel simPanel = new MultiAgentSimulationPanel();
					GuiMain.switchPanel(simPanel);
				} catch (Exception ex) {
					JOptionPane
							.showConfirmDialog(
									null,
									"At least one element of each type should be selected",
									"Simulation Error",
									JOptionPane.OK_CANCEL_OPTION,
									JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.anchor = GridBagConstraints.EAST;
		gbc_btnNext.insets = new Insets(0, 0, 0, 5);
		gbc_btnNext.gridx = 5;
		gbc_btnNext.gridy = 6;
		add(btnNext, gbc_btnNext);

	}

}
