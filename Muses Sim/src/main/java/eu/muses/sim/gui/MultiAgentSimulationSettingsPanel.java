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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JButton;

import eu.muses.sim.OpportunityDescriptor;
import eu.muses.sim.Outcome;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.trustman.TrustValue;
import eu.muses.sim.userman.action.AccessAction;
import eu.muses.sim.userman.action.GiveUpAction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JComboBox;

public class MultiAgentSimulationSettingsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public MultiAgentSimulationSettingsPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblMultiagentSimulationSettings = new JLabel(
				"Multi-Agent Simulation Settings");
		lblMultiagentSimulationSettings.setFont(new Font("Arial", Font.PLAIN,
				20));
		GridBagConstraints gbc_lblMultiagentSimulationSettings = new GridBagConstraints();
		gbc_lblMultiagentSimulationSettings.insets = new Insets(0, 0, 5, 0);
		gbc_lblMultiagentSimulationSettings.gridwidth = 29;
		gbc_lblMultiagentSimulationSettings.gridx = 0;
		gbc_lblMultiagentSimulationSettings.gridy = 0;
		add(lblMultiagentSimulationSettings,
				gbc_lblMultiagentSimulationSettings);

		JLabel lblSimulationUsers = new JLabel("Simulation Users:");
		lblSimulationUsers.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblSimulationUsers = new GridBagConstraints();
		gbc_lblSimulationUsers.anchor = GridBagConstraints.WEST;
		gbc_lblSimulationUsers.insets = new Insets(0, 0, 5, 5);
		gbc_lblSimulationUsers.gridx = 0;
		gbc_lblSimulationUsers.gridy = 1;
		add(lblSimulationUsers, gbc_lblSimulationUsers);

		final JLabel label = new JLabel("100");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		add(label, gbc_label);

		final JSlider slider_1 = new JSlider();
		slider_1.setBackground(Color.WHITE);
		slider_1.setMajorTickSpacing(1000);
		slider_1.setValue(100);
		slider_1.setMinorTickSpacing(500);
		slider_1.setMaximum(10000);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setLabelTable(slider_1.createStandardLabels(1000));
		GridBagConstraints gbc_slider_1 = new GridBagConstraints();
		gbc_slider_1.insets = new Insets(0, 0, 5, 5);
		gbc_slider_1.gridwidth = 16;
		gbc_slider_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider_1.gridx = 0;
		gbc_slider_1.gridy = 2;
		add(slider_1, gbc_slider_1);

		JLabel lblSimulationAssets = new JLabel("Simulation Assets:");
		lblSimulationAssets.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblSimulationAssets = new GridBagConstraints();
		gbc_lblSimulationAssets.anchor = GridBagConstraints.WEST;
		gbc_lblSimulationAssets.insets = new Insets(0, 0, 5, 5);
		gbc_lblSimulationAssets.gridx = 0;
		gbc_lblSimulationAssets.gridy = 3;
		add(lblSimulationAssets, gbc_lblSimulationAssets);

		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				if (!slider.getValueIsAdjusting()) {
					label.setText(String.valueOf(slider.getValue()));
				}
			}
		});

		final JSlider slider_2 = new JSlider();
		slider_2.setBackground(Color.WHITE);
		slider_2.setMajorTickSpacing(1000);
		slider_2.setMinorTickSpacing(500);
		slider_2.setMaximum(10000);
		slider_2.setPaintTicks(true);
		slider_2.setPaintLabels(true);
		slider_2.setLabelTable(slider_1.createStandardLabels(1000));

		final JLabel label_1 = new JLabel("50");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 3;
		add(label_1, gbc_label_1);
		GridBagConstraints gbc_slider_2 = new GridBagConstraints();
		gbc_slider_2.insets = new Insets(0, 0, 5, 5);
		gbc_slider_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider_2.gridwidth = 16;
		gbc_slider_2.gridx = 0;
		gbc_slider_2.gridy = 4;
		add(slider_2, gbc_slider_2);

		JLabel lblAccessRequestsPer = new JLabel("Access Requests per user:");
		lblAccessRequestsPer.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblAccessRequestsPer = new GridBagConstraints();
		gbc_lblAccessRequestsPer.anchor = GridBagConstraints.WEST;
		gbc_lblAccessRequestsPer.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccessRequestsPer.gridx = 0;
		gbc_lblAccessRequestsPer.gridy = 5;
		add(lblAccessRequestsPer, gbc_lblAccessRequestsPer);

		textField = new JTextField();
		textField.setText("24");
		textField.setToolTipText("only positive numbers");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 5;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JCheckBox chckbxUserCanAccess = new JCheckBox(
				"User CANNOT access an asset more than once");
		GridBagConstraints gbc_chckbxUserCanAccess = new GridBagConstraints();
		gbc_chckbxUserCanAccess.anchor = GridBagConstraints.WEST;
		gbc_chckbxUserCanAccess.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxUserCanAccess.gridx = 2;
		gbc_chckbxUserCanAccess.gridy = 5;
		add(chckbxUserCanAccess, gbc_chckbxUserCanAccess);

		slider_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				if (!slider.getValueIsAdjusting()) {
					label_1.setText(String.valueOf(slider.getValue()));
				}
			}
		});

		JCheckBox chckbxNewCheckBox = new JCheckBox(
				"User should always access the same asset");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 3;
		gbc_chckbxNewCheckBox.gridy = 5;
		add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		final JCheckBox chckbxUseOpportunities = new JCheckBox(
				"Use opportunities");
		GridBagConstraints gbc_chckbxUseOpportunities = new GridBagConstraints();
		gbc_chckbxUseOpportunities.anchor = GridBagConstraints.WEST;
		gbc_chckbxUseOpportunities.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxUseOpportunities.gridx = 4;
		gbc_chckbxUseOpportunities.gridy = 5;
		add(chckbxUseOpportunities, gbc_chckbxUseOpportunities);

		final JCheckBox chckbxUseRiskTreatment = new JCheckBox(
				"Use risk treatment");
		GridBagConstraints gbc_chckbxUseRiskTreatment = new GridBagConstraints();
		gbc_chckbxUseRiskTreatment.anchor = GridBagConstraints.WEST;
		gbc_chckbxUseRiskTreatment.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxUseRiskTreatment.gridx = 5;
		gbc_chckbxUseRiskTreatment.gridy = 5;
		add(chckbxUseRiskTreatment, gbc_chckbxUseRiskTreatment);

		JLabel lblFixedValue = new JLabel("Fixed value [0...1]");
		lblFixedValue.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblFixedValue = new GridBagConstraints();
		gbc_lblFixedValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblFixedValue.gridx = 2;
		gbc_lblFixedValue.gridy = 6;
		add(lblFixedValue, gbc_lblFixedValue);

		final JCheckBox chckbxRandomTrustValues = new JCheckBox(
				"Random trust values");
		GridBagConstraints gbc_chckbxRandomTrustValues = new GridBagConstraints();
		gbc_chckbxRandomTrustValues.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxRandomTrustValues.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxRandomTrustValues.gridx = 0;
		gbc_chckbxRandomTrustValues.gridy = 7;
		add(chckbxRandomTrustValues, gbc_chckbxRandomTrustValues);

		JLabel lblOr = new JLabel("- OR -");
		lblOr.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblOr = new GridBagConstraints();
		gbc_lblOr.insets = new Insets(0, 0, 5, 5);
		gbc_lblOr.gridx = 1;
		gbc_lblOr.gridy = 7;
		add(lblOr, gbc_lblOr);

		textField_1 = new JTextField();
		textField_1.setText("0.5");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 7;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblOfUsers = new JLabel(
				"% of users who will give up due to distraction: ");
		lblOfUsers.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblOfUsers = new GridBagConstraints();
		gbc_lblOfUsers.insets = new Insets(0, 0, 5, 5);
		gbc_lblOfUsers.gridx = 0;
		gbc_lblOfUsers.gridy = 8;
		add(lblOfUsers, gbc_lblOfUsers);

		final JLabel label_2 = new JLabel("0");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 8;
		add(label_2, gbc_label_2);

		JLabel lblOfUsers_1 = new JLabel(
				"% of users who will give up due to risk: ");
		lblOfUsers_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblOfUsers_1 = new GridBagConstraints();
		gbc_lblOfUsers_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblOfUsers_1.gridx = 2;
		gbc_lblOfUsers_1.gridy = 8;
		add(lblOfUsers_1, gbc_lblOfUsers_1);

		final JLabel label_3 = new JLabel("0");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 3;
		gbc_label_3.gridy = 8;
		add(label_3, gbc_label_3);

		final JSlider slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setValue(0);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider.insets = new Insets(0, 0, 5, 5);
		gbc_slider.gridx = 0;
		gbc_slider.gridy = 9;
		add(slider, gbc_slider);

		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				if (!slider.getValueIsAdjusting()) {
					label_2.setText(String.valueOf(slider.getValue()) + "%");
				}
			}
		});

		final JSlider slider_3 = new JSlider();
		slider_3.setSnapToTicks(true);
		slider_3.setValue(0);
		slider_3.setMajorTickSpacing(10);
		slider_3.setMinorTickSpacing(5);
		slider_3.setPaintTicks(true);
		slider_3.setPaintLabels(true);
		GridBagConstraints gbc_slider_3 = new GridBagConstraints();
		gbc_slider_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider_3.insets = new Insets(0, 0, 5, 5);
		gbc_slider_3.gridx = 2;
		gbc_slider_3.gridy = 9;
		add(slider_3, gbc_slider_3);

		slider_3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				if (!slider.getValueIsAdjusting()) {
					label_3.setText(String.valueOf(slider.getValue()) + "%");
				}
			}
		});

		final JCheckBox chckbxRandomRiskPolicy = new JCheckBox(
				"Random risk policy for each user");
		GridBagConstraints gbc_chckbxRandomRiskPolicy = new GridBagConstraints();
		gbc_chckbxRandomRiskPolicy.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxRandomRiskPolicy.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxRandomRiskPolicy.gridx = 0;
		gbc_chckbxRandomRiskPolicy.gridy = 10;
		add(chckbxRandomRiskPolicy, gbc_chckbxRandomRiskPolicy);

		JLabel lblOr_1 = new JLabel("- OR -");
		lblOr_1.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblOr_1 = new GridBagConstraints();
		gbc_lblOr_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblOr_1.gridx = 1;
		gbc_lblOr_1.gridy = 10;
		add(lblOr_1, gbc_lblOr_1);

		final JComboBox<RiskPolicy> comboBox = new JComboBox<RiskPolicy>();
		if (!GuiMain.getPersistenceManager().getRiskPolicies().isEmpty()) {
			for (RiskPolicy rp : GuiMain.getPersistenceManager()
					.getRiskPolicies()) {
				comboBox.addItem(rp);
			}
		} else {
			comboBox.setModel(new DefaultComboBoxModel(
					new String[] { "ADD RISK POLICIES FIRST" }));
		}

		comboBox.setSelectedIndex(1);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 10;
		add(comboBox, gbc_comboBox);

		JLabel lblSelectOne = new JLabel("Select one");
		GridBagConstraints gbc_lblSelectOne = new GridBagConstraints();
		gbc_lblSelectOne.anchor = GridBagConstraints.WEST;
		gbc_lblSelectOne.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectOne.gridx = 3;
		gbc_lblSelectOne.gridy = 10;
		add(lblSelectOne, gbc_lblSelectOne);

		JLabel lblLikelihoodThat = new JLabel(
				"% likelihood that the asset will be compromised:");
		lblLikelihoodThat.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblLikelihoodThat = new GridBagConstraints();
		gbc_lblLikelihoodThat.insets = new Insets(0, 0, 5, 5);
		gbc_lblLikelihoodThat.gridx = 0;
		gbc_lblLikelihoodThat.gridy = 11;
		add(lblLikelihoodThat, gbc_lblLikelihoodThat);

		final JLabel label_4 = new JLabel("0");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 11;
		add(label_4, gbc_label_4);

		final JSlider slider_4 = new JSlider();
		slider_4.setSnapToTicks(true);
		slider_4.setMajorTickSpacing(10);
		slider_4.setMinorTickSpacing(5);
		slider_4.setValue(0);
		slider_4.setPaintTicks(true);
		slider_4.setPaintLabels(true);
		GridBagConstraints gbc_slider_4 = new GridBagConstraints();
		gbc_slider_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider_4.insets = new Insets(0, 0, 5, 5);
		gbc_slider_4.gridx = 0;
		gbc_slider_4.gridy = 12;
		add(slider_4, gbc_slider_4);

		slider_4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				if (!slider.getValueIsAdjusting()) {
					label_4.setText(String.valueOf(slider.getValue()) + "%");
				}
			}
		});

		JButton btnStartSimulation = new JButton("Start Simulation");
		btnStartSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int userBehaviourLeft = (int) (slider_1.getValue() * (Double) (slider
							.getValue() / 100.00));
					int userGiveUpLeft = (int) (slider_1.getValue() * (Double) (slider_3
							.getValue() / 100.00));
					Random r = new Random(1985495673);
					for (int i = 0; i < slider_1.getValue(); i++) {
						if (chckbxRandomTrustValues.isSelected()) {
							SimUser u = new SimUser("User" + i,
									200, new TrustValue(r
											.nextDouble()));
							if (userBehaviourLeft > 0) {
								u.setBehaviour(0);
								userBehaviourLeft--;
							} else {
								u.setBehaviour(100);
							}
							GuiMain.getPersistenceManager().getSimUsers()
									.add(u);
						} else {
							SimUser u = new SimUser("User" + i,
									200, new TrustValue(
											Double.valueOf(textField_1
													.getText())));
							if (userBehaviourLeft > 0) {
								u.setBehaviour(0);
								userBehaviourLeft--;
							} else {
								u.setBehaviour(100);
							}
							GuiMain.getPersistenceManager().getSimUsers()
									.add(u);
						}
					}
					for (int j = 0; j < slider_2.getValue(); j++) {
						/*
						 * Asset a = new Asset("Asset" + j, r.nextDouble() *
						 * 100000);
						 */
						Asset a = new Asset("Asset" + j, 10000);
						GuiMain.getPersistenceManager().getAssets().add(a);
					}
					for (int k = 0; k < Integer.parseInt(textField.getText()); k++) {
						for (int l = 0; l < GuiMain.getPersistenceManager()
								.getSimUsers().size(); l++) {
							AccessRequest ar = new AccessRequest(GuiMain
									.getMaterialForPatentProposal());
							OpportunityDescriptor opportunityDescriptor = new OpportunityDescriptor();
							if (chckbxUseOpportunities.isSelected()) {
								opportunityDescriptor
										.setDescription("If user works the company will not lose "
												+ GuiMain
														.getPersistenceManager()
														.getSimUsers().get(l)
														.getHourlyCost());
								opportunityDescriptor
										.addOutcome(new Outcome(
												"If user works the company will not lose "
														+ GuiMain
																.getPersistenceManager()
																.getSimUsers()
																.get(l)
																.getHourlyCost(),
												GuiMain.getPersistenceManager()
														.getSimUsers().get(l)
														.getHourlyCost()));
								opportunityDescriptor.addRequestedAsset(GuiMain
										.getPersistenceManager()
										.getAssets()
										.get(r.nextInt(GuiMain
												.getPersistenceManager()
												.getAssets().size())));
							} else {
								opportunityDescriptor
										.setDescription("There is no opportunity descriptor asociated with this request");
								opportunityDescriptor
										.addOutcome(new Outcome(
												"There is no opportunity descriptor asociated with this request",
												0.0));
								opportunityDescriptor.addRequestedAsset(GuiMain
										.getPersistenceManager()
										.getAssets()
										.get(r.nextInt(GuiMain
												.getPersistenceManager()
												.getAssets().size())));
							}
							ar.setOpportunityDescriptor(opportunityDescriptor);
							GuiMain.getPersistenceManager().getSimUsers()
									.get(l).setBehaviour(100);
							// TODO set behaviour options
							/*
							 * GuiMain.getPersistenceManager().getSimUsers()
							 * .get(comboBox_1.getSelectedIndex())
							 * .setBehaviour(slider.getValue());
							 */
							ar.setUser(GuiMain.getPersistenceManager()
									.getSimUsers().get(l));
							if (userGiveUpLeft > 0 && r.nextDouble() > 0.5) {
								ar.setUserAction(new GiveUpAction());
								userGiveUpLeft--;
							} else {
								ar.setUserAction(new AccessAction());
							}
							GuiMain.getArList().add(ar);
						}

					}
					if (chckbxRandomRiskPolicy.isSelected()) {
						MultiAgentSimulationPanel simPanel = new MultiAgentSimulationPanel(
								true,
								(int) ((slider_1.getValue() * Integer
										.parseInt(textField.getText())) * (Double) (slider_4
										.getValue() / 100.00)));
						GuiMain.switchPanel(simPanel);
					} else {
						GuiMain.getS2Rt2ae().setRiskPolicy(
								(RiskPolicy) comboBox.getSelectedItem());
						MultiAgentSimulationPanel simPanel = new MultiAgentSimulationPanel(
								false,
								(int) ((slider_1.getValue() * Integer
										.parseInt(textField.getText())) * (Double) (slider_4
										.getValue() / 100.00)));
						GuiMain.switchPanel(simPanel);
					}
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(null,
							"Check that all the parameters are correct.",
							"Input error.", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		GridBagConstraints gbc_btnStartSimulation = new GridBagConstraints();
		gbc_btnStartSimulation.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnStartSimulation.insets = new Insets(0, 0, 0, 5);
		gbc_btnStartSimulation.gridx = 16;
		gbc_btnStartSimulation.gridy = 17;
		add(btnStartSimulation, gbc_btnStartSimulation);

	}

}
