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
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

import java.awt.Component;

import javax.swing.Box;

import eu.muses.sim.OpportunityDescriptor;
import eu.muses.sim.Outcome;
import eu.muses.sim.RealTimeRiskTrustAnalysisEngine;
import eu.muses.sim.decision.CorporateUserAccessRequestDecision;
import eu.muses.sim.decision.Decision;
import eu.muses.sim.persistence.AdminConfiguration;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.complexpolicy.ComplexPolicy;
import eu.muses.sim.riskman.*;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.trustman.TrustValue;
import eu.muses.sim.userman.User;
import eu.muses.wp5.Clue;
import eu.muses.wp5.EventProcessor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingConstants;

import com.udojava.evalex.Expression;
import java.awt.BorderLayout;
import java.awt.GridLayout;


public class AdminClient extends JPanel implements ItemListener {

	/**
	 * Class variables.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAddOD;
	private JTextField textField;
	private JTextField lostIncome;
	private JTable table_1;
	private ComplexPolicy cp;
	private BigDecimal result = null;
	private JCheckBox CheckBoxRule1;
	Outcome badOutcome = new Outcome();
	StringBuffer choices;
	public String selectedRule;
	public String ConnectionChoosen;
	public String ZoneChoosen;
	
	/**
	 * Creates and sets up the panel.
	 */
	public AdminClient() {
		choices = new StringBuffer("-");
		
		if ( GuiMain.getPersistenceManager().getObjAsset() != null){
		 String Asset = GuiMain.getPersistenceManager().getObjAsset().toString();
			
		}
		
	

		JTextPane textPane = new JTextPane();
		
		
		final Document document = textPane.getDocument();

		
		setToolTipText("");
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		

		ImageIcon img = new ImageIcon(
				GuiMain.class.getResource("/eu/muses/sim/gui/muses-text.png"));
				GridBagLayout gridBagLayout = new GridBagLayout();
				gridBagLayout.columnWidths = new int[] {300, 300};
				gridBagLayout.rowHeights = new int[]{24, 85, 14, 14, 41, 41, 14, 41, 14, 23, 23, 23, 29, 29, 0};
				gridBagLayout.columnWeights = new double[]{0.0, 0.0};
				gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				setLayout(gridBagLayout);
				
			
		
				JLabel lblNewOportunitiesDescriptor = new JLabel("Admin Client Menu");
				lblNewOportunitiesDescriptor.setAlignmentX(Component.RIGHT_ALIGNMENT);
				lblNewOportunitiesDescriptor.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewOportunitiesDescriptor.setFont(new Font("Arial", Font.PLAIN, 20));
				GridBagConstraints gbc_lblNewOportunitiesDescriptor = new GridBagConstraints();
				gbc_lblNewOportunitiesDescriptor.fill = GridBagConstraints.VERTICAL;
				gbc_lblNewOportunitiesDescriptor.gridwidth = 2;
				gbc_lblNewOportunitiesDescriptor.insets = new Insets(0, 0, 5, 0);
				gbc_lblNewOportunitiesDescriptor.gridx = 0;
				gbc_lblNewOportunitiesDescriptor.gridy = 0;
				add(lblNewOportunitiesDescriptor, gbc_lblNewOportunitiesDescriptor);
				
				
				JLabel wIcon = new JLabel(img);
				wIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
				wIcon.setHorizontalAlignment(SwingConstants.TRAILING);
				GridBagConstraints gbc_wIcon = new GridBagConstraints();
				gbc_wIcon.insets = new Insets(0, 0, 5, 0);
				gbc_wIcon.gridwidth = 2;
				gbc_wIcon.gridx = 0;
				gbc_wIcon.gridy = 1;
				add(wIcon, gbc_wIcon);
						
						JLabel lblZoneType = new JLabel("Where are you ?");
						lblZoneType.setHorizontalAlignment(SwingConstants.TRAILING);
						lblZoneType.setFont(new Font("Arial", Font.BOLD, 12));
						GridBagConstraints gbc_lblZoneType = new GridBagConstraints();
						gbc_lblZoneType.anchor = GridBagConstraints.WEST;
						gbc_lblZoneType.gridwidth = 2;
						gbc_lblZoneType.insets = new Insets(0, 10, 5, 0);
						gbc_lblZoneType.gridx = 0;
						gbc_lblZoneType.gridy = 2;
						add(lblZoneType, gbc_lblZoneType);
				
						final JComboBox<String> comboBox_zone = new JComboBox<String>();
						comboBox_zone.addItem("SELECT A ZONE");
						comboBox_zone.addItem("User inside company building");
						comboBox_zone.addItem("User outside company building");
						GridBagConstraints gbc_comboBox_zone = new GridBagConstraints();
						gbc_comboBox_zone.fill = GridBagConstraints.HORIZONTAL;
						gbc_comboBox_zone.anchor = GridBagConstraints.EAST;
						gbc_comboBox_zone.insets = new Insets(0, 0, 5, 5);
						gbc_comboBox_zone.gridx = 0;
						gbc_comboBox_zone.gridy = 3;
						add(comboBox_zone, gbc_comboBox_zone);
						
						comboBox_zone.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ZoneChoosen = (String) comboBox_zone.getSelectedItem();
								
							}
						});
				JLabel lblRiskPolicy = new JLabel("Complex Risk Policy");
				lblRiskPolicy.setAlignmentX(Component.CENTER_ALIGNMENT);
				lblRiskPolicy.setHorizontalAlignment(SwingConstants.LEFT);
				lblRiskPolicy.setFont(new Font("Arial", Font.BOLD, 12));
				GridBagConstraints gbc_lblRiskPolicy = new GridBagConstraints();
				gbc_lblRiskPolicy.anchor = GridBagConstraints.WEST;
				gbc_lblRiskPolicy.insets = new Insets(0, 10, 5, 0);
				gbc_lblRiskPolicy.gridwidth = 2;
				gbc_lblRiskPolicy.gridx = 0;
				gbc_lblRiskPolicy.gridy = 4;
				add(lblRiskPolicy, gbc_lblRiskPolicy);
		
				final JComboBox<ComplexPolicy> comboBox_2 = new JComboBox<ComplexPolicy>();
				comboBox_2.setAlignmentX(Component.RIGHT_ALIGNMENT);
				
						comboBox_2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								cp = (ComplexPolicy) comboBox_2.getSelectedItem();
								try {
									document.insertString(document.getLength(),
											"Policy to evaluate: \n" + cp.getTextPolicy(), null);
								} catch (BadLocationException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
						GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
						gbc_comboBox_2.fill = GridBagConstraints.BOTH;
						gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
						gbc_comboBox_2.gridx = 0;
						gbc_comboBox_2.gridy = 5;
						add(comboBox_2, gbc_comboBox_2);
						
		JLabel LBLrules = new JLabel("Configuration of rule(s) that must be applied");
		LBLrules.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_LBLrules = new GridBagConstraints();
		gbc_LBLrules.gridwidth = 2;
		gbc_LBLrules.anchor = GridBagConstraints.WEST;
		gbc_LBLrules.insets = new Insets(0, 10, 5, 0);
		gbc_LBLrules.gridx = 0;
		gbc_LBLrules.gridy = 6;
		add(LBLrules, gbc_LBLrules);
		
				
			    CheckBoxRule1 = new JCheckBox("No access outside office");
			    GridBagConstraints gbc_CheckBoxRule1 = new GridBagConstraints();
			    gbc_CheckBoxRule1.anchor = GridBagConstraints.WEST;
			    gbc_CheckBoxRule1.insets = new Insets(0, 0, 5, 5);
			    gbc_CheckBoxRule1.gridx = 0;
			    gbc_CheckBoxRule1.gridy = 7;
			    add(CheckBoxRule1, gbc_CheckBoxRule1);
			    CheckBoxRule1.addItemListener(this);
		
		
		
		
		
		JButton btnSaveAsset = new JButton("Save configuration");
		
		btnSaveAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int result1 = 1;

					try{
						
						if (comboBox_zone.getSelectedItem().toString().contains("ZONE")
								|| comboBox_2.getSelectedItem().toString().contains("POLICIES") ){
							JOptionPane.showConfirmDialog(null,
									"Input should be correctly filled", "Wrong Input",
									JOptionPane.OK_CANCEL_OPTION, 
									JOptionPane.ERROR_MESSAGE);
							
						}else{

					
					AdminConfiguration adminConf = new AdminConfiguration();

					adminConf.setConnection(ConnectionChoosen);
					adminConf.setCompleyRiskPolicy(cp);
					adminConf.setRules(selectedRule);
					adminConf.setZone(ZoneChoosen);
					
					GuiMain.persistenceManager.setAdminConf(adminConf);

					
					//System.out.println(GuiMain.persistenceManager.getAdminConf().size());
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
				 //int result = 0 + (int)(Math.random() * ((3 - 0) + 1));
			/*	try {
					SimUser user1 = new SimUser("user1", 120, new TrustValue(0.5));
					System.out.println(user1.getHourlyCost());

					OpportunityDescriptor opportunityDescriptor = new OpportunityDescriptor();
					opportunityDescriptor.setDescription("test");
					System.out.println(opportunityDescriptor.getDescription());
					opportunityDescriptor.addOutcome(new Outcome((String) "test", 33));
					opportunityDescriptor.addRequestedAsset((Asset) comboBox_1
							.getSelectedItem());
					int[] clueRows = table_1.getSelectedRows();
					List<Clue> clues = new ArrayList<Clue>();
					for (int i : clueRows) {
						clues.add(new Clue((String) table_1.getValueAt(i, 0)));
					}
					
					EventProcessor S2EventCorrelator1 = new EventProcessor();
					S2EventCorrelator1.setClues(clues);
				
					AccessRequest ar = new AccessRequest();
					ar.setAccessRisk(null);
					GuiMain.getS2Rt2ae().setRiskPolicy(
							(RiskPolicy) comboBox_2.getSelectedItem());
					
					int Hour = Integer.parseInt(txtAddOD.getText());
					int Lost = Integer.parseInt(lostIncome.getText());
					
					System.out.println(Hour + " est  " + Lost);
					
					GuiMain.setSimAmount(1);
					AccessRequest accessRequest = GuiMain.getAccessRequest();
					GuiMain.setUser1(user1);
					System.out.println(Hour + " est  " + accessRequest);
					
					
					Decision decision = GuiMain.getS2Rt2ae()
							.decidesBasedOnConfiguredRiskPolicy(accessRequest);
					System.out.println("The computed decision for the asset "
							+ accessRequest.getRequestedCorporateAsset()
									.iterator().next().getAssetName()
							+ " was: "
							+ ((CorporateUserAccessRequestDecision) decision)
									.getTextualDecisionDescription() + "\n");
					*/
				
				
					/*JOptionPane.showConfirmDialog(null,rt2ae.computeThreatOutcomeProbability(badOutcome, 0.5, ""),
							JOptionPane.OK_CANCEL_OPTION, 
							JOptionPane.ERROR_MESSAGE); */
/*
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(null,
							"Input should be correctly filled", "Wrong Input",
							JOptionPane.OK_CANCEL_OPTION, 
							JOptionPane.ERROR_MESSAGE);
				}
				
				try{
					
					
					int Hour = Integer.parseInt(txtAddOD.getText());
					int Lost = Integer.parseInt(lostIncome.getText());
				
					//String asset = comboBox_1.getSelectedItem().toString();
					String Zone = comboBox_zone.getSelectedItem().toString();
					String connection = comboBox_connection.getSelectedItem().toString();
					String policy =  comboBox_2.getSelectedItem().toString();
					
					int clue = table_1.getSelectedRow();
					String ClueTxt = (String) table_1.getValueAt(clue, clue);
								
					//GuiMain.getPersistenceManager().setAssetSelected(asset);
					GuiMain.getPersistenceManager().setClueSelected(ClueTxt);
					GuiMain.getPersistenceManager().setPotentialLoose(Lost);
					GuiMain.getPersistenceManager().setRPSelected(policy);
					GuiMain.getPersistenceManager().setWorkingHour(Hour);
					GuiMain.getPersistenceManager().setConnection(connection);
					GuiMain.getPersistenceManager().setZone(Zone);

					
					System.out.println(Hour + " est  " + Lost);
					System.out.println(Zone + " +");
				//	System.out.println(asset + " +  ");
					System.out.println(connection + " +  ");
					System.out.println(policy + "+");
					System.out.println(ClueTxt);
					
					
					result = new Expression(cp.getLogicalPolicy())
					.with("a", "")
					.and("b", "")
					.and("c", "")
					.and("d", "")
					.and("e", "")
					.and("f", "").eval();
					
					if(result1 <= 1){
						
						
						 JOptionPane.showConfirmDialog(null,
								 	getPanelGranted(),
			                        "MUSES Dialog",
			                        JOptionPane.OK_CANCEL_OPTION,
			                        JOptionPane.PLAIN_MESSAGE);
				        
				        
				        /*
						GuiMain.frmMusesRtae.setVisible(true);
						JPanel AccessPanel = new AccessAllowedPanel();
						GuiMain.switchPanel(AccessPanel);
						GuiMain.frmMusesRtae.getJMenuBar().setVisible(false);
						 
					}else if(result1 >1 && result1 <=2 ){

						 JOptionPane.showConfirmDialog(null,
								 	getPanelMaybe(),
			                        "MUSES Dialog",
			                        JOptionPane.OK_CANCEL_OPTION,
			                        JOptionPane.PLAIN_MESSAGE);
					}
					else if (result1 >1 && result1 <=2 ){
						
						 JOptionPane.showConfirmDialog(null,
								 	getPanelWarnng(),
			                        "MUSES Dialog",
			                        JOptionPane.OK_CANCEL_OPTION,
			                        JOptionPane.PLAIN_MESSAGE);
					}
					else {
						/*
						GuiMain.frmMusesRtae.setVisible(true);
						JPanel UTUPanel = new AccessUpToUser();
						GuiMain.switchPanel(UTUPanel);
						GuiMain.frmMusesRtae.getJMenuBar().setVisible(false);
						
					}
					*/
				} catch (Exception ex){
					
							JOptionPane.showConfirmDialog(null,
							"Input should be correctly filled", "Wrong Input",
							JOptionPane.OK_CANCEL_OPTION, 
							JOptionPane.ERROR_MESSAGE);
					
				} 
				
				
				// TODO Auto-generated method stub
				
			}
		});
		GridBagConstraints gbc_btnSaveAsset = new GridBagConstraints();
		gbc_btnSaveAsset.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaveAsset.gridx = 1;
		gbc_btnSaveAsset.gridy = 9;
		add(btnSaveAsset, gbc_btnSaveAsset);
		
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
		gbc_btnBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 10;
		add(btnBack, gbc_btnBack);
		/*
		JLabel lblClues = new JLabel("Clues");
		lblClues.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblClues = new GridBagConstraints();
		gbc_lblClues.anchor = GridBagConstraints.WEST;
		gbc_lblClues.insets = new Insets(0, 0, 5, 5);
		gbc_lblClues.gridx = 0;
		gbc_lblClues.gridy = 8;
		add(lblClues, gbc_lblClues);
		
		DefaultTableModel model2 = new DefaultTableModel();
		model2.addColumn("Clue Name");

		for (Clue cl : GuiMain.getPersistenceManager().getClues()) {
			model2.addRow(new String[] { cl.getId() });
		}

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 1;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 9;
		add(scrollPane_1, gbc_scrollPane_1);

		table_1 = new JTable(model2);
		table_1.setToolTipText("Select one or more clues, you can select multiple items by holding Shift key");
		scrollPane_1.setViewportView(table_1);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 9;
		add(verticalStrut, gbc_verticalStrut);
	*/

		if (!GuiMain.getPersistenceManager().getComplexPolicies().isEmpty()) {
						for (ComplexPolicy cp : GuiMain.getPersistenceManager()
								.getComplexPolicies()) {
							comboBox_2.addItem(cp);
						}
					} else {
						comboBox_2.setModel(new DefaultComboBoxModel(
								new String[] { "ADD COMPLEX RISK POLICIES FIRST" }));
					}
			
					comboBox_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cp = (ComplexPolicy) comboBox_2.getSelectedItem();
							try {
								document.insertString(document.getLength(),
										"Policy to evaluate: \n" + cp.getTextPolicy(), null);
							} catch (BadLocationException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
						}
						}
					});
		
	}

	 private JPanel getPanelGranted() {
		 	
	        JPanel panel = new JPanel();
	        JLabel label = new JLabel("Access Granted :");
	     //   JLabel label2 = new JLabel(Asset);
	        
	        //JLabel label1 = new JLabel(Asset);
	        ImageIcon img1 = new ImageIcon(
				GuiMain.class.getResource("/eu/muses/sim/gui/True.png"));

			int imageW = 50; //My Button width
			int imageH = 50;//My button height
			 
			Image img = img1.getImage();
			BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			Graphics g = bi.createGraphics();
			g.drawImage(img, 0, 0, imageW, imageH, null, null);
			ImageIcon newIcon = new ImageIcon(bi); 

	        label.setIcon(newIcon);
	        panel.add(label);
	      //  panel.add(label2);

	        return panel;
	    }
	 
	 private JPanel getPanelWarnng() {
	        JPanel panel = new JPanel();
	        JLabel label = new JLabel("Access Denied: ");
	        ImageIcon img1 = new ImageIcon(
				GuiMain.class.getResource("/eu/muses/sim/gui/warning.png"));

			int imageW = 50; //My Button width
			int imageH = 50;//My button height
			 
			Image img = img1.getImage();
			BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			Graphics g = bi.createGraphics();
			g.drawImage(img, 0, 0, imageW, imageH, null, null);
			ImageIcon newIcon = new ImageIcon(bi); 

	        label.setIcon(newIcon);
	        panel.add(label);

	        return panel;
	    }
	 
	 private JPanel getPanelMaybe() {
	        JPanel panel = new JPanel();
	        JLabel label = new JLabel("<html>We are sorry, But the info you gave us don't give enouth safety <br>"
	        		+ "raeson to give you access to the requested asset </html> ");
	        ImageIcon img1 = new ImageIcon(
				GuiMain.class.getResource("/eu/muses/sim/gui/warning.png"));

			int imageW = 50; //My Button width
			int imageH = 50;//My button height
			 
			Image img = img1.getImage();
			BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			Graphics g = bi.createGraphics();
			g.drawImage(img, 0, 0, imageW, imageH, null, null);
			ImageIcon newIcon = new ImageIcon(bi); 

	        label.setIcon(newIcon);
	        panel.add(label);

	        return panel;
	    }

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		 int index = 0;
	        char c = '-';
	        Object source = e.getItemSelectable();

	        if (source == CheckBoxRule1 ) {
	            index = 0;
	            c = '1';
	       
	        }

	        //Now that we know which button was pushed, find out
	        //whether it was selected or deselected.
	        if (e.getStateChange() == ItemEvent.DESELECTED) {
	            c = '-';
	        }

	        //Apply the change to the string.
	        choices.setCharAt(index, c);
	        selectedRule = choices.toString();
	        System.out.println(choices);
	        GuiMain.persistenceManager.setSelectedRule(selectedRule);
	}
}
