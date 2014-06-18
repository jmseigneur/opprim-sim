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
import eu.muses.wp5.CluesThreatEntry;
import eu.muses.wp5.CluesThreatTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class CluesandThreatsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAddAsset;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CluesandThreatsPanel() {

		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewAsset = new JLabel("Clues and Threats Table");
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewAsset.gridwidth = 17;
		gbc_lblNewAsset.gridx = 0;
		gbc_lblNewAsset.gridy = 0;
		lblNewAsset.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblNewAsset, gbc_lblNewAsset);

		CluesThreatTable tableCluesThreats = GuiMain.getPersistenceManager()
				.getCluesThreatTable();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Clues");
		model.addColumn("Threat");
		model.addColumn("Probability");

		Collection<CluesThreatEntry> cluesThreatEntries = tableCluesThreats
				.getCluesThreatTable();

		for (CluesThreatEntry entry : cluesThreatEntries) {
			System.out.println(entry.getCluesAsString());
			System.out.println(entry.getThreat().getDescription());
			System.out.println(String.valueOf(entry.getThreat()
					.getProbability().getProb()));
			model.addRow(new String[] {
					entry.getCluesAsString(),
					entry.getThreat().getDescription(),
					String.valueOf(entry.getThreat().getProbability().getProb()) });
		}

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		table = new JTable(model);
		scrollPane.setViewportView(table);
		scrollPane.setBackground(Color.WHITE);
		table.setRowSelectionAllowed(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(Color.WHITE);

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

		JButton btnSaveAsset = new JButton("Go Back");
		btnSaveAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GuiMain.initializeHomePanel();
					JPanel mainPanel = GuiMain.getMainPanel();
					GuiMain.switchPanel(mainPanel);
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane
							.showConfirmDialog(
									null,
									"Clues and Threats couldn't be retrieved, try later",
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
