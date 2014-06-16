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

import java.awt.Component;

import javax.swing.Box;

import eu.muses.sim.OpportunityDescriptor;
import eu.muses.sim.Outcome;
import eu.muses.sim.decision.CorporateUserAccessRequestDecision;
import eu.muses.sim.decision.Decision;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.RiskTreatment;
import eu.muses.sim.riskman.SecurityIncident;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.test.SimUser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class AliceRequestsAssetPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public AliceRequestsAssetPanel() {
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

		JLabel lblNewAsset = new JLabel("Alice Requests Asset Simulation");
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewAsset.gridwidth = 17;
		gbc_lblNewAsset.gridx = 0;
		gbc_lblNewAsset.gridy = 0;
		lblNewAsset.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblNewAsset, gbc_lblNewAsset);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
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

		JButton btnRunSimulation = new JButton("Run Simulation");
		btnRunSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					GuiMain.setSimAmount(GuiMain.getSimAmount()+1);
					AccessRequest accessRequest = GuiMain.getAccessRequest();

					// XXX //user1Laptop is for example inferred by the sensed
					// MUSES
					// WP6 context observation and their events
					// correlation with MUSES WP5

					Decision decision = GuiMain.getS2Rt2ae()
							.decidesBasedOnConfiguredRiskPolicy(accessRequest);
					System.out.println("The computed decision for the asset "
							+ accessRequest.getRequestedCorporateAsset()
									.iterator().next().getAssetName()
							+ " was: "
							+ ((CorporateUserAccessRequestDecision) decision)
									.getTextualDecisionDescription() + "\n");
					GuiMain.getS2Rt2ae()
							.recalculateThreatProbabilitiesWhenNoIncident(
									accessRequest);
					if (!decision.equals(Decision.STRONG_DENY_ACCESS)) {
						if (!decision.equals(Decision.ALLOW_ACCESS)) {
							GuiMain.getUser1()
									.readsAccessRiskCommunicationIncludingPotentialRiskTreatments(
											decision.getRiskCommunication()); // including
																				// some
																				// potential
																				// other
																				// behaviours,
																				// risk
																				// treatments
																				// that
							// would allow the user to access the asset with
							// less
							// risk, such as
							// going to a company lounge with secure WiFi
						}
						while (decision.equals(Decision.MAYBE_ACCESS)
								&& GuiMain.getUser1().isStillMakingRequest(
										accessRequest)) {
							if (GuiMain.getUser1().givesUpRequestDueToRisk(
									accessRequest)) {
								GuiMain.getUser1().setStillMakingRequest(
										accessRequest, false);
							} else {
								if (decision
										.getRiskCommunication()
										.hasRiskTreatment(
												RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY)) {
									if (GuiMain.getUser1()
											.acceptsToRefineOpportunity()) {
										System.out
												.println("User accepted to refine the access oportunity");
										OpportunityDescriptor opportunityDescriptor = GuiMain
												.getUser1()
												.refinesOpportunity(); // in our
																		// example
										// it corresponds
										// to
										// refinesOpportunity()
										// below
										accessRequest
												.setOpportunityDescriptor(opportunityDescriptor);
										GuiMain.getS2EventCorrelator()
												.logsSuccessfullyAppliedRiskTreatment(
														RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY);
									}
								}
								for (RiskTreatment riskTreatment : decision
										.getRiskCommunication()
										.getRiskTreatments()) {
									if (!riskTreatment
											.equals(RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY)) {
										if (GuiMain
												.getUser1()
												.appliesSuccessfullyRiskTreatment(
														riskTreatment)) {
											// e.g.
											// user1.movesTo(genevaAirportSecuredCorporateLoungeWiFi);
											// //this risk treatment
											// allows her to access the asset
											GuiMain.getUser1()
													.isInformedOfSuccessfullyAppliedRiskTreatment(
															riskTreatment);
											GuiMain.getS2EventCorrelator()
													.logsSuccessfullyAppliedRiskTreatment(
															riskTreatment);
										} else {
											GuiMain.getUser1()
													.isInformedOfUnsuccessfullRiskTreatmentApplication();
										}
									}
								}
								decision = GuiMain.getS2Rt2ae()
										.decidesBasedOnConfiguredRiskPolicy(
												accessRequest);
								GuiMain.getUser1()
										.readsAccessRiskCommunicationIncludingPotentialRiskTreatments(
												decision.getRiskCommunication()); // including
																					// some
																					// potential
																					// other
																					// behaviours,
																					// risk
																					// treatments
																					// that
								// would allow the user to access the asset with
								// less risk, such
								// as going to a company lounge with secure WiFi
							}
						}
						while (decision.equals(Decision.ON_YOUR_RISK_ACCESS)
								&& GuiMain.getUser1().isStillMakingRequest(
										accessRequest)) {
							if (GuiMain.getUser1().givesUpRequestDueToRisk(
									accessRequest)) {
								GuiMain.getUser1().setStillMakingRequest(
										accessRequest, false);
								GuiMain.getS2EventCorrelator()
										.logsAccessRequestUserDecisionInMusesCompanyInstance();
								// It may be important to also log when a user
								// decides not taking the opportunity due to
								// risk,
								// e.g.,
								// to avoid never taking opportunities even when
								// there is no risk due to laziness or risk
								// aversion...
							} else {
								if (GuiMain.getUser1()
										.decidesAccessingAssetInSpiteOfRisk(
												accessRequest)) {
									GuiMain.getUser1().setStillMakingRequest(
											accessRequest, false);
									Asset[] corporateAssets = GuiMain
											.getUser1().getCorporateAssets(
													accessRequest);
									GuiMain.getS2EventCorrelator()
											.logsAccessRequestUserDecisionInMusesCompanyInstance();
									GuiMain.getS2EventCorrelator()
											.logsUserUsesAssetInMusesCompanyInstance();
									GuiMain.getUser1().usesCorporateAssets(
											corporateAssets);
									if (GuiMain
											.getUser1()
											.successfullyUseCorporateAssetsGivenTheSpecifiedOpportunity(
													accessRequest
															.getOpportunityDescriptor())) {
										GuiMain.getS2EventCorrelator()
												.logsPositiveOutcomeBasedOnTheAchievedOpportunity(
														accessRequest);
										GuiMain.getS2Rt2ae()
												.updatesTrustInUserGivenPositiveOutcome(
														GuiMain.getUser1(),
														accessRequest
																.getOpportunityDescriptor());
									} else {
										GuiMain.getS2EventCorrelator()
												.logsNegativeOutcomeBasedOnTheNonAchievedOpportunity(
														accessRequest);
										GuiMain.getS2Rt2ae()
												.updatesTrustInUserGivenNegativeOutcome(
														GuiMain.getUser1(),
														accessRequest
																.getOpportunityDescriptor());
									}
								} else {
									if (decision
											.getRiskCommunication()
											.hasRiskTreatment(
													RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY)) {
										if (GuiMain.getUser1()
												.acceptsToRefineOpportunity()) {
											OpportunityDescriptor opportunityDescriptor = GuiMain
													.getUser1()
													.refinesOpportunity();
											// in our example it corresponds to
											// refinesOpportunity()
											// below
											accessRequest
													.setOpportunityDescriptor(opportunityDescriptor);
											GuiMain.getS2EventCorrelator()
													.logsSuccessfullyAppliedRiskTreatment(
															RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY);
										}
									}
									for (RiskTreatment riskTreatment : decision
											.getRiskCommunication()
											.getRiskTreatments()) {
										if (!riskTreatment
												.equals(RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY)) {
											if (GuiMain
													.getUser1()
													.appliesSuccessfullyRiskTreatment(
															riskTreatment)) {
												// e.g.
												// user1.movesTo(genevaAirportSecuredCorporateLoungeWiFi);
												// //this risk
												// treatment allows her to
												// access
												// the asset
												GuiMain.getUser1()
														.isInformedOfSuccessfullyAppliedRiskTreatment(
																riskTreatment);
												GuiMain.getS2EventCorrelator()
														.logsSuccessfullyAppliedRiskTreatment(
																riskTreatment);
											}
										} else {
											GuiMain.getUser1()
													.isInformedOfUnsuccessfullRiskTreatmentApplication();
										}
									}
									decision = GuiMain
											.getS2Rt2ae()
											.decidesBasedOnConfiguredRiskPolicy(
													accessRequest);
									GuiMain.getUser1()
											.readsAccessRiskCommunicationIncludingPotentialRiskTreatments(
													decision.getRiskCommunication()); // including
																						// some
																						// potential
																						// other
																						// behaviours,
																						// risk
									// treatments that would allow the user to
									// access the
									// asset with less risk, such as going to a
									// company
									// lounge with secure WiFi
								}
							}
						}
						if (decision.equals(Decision.ALLOW_ACCESS)) {
							GuiMain.getUser1().setStillMakingRequest(
									accessRequest, false);
							Asset[] corporateAssets = GuiMain.getUser1()
									.getCorporateAssets(accessRequest);
							GuiMain.getS2EventCorrelator()
									.logsUserUsesAssetInMusesCompanyInstance();
							GuiMain.getUser1().usesCorporateAssets(
									corporateAssets);
							if (GuiMain
									.getUser1()
									.successfullyUseCorporateAssetsGivenTheSpecifiedOpportunity(
											accessRequest
													.getOpportunityDescriptor())) {
								GuiMain.getS2EventCorrelator()
										.logsPositiveOutcomeBasedOnTheAchievedOpportunity(
												accessRequest);
								GuiMain.getS2Rt2ae()
										.updatesTrustInUserGivenPositiveOutcome(
												GuiMain.getUser1(),
												accessRequest
														.getOpportunityDescriptor());
							} else {
								GuiMain.getS2EventCorrelator()
										.logsNegativeOutcomeBasedOnTheNonAchievedOpportunity(
												accessRequest);
								GuiMain.getS2Rt2ae()
										.updatesTrustInUserGivenNegativeOutcome(
												GuiMain.getUser1(),
												accessRequest
														.getOpportunityDescriptor());
							}
						}

					} else {
						GuiMain.getS2EventCorrelator().logDeniedRequest(
								accessRequest);
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
		gbc_btnRunSimulation.insets = new Insets(0, 0, 0, 5);
		gbc_btnRunSimulation.gridx = 1;
		gbc_btnRunSimulation.gridy = 7;
		add(btnRunSimulation, gbc_btnRunSimulation);
		GridBagConstraints gbc_btnSaveAsset = new GridBagConstraints();
		gbc_btnSaveAsset.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveAsset.gridx = 12;
		gbc_btnSaveAsset.gridy = 7;
		add(btnSaveAsset, gbc_btnSaveAsset);

	}

}
