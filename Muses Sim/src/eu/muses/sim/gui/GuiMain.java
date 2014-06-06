package eu.muses.sim.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import com.alee.laf.WebLookAndFeel;

import javax.swing.JProgressBar;
import javax.swing.JSpinner;

import com.alee.extended.checkbox.WebTristateCheckBox;
import com.alee.extended.filechooser.WebDirectoryChooser;

import java.awt.Window;

import com.alee.extended.filechooser.WebFileTable;
import com.alee.extended.statusbar.WebStatusBar;
import com.alee.extended.tree.WebAsyncTree;
import com.alee.managers.glasspane.WebGlassPane;

import javax.swing.JRootPane;

import com.alee.laf.slider.WebSlider;
import com.alee.laf.tabbedpane.WebTabbedPane;
import com.alee.laf.menu.WebMenuBar;
import com.alee.laf.menu.WebMenuItem;
import com.alee.laf.menu.WebMenu;
import java.awt.Color;
import java.awt.Font;

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
		
		try
		{
		    // Setting up WebLookAndFeel style
		    UIManager.setLookAndFeel (WebLookAndFeel.class.getCanonicalName ());
		}
		catch ( Throwable e )
		{
		    // Something went wrong
		}
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMusesRtae = new JFrame();
		frmMusesRtae.setFont(new Font("Rockwell", Font.PLAIN, 16));
		frmMusesRtae.setForeground(Color.WHITE);
		frmMusesRtae.setTitle("MUSES RT2AE");
		
		ImageIcon img = new ImageIcon("C:\\Users\\cballest\\Desktop\\muses-logo.png");
		frmMusesRtae.setIconImage(img.getImage());
		
		JMenuBar menuBar = new JMenuBar();
		frmMusesRtae.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Configure");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAssets = new JMenuItem("Assets");
		mnNewMenu.add(mntmAssets);
		
		JMenuItem mntmRiskPolicies = new JMenuItem("Risk Policies");
		mnNewMenu.add(mntmRiskPolicies);
		
		JMenuItem mntmClues = new JMenuItem("Clues");
		mnNewMenu.add(mntmClues);
		
		JMenuItem mntmThreats = new JMenuItem("Threats");
		mnNewMenu.add(mntmThreats);
		
		JMenuItem mntmOpportunities = new JMenuItem("Opportunities");
		mnNewMenu.add(mntmOpportunities);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmUserTurstValue = new JMenuItem("User Trust Value");
		mnView.add(mntmUserTurstValue);
		
		JMenuItem mntmDeviceTrustValue = new JMenuItem("Device Trust Value");
		mnView.add(mntmDeviceTrustValue);
		
		JMenuItem mntmSecurityState = new JMenuItem("Security State");
		mnView.add(mntmSecurityState);
		
		JMenuItem mntmThreatsProbabilities = new JMenuItem("Threats Probabilities");
		mnView.add(mntmThreatsProbabilities);
		
		JMenuItem mntmOpportunitiesProbabilities = new JMenuItem("Opportunities Probabilities");
		mnView.add(mntmOpportunitiesProbabilities);
		
		JMenu mnScenarios = new JMenu("Scenarios");
		menuBar.add(mnScenarios);
		
		JMenuItem mntmAliceRequestsPatent = new JMenuItem("Alice Requests Patent Material");
		mnScenarios.add(mntmAliceRequestsPatent);
		
		JMenuItem mntmSecurityIncidentOn = new JMenuItem("Security Incident on Patent Material");
		mnScenarios.add(mntmSecurityIncidentOn);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmFaq = new JMenuItem("F.A.Q.");
		mnHelp.add(mntmFaq);
	}

}
