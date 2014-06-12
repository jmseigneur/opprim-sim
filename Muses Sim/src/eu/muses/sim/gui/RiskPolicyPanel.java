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
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;

import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.RiskValue;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;

public class RiskPolicyPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public RiskPolicyPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewAsset = new JLabel("New Risk Policy");
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewAsset.gridwidth = 15;
		gbc_lblNewAsset.gridx = 1;
		gbc_lblNewAsset.gridy = 0;
		lblNewAsset.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblNewAsset, gbc_lblNewAsset);
		
		JLabel lblAddRiskValue = new JLabel("Add Risk Value:");
		GridBagConstraints gbc_lblAddRiskValue = new GridBagConstraints();
		gbc_lblAddRiskValue.anchor = GridBagConstraints.WEST;
		gbc_lblAddRiskValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddRiskValue.gridx = 0;
		gbc_lblAddRiskValue.gridy = 1;
		lblAddRiskValue.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblAddRiskValue, gbc_lblAddRiskValue);
		
		textField = new JTextField();
		textField.setToolTipText("add a risk value [0..1]");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Use custom Risk Value");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 2;
		add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JLabel lblOr = new JLabel("- OR -");
		GridBagConstraints gbc_lblOr = new GridBagConstraints();
		gbc_lblOr.anchor = GridBagConstraints.WEST;
		gbc_lblOr.insets = new Insets(0, 0, 5, 5);
		gbc_lblOr.gridx = 0;
		gbc_lblOr.gridy = 3;
		lblOr.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblOr, gbc_lblOr);
		
		JLabel lblSelectAPredefined = new JLabel("Select a Predefined Risk Level:");
		GridBagConstraints gbc_lblSelectAPredefined = new GridBagConstraints();
		gbc_lblSelectAPredefined.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectAPredefined.gridx = 0;
		gbc_lblSelectAPredefined.gridy = 4;
		lblSelectAPredefined.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblSelectAPredefined, gbc_lblSelectAPredefined);
		
		final JComboBox<RiskValue> comboBox = new JComboBox<RiskValue>();
		comboBox.addItem(RiskValue.TAKE_NO_RISK);
		comboBox.addItem(RiskValue.TAKE_AVERAGE_RISK);
		comboBox.addItem(RiskValue.TAKE_FULL_RISK);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 5;
		add(comboBox, gbc_comboBox);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 4;
		gbc_verticalStrut_1.gridy = 6;
		add(verticalStrut_1, gbc_verticalStrut_1);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 10;
		gbc_verticalStrut.gridy = 6;
		add(verticalStrut, gbc_verticalStrut);
		
		JButton btnSavePolicy = new JButton("Save Policy");
		btnSavePolicy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbxNewCheckBox.isSelected()){
					try{
					RiskPolicy rp = new RiskPolicy(new RiskValue(Double.parseDouble(textField.getText()), "Custom Policy"), null);
					GuiMain.getRiskPolicies().add(rp);
					GuiMain.initializeHomePanel();
					JPanel mainPanel = GuiMain.getMainPanel();
					GuiMain.switchPanel(mainPanel);
					}catch (Exception ex){
						ex.printStackTrace();
						JOptionPane.showConfirmDialog(null, "Input should be a number between 0 and 1", "Wrong Input", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
					}
				}else{
					RiskPolicy rp = new RiskPolicy((RiskValue) comboBox.getSelectedItem(), null);
					GuiMain.getRiskPolicies().add(rp);
					GuiMain.initializeHomePanel();
					JPanel mainPanel = GuiMain.getMainPanel();
					GuiMain.switchPanel(mainPanel);
				}
				
				
			}
		});
		GridBagConstraints gbc_btnSavePolicy = new GridBagConstraints();
		gbc_btnSavePolicy.anchor = GridBagConstraints.WEST;
		gbc_btnSavePolicy.insets = new Insets(0, 0, 0, 5);
		gbc_btnSavePolicy.gridx = 4;
		gbc_btnSavePolicy.gridy = 7;
		add(btnSavePolicy, gbc_btnSavePolicy);

	}

}
