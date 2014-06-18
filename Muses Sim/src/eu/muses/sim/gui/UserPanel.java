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
import eu.muses.sim.trustman.TrustValue;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.InputMismatchException;

public class UserPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAddAsset;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public UserPanel() {
		setToolTipText("");
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewAsset = new JLabel("New User");
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewAsset.gridwidth = 15;
		gbc_lblNewAsset.gridx = 1;
		gbc_lblNewAsset.gridy = 0;
		lblNewAsset.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblNewAsset, gbc_lblNewAsset);

		JLabel lblAssetDescription = new JLabel("User Nickname:");
		GridBagConstraints gbc_lblAssetDescription = new GridBagConstraints();
		gbc_lblAssetDescription.anchor = GridBagConstraints.WEST;
		gbc_lblAssetDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssetDescription.gridx = 0;
		gbc_lblAssetDescription.gridy = 1;
		lblAssetDescription.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblAssetDescription, gbc_lblAssetDescription);

		txtAddAsset = new JTextField();
		txtAddAsset.setToolTipText("Add a user nickname");
		GridBagConstraints gbc_txtAddAsset = new GridBagConstraints();
		gbc_txtAddAsset.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddAsset.gridwidth = 13;
		gbc_txtAddAsset.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddAsset.gridx = 0;
		gbc_txtAddAsset.gridy = 2;
		add(txtAddAsset, gbc_txtAddAsset);
		txtAddAsset.setColumns(10);

		JLabel lblAssetValue = new JLabel("Trust Level:");
		GridBagConstraints gbc_lblAssetValue = new GridBagConstraints();
		gbc_lblAssetValue.anchor = GridBagConstraints.WEST;
		gbc_lblAssetValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssetValue.gridx = 0;
		gbc_lblAssetValue.gridy = 3;
		lblAssetValue.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblAssetValue, gbc_lblAssetValue);

		JLabel lblHourlyWage = new JLabel("Hourly wage:");
		lblHourlyWage.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblHourlyWage = new GridBagConstraints();
		gbc_lblHourlyWage.anchor = GridBagConstraints.WEST;
		gbc_lblHourlyWage.insets = new Insets(0, 0, 5, 5);
		gbc_lblHourlyWage.gridx = 1;
		gbc_lblHourlyWage.gridy = 3;
		add(lblHourlyWage, gbc_lblHourlyWage);

		textField = new JTextField();
		textField.setToolTipText("user's trust level [0...1]");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 4;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnSaveAsset = new JButton("Save User");
		btnSaveAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtAddAsset.getText().isEmpty()
							|| textField_1.getText().isEmpty()
							|| textField.getText().isEmpty())
						throw new InputMismatchException();
					if (Double.parseDouble(textField.getText()) > 1)
						throw new NumberFormatException();
					if (Double.parseDouble(textField_1.getText()) < 0)
						throw new ParseException("Wrong number", 0);
					SimUser u = new SimUser(txtAddAsset.getText(), Double
							.parseDouble(textField_1.getText()),
							new TrustValue(Double.parseDouble(textField
									.getText())));
					GuiMain.getPersistenceManager().getSimUsers().add(u);
					GuiMain.initializeHomePanel();
					JPanel mainPanel = GuiMain.getMainPanel();
					GuiMain.switchPanel(mainPanel);
				} catch (InputMismatchException iEx) {
					JOptionPane.showConfirmDialog(null,
							"All input fields should be correctly filled",
							"Missing Input", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException nEx) {
					JOptionPane
							.showConfirmDialog(
									null,
									"Trust Level should be a number in between 0 and 1",
									"Wrong Input",
									JOptionPane.OK_CANCEL_OPTION,
									JOptionPane.ERROR_MESSAGE);
				} catch (ParseException pEx) {
					JOptionPane.showConfirmDialog(null,
							"Hourly Wage should be a positive number",
							"Wrong Input", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(null,
							"Incorrect input, check all input fields",
							"Wrong Input", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		textField_1 = new JTextField();
		textField_1.setToolTipText("Hourly salary, positive number");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		GridBagConstraints gbc_btnSaveAsset = new GridBagConstraints();
		gbc_btnSaveAsset.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaveAsset.gridx = 12;
		gbc_btnSaveAsset.gridy = 4;
		add(btnSaveAsset, gbc_btnSaveAsset);

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

	}

}
