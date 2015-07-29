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

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;

import eu.muses.sim.Outcome;
import eu.muses.sim.riskman.asset.Asset;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingConstants;

import org.springframework.ui.context.Theme;

/**
 * The class AssetPanel
 * It provides a GUI to add new assets for simulation purposes.
 * 
 */
public class AssetPanel extends JPanel {

	/**
	 * Class variables.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAddAsset;
	private JTextField textField;
	private String confidentialLvl;
	Outcome badOutcome = new Outcome();

	/**
	 * Creates and sets up the panel.
	 */
	public AssetPanel() {
		setToolTipText("");
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewAsset = new JLabel("New Asset");
		lblNewAsset.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewAsset.gridwidth = 18;
		gbc_lblNewAsset.gridx = 0;
		gbc_lblNewAsset.gridy = 0;
		lblNewAsset.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblNewAsset, gbc_lblNewAsset);

		JLabel lblAssetDescription = new JLabel("Asset Name:");
		GridBagConstraints gbc_lblAssetDescription = new GridBagConstraints();
		gbc_lblAssetDescription.anchor = GridBagConstraints.WEST;
		gbc_lblAssetDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssetDescription.gridx = 0;
		gbc_lblAssetDescription.gridy = 1;
		lblAssetDescription.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblAssetDescription, gbc_lblAssetDescription);

		txtAddAsset = new JTextField();
		txtAddAsset.setToolTipText("Add the asset name");
		GridBagConstraints gbc_txtAddAsset = new GridBagConstraints();
		gbc_txtAddAsset.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddAsset.gridwidth = 14;
		gbc_txtAddAsset.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddAsset.gridx = 0;
		gbc_txtAddAsset.gridy = 2;
		add(txtAddAsset, gbc_txtAddAsset);
		txtAddAsset.setColumns(10);

		JLabel lblAssetValue = new JLabel("Asset Value:");
		GridBagConstraints gbc_lblAssetValue = new GridBagConstraints();
		gbc_lblAssetValue.anchor = GridBagConstraints.WEST;
		gbc_lblAssetValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssetValue.gridx = 0;
		gbc_lblAssetValue.gridy = 3;
		lblAssetValue.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblAssetValue, gbc_lblAssetValue);

		textField = new JTextField();
		textField.setToolTipText("Add the asset value, positive numbers only");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 4;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblAssetType = new JLabel("Asset Type:");
		lblAssetType.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblAssetType = new GridBagConstraints();
		gbc_lblAssetType.anchor = GridBagConstraints.WEST;
		gbc_lblAssetType.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssetType.gridx = 0;
		gbc_lblAssetType.gridy = 5;
		add(lblAssetType, gbc_lblAssetType);
		
		JLabel lblAssetCLvl = new JLabel("Asset Confidential level:");
		lblAssetCLvl.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblAssetCLvl = new GridBagConstraints();
		gbc_lblAssetCLvl.anchor = GridBagConstraints.WEST;
		gbc_lblAssetCLvl.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssetCLvl.gridx = 1;
		gbc_lblAssetCLvl.gridy = 5;
		add(lblAssetCLvl, gbc_lblAssetCLvl);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 13;
		gbc_verticalStrut_1.gridy = 7;
		add(verticalStrut_1, gbc_verticalStrut_1);

		final JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem("SELECT AN ASSET TYPE");
		comboBox_1.addItem("File");
		comboBox_1.addItem("Equipment");
		comboBox_1.addItem("Other");
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.anchor = GridBagConstraints.WEST;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 6;
		add(comboBox_1, gbc_comboBox_1);
		
		final JComboBox<String> comboBoxConfidentialLvl = new JComboBox<String>();
		comboBoxConfidentialLvl.addItem("SELECT A CONFIDENTIAL LEVEL");
		comboBoxConfidentialLvl.addItem("Strict Confidential");
		comboBoxConfidentialLvl.addItem("Confidential");
		comboBoxConfidentialLvl.addItem("Public");
		comboBoxConfidentialLvl.addItem("Internal");

		GridBagConstraints gbc_comboBoxConfidentialLvl = new GridBagConstraints();
		gbc_comboBoxConfidentialLvl.anchor = GridBagConstraints.WEST;
		gbc_comboBoxConfidentialLvl.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxConfidentialLvl.gridx = 1;
		gbc_comboBoxConfidentialLvl.gridy = 6;
		add(comboBoxConfidentialLvl, gbc_comboBoxConfidentialLvl);
		
		JLabel lblEXTENSION = new JLabel("Extension:");
		lblEXTENSION.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblEXTENSION = new GridBagConstraints();
		gbc_lblEXTENSION.anchor = GridBagConstraints.WEST;
		gbc_lblEXTENSION.insets = new Insets(0, 0, 5, 5);
		gbc_lblEXTENSION.gridx = 2;
		gbc_lblEXTENSION.gridy = 5;
		add(lblEXTENSION, gbc_lblEXTENSION);
		
		final JComboBox<String> comboBoxExtension = new JComboBox<String>();
		comboBoxExtension.addItem("Select an extension");
		comboBoxExtension.addItem(".txt");
		comboBoxExtension.addItem(".pdf");
		comboBoxExtension.addItem(".html");

		GridBagConstraints gbc_comboBoxExtension = new GridBagConstraints();
		gbc_comboBoxExtension.anchor = GridBagConstraints.WEST;
		gbc_comboBoxExtension.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxExtension.gridx = 2;
		gbc_comboBoxExtension.gridy = 6;
		add(comboBoxExtension, gbc_comboBoxExtension);


		JButton btnSaveAsset = new JButton("Save Asset");
		btnSaveAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/*,confidentialLvl = comboBox_1.getSelectedItem().toString()*/
					if (txtAddAsset.getText().isEmpty()
							|| textField.getText().isEmpty()
							|| comboBox_1.getSelectedIndex() == 0)
						throw new Exception();
					Asset a = new Asset(txtAddAsset.getText(), Double
							.parseDouble(textField.getText()));
					GuiMain.getS2Rt2ae().addAsset(a);
					GuiMain.getPersistenceManager().setAssets(
							new ArrayList<Asset>(Arrays.asList(a)));
					System.out.println("Asset "
							+ GuiMain.getS2Rt2ae()
									.getAsset(txtAddAsset.getText())
									.getAssetName()
							+ " was added with cost "
							+ GuiMain.getS2Rt2ae()
									.getAsset(txtAddAsset.getText()).getValue());
					GuiMain.getPersistenceManager().setOutcomes(
							new ArrayList<Outcome>(Arrays.asList(badOutcome)));
					GuiMain.initializeHomePanel();
					JPanel mainPanel = GuiMain.getMainPanel();
					GuiMain.switchPanel(mainPanel);
										
					String extension = comboBoxExtension.getSelectedItem().toString();
					String filename = txtAddAsset.getText()+extension;
					String workingDirectory = "/Users/jonathan/Desktop/asset";
			 
					//****************//
			 
					String absoluteFilePath = "";
			 
					//absoluteFilePath = workingDirectory + System.getProperty("file.separator") + filename;
					absoluteFilePath = workingDirectory + File.separator + filename;
			 
					System.out.println("Final filepath : " + absoluteFilePath);
			 
					//****************//
			 
					File file = new File(absoluteFilePath);
					if (file.createNewFile()) {
						System.out.println("File is created!");
					} else {
						System.out.println("File is already existed!");
						 JOptionPane.showConfirmDialog(null,
								 	"File is already existed!",
			                        "MUSES Dialog",
			                        JOptionPane.OK_CANCEL_OPTION,
			                        JOptionPane.ERROR_MESSAGE);
					}
					
					
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(null,
							"Input should be correctly filled", "Wrong Input",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		GridBagConstraints gbc_btnSaveAsset = new GridBagConstraints();
		gbc_btnSaveAsset.insets = new Insets(0, 40, 5, 5);
		gbc_btnSaveAsset.gridx = 2;
		gbc_btnSaveAsset.gridy = 7;
		add(btnSaveAsset, gbc_btnSaveAsset);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 13;
		gbc_verticalStrut.gridy = 6;
		add(verticalStrut, gbc_verticalStrut);

	}

}
