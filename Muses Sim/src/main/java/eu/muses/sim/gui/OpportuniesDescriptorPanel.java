/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.gui;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Color;
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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

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
import eu.muses.sim.riskman.complexpolicy.ComplexPolicy;
import eu.muses.sim.riskman.*;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.trustman.TrustValue;
import eu.muses.sim.userman.User;
import eu.muses.wp5.Clue;
import eu.muses.wp5.EventProcessor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingConstants;

import org.apache.commons.lang3.StringUtils;

import com.udojava.evalex.Expression;

public class OpportuniesDescriptorPanel extends JPanel {

	/**
	 * Class variables.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAddOD;
	private JTextField textField;
	private JTextField lostIncome;
	private String selectedAsset;
	private JTable table_1;
	Outcome badOutcome = new Outcome();
	public String root = "/Users/jonathan/Desktop/asset/";
	private ComplexPolicy cp;
	private BigDecimal result = null;
	private Asset myasset = null;
	private String newAssetSelected;
	private String newassetLabel;
	public String Asset;
	String AssetSelected;

	/**
	 * Creates and sets up the panel.
	 */
	public OpportuniesDescriptorPanel() {
		
		if ( GuiMain.getPersistenceManager().getObjAsset() != null){
			Asset = GuiMain.getPersistenceManager().getObjAsset().toString();
				
		}
		
		if (GuiMain.persistenceManager.getSelectedAssetsbyUser().size() != 0){
			Asset ItemSelected =  GuiMain.persistenceManager.getSelectedAssetsbyUser().get(0);
			
			AssetSelected = ItemSelected.getAssetName();				
		}
		
		if (GuiMain.persistenceManager.getSelectedAssetsbyUser().size() >= 2){
			newAssetSelected = GuiMain.persistenceManager.getSelectedAssetsbyUser().get(1).getAssetName();
			newassetLabel = "Additional Asset :"+newAssetSelected;
		}
		
		
		
		
		setToolTipText("");
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		
		final JFrame f = new JFrame("Asset");
        f.setPreferredSize(new Dimension(500, 300));
        f.pack();
        ImageIcon img = new ImageIcon(
				GuiMain.class.getResource("/eu/muses/sim/gui/muses-text.png"));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {300, 300};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
				
				JLabel lblNewOportunitiesDescriptor = new JLabel("Opportunities Descriptor");
				lblNewOportunitiesDescriptor.setHorizontalAlignment(SwingConstants.TRAILING);
				lblNewOportunitiesDescriptor.setFont(new Font("Arial", Font.PLAIN, 20));
				GridBagConstraints gbc_lblNewOportunitiesDescriptor = new GridBagConstraints();
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
				
						JLabel lblHourDescription = new JLabel("How many hours do you think you have for working ?");
						lblHourDescription.setFont(new Font("Arial", Font.BOLD, 12));
						GridBagConstraints gbc_lblHourDescription = new GridBagConstraints();
						gbc_lblHourDescription.gridwidth = 2;
						gbc_lblHourDescription.insets = new Insets(0, 0, 5, 0);
						gbc_lblHourDescription.gridx = 0;
						gbc_lblHourDescription.gridy = 2;
						add(lblHourDescription, gbc_lblHourDescription);
		
				txtAddOD = new JTextField();
				txtAddOD.setToolTipText("Enter number of hour");
				GridBagConstraints gbc_txtAddOD = new GridBagConstraints();
				gbc_txtAddOD.fill = GridBagConstraints.BOTH;
				gbc_txtAddOD.gridwidth = 2;
				gbc_txtAddOD.insets = new Insets(0, 0, 5, 0);
				gbc_txtAddOD.gridx = 0;
				gbc_txtAddOD.gridy = 3;
				add(txtAddOD, gbc_txtAddOD);
				txtAddOD.setColumns(10);
				
						JLabel lblHourValue = new JLabel("If you cannot work right now, do you lose potential extra revenues ?");
						lblHourValue.setFont(new Font("Arial", Font.BOLD, 12));
						GridBagConstraints gbc_lblHourValue = new GridBagConstraints();
						gbc_lblHourValue.gridwidth = 2;
						gbc_lblHourValue.insets = new Insets(0, 0, 5, 0);
						gbc_lblHourValue.gridx = 0;
						gbc_lblHourValue.gridy = 4;
						add(lblHourValue, gbc_lblHourValue);
						lblHourValue.setFont(new Font("Arial", Font.BOLD, 12));
		
				lostIncome = new JTextField();
				lostIncome.setToolTipText("Add the potential revenue loss in Euros");
				GridBagConstraints gbc_lostIncome = new GridBagConstraints();
				gbc_lostIncome.fill = GridBagConstraints.BOTH;
				gbc_lostIncome.gridwidth = 2;
				gbc_lostIncome.insets = new Insets(0, 0, 5, 0);
				gbc_lostIncome.gridx = 0;
				gbc_lostIncome.gridy = 5;
				add(lostIncome, gbc_lostIncome);
				lostIncome.setColumns(10);
		
		textField = new JTextField();
		textField.setToolTipText("Add the potential revenue loss description");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 6;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel allreadySelected = new JLabel("Asset already selected : ");
		GridBagConstraints gbc_allreadySelected = new GridBagConstraints();
		gbc_allreadySelected.fill = GridBagConstraints.BOTH;
		gbc_allreadySelected.anchor = GridBagConstraints.WEST;
		gbc_allreadySelected.insets = new Insets(0, 10, 5, 5);
		gbc_allreadySelected.gridx = 0;
		gbc_allreadySelected.gridy = 7;
		add(allreadySelected, gbc_allreadySelected);
		
		JLabel newAsset = new JLabel("Do you need another asset ?");
		GridBagConstraints gbc_newAsset = new GridBagConstraints();
		gbc_newAsset.fill = GridBagConstraints.BOTH;
		gbc_newAsset.anchor = GridBagConstraints.WEST;
		gbc_newAsset.insets = new Insets(0, 10, 5, 5);
		gbc_newAsset.gridx = 0;
		gbc_newAsset.gridy = 8;
		add(newAsset, gbc_newAsset);
		
		JLabel assetAllereadySelected = new JLabel(AssetSelected);
		assetAllereadySelected.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_assetAllereadySelected = new GridBagConstraints();
		gbc_assetAllereadySelected.anchor = GridBagConstraints.WEST;
		gbc_assetAllereadySelected.insets = new Insets(0, 0, 5, 0);
		gbc_assetAllereadySelected.gridx = 1;
		gbc_assetAllereadySelected.gridy = 7;
		add(assetAllereadySelected, gbc_assetAllereadySelected);
		assetAllereadySelected.setFont(new Font("Arial", Font.BOLD, 12));
		
		final JLabel newSelected = new JLabel(newassetLabel);
		newSelected.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_newSelected = new GridBagConstraints();
		gbc_newSelected.insets = new Insets(0, 0, 5, 0);
		gbc_newSelected.anchor = GridBagConstraints.WEST;
		gbc_newSelected.gridx = 1;
		gbc_newSelected.gridy = 8;
		add(newSelected, gbc_newSelected);
		
		
		JButton btnSaveAsset = new JButton("Send Request");
		
		btnSaveAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int result1 = 1;
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
				} */
					final JDialog dialog = new JDialog(f, "Opportunity Denied", true);
					 
					
				try{
					
					
					SimUser user = new SimUser("user1", 120, new TrustValue(0.5), "pass");

					//Asset asset = new Asset("Patent", 10000);
					int Hour = Integer.parseInt(txtAddOD.getText());
					int Lost = Integer.parseInt(lostIncome.getText());			
													
					GuiMain.getPersistenceManager().setPotentialLoose(Lost);
					GuiMain.getPersistenceManager().setWorkingHour(Hour);
					
					double costOpportunity = Hour*user.getHourlyCost()+Lost; 
					
					System.out.println(Hour + " est  " + Lost);
					
					double maxCostThreat = 0;
                	for (Asset asset : GuiMain.persistenceManager.getSelectedAssetsbyUser()) {

                		maxCostThreat = maxCostThreat + asset.getValue();
    					System.out.println("Asset : "+asset.getAssetName());

                	}
					
					ComplexPolicy cp = GuiMain.persistenceManager.getAdminConf().getCompleyRiskPolicy();


					//double oppBenefit = costOpportunity - maxCostThreat;

					//System.out.println("oppBenefit: " +oppBenefit);
					
					System.out.println("policy: " +cp.getName());
					System.out.println("policy: " +cp.getTextPolicy());
					
					System.out.println("getLogicalPolicy(): " +cp.getLogicalPolicy());
					
					String rules = "";
					
					String zones = "";
					
					GuiMain.displayOpportunity = "1";
					
					/*System.out.println("rules: "+GuiMain.persistenceManager.getAdminConf().getConnection() );

					if(GuiMain.persistenceManager.getAdminConf().getConnection().equalsIgnoreCase("Secure Wi-Fi")){
						connection = "1";
					
					}else{
						connection = "0";
					}*/
					System.out.println("rules: "+GuiMain.persistenceManager.getAdminConf().getZone() );

					if(GuiMain.persistenceManager.getAdminConf().getZone().equalsIgnoreCase("User inside company building")){
						
						zones = "1";
						
					}else{
						zones = "0";
					}
					System.out.println("rules: "+GuiMain.persistenceManager.getAdminConf().getRules() );
					System.out.println("zones: "+zones );


					if(GuiMain.persistenceManager.getAdminConf().getRules().equalsIgnoreCase("1") && zones.equalsIgnoreCase("1")){
						rules = "1";
						System.out.println("rules 1: "+rules);

					} else {
							rules = "0";
							System.out.println("rules 2: "+rules);

					}
	
					System.out.println("rules finale: "+rules);


					result = new Expression(cp.getLogicalPolicy())
					.with("a", String.valueOf(maxCostThreat))
					.and("b", "0")
					.and("c", String.valueOf(costOpportunity))
					.and("d", "0")
					.and("e", "0")
					.and("f", rules)
					.and("g", GuiMain.displayOpportunity).eval();
					
					System.out.println("Result: " + result.intValue());

					if(result.intValue() == 1){
						 			JOptionPane.showConfirmDialog(null,
								 	getPanelGranted(),
			                        "MUSES Dialog Allow",
			                        JOptionPane.OK_CANCEL_OPTION,
			                        JOptionPane.PLAIN_MESSAGE);
						}else{
						
							 		JOptionPane.showConfirmDialog(null,
							 		getPanelWarnng(),
				                    "MUSES Dialog Deny",
				                    JOptionPane.OK_CANCEL_OPTION,
				                    JOptionPane.PLAIN_MESSAGE);
						}

					 
					/*if(result1 <= 1){
						
						
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
						
						GuiMain.frmMusesRtae.setVisible(true);
						JPanel UTUPanel = new AccessUpToUser();
						GuiMain.switchPanel(UTUPanel);
						GuiMain.frmMusesRtae.getJMenuBar().setVisible(false);
						
					}*/
					
				} catch (Exception ex){
					System.out.println("Erreur: " +ex.getMessage());

							JOptionPane.showConfirmDialog(null,
							"Input should be correctly filled", "Wrong Input",
							JOptionPane.OK_CANCEL_OPTION, 
							JOptionPane.ERROR_MESSAGE);
					
				}
				
				// TODO Auto-generated method stub
				
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
				
				GuiMain.displayOpportunity = "0";

				}
		});
		
		JButton addNewAsset = new JButton("Add new Asset");
		GridBagConstraints gbc_addNewAsset = new GridBagConstraints();
		gbc_addNewAsset.fill = GridBagConstraints.BOTH;
		gbc_addNewAsset.anchor = GridBagConstraints.WEST;
		gbc_addNewAsset.insets = new Insets(0, 0, 5, 5);
		gbc_addNewAsset.gridx = 0;
		gbc_addNewAsset.gridy = 9;
		add(addNewAsset, gbc_addNewAsset);
		
		
	
		
		addNewAsset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				GuiMain.persistenceManager.setWorkingHour(Integer.parseInt(txtAddOD.getText()));
				GuiMain.persistenceManager.setPotentialLoose(Integer.parseInt(lostIncome.getText()));
				GuiMain.persistenceManager.setLoosingExplanation(textField.getText());
				
				FilesInTheJList Fitj = new FilesInTheJList();
				
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.anchor = GridBagConstraints.EAST;
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 10;
		add(btnBack, gbc_btnBack);
		GridBagConstraints gbc_btnSaveAsset = new GridBagConstraints();
		gbc_btnSaveAsset.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaveAsset.fill = GridBagConstraints.BOTH;
		gbc_btnSaveAsset.anchor = GridBagConstraints.WEST;
		gbc_btnSaveAsset.gridx = 1;
		gbc_btnSaveAsset.gridy = 9;
		add(btnSaveAsset, gbc_btnSaveAsset);
		
		/*
		 * Save data in case of refresh 
		 */
		
		if (GuiMain.persistenceManager.getLoosingExplanation() != null ){
			textField.setText(GuiMain.persistenceManager.getLoosingExplanation());
			txtAddOD.setText(String.valueOf(GuiMain.persistenceManager.getWorkingHour()));
			lostIncome.setText(String.valueOf(GuiMain.persistenceManager.getPotentialLoose()));
			
		}

		
	}

	 private JPanel getPanelGranted() {
		 	
	        JPanel panel = new JPanel();
	        JLabel label = new JLabel("Access Granted :");
	        JLabel label2 = new JLabel(Asset);
	        
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
	        panel.add(label2);

	        return panel;
	    }
	 
	 private JPanel getPanelWarnng() {
	        JPanel panel = new JPanel();
	        JLabel label = new JLabel("Access Denied ");
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
	 
	 
}
