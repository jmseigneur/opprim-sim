package eu.muses.sim.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.Certificate;

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

import eu.muses.sim.RealTimeRiskTrustAnalysisEngine;
import eu.muses.sim.corporate.Corporation;
import eu.muses.sim.riskman.PersonalUserDevice;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.RiskValue;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.asset.UserDevice;
import eu.muses.sim.test.MusesClientApp;
import eu.muses.sim.test.MusesServerApp;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.trustman.TrustValue;
import eu.muses.wp5.EventProcessor;

public class GuiMain {

	private JFrame frmMusesRtae;

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
	static SimUser userCso = new SimUser("userCSO", 300);

	/** The user1. */
	static SimUser user1 = new SimUser("user1", 120);

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		GuiMain.musesUsersDevicesAndAssetsConfigurationsSteps();
		try {
			GuiMain.s2Rt2ae.initCluesThreatTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
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

		// Main panel initialization
		JLabel backgroundImage = new JLabel();
		backgroundImage.setIcon(new ImageIcon(GuiMain.class
				.getResource("/eu/muses/sim/gui/muses-title.png")));
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.X_AXIS);
		mainPanel.setLayout(layout);
		mainPanel.add(Box.createHorizontalGlue());
		mainPanel.add(backgroundImage);
		mainPanel.add(Box.createHorizontalGlue());
		switchPanel(mainPanel);

		// Menu bar and sub menus initialization
		JMenuBar menuBar = new JMenuBar();
		frmMusesRtae.setJMenuBar(menuBar);

		JMenu mnHome = new JMenu("Home");
		menuBar.add(mnHome);

		JMenuItem mntmBackHome = new JMenuItem("Back Home");
		mntmBackHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel backgroundImage = new JLabel();
				backgroundImage.setIcon(new ImageIcon(GuiMain.class
						.getResource("/eu/muses/sim/gui/muses-title.png")));
				JPanel mainPanel = new JPanel();
				mainPanel.setBackground(new Color(255, 255, 255));
				BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.X_AXIS);
				mainPanel.setLayout(layout);
				mainPanel.add(Box.createHorizontalGlue());
				mainPanel.add(backgroundImage);
				mainPanel.add(Box.createHorizontalGlue());
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

		JMenuItem mntmThreats = new JMenuItem("Threats");
		mntmThreats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Threat panel initialization
				JPanel threatPanel = new ThreatPanel();
				switchPanel(threatPanel);
			}
		});

		JMenuItem mntmOutcomes = new JMenuItem("Outcomes");
		mntmOutcomes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Outcome panel initialization
				JPanel outcomePanel = new OutcomePanel();
				switchPanel(outcomePanel);
			}
		});
		mnConfigurationMenu.add(mntmOutcomes);
		mnConfigurationMenu.add(mntmThreats);

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

		JMenuItem mntmUserTurstValue = new JMenuItem("User Trust Value");
		mnView.add(mntmUserTurstValue);

		JMenuItem mntmDeviceTrustValue = new JMenuItem("Device Trust Value");
		mnView.add(mntmDeviceTrustValue);

		JMenuItem mntmSecurityState = new JMenuItem("Security State");
		mnView.add(mntmSecurityState);

		JMenuItem mntmThreatsProbabilities = new JMenuItem(
				"Threats Probabilities");
		mnView.add(mntmThreatsProbabilities);

		JMenuItem mntmOpportunitiesProbabilities = new JMenuItem(
				"Opportunities Probabilities");
		mnView.add(mntmOpportunitiesProbabilities);

		JMenu mnScenarios = new JMenu("Scenarios");
		menuBar.add(mnScenarios);

		JMenuItem mntmAliceRequestsPatent = new JMenuItem(
				"Alice Requests Patent Material");
		mnScenarios.add(mntmAliceRequestsPatent);

		JMenuItem mntmSecurityIncidentOn = new JMenuItem(
				"Security Incident on Patent Material");
		mnScenarios.add(mntmSecurityIncidentOn);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmFaq = new JMenuItem("F.A.Q.");
		mnHelp.add(mntmFaq);
	}

	private void switchPanel(JPanel panel) {

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
				GuiMain.s2EventCorrelator, RiskPolicy.TAKE_MEDIUM_RISK);
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
}
