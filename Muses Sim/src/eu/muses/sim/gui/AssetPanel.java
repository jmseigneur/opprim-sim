package eu.muses.sim.gui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AssetPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAddAsset;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AssetPanel() {
		setToolTipText("");
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewAsset = new JLabel("New Asset");
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewAsset.gridwidth = 17;
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
		txtAddAsset.setToolTipText("add the asset description...");
		GridBagConstraints gbc_txtAddAsset = new GridBagConstraints();
		gbc_txtAddAsset.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddAsset.gridwidth = 13;
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
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 4;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"euros (\u20AC)", "k\u20AC "}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 4;
		add(comboBox, gbc_comboBox);
		
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
		
		JButton btnSaveAsset = new JButton("Save Asset");
		btnSaveAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnSaveAsset = new GridBagConstraints();
		gbc_btnSaveAsset.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveAsset.gridx = 12;
		gbc_btnSaveAsset.gridy = 7;
		add(btnSaveAsset, gbc_btnSaveAsset);

	}

}
