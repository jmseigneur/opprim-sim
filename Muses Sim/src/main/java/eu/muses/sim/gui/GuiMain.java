/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.apache.http.impl.conn.InMemoryDnsResolver;

import eu.muses.sim.RealTimeRiskTrustAnalysisEngine;
import eu.muses.sim.corporate.Corporation;
import eu.muses.sim.persistence.InMemoryPersistenceManager;
import eu.muses.sim.persistence.PersistenceManager;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.PersonalUserDevice;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.RiskValue;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.asset.UserDevice;
import eu.muses.sim.test.MusesClientApp;
import eu.muses.sim.test.MusesServerApp;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.trustman.TrustValue;
import eu.muses.wp5.Clue;
import eu.muses.wp5.EventProcessor;
import eu.musesproject.server.persistence.DbPersistenceManager;

public class GuiMain {

	private static JFrame frmMusesRtae;
	private static JPanel mainPanel;

	/** The s2. */
	static Corporation s2 = new Corporation();

	/** The s2 event correlator. */
	static EventProcessor s2EventCorrelator;

	/** The s2 rt2ae. */
	static RealTimeRiskTrustAnalysisEngine s2Rt2ae;

	/** The s2 muses server app. */
	static MusesServerApp s2MusesServerApp;

	/** The s2 muses client app. */
	static MusesClientApp s2MusesClientApp;

	/** The user cso. */
	static SimUser userCso = new SimUser("userCSO", 300, new TrustValue(0.5));

	/** The user1. */
	static SimUser user1 = new SimUser("user1", 120, new TrustValue(0.5));

	/** The user1 laptop. */
	static UserDevice user1Laptop = new PersonalUserDevice();
	// static RealTimeRiskTrustAnalysisEngine s2MobileRt2aeForUser1;

	/** The material for public marketing poster. */
	static Asset materialForPublicMarketingPoster;

	/** The material for bid. */
	static Asset materialForBid;

	/** The new patent proposal. */
	static Asset newPatentProposal;

	/** The material for patent proposal. */
	static Asset materialForPatentProposal;

	/** The amount of simulations */
	static int simAmount = 0;

	/** The amount of security incidents */
	static int incidentAmount = 0;

	/** The access request */
	static AccessRequest accessRequest;

	/** The persistence manager */
	static PersistenceManager persistenceManager;

	/** The temporary access request list */
	static List<AccessRequest> arList = new ArrayList<AccessRequest>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// persistenceManager = new DbPersistenceManager();
					persistenceManager = new InMemoryPersistenceManager();
					GuiMain window = new GuiMain();
					window.frmMusesRtae.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiMain() {

		userCso.setTrustValue(new TrustValue(0.5));
		GuiMain.s2.setCso(GuiMain.userCso);

		if (persistenceManager.getClass().equals(
				InMemoryPersistenceManager.class)) {
			persistenceManager.setClues(new ArrayList<Clue>(Arrays.asList(
					Clue.antivirusClue, Clue.firewallClue, Clue.vpnClue)));
			/*persistenceManager.setAssets(new ArrayList<Asset>(Arrays.asList(
					new Asset("Important File", 1000), new Asset(
							"Irrelevant File", 0))));*/
			persistenceManager.setRiskPolicies(new ArrayList<RiskPolicy>(Arrays
					.asList(RiskPolicy.TAKE_FULL_RISK,
							RiskPolicy.TAKE_MEDIUM_RISK,
							RiskPolicy.TAKE_NO_RISK)));
			/*persistenceManager
					.setSimUsers(new ArrayList<SimUser>(Arrays
							.asList(new SimUser("TestUser", 120,
									new TrustValue(0.5)))));*/
		}

		GuiMain.musesUsersDevicesAndAssetsConfigurationsSteps();
		/*
		 * try { GuiMain.s2Rt2ae.initCluesThreatTable(); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
		initialize();

	}

	/**
	 * Initialize the contents of the frame, menus and app panels.
	 */
	private void initialize() {

		// Frame initialization
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		frmMusesRtae = new JFrame();
		frmMusesRtae.getContentPane().setBackground(new Color(255, 255, 255));
		frmMusesRtae.setTitle("MUSES RT2AE");
		frmMusesRtae.setSize(800, 600);
		frmMusesRtae.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon(
				GuiMain.class.getResource("/eu/muses/sim/gui/muses-logo.png"));
		frmMusesRtae.setIconImage(img.getImage());
		initializeHomePanel();
		switchPanel(mainPanel);

		// Menu bar and sub menus initialization
		JMenuBar menuBar = new JMenuBar();
		frmMusesRtae.setJMenuBar(menuBar);

		JMenu mnHome = new JMenu("Home");
		menuBar.add(mnHome);

		JMenuItem mntmBackHome = new JMenuItem("Back Home");
		mntmBackHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initializeHomePanel();
				switchPanel(mainPanel);
			}
		});
		mnHome.add(mntmBackHome);

		JMenu mnConfigurationMenu = new JMenu("Configure");
		menuBar.add(mnConfigurationMenu);

		JMenuItem mntmAssets = new JMenuItem("Assets");
		mntmAssets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Asset panel initialization
				JPanel assetPanel = new AssetPanel();
				switchPanel(assetPanel);

			}
		});
		mnConfigurationMenu.add(mntmAssets);

		JMenuItem mntmRiskPolicies = new JMenuItem("Risk Policies");
		mntmRiskPolicies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Risk panel initialization
				JPanel riskPanel = new RiskPolicyPanel();
				switchPanel(riskPanel);
			}
		});

		JMenuItem mntmUsers = new JMenuItem("Users");
		mntmUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// User panel initialization
				JPanel userPanel = new UserPanel();
				switchPanel(userPanel);
			}
		});
		mnConfigurationMenu.add(mntmUsers);
		mnConfigurationMenu.add(mntmRiskPolicies);

		JMenuItem mntmClues = new JMenuItem("Clues");
		mntmClues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clue panel initialization
				JPanel cluePanel = new CluePanel();
				switchPanel(cluePanel);
			}
		});
		mnConfigurationMenu.add(mntmClues);

		/*
		 * JMenuItem mntmThreats = new JMenuItem("Threats");
		 * mntmThreats.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { // Threat panel initialization
		 * JPanel threatPanel = new ThreatPanel(); switchPanel(threatPanel); }
		 * });
		 */

		/*
		 * JMenuItem mntmOutcomes = new JMenuItem("Outcomes");
		 * mntmOutcomes.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { // Outcome panel initialization
		 * JPanel outcomePanel = new OutcomePanel(); switchPanel(outcomePanel);
		 * } }); mnConfigurationMenu.add(mntmOutcomes);
		 */
		/* mnConfigurationMenu.add(mntmThreats); */

		JMenuItem mntmOpportunities = new JMenuItem("Opportunities");
		mntmOpportunities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Opportunity panel initialization
				JPanel opportunityPanel = new OpportunityPanel();
				switchPanel(opportunityPanel);
			}
		});
		mnConfigurationMenu.add(mntmOpportunities);

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);

		/*
		 * JMenuItem mntmSecurityState = new JMenuItem("Security State");
		 * mntmSecurityState.addActionListener(new ActionListener() { public
		 * void actionPerformed(ActionEvent e) { // Security State panel
		 * initialization JPanel securityStatePanel = new SecurityStatePanel();
		 * switchPanel(securityStatePanel); } }); mnView.add(mntmSecurityState);
		 */

		JMenuItem mntmUserTurstValue = new JMenuItem("Trust Values");
		mntmUserTurstValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Trust Values panel initialization
				JPanel trustValuesPanel = new TrustValuesPanel();
				switchPanel(trustValuesPanel);
			}
		});
		mnView.add(mntmUserTurstValue);

		JMenuItem mntmThreatsProbabilities = new JMenuItem("Assets");
		mntmThreatsProbabilities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// View Assets panel initialization
				JPanel viewAssetsPanel = new ViewAssetsPanel();
				switchPanel(viewAssetsPanel);
			}
		});
		mnView.add(mntmThreatsProbabilities);

		JMenuItem mntmDeviceTrustValue = new JMenuItem(
				"Clues and Threats Table");
		mntmDeviceTrustValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clues and Threats Table panel initialization
				JPanel cluesAndThreatsPanel = new CluesandThreatsPanel();
				switchPanel(cluesAndThreatsPanel);
			}
		});
		mnView.add(mntmDeviceTrustValue);

		JMenuItem mntmOpportunitiesProbabilities = new JMenuItem(
				"Opportunities");
		mntmOpportunitiesProbabilities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// View Opportunities panel initialization
				JPanel viewOpportunitiesPanel = new ViewOpportunitiesPanel();
				switchPanel(viewOpportunitiesPanel);
			}
		});
		mnView.add(mntmOpportunitiesProbabilities);

		JMenu mnScenarios = new JMenu("Scenarios");
		menuBar.add(mnScenarios);

		JMenuItem mntmAliceRequestsPatent = new JMenuItem("User Requests Asset");
		mntmAliceRequestsPatent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPanel requestAssetSimulationSettingsPanel = new RequestAssetSimulationSettingsPanel();
				switchPanel(requestAssetSimulationSettingsPanel);

			}
		});
		mnScenarios.add(mntmAliceRequestsPatent);

		JMenuItem mntmSecurityIncidentOn = new JMenuItem(
				"Security Incident on Asset");
		mntmSecurityIncidentOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPanel securityIncidentOnAssetPanel = new SecurityIncidentSimulationSettingsPanel();
				switchPanel(securityIncidentOnAssetPanel);

			}
		});

		JMenuItem mntmMultiAgentSim = new JMenuItem("Multi-Agent Simulation");
		mntmMultiAgentSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel multiAgentSimulationSettingsPanel = new MultiAgentSimulationSettingsPanel();
				switchPanel(multiAgentSimulationSettingsPanel);
			}
		});

		JMenuItem mntmDataBreach = new JMenuItem("Data Breach Calculator");
		mntmDataBreach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel dataBreachCalculatorPanel = new DatabreachCalculatorPanel();
				switchPanel(dataBreachCalculatorPanel);
			}
		});

		mnScenarios.add(mntmMultiAgentSim);
		mnScenarios.add(mntmSecurityIncidentOn);
		mnScenarios.add(mntmDataBreach);

		JMenuItem mntmPrivacyShield = new JMenuItem("Privacy Shield");
		mntmPrivacyShield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel privacyShieldPanel = new PrivacyShieldPanel();
				switchPanel(privacyShieldPanel);
			}
		});
		mnScenarios.add(mntmPrivacyShield);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmFaq = new JMenuItem("F.A.Q.");
		mnHelp.add(mntmFaq);
	}

	public static void switchPanel(JPanel panel) {

		frmMusesRtae.getContentPane().removeAll();
		frmMusesRtae.getContentPane().add(panel);
		frmMusesRtae.getContentPane().revalidate();

	}

	public static void musesUsersDevicesAndAssetsConfigurationsSteps() {

		RiskPolicy riskPolicy = GuiMain.userCso
				.configureRiskPolicy(RiskValue.TAKE_AVERAGE_RISK); // The risk
		// policy would
		// be specified
		// as risk
		// probability
		// curves
		// ponderated
		// with costs and
		// benefits
		GuiMain.s2EventCorrelator = GuiMain.userCso.configureEventCorrelator();
		GuiMain.s2Rt2ae = GuiMain.userCso.configureRt2ae(
				GuiMain.s2EventCorrelator, RiskPolicy.TAKE_FULL_RISK);
		GuiMain.s2MusesServerApp = GuiMain.userCso
				.configureMusesServerApp(GuiMain.s2Rt2ae);

		GuiMain.s2MusesClientApp = GuiMain.userCso
				.configureMusesClientApp(GuiMain.s2MusesServerApp);

		if (GuiMain.userCso.hasCsoConfiguredAssets(GuiMain.s2Rt2ae)) {
			GuiMain.materialForPublicMarketingPoster = GuiMain.s2Rt2ae
					.getAsset("materialForPublicMarketingPoster");
			GuiMain.materialForBid = GuiMain.s2Rt2ae.getAsset("materialForBid");
			GuiMain.newPatentProposal = GuiMain.s2Rt2ae
					.getAsset("newPatentProposal");
			GuiMain.materialForPatentProposal = GuiMain.s2Rt2ae
					.getAsset("materialForPatentProposal");
		} else {
			GuiMain.newPatentProposal = GuiMain.userCso.addsNewAssetToRt2ae(
					GuiMain.s2Rt2ae, new Asset("newPatentProposal", 600000));

			GuiMain.materialForPatentProposal = GuiMain.userCso
					.addsNewAssetToRt2ae(GuiMain.s2Rt2ae, new Asset(
							"materialForPatentProposal",
							GuiMain.newPatentProposal.getValue()));

			GuiMain.materialForBid = GuiMain.userCso.addsNewAssetToRt2ae(
					GuiMain.s2Rt2ae, new Asset("materialForBid", 150000));

			GuiMain.materialForPublicMarketingPoster = GuiMain.userCso
					.addsNewAssetToRt2ae(GuiMain.s2Rt2ae, new Asset(
							"materialForPublicMarketingPoster", 0));
		}

		GuiMain.userCso.enrollsUserInCompanyInformationSystem(GuiMain.user1);

		GuiMain.user1Laptop = new PersonalUserDevice();

		if (GuiMain.userCso.checksIfDeviceIsTrustworthyEnough()) {
			GuiMain.user1Laptop.installOnClient(GuiMain.s2MusesClientApp);
			String userLogin = GuiMain.user1.getNickname();
			String password = GuiMain.user1.typePassword();
			if (GuiMain.user1.authenticateWihMusesCredentials(userLogin,
					password)) {
				GuiMain.user1Laptop.setOwner(GuiMain.user1.getNickname());
				GuiMain.user1.authenticates();
				Certificate deviceKeyPairMusesCertificate = GuiMain.s2EventCorrelator
						.logNewDevice(GuiMain.user1Laptop.getCryptoId(),
								GuiMain.user1Laptop.getOwner(),
								GuiMain.user1Laptop
										.getCertificateSignatureRequest());
				GuiMain.user1Laptop
						.setCertificate(deviceKeyPairMusesCertificate);
			} else {
				System.exit(-1);
			}
		}

	}

	/**
	 * @return the frmMusesRtae
	 */
	public JFrame getFrmMusesRtae() {
		return frmMusesRtae;
	}

	/**
	 * @param frmMusesRtae
	 *            the frmMusesRtae to set
	 */
	public void setFrmMusesRtae(JFrame frmMusesRtae) {
		this.frmMusesRtae = frmMusesRtae;
	}

	/**
	 * @return the s2
	 */
	public static Corporation getS2() {
		return s2;
	}

	/**
	 * @param s2
	 *            the s2 to set
	 */
	public static void setS2(Corporation s2) {
		GuiMain.s2 = s2;
	}

	/**
	 * @return the s2EventCorrelator
	 */
	public static EventProcessor getS2EventCorrelator() {
		return s2EventCorrelator;
	}

	/**
	 * @param s2EventCorrelator
	 *            the s2EventCorrelator to set
	 */
	public static void setS2EventCorrelator(EventProcessor s2EventCorrelator) {
		GuiMain.s2EventCorrelator = s2EventCorrelator;
	}

	/**
	 * @return the s2Rt2ae
	 */
	public static RealTimeRiskTrustAnalysisEngine getS2Rt2ae() {
		return s2Rt2ae;
	}

	/**
	 * @param s2Rt2ae
	 *            the s2Rt2ae to set
	 */
	public static void setS2Rt2ae(RealTimeRiskTrustAnalysisEngine s2Rt2ae) {
		GuiMain.s2Rt2ae = s2Rt2ae;
	}

	/**
	 * @return the s2MusesServerApp
	 */
	public static MusesServerApp getS2MusesServerApp() {
		return s2MusesServerApp;
	}

	/**
	 * @param s2MusesServerApp
	 *            the s2MusesServerApp to set
	 */
	public static void setS2MusesServerApp(MusesServerApp s2MusesServerApp) {
		GuiMain.s2MusesServerApp = s2MusesServerApp;
	}

	/**
	 * @return the s2MusesClientApp
	 */
	public static MusesClientApp getS2MusesClientApp() {
		return s2MusesClientApp;
	}

	/**
	 * @param s2MusesClientApp
	 *            the s2MusesClientApp to set
	 */
	public static void setS2MusesClientApp(MusesClientApp s2MusesClientApp) {
		GuiMain.s2MusesClientApp = s2MusesClientApp;
	}

	/**
	 * @return the userCso
	 */
	public static SimUser getUserCso() {
		return userCso;
	}

	/**
	 * @param userCso
	 *            the userCso to set
	 */
	public static void setUserCso(SimUser userCso) {
		GuiMain.userCso = userCso;
	}

	/**
	 * @return the user1
	 */
	public static SimUser getUser1() {
		return user1;
	}

	/**
	 * @param user1
	 *            the user1 to set
	 */
	public static void setUser1(SimUser user1) {
		GuiMain.user1 = user1;
	}

	/**
	 * @return the user1Laptop
	 */
	public static UserDevice getUser1Laptop() {
		return user1Laptop;
	}

	/**
	 * @param user1Laptop
	 *            the user1Laptop to set
	 */
	public static void setUser1Laptop(UserDevice user1Laptop) {
		GuiMain.user1Laptop = user1Laptop;
	}

	/**
	 * @return the materialForPublicMarketingPoster
	 */
	public static Asset getMaterialForPublicMarketingPoster() {
		return materialForPublicMarketingPoster;
	}

	/**
	 * @param materialForPublicMarketingPoster
	 *            the materialForPublicMarketingPoster to set
	 */
	public static void setMaterialForPublicMarketingPoster(
			Asset materialForPublicMarketingPoster) {
		GuiMain.materialForPublicMarketingPoster = materialForPublicMarketingPoster;
	}

	/**
	 * @return the materialForBid
	 */
	public static Asset getMaterialForBid() {
		return materialForBid;
	}

	/**
	 * @param materialForBid
	 *            the materialForBid to set
	 */
	public static void setMaterialForBid(Asset materialForBid) {
		GuiMain.materialForBid = materialForBid;
	}

	/**
	 * @return the newPatentProposal
	 */
	public static Asset getNewPatentProposal() {
		return newPatentProposal;
	}

	/**
	 * @param newPatentProposal
	 *            the newPatentProposal to set
	 */
	public static void setNewPatentProposal(Asset newPatentProposal) {
		GuiMain.newPatentProposal = newPatentProposal;
	}

	/**
	 * @return the materialForPatentProposal
	 */
	public static Asset getMaterialForPatentProposal() {
		return materialForPatentProposal;
	}

	/**
	 * @param materialForPatentProposal
	 *            the materialForPatentProposal to set
	 */
	public static void setMaterialForPatentProposal(
			Asset materialForPatentProposal) {
		GuiMain.materialForPatentProposal = materialForPatentProposal;
	}

	public static void initializeHomePanel() {

		// Main panel initialization
		JLabel backgroundImage = new JLabel();
		backgroundImage.setIcon(new ImageIcon(GuiMain.class
				.getResource("/eu/muses/sim/gui/muses-title.png")));
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.X_AXIS);
		mainPanel.setLayout(layout);
		mainPanel.add(Box.createHorizontalGlue());
		mainPanel.add(backgroundImage);
		mainPanel.add(Box.createHorizontalGlue());

	}

	/**
	 * @return the mainPanel
	 */
	public static JPanel getMainPanel() {
		return mainPanel;
	}

	/**
	 * @param mainPanel
	 *            the mainPanel to set
	 */
	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	/**
	 * @return the simAmount
	 */
	public static int getSimAmount() {
		return simAmount;
	}

	/**
	 * @param simAmount
	 *            the simAmount to set
	 */
	public static void setSimAmount(int simAmount) {
		GuiMain.simAmount = simAmount;
	}

	/**
	 * @return the incidentAmount
	 */
	public static int getIncidentAmount() {
		return incidentAmount;
	}

	/**
	 * @param incidentAmount
	 *            the incidentAmount to set
	 */
	public static void setIncidentAmount(int incidentAmount) {
		GuiMain.incidentAmount = incidentAmount;
	}

	/**
	 * @return the accessRequest
	 */
	public static AccessRequest getAccessRequest() {
		return accessRequest;
	}

	/**
	 * @param accessRequest
	 *            the accessRequest to set
	 */
	public static void setAccessRequest(AccessRequest accessRequest) {
		GuiMain.accessRequest = accessRequest;
	}

	/**
	 * @return the inMemoryPersistenceManager
	 */
	public static PersistenceManager getPersistenceManager() {
		return persistenceManager;
	}

	/**
	 * @param inMemoryPersistenceManager
	 *            the inMemoryPersistenceManager to set
	 */
	public static void setPersistenceManager(PersistenceManager pManager) {
		persistenceManager = pManager;
	}

	/**
	 * @return the arList
	 */
	public static List<AccessRequest> getArList() {
		return arList;
	}

	/**
	 * @param arList
	 *            the arList to set
	 */
	public void setArList(List<AccessRequest> arList) {
		this.arList = arList;
	}

}
