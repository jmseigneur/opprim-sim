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
import javax.swing.text.Document;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.Component;

import javax.swing.Box;

import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.SecurityIncident;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JScrollPane;

public class SecurityIncidentOnAssetPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static int accessRequest;

	/**
	 * Create the panel.
	 */
	public SecurityIncidentOnAssetPanel(int accessRequest) {
		this.accessRequest = accessRequest;
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewAsset = new JLabel("Report Security Incident");
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewAsset.gridwidth = 17;
		gbc_lblNewAsset.gridx = 0;
		gbc_lblNewAsset.gridy = 0;
		lblNewAsset.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblNewAsset, gbc_lblNewAsset);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 15;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

		Document document = textPane.getDocument();
		DocumentPrintStream documentPrintStream = new DocumentPrintStream(
				document, System.out);
		System.setOut(documentPrintStream);

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

		JButton btnRunSimulation = new JButton("Report");
		btnRunSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					try {

						AccessRequest accessRequest = GuiMain
								.getPersistenceManager()
								.getAccessRequests()
								.get(SecurityIncidentOnAssetPanel.accessRequest);
						if(!accessRequest.isSolved()){
						GuiMain.setUser1(accessRequest.getUser());

						// Much later assuming there is a security incident on
						// the
						// asset
						SecurityIncident securityIncidentOnPatent = new SecurityIncident(
								"Patent is invalidated", GuiMain
										.getMaterialForPatentProposal()
										.getValue()); // the
														// MUSES
														// WP5
														// event
														// correlator
														// would
														// detect
						// this incident
						GuiMain.getS2EventCorrelator().reportsSecurityIncident(
								securityIncidentOnPatent);
						if (GuiMain.getS2EventCorrelator()
								.seemsUserInvolvedInSecurityIncident(
										GuiMain.getUser1()) > 0.8) {
							System.out
									.println("S2 Event Correlator detected a security incident possibly linked to the user");
							GuiMain.getS2MusesClientApp()
									.warnsUserResponsibleForSecurityIncident(
											GuiMain.getUser1(),
											securityIncidentOnPatent);
							GuiMain.getS2Rt2ae().decreasesTrustInUser(
									GuiMain.getUser1(),
									securityIncidentOnPatent);
							GuiMain.getS2Rt2ae()
									.recalculateThreatProbabilitiesWhenIncident(
											accessRequest);
							accessRequest.setSolved(true);
							GuiMain.getPersistenceManager()
									.setAccessRequests(new ArrayList<AccessRequest>(Arrays.asList(accessRequest)));
						}
						}else{
							JOptionPane
							.showConfirmDialog(
									null,
									"There was already a security incident reported for this asset access request",
									"Notice", JOptionPane.OK_CANCEL_OPTION,
									JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showConfirmDialog(null,
								"Something went wrong with the simulation",
								"Error", JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		GridBagConstraints gbc_btnRunSimulation = new GridBagConstraints();
		gbc_btnRunSimulation.insets = new Insets(0, 0, 5, 5);
		gbc_btnRunSimulation.gridx = 14;
		gbc_btnRunSimulation.gridy = 3;
		add(btnRunSimulation, gbc_btnRunSimulation);
		GridBagConstraints gbc_btnSaveAsset = new GridBagConstraints();
		gbc_btnSaveAsset.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaveAsset.gridx = 15;
		gbc_btnSaveAsset.gridy = 3;
		add(btnSaveAsset, gbc_btnSaveAsset);

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

	}

}
