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
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;

import eu.muses.sim.Outcome;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.wp5.Clue;
import eu.muses.wp5.CluesThreatEntry;
import eu.muses.wp5.CluesThreatTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.List;

public class ThreatPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ThreatPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewAsset = new JLabel("New Threat");
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewAsset.gridwidth = 15;
		gbc_lblNewAsset.gridx = 1;
		gbc_lblNewAsset.gridy = 0;
		lblNewAsset.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblNewAsset, gbc_lblNewAsset);

		JLabel lblAddAThreat = new JLabel("Add a Threat Description:");
		GridBagConstraints gbc_lblAddAThreat = new GridBagConstraints();
		gbc_lblAddAThreat.anchor = GridBagConstraints.WEST;
		gbc_lblAddAThreat.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddAThreat.gridx = 0;
		gbc_lblAddAThreat.gridy = 1;
		lblAddAThreat.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblAddAThreat, gbc_lblAddAThreat);

		textField = new JTextField();
		textField.setToolTipText("add a textual description of the threat...");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 13;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblAttachAnOutcome = new JLabel(
				"Attach an Outcome to the Threat:");
		GridBagConstraints gbc_lblAttachAnOutcome = new GridBagConstraints();
		gbc_lblAttachAnOutcome.anchor = GridBagConstraints.WEST;
		gbc_lblAttachAnOutcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttachAnOutcome.gridx = 0;
		gbc_lblAttachAnOutcome.gridy = 3;
		lblAttachAnOutcome.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblAttachAnOutcome, gbc_lblAttachAnOutcome);

		final JComboBox<Outcome> comboBox = new JComboBox<Outcome>();
		if (GuiMain.getOutcomes() != null && !GuiMain.getOutcomes().isEmpty()) {
			for (Outcome o : GuiMain.getOutcomes()) {
				comboBox.addItem(o);
			}
		} else {
			comboBox.setModel(new DefaultComboBoxModel(
					new String[] { "ADD OUTCOMES FIRST" }));
		}
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 4;
		add(comboBox, gbc_comboBox);

		JLabel lblAttachAClue = new JLabel("Attach a Clue to the Threat:");
		GridBagConstraints gbc_lblAttachAClue = new GridBagConstraints();
		gbc_lblAttachAClue.anchor = GridBagConstraints.WEST;
		gbc_lblAttachAClue.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttachAClue.gridx = 0;
		gbc_lblAttachAClue.gridy = 5;
		lblAttachAClue.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblAttachAClue, gbc_lblAttachAClue);

		final JComboBox<Clue> comboBox_1 = new JComboBox<Clue>();
		CluesThreatTable table = GuiMain.getS2Rt2ae().getCluesThreatTable();
		for (CluesThreatEntry entry : table.getCluesThreatTable()) {
			List<Clue> clues = entry.getClues();
			for (Clue clue : clues) {
				comboBox_1.addItem(clue);
			}
		}
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.anchor = GridBagConstraints.WEST;
		gbc_comboBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 6;
		add(comboBox_1, gbc_comboBox_1);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 10;
		gbc_verticalStrut.gridy = 5;
		add(verticalStrut, gbc_verticalStrut);

		JButton btnSaveThreat = new JButton("Save Threat");
		btnSaveThreat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Threat t = new Threat(textField.getText(), new Probability(
							0.5), (Outcome) comboBox.getSelectedItem());
					CluesThreatTable table = GuiMain.getS2Rt2ae()
							.getCluesThreatTable();
					Collection<CluesThreatEntry> entries = table
							.getCluesThreatTable();
					for (CluesThreatEntry entry : entries) {
						List<Clue> clues = entry.getClues();
						if (clues.contains(comboBox_1.getSelectedItem())) {
							entry.setThreat(t);
						}
					}

					table.setCluesThreatTable(entries);
					System.out.println(table.toString());
					GuiMain.getS2Rt2ae().setCluesThreatTable(table);
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

		GridBagConstraints gbc_btnSaveThreat = new GridBagConstraints();
		gbc_btnSaveThreat.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveThreat.gridx = 10;
		gbc_btnSaveThreat.gridy = 6;
		add(btnSaveThreat, gbc_btnSaveThreat);

	}

}
