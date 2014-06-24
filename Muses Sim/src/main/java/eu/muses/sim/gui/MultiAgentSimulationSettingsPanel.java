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
import javax.swing.JSlider;

public class MultiAgentSimulationSettingsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * Create the panel.
	 */
	public MultiAgentSimulationSettingsPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblMultiagentSimulationSettings = new JLabel("Multi-Agent Simulation Settings");
		lblMultiagentSimulationSettings.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblMultiagentSimulationSettings = new GridBagConstraints();
		gbc_lblMultiagentSimulationSettings.insets = new Insets(0, 0, 5, 5);
		gbc_lblMultiagentSimulationSettings.gridwidth = 27;
		gbc_lblMultiagentSimulationSettings.gridx = 0;
		gbc_lblMultiagentSimulationSettings.gridy = 0;
		add(lblMultiagentSimulationSettings, gbc_lblMultiagentSimulationSettings);
		
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
		
		JSlider slider_1 = new JSlider();
		slider_1.setBackground(Color.WHITE);
		slider_1.setMajorTickSpacing(1000);
		slider_1.setValue(100);
		slider_1.setMinorTickSpacing(500);
		slider_1.setMaximum(10000);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setLabelTable(slider_1.createStandardLabels(1000));
		GridBagConstraints gbc_slider_1 = new GridBagConstraints();
		gbc_slider_1.insets = new Insets(0, 0, 5, 0);
		gbc_slider_1.gridwidth = 27;
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
				JSlider slider = (JSlider)e.getSource();
	            if (!slider.getValueIsAdjusting()) {
	                label.setText(String.valueOf(slider.getValue()));
	            }
			}
		});
		
		JSlider slider_2 = new JSlider();
		slider_2.setBackground(Color.WHITE);
		slider_2.setMajorTickSpacing(1000);
		slider_2.setValue(100);
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
		gbc_slider_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider_2.gridwidth = 27;
		gbc_slider_2.gridx = 0;
		gbc_slider_2.gridy = 4;
		add(slider_2, gbc_slider_2);
		
		slider_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider)e.getSource();
	            if (!slider.getValueIsAdjusting()) {
	                label_1.setText(String.valueOf(slider.getValue()));
	            }
			}
		});
		
	}

}
