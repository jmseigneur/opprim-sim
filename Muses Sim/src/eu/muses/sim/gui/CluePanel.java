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
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;

import eu.muses.sim.persistence.InMemoryPersistenceManager;
import eu.muses.wp5.Clue;
import eu.muses.wp5.CluesThreatTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class CluePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField textField;

	/**
	 * Create the panel.
	 */
	public CluePanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewAsset = new JLabel("New Clue");
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewAsset.gridwidth = 15;
		gbc_lblNewAsset.gridx = 1;
		gbc_lblNewAsset.gridy = 0;
		lblNewAsset.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblNewAsset, gbc_lblNewAsset);

		JLabel lblAddClue = new JLabel("Add Clue:");
		GridBagConstraints gbc_lblAddClue = new GridBagConstraints();
		gbc_lblAddClue.gridwidth = 4;
		gbc_lblAddClue.anchor = GridBagConstraints.WEST;
		gbc_lblAddClue.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddClue.gridx = 0;
		gbc_lblAddClue.gridy = 1;
		lblAddClue.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblAddClue, gbc_lblAddClue);

		textField = new JTextField();
		textField.setToolTipText("name the clue...");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 10;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 12;
		gbc_verticalStrut_1.gridy = 3;
		add(verticalStrut_1, gbc_verticalStrut_1);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 12;
		gbc_verticalStrut.gridy = 4;
		add(verticalStrut, gbc_verticalStrut);

		JButton btnSaveClue = new JButton("Save Clue");
		btnSaveClue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Clue c = new Clue(textField.getText());
					GuiMain.getPersistenceManager().getClues().add(c);
					GuiMain.initializeHomePanel();
					JPanel mainPanel = GuiMain.getMainPanel();
					GuiMain.switchPanel(mainPanel);
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showConfirmDialog(null,
							"Input should be correctly filled", "Wrong Input",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		GridBagConstraints gbc_btnSaveClue = new GridBagConstraints();
		gbc_btnSaveClue.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveClue.gridx = 12;
		gbc_btnSaveClue.gridy = 5;
		add(btnSaveClue, gbc_btnSaveClue);

	}

}
