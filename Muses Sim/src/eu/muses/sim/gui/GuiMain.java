package eu.muses.sim.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuiMain {

	private JFrame frmMusesRtae;

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

		initialize();

	}

	/**
	 * Initialize the contents of the frame, menus and app panels.
	 */
	private void initialize() {

		// Frame initialization
		frmMusesRtae = new JFrame();
		frmMusesRtae.getContentPane().setBackground(new Color(255, 255, 255));
		frmMusesRtae.setTitle("MUSES RT2AE");
		frmMusesRtae.setSize(800, 600);
		frmMusesRtae.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon(
				"/muses-logo.png");
		frmMusesRtae.setIconImage(img.getImage());

		// Main panel initialization
		JLabel backgroundImage = new JLabel();
		backgroundImage.setIcon(new ImageIcon(
				"/muses-title.png"));
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
				backgroundImage.setIcon(new ImageIcon(
						"/muses-title.png"));
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
				JPanel assetPanel = new JPanel();
				assetPanel.setBackground(new Color(255, 255, 255));
				JTextArea title = new JTextArea("Add a New Asset");
				title.setFont(new Font("Arial", Font.BOLD, 16));
				assetPanel.add(title);
				JTextArea name = new JTextArea("Name the Asset:");
				name.setFont(new Font("Arial", Font.PLAIN, 14));
				assetPanel.add(name);
				switchPanel(assetPanel);

			}
		});
		mnConfigurationMenu.add(mntmAssets);

		JMenuItem mntmRiskPolicies = new JMenuItem("Risk Policies");
		mntmRiskPolicies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Risk panel initialization
				JPanel riskPanel = new JPanel();
				riskPanel.setBackground(new Color(255, 255, 255));
				JTextArea title = new JTextArea("Add a New Risk");
				title.setFont(new Font("Arial", Font.BOLD, 16));
				riskPanel.add(title);
				switchPanel(riskPanel);
			}
		});
		mnConfigurationMenu.add(mntmRiskPolicies);

		JMenuItem mntmClues = new JMenuItem("Clues");
		mntmClues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clue panel initialization
				JPanel cluePanel = new JPanel();
				cluePanel.setBackground(new Color(255, 255, 255));
				JTextArea title = new JTextArea("Add a New Clue");
				title.setFont(new Font("Arial", Font.BOLD, 16));
				cluePanel.add(title);
				switchPanel(cluePanel);
			}
		});
		mnConfigurationMenu.add(mntmClues);

		JMenuItem mntmThreats = new JMenuItem("Threats");
		mntmThreats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Threat panel initialization
				JPanel threatPanel = new JPanel();
				threatPanel.setBackground(new Color(255, 255, 255));
				JTextArea title = new JTextArea("Add a New Threat");
				title.setFont(new Font("Arial", Font.BOLD, 16));
				threatPanel.add(title);
				switchPanel(threatPanel);
			}
		});
		mnConfigurationMenu.add(mntmThreats);

		JMenuItem mntmOpportunities = new JMenuItem("Opportunities");
		mntmOpportunities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Opportunity panel initialization
				JPanel opportunityPanel = new JPanel();
				opportunityPanel.setBackground(new Color(255, 255, 255));
				JTextArea title = new JTextArea("Add a New Opportunity");
				title.setFont(new Font("Arial", Font.BOLD, 16));
				opportunityPanel.add(title);
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

}
