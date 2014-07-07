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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;

import eu.muses.sim.persistence.InMemoryPersistenceManager;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.test.SimUser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrustValuesPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAddAsset;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public TrustValuesPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewAsset = new JLabel("Trust Values");
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewAsset.gridwidth = 17;
		gbc_lblNewAsset.gridx = 0;
		gbc_lblNewAsset.gridy = 0;
		lblNewAsset.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblNewAsset, gbc_lblNewAsset);

		final JComboBox<SimUser> comboBox = new JComboBox<SimUser>();
		for (SimUser user : GuiMain.getPersistenceManager().getSimUsers()) {
			comboBox.addItem(user);
		}
		comboBox.addItem(GuiMain.getUserCso());
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);

		JLabel lblUserTrustValue = new JLabel("User Trust Value: ");
		GridBagConstraints gbc_lblUserTrustValue = new GridBagConstraints();
		gbc_lblUserTrustValue.anchor = GridBagConstraints.WEST;
		gbc_lblUserTrustValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserTrustValue.gridx = 1;
		gbc_lblUserTrustValue.gridy = 4;
		lblUserTrustValue.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblUserTrustValue, gbc_lblUserTrustValue);

		final JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 4;
		add(lblNewLabel, gbc_lblNewLabel);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 12;
		gbc_verticalStrut_1.gridy = 5;
		add(verticalStrut_1, gbc_verticalStrut_1);

		JLabel lblDeviceTrustValue = new JLabel("Device Trust Value: ");
		GridBagConstraints gbc_lblDeviceTrustValue = new GridBagConstraints();
		gbc_lblDeviceTrustValue.anchor = GridBagConstraints.WEST;
		gbc_lblDeviceTrustValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeviceTrustValue.gridx = 1;
		gbc_lblDeviceTrustValue.gridy = 6;
		lblDeviceTrustValue.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblDeviceTrustValue, gbc_lblDeviceTrustValue);

		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 6;
		add(label, gbc_label);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimUser user = (SimUser) comboBox.getSelectedItem();
				lblNewLabel.setText(String.valueOf(user.getTrustValue()
						.getValue()));

			}
		});

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 12;
		gbc_verticalStrut.gridy = 6;
		add(verticalStrut, gbc_verticalStrut);

		JButton btnSaveAsset = new JButton("Go Back");
		btnSaveAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GuiMain.initializeHomePanel();
					JPanel mainPanel = GuiMain.getMainPanel();
					GuiMain.switchPanel(mainPanel);
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showConfirmDialog(null,
							"Trust Values couldn't be retrieved, try later",
							"Error", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnSaveAsset = new GridBagConstraints();
		gbc_btnSaveAsset.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveAsset.gridx = 12;
		gbc_btnSaveAsset.gridy = 7;
		add(btnSaveAsset, gbc_btnSaveAsset);

	}

}