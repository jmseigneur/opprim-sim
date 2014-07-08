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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.Component;

import javax.swing.Box;

import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.userman.action.AccessAction;
import eu.muses.sim.userman.action.GiveUpAction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PrivacyShieldPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private TableRowSorter<DefaultTableModel> sorter;
	private int modelRow;
	private int viewRow;

	/**
	 * Create the panel.
	 */
	public PrivacyShieldPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewAsset = new JLabel("Logged Access Requests");
		GridBagConstraints gbc_lblNewAsset = new GridBagConstraints();
		gbc_lblNewAsset.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewAsset.gridwidth = 16;
		gbc_lblNewAsset.gridx = 0;
		gbc_lblNewAsset.gridy = 0;
		lblNewAsset.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lblNewAsset, gbc_lblNewAsset);

		JLabel lblFilterByAsset = new JLabel("Filter by Asset:");
		lblFilterByAsset.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblFilterByAsset = new GridBagConstraints();
		gbc_lblFilterByAsset.anchor = GridBagConstraints.WEST;
		gbc_lblFilterByAsset.insets = new Insets(0, 0, 5, 5);
		gbc_lblFilterByAsset.gridx = 1;
		gbc_lblFilterByAsset.gridy = 2;
		add(lblFilterByAsset, gbc_lblFilterByAsset);

		textField = new JTextField();
		textField.setToolTipText("ty the name of an asset to filter");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblFilterByUser = new JLabel("Filter by User:");
		lblFilterByUser.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblFilterByUser = new GridBagConstraints();
		gbc_lblFilterByUser.anchor = GridBagConstraints.WEST;
		gbc_lblFilterByUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblFilterByUser.gridx = 3;
		gbc_lblFilterByUser.gridy = 2;
		add(lblFilterByUser, gbc_lblFilterByUser);

		textField_1 = new JTextField();
		textField_1.setToolTipText("tipe the name of a user to filter");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 2;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 12;
		gbc_verticalStrut_1.gridy = 3;
		add(verticalStrut_1, gbc_verticalStrut_1);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 14;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);

		final DefaultTableModel model = new DefaultTableModel();
		sorter = new TableRowSorter<DefaultTableModel>(model);
		model.addColumn("Asset");
		model.addColumn("User");
		model.addColumn("Threat");
		model.addColumn("User Action");
		model.addColumn("Status");
		model.addColumn("Timestamp");

		for (AccessRequest ar : GuiMain.getPersistenceManager()
				.getAccessRequests()) {
			String userAction = "";
			String status = "";
			if (ar.isSolved())
				status = "Solved";
			else
				status = "Pending Report";
			if (ar.getUserAction().getClass().equals(GiveUpAction.class))
				userAction = "Not Accessed";
			if (ar.getUserAction().getClass().equals(AccessAction.class))
				userAction = "Accessed";
			model.addRow(new String[] {
					ar.getOpportunityDescriptor().getRequestedAssets()
							.iterator().next().getAssetName(),
					ar.getUser().getNickname(),
					ar.getCluesThreatEntry().getThreat().getDescription(),
					userAction, status, Long.toString(ar.getTime().getTimeInMillis()) });
		}

		table = new JTable(model);
		table.setRowSorter(sorter);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// When selection changes, provide user with row numbers for
		// both view and model.
		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						viewRow = table.getSelectedRow();
						if (viewRow < 0) {
							// Selection got filtered away.
						} else {
							modelRow = table.convertRowIndexToModel(viewRow);
							System.out.println(String.format(
									"Selected Row in view: %d. "
											+ "Selected Row in model: %d.",
									viewRow, modelRow));
						}
					}
				});
		scrollPane.setViewportView(table);

		textField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				newFilter();
			}

			public void insertUpdate(DocumentEvent e) {
				newFilter();
			}

			public void removeUpdate(DocumentEvent e) {
				newFilter();
			}
		});

		textField_1.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				newFilter2();
			}

			public void insertUpdate(DocumentEvent e) {
				newFilter2();
			}

			public void removeUpdate(DocumentEvent e) {
				newFilter2();
			}
		});

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 12;
		gbc_verticalStrut.gridy = 4;
		add(verticalStrut, gbc_verticalStrut);

		JButton btnSaveClue = new JButton("Anonymize Access Request");
		btnSaveClue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccessRequest ar = GuiMain.getPersistenceManager()
				.getAccessRequests().get(modelRow);
				GuiMain.getPersistenceManager().anonymizeAccessReqeuests(new ArrayList<AccessRequest>(Arrays.asList(ar)));
				JPanel privacyShieldPanel = new PrivacyShieldPanel();
				GuiMain.switchPanel(privacyShieldPanel);
			}		
		});

		JButton btnClearAssetFrom = new JButton("Go Back");
		btnClearAssetFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GuiMain.initializeHomePanel();
					JPanel mainPanel = GuiMain.getMainPanel();
					GuiMain.switchPanel(mainPanel);
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showConfirmDialog(null,
							"Something went wrong with the simulation",
							"Error", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnClearAssetFrom = new GridBagConstraints();
		gbc_btnClearAssetFrom.insets = new Insets(0, 0, 0, 5);
		gbc_btnClearAssetFrom.gridx = 13;
		gbc_btnClearAssetFrom.gridy = 5;
		add(btnClearAssetFrom, gbc_btnClearAssetFrom);
		GridBagConstraints gbc_btnSaveClue = new GridBagConstraints();
		gbc_btnSaveClue.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveClue.gridx = 14;
		gbc_btnSaveClue.gridy = 5;
		add(btnSaveClue, gbc_btnSaveClue);

	}

	private void newFilter() {
		RowFilter<DefaultTableModel, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(textField.getText(), 0);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	private void newFilter2() {
		RowFilter<DefaultTableModel, Object> rfs = null;
		// If current expression doesn't parse, don't update.
		try {
			rfs = RowFilter.regexFilter(textField_1.getText(), 1);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rfs);
	}
}
