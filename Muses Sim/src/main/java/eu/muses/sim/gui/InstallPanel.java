package eu.muses.sim.gui;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.Component;

import javax.swing.Box;

import eu.muses.sim.OpportunityDescriptor;
import eu.muses.sim.Outcome;
import eu.muses.sim.RealTimeRiskTrustAnalysisEngine;
import eu.muses.sim.decision.CorporateUserAccessRequestDecision;
import eu.muses.sim.decision.Decision;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.*;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.trustman.TrustValue;
import eu.muses.sim.userman.User;
import eu.muses.wp5.Clue;
import eu.muses.wp5.EventProcessor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstallPanel extends JPanel{
	
	/**
	 * 
	 */
	private Container container;
	private GridBagLayout gblayout;
	private GridBagConstraints gbconstraints;
	private static final long serialVersionUID = 1L;

	/**
	 * Creates and sets up the panel.
	 */
	public InstallPanel() {
		setToolTipText("");
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		
		JLabel lblNewAccessAllowedPanel = new JLabel("Access Denied");
		lblNewAccessAllowedPanel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewAccessAllowedPanel = new GridBagConstraints();
		gbc_lblNewAccessAllowedPanel.anchor = GridBagConstraints.CENTER;

		ImageIcon img = new ImageIcon(
				GuiMain.class.getResource("/eu/muses/sim/gui/muses-text.png"));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {250, 250};
		gridBagLayout.rowHeights = new int[]{85, 94, 23, 29, 29, 0};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
JLabel wIcon = new JLabel(img);
GridBagConstraints gbc_wIcon = new GridBagConstraints();
gbc_wIcon.fill = GridBagConstraints.BOTH;
gbc_wIcon.gridwidth = 2;
gbc_wIcon.anchor = GridBagConstraints.WEST;
gbc_wIcon.insets = new Insets(0, 0, 5, 0);
gbc_wIcon.gridx = 0;
gbc_wIcon.gridy = 0;
add(wIcon, gbc_wIcon);


JTextArea policyField = new JTextArea("Muses-Aware app installation policy agreement : In order to enforce the corporate security policies,"
		+ "MUSES monitors and may record some of your activities in order to increase the trusttworthiness and decrease the risk of being compromised. Other iformation can be "
		+ "below ..");
policyField.setTabSize(5);
policyField.setLineWrap(true);
policyField.setWrapStyleWord(true);
policyField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

JScrollPane areaScrollPane = new JScrollPane(policyField);
areaScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
areaScrollPane.setPreferredSize(new Dimension(250, 250));
GridBagConstraints gbc_areaScrollPane = new GridBagConstraints();
gbc_areaScrollPane.fill = GridBagConstraints.BOTH;
gbc_areaScrollPane.gridwidth = 2;
gbc_areaScrollPane.insets = new Insets(0, 50, 5, 50);
gbc_areaScrollPane.gridx = 0;
gbc_areaScrollPane.gridy = 1;
add(areaScrollPane, gbc_areaScrollPane);



final JCheckBox agressPolicy = new JCheckBox("I agree with Muses above installation policy");
GridBagConstraints gbc_agressPolicy = new GridBagConstraints();
gbc_agressPolicy.gridwidth = 2;
gbc_agressPolicy.anchor = GridBagConstraints.WEST;
gbc_agressPolicy.insets = new Insets(0, 50, 5, 5);
gbc_agressPolicy.gridx = 0;
gbc_agressPolicy.gridy = 2;
add(agressPolicy, gbc_agressPolicy);


JButton btnBack1 = new JButton("Install");
GridBagConstraints gbc_btnBack1 = new GridBagConstraints();
gbc_btnBack1.fill = GridBagConstraints.BOTH;
gbc_btnBack1.anchor = GridBagConstraints.WEST;
gbc_btnBack1.insets = new Insets(0, 20, 5, 20);
gbc_btnBack1.gridx = 0;
gbc_btnBack1.gridy = 3;
add(btnBack1, gbc_btnBack1);

btnBack1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		if(agressPolicy.isSelected() ){
			
			GuiMain.frmMusesRtae.setVisible(true);
			JPanel ODPanel = new selectedFilePanel();
			GuiMain.switchPanel(ODPanel);
			GuiMain.frmMusesRtae.getJMenuBar().setVisible(false);
			
		}else
		{

			ImageIcon img1 = new ImageIcon(
					GuiMain.class.getResource("/eu/muses/sim/gui/warning.png"));
			
			int imageW = 50; //My Button width
			int imageH = 50;//My button height
			 
			Image img = img1.getImage();
			BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			Graphics g = bi.createGraphics();
			g.drawImage(img, 0, 0, imageW, imageH, null, null);
			ImageIcon newIcon = new ImageIcon(bi);
			
		        JOptionPane.showMessageDialog(null, "You have to agree with our term", "About", JOptionPane.INFORMATION_MESSAGE, newIcon);
		}
	
	}
	
});

JButton btnBack = new JButton("Home");

btnBack.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		GuiMain.initializeHomePanel();				
		GuiMain.frmMusesRtae.setVisible(true);
		JPanel ODPanel = new JPanel();
		GuiMain.switchPanel(ODPanel);
		GuiMain.frmMusesRtae.getJMenuBar().setVisible(true);
		JLabel backgroundImage = new JLabel();
		backgroundImage.setIcon(new ImageIcon(GuiMain.class
				.getResource("/eu/muses/sim/gui/muses-title.png")));
		ODPanel.setBackground(new Color(255, 255, 255));
		BoxLayout layout = new BoxLayout(ODPanel, BoxLayout.X_AXIS);
		ODPanel.setLayout(layout);
		ODPanel.add(Box.createHorizontalGlue());
		ODPanel.add(backgroundImage);
		ODPanel.add(Box.createHorizontalGlue());
	
		}
	
});
GridBagConstraints gbc_btnBack = new GridBagConstraints();
gbc_btnBack.fill = GridBagConstraints.BOTH;
gbc_btnBack.insets = new Insets(0, 20, 5, 20);
gbc_btnBack.anchor = GridBagConstraints.WEST;
gbc_btnBack.gridx = 1;
gbc_btnBack.gridy = 3;
add(btnBack, gbc_btnBack);
		
	}
	
	

}
