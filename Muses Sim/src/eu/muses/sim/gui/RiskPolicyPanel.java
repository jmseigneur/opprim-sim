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
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public RiskPolicyPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
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
		
		JLabel lblAddPolicyName = new JLabel("Add Policy Name:");
		GridBagConstraints gbc_lblAddPolicyName = new GridBagConstraints();
		gbc_lblAddPolicyName.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddPolicyName.gridx = 0;
		gbc_lblAddPolicyName.gridy = 3;
		lblAddPolicyName.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblAddPolicyName, gbc_lblAddPolicyName);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 4;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

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

					try {
						if(Double.parseDouble(textField.getText()) > 1.0)
							throw new Exception();
						RiskPolicy rp = new RiskPolicy(new RiskValue(Double
								.parseDouble(textField.getText()),
								textField_1.getText()), null);
						GuiMain.getRiskPolicies().add(rp);
						GuiMain.initializeHomePanel();
						JPanel mainPanel = GuiMain.getMainPanel();
						GuiMain.switchPanel(mainPanel);
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showConfirmDialog(null,
								"Input should be a number between 0 and 1",
								"Wrong Input", JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.ERROR_MESSAGE);
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
