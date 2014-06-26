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

import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JButton;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

public class DatabreachCalculatorPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public DatabreachCalculatorPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0,
				1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblDataBreachCalculator = new JLabel("Data Breach Calculator");
		lblDataBreachCalculator.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblDataBreachCalculator = new GridBagConstraints();
		gbc_lblDataBreachCalculator.insets = new Insets(0, 0, 5, 0);
		gbc_lblDataBreachCalculator.gridwidth = 27;
		gbc_lblDataBreachCalculator.gridx = 0;
		gbc_lblDataBreachCalculator.gridy = 0;
		add(lblDataBreachCalculator, gbc_lblDataBreachCalculator);

		JLabel lblWhatIsYour = new JLabel(
				"1. What is your organization's industry classification?");
		lblWhatIsYour.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblWhatIsYour = new GridBagConstraints();
		gbc_lblWhatIsYour.ipady = 10;
		gbc_lblWhatIsYour.anchor = GridBagConstraints.WEST;
		gbc_lblWhatIsYour.insets = new Insets(0, 0, 5, 5);
		gbc_lblWhatIsYour.gridx = 0;
		gbc_lblWhatIsYour.gridy = 1;
		add(lblWhatIsYour, gbc_lblWhatIsYour);

		JLabel lblDoYouHave = new JLabel(
				"2. Do you have a privacy and data protection security policy?");
		lblDoYouHave.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblDoYouHave = new GridBagConstraints();
		gbc_lblDoYouHave.anchor = GridBagConstraints.WEST;
		gbc_lblDoYouHave.insets = new Insets(0, 0, 5, 5);
		gbc_lblDoYouHave.gridx = 1;
		gbc_lblDoYouHave.gridy = 1;
		add(lblDoYouHave, gbc_lblDoYouHave);

		final JComboBox<DataBreachQuestion> comboBox_1 = new JComboBox<DataBreachQuestion>();
		comboBox_1
				.addItem(new DataBreachQuestion("1", "Communications", "1.05"));
		comboBox_1.addItem(new DataBreachQuestion("1", "Consumer Products",
				"0.84"));
		comboBox_1.addItem(new DataBreachQuestion("1", "Education", "0.86"));
		comboBox_1.addItem(new DataBreachQuestion("1", "Financial Services",
				"1.33"));
		comboBox_1.addItem(new DataBreachQuestion("1", "Government", "0.80"));
		comboBox_1.addItem(new DataBreachQuestion("1", "Healthcare and Pharma",
				"1.25"));
		comboBox_1.addItem(new DataBreachQuestion("1", "Industrial", "0.93"));
		comboBox_1.addItem(new DataBreachQuestion("1", "Retail", "0.70"));
		comboBox_1.addItem(new DataBreachQuestion("1", "Services", "1.13"));
		comboBox_1.addItem(new DataBreachQuestion("1",
				"Technology and Software", "1.05"));
		comboBox_1
				.addItem(new DataBreachQuestion("1", "Transportation", "0.97"));
		comboBox_1.addItem(new DataBreachQuestion("1", "All Others", "1.09"));
		GridBagConstraints gbc_comboBoxOrganization = new GridBagConstraints();
		gbc_comboBoxOrganization.anchor = GridBagConstraints.WEST;
		gbc_comboBoxOrganization.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxOrganization.gridx = 0;
		gbc_comboBoxOrganization.gridy = 2;
		add(comboBox_1, gbc_comboBoxOrganization);

		final JComboBox<DataBreachQuestion> comboBox_2 = new JComboBox<DataBreachQuestion>();
		comboBox_2
				.addItem(new DataBreachQuestion(
						"2",
						"Yes, we have a formal program implemented across the entire enterprise",
						"0.75"));
		comboBox_2
				.addItem(new DataBreachQuestion(
						"2",
						"Yes, we have a formal program, but it is not implemented across the enterprise",
						"0.92"));
		comboBox_2
				.addItem(new DataBreachQuestion(
						"2",
						"Yes, we have an informal program implemented across the enterprise",
						"1.08"));
		comboBox_2
				.addItem(new DataBreachQuestion(
						"2",
						"Yes, we have an informal program, but it is not implemented across the enterprise",
						"1.12"));
		comboBox_2.addItem(new DataBreachQuestion("2",
				"No, we do not have a privacy or data protection program",
				"1.13"));
		GridBagConstraints gbc_comboBoxPrivacy = new GridBagConstraints();
		gbc_comboBoxPrivacy.anchor = GridBagConstraints.WEST;
		gbc_comboBoxPrivacy.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPrivacy.gridx = 1;
		gbc_comboBoxPrivacy.gridy = 2;
		add(comboBox_2, gbc_comboBoxPrivacy);

		JLabel lblNewLabel = new JLabel(
				"3. What types of information do your employees handle?");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.ipady = 10;
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblWhatDoYou = new JLabel(
				"4. What do you think is the most likely cause of a data breach?");
		lblWhatDoYou.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblWhatDoYou = new GridBagConstraints();
		gbc_lblWhatDoYou.anchor = GridBagConstraints.WEST;
		gbc_lblWhatDoYou.insets = new Insets(0, 0, 5, 5);
		gbc_lblWhatDoYou.gridx = 1;
		gbc_lblWhatDoYou.gridy = 3;
		add(lblWhatDoYou, gbc_lblWhatDoYou);

		final JComboBox<DataBreachQuestion> comboBox_3 = new JComboBox<DataBreachQuestion>();
		comboBox_3
				.addItem(new DataBreachQuestion("3", "Consumer data", "0.77"));
		comboBox_3.addItem(new DataBreachQuestion("3",
				"Customer data including credit card information", "1.13"));
		comboBox_3.addItem(new DataBreachQuestion("3",
				"Customer data excluding credit card information", "0.99"));
		comboBox_3.addItem(new DataBreachQuestion("3", "Employee records",
				"1.23"));
		comboBox_3.addItem(new DataBreachQuestion("3", "Citizen records",
				"0.71"));
		comboBox_3.addItem(new DataBreachQuestion("3", "Student information",
				"0.88"));
		comboBox_3.addItem(new DataBreachQuestion("3", "Patient health data",
				"1.32"));
		comboBox_3.addItem(new DataBreachQuestion("3",
				"No personal data stored", "0.97"));
		GridBagConstraints gbc_comboBoxInformationType = new GridBagConstraints();
		gbc_comboBoxInformationType.anchor = GridBagConstraints.WEST;
		gbc_comboBoxInformationType.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxInformationType.gridx = 0;
		gbc_comboBoxInformationType.gridy = 4;
		add(comboBox_3, gbc_comboBoxInformationType);

		final JComboBox<DataBreachQuestion> comboBox_4 = new JComboBox<DataBreachQuestion>();
		comboBox_4.addItem(new DataBreachQuestion("4",
				"Malicious or criminal attack", "1.31"));
		comboBox_4.addItem(new DataBreachQuestion("4",
				"Negligence or mistakes", "0.75"));
		comboBox_4
				.addItem(new DataBreachQuestion("4", "System glitch", "0.82"));
		comboBox_4.addItem(new DataBreachQuestion("4", "Don't know", "1.12"));
		GridBagConstraints gbc_comboBoxCauseDataBreach = new GridBagConstraints();
		gbc_comboBoxCauseDataBreach.anchor = GridBagConstraints.WEST;
		gbc_comboBoxCauseDataBreach.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCauseDataBreach.gridx = 1;
		gbc_comboBoxCauseDataBreach.gridy = 4;
		add(comboBox_4, gbc_comboBoxCauseDataBreach);

		JLabel lblNewLabel_1 = new JLabel(
				"5. Do your employees store sensitive data on laptops or on removable storage?");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.ipady = 10;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 5;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblIsSensitive = new JLabel(
				"6. Is sensitive data encrypted on all laptops or removable storage?");
		lblIsSensitive.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblIsSensitive = new GridBagConstraints();
		gbc_lblIsSensitive.anchor = GridBagConstraints.WEST;
		gbc_lblIsSensitive.insets = new Insets(0, 0, 5, 5);
		gbc_lblIsSensitive.gridx = 1;
		gbc_lblIsSensitive.gridy = 5;
		add(lblIsSensitive, gbc_lblIsSensitive);

		final JComboBox<DataBreachQuestion> comboBox_5 = new JComboBox<DataBreachQuestion>();
		comboBox_5.addItem(new DataBreachQuestion("5", "Yes", "1.05"));
		comboBox_5.addItem(new DataBreachQuestion("5", "No", "0.95"));
		GridBagConstraints gbc_comboBoxStorage = new GridBagConstraints();
		gbc_comboBoxStorage.anchor = GridBagConstraints.WEST;
		gbc_comboBoxStorage.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxStorage.gridx = 0;
		gbc_comboBoxStorage.gridy = 6;
		add(comboBox_5, gbc_comboBoxStorage);

		final JComboBox<DataBreachQuestion> comboBox_6 = new JComboBox<DataBreachQuestion>();
		comboBox_6.addItem(new DataBreachQuestion("6", "Yes", "0.61"));
		comboBox_6.addItem(new DataBreachQuestion("6", "No", "1.27"));
		comboBox_6.addItem(new DataBreachQuestion("6", "Not Sure", "1.12"));
		GridBagConstraints gbc_comboBoxEncrypted = new GridBagConstraints();
		gbc_comboBoxEncrypted.anchor = GridBagConstraints.WEST;
		gbc_comboBoxEncrypted.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxEncrypted.gridx = 1;
		gbc_comboBoxEncrypted.gridy = 6;
		add(comboBox_6, gbc_comboBoxEncrypted);

		JLabel lblNewLabel_2 = new JLabel(
				"7. Does your organization have a dedicated information security leader, such as a chief information security officer (CISO)?");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.ipady = 10;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 7;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(
				"8. What is the global headcount of your organization?");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 7;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		final JComboBox<DataBreachQuestion> comboBox_7 = new JComboBox<DataBreachQuestion>();
		comboBox_7.addItem(new DataBreachQuestion("7", "Yes", "0.88"));
		comboBox_7.addItem(new DataBreachQuestion("7", "No", "1.09"));
		comboBox_7.addItem(new DataBreachQuestion("7", "Not Sure", "1.03"));
		GridBagConstraints gbc_comboBoxSecurityLeader = new GridBagConstraints();
		gbc_comboBoxSecurityLeader.anchor = GridBagConstraints.WEST;
		gbc_comboBoxSecurityLeader.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxSecurityLeader.gridx = 0;
		gbc_comboBoxSecurityLeader.gridy = 8;
		add(comboBox_7, gbc_comboBoxSecurityLeader);

		final JComboBox<DataBreachQuestion> comboBox_8 = new JComboBox<DataBreachQuestion>();
		comboBox_8
				.addItem(new DataBreachQuestion("8", "Less than 500", "0.82"));
		comboBox_8.addItem(new DataBreachQuestion("8", "Between 501 to 1,000",
				"0.90"));
		comboBox_8.addItem(new DataBreachQuestion("8",
				"Between 1,001 to 5,000", "1.03"));
		comboBox_8.addItem(new DataBreachQuestion("8",
				"Between 5,001 to 10,000", "1.12"));
		comboBox_8.addItem(new DataBreachQuestion("8",
				"Between 10,001 to 25,000", "1.17"));
		comboBox_8.addItem(new DataBreachQuestion("8",
				"Between 25,001 to 75,000", "1.04"));
		comboBox_8.addItem(new DataBreachQuestion("8", "More than 75,000",
				"0.92"));
		GridBagConstraints gbc_comboBoxHeadCount = new GridBagConstraints();
		gbc_comboBoxHeadCount.anchor = GridBagConstraints.WEST;
		gbc_comboBoxHeadCount.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxHeadCount.gridx = 1;
		gbc_comboBoxHeadCount.gridy = 8;
		add(comboBox_8, gbc_comboBoxHeadCount);

		JLabel lblWhatIsThe = new JLabel(
				"9. What is the global footprint of your organization?");
		lblWhatIsThe.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblWhatIsThe = new GridBagConstraints();
		gbc_lblWhatIsThe.ipady = 10;
		gbc_lblWhatIsThe.anchor = GridBagConstraints.WEST;
		gbc_lblWhatIsThe.insets = new Insets(0, 0, 5, 5);
		gbc_lblWhatIsThe.gridx = 0;
		gbc_lblWhatIsThe.gridy = 9;
		add(lblWhatIsThe, gbc_lblWhatIsThe);

		JLabel lblNewLabel_4 = new JLabel(
				"10. Do you allow employees or partners to access your sensitive networks or applications from a remote location?");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 9;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		final JComboBox<DataBreachQuestion> comboBox_9 = new JComboBox<DataBreachQuestion>();
		comboBox_9.addItem(new DataBreachQuestion("9",
				"Operations in one country", "0.89"));
		comboBox_9.addItem(new DataBreachQuestion("9",
				"Operations in a few countries, in one global region", "0.93"));
		comboBox_9.addItem(new DataBreachQuestion("9",
				"Operations in many countries, in one global region", "1.05"));
		comboBox_9.addItem(new DataBreachQuestion("9",
				"Operations in all global regions", "1.13"));
		GridBagConstraints gbc_comboBoxFootprint = new GridBagConstraints();
		gbc_comboBoxFootprint.anchor = GridBagConstraints.WEST;
		gbc_comboBoxFootprint.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxFootprint.gridx = 0;
		gbc_comboBoxFootprint.gridy = 10;
		add(comboBox_9, gbc_comboBoxFootprint);

		final JComboBox<DataBreachQuestion> comboBox_10 = new JComboBox<DataBreachQuestion>();
		comboBox_10.addItem(new DataBreachQuestion("10",
				"Yes, but only if they use a corporate device", "0.01"));
		comboBox_10.addItem(new DataBreachQuestion("10",
				"Yes, using either a corporate or personal devices", "0.02"));
		comboBox_10.addItem(new DataBreachQuestion("10",
				"No, no remote access allowed at all", "0.03"));
		GridBagConstraints gbc_comboBoxRemoteAccess = new GridBagConstraints();
		gbc_comboBoxRemoteAccess.anchor = GridBagConstraints.WEST;
		gbc_comboBoxRemoteAccess.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxRemoteAccess.gridx = 1;
		gbc_comboBoxRemoteAccess.gridy = 10;
		add(comboBox_10, gbc_comboBoxRemoteAccess);

		JLabel lblNewLabel_5 = new JLabel(
				"11. Which strong authentication measures have you deployed to protect sensitive networks and applications from unauthorized access?");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.ipady = 10;
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 11;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel(
				"12. Where is your organization's headquarters or where does it conduct the majority of its business?");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 11;
		add(lblNewLabel_6, gbc_lblNewLabel_6);

		final JComboBox<DataBreachQuestion> comboBox_11 = new JComboBox<DataBreachQuestion>();
		comboBox_11
				.addItem(new DataBreachQuestion(
						"11",
						"Two-factor authentication using hardware or software tokens, such as RSA SecurID",
						"1.01"));
		comboBox_11
				.addItem(new DataBreachQuestion(
						"11",
						"Two-factor authentication using user or device-specific digital certificates",
						"1.02"));
		comboBox_11
				.addItem(new DataBreachQuestion(
						"11",
						"Risk-based authentication that profiles user or device behavior",
						"1.03"));
		comboBox_11.addItem(new DataBreachQuestion("11",
				"No strong authentication deployed", "1.04"));
		GridBagConstraints gbc_comboBoxAuthentication = new GridBagConstraints();
		gbc_comboBoxAuthentication.anchor = GridBagConstraints.WEST;
		gbc_comboBoxAuthentication.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAuthentication.gridx = 0;
		gbc_comboBoxAuthentication.gridy = 12;
		add(comboBox_11, gbc_comboBoxAuthentication);

		final JComboBox<DataBreachQuestion> comboBox_12 = new JComboBox<DataBreachQuestion>();
		comboBox_12.addItem(new DataBreachQuestion("12", "United States - USD",
				"188"));
		comboBox_12.addItem(new DataBreachQuestion("12",
				"United Kingdom - GBP", "86"));
		comboBox_12
				.addItem(new DataBreachQuestion("12", "Germany - EUR", "151"));
		comboBox_12
				.addItem(new DataBreachQuestion("12", "France - EUR", "127"));
		comboBox_12.addItem(new DataBreachQuestion("12", "Australia - AUD",
				"129"));
		comboBox_12.addItem(new DataBreachQuestion("12", "Italy - EUR", "95"));
		comboBox_12
				.addItem(new DataBreachQuestion("12", "India - INR", "2271"));
		comboBox_12
				.addItem(new DataBreachQuestion("12", "Japan - JPY", "12263"));
		comboBox_12.addItem(new DataBreachQuestion("12", "All Others - USD",
				"136"));
		GridBagConstraints gbc_comboBoxLocation = new GridBagConstraints();
		gbc_comboBoxLocation.anchor = GridBagConstraints.WEST;
		gbc_comboBoxLocation.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxLocation.gridx = 1;
		gbc_comboBoxLocation.gridy = 12;
		add(comboBox_12, gbc_comboBoxLocation);

		JLabel lblNewLabel_7 = new JLabel(
				"13. How many records do you estimate would be at risk in the event of a data breach?");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.ipady = 10;
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 13;
		add(lblNewLabel_7, gbc_lblNewLabel_7);

		final JComboBox<DataBreachQuestion> comboBox_13 = new JComboBox<DataBreachQuestion>();
		comboBox_13.addItem(new DataBreachQuestion("13", "Less than 1,000",
				"500"));
		comboBox_13.addItem(new DataBreachQuestion("13", "1,001 to 5,000",
				"3000"));
		comboBox_13.addItem(new DataBreachQuestion("13", "5,001 to 10,0000",
				"7500"));
		comboBox_13.addItem(new DataBreachQuestion("13", "10,001 to 25,000",
				"17500"));
		comboBox_13.addItem(new DataBreachQuestion("13", "25,001 to 50,000",
				"37500"));
		comboBox_13.addItem(new DataBreachQuestion("13", "50,001 to 100,000",
				"75000"));
		comboBox_13.addItem(new DataBreachQuestion("13", "More than 100,000",
				"120000"));

		JLabel lblBenefitsComputation = new JLabel("Benefits Computation");
		lblBenefitsComputation.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblBenefitsComputation = new GridBagConstraints();
		gbc_lblBenefitsComputation.gridwidth = 3;
		gbc_lblBenefitsComputation.insets = new Insets(0, 0, 5, 5);
		gbc_lblBenefitsComputation.gridx = 4;
		gbc_lblBenefitsComputation.gridy = 12;
		add(lblBenefitsComputation, gbc_lblBenefitsComputation);
		GridBagConstraints gbc_comboBoxRecordRisk = new GridBagConstraints();
		gbc_comboBoxRecordRisk.anchor = GridBagConstraints.WEST;
		gbc_comboBoxRecordRisk.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxRecordRisk.gridx = 0;
		gbc_comboBoxRecordRisk.gridy = 14;
		add(comboBox_13, gbc_comboBoxRecordRisk);

		JLabel lblNewLabel_14 = new JLabel("Number of Consultants:");
		lblNewLabel_14.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.ipadx = 40;
		gbc_lblNewLabel_14.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 3;
		gbc_lblNewLabel_14.gridy = 14;
		add(lblNewLabel_14, gbc_lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("Hours waiting per month:");
		lblNewLabel_15.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.ipadx = 40;
		gbc_lblNewLabel_15.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_15.gridx = 4;
		gbc_lblNewLabel_15.gridy = 14;
		add(lblNewLabel_15, gbc_lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel("Hourly Salary:");
		lblNewLabel_16.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 5;
		gbc_lblNewLabel_16.gridy = 14;
		add(lblNewLabel_16, gbc_lblNewLabel_16);

		textField = new JTextField("0");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 15;
		add(textField, gbc_textField);
		textField.setColumns(10);

		textField_1 = new JTextField("0");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 15;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField("0");
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 15;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		JLabel lblBasedOnYour = new JLabel(
				"Based on your inputs and our trend data, your risk exposure is:");
		lblBasedOnYour.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblBasedOnYour = new GridBagConstraints();
		gbc_lblBasedOnYour.ipady = 30;
		gbc_lblBasedOnYour.anchor = GridBagConstraints.WEST;
		gbc_lblBasedOnYour.insets = new Insets(0, 0, 5, 5);
		gbc_lblBasedOnYour.gridx = 0;
		gbc_lblBasedOnYour.gridy = 20;
		add(lblBasedOnYour, gbc_lblBasedOnYour);

		JLabel lblPotentialBenefit = new JLabel("Potential Benefit: ");
		lblPotentialBenefit.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPotentialBenefit = new GridBagConstraints();
		gbc_lblPotentialBenefit.anchor = GridBagConstraints.EAST;
		gbc_lblPotentialBenefit.insets = new Insets(0, 0, 5, 5);
		gbc_lblPotentialBenefit.gridx = 1;
		gbc_lblPotentialBenefit.gridy = 20;
		add(lblPotentialBenefit, gbc_lblPotentialBenefit);

		final JLabel label = new JLabel("");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 20;
		add(label, gbc_label);

		final JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 1;
		gbc_lblNewLabel_11.gridy = 22;
		add(lblNewLabel_11, gbc_lblNewLabel_11);

		final JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 1;
		gbc_lblNewLabel_12.gridy = 23;
		add(lblNewLabel_12, gbc_lblNewLabel_12);

		final JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_13.gridx = 1;
		gbc_lblNewLabel_13.gridy = 24;
		add(lblNewLabel_13, gbc_lblNewLabel_13);

		final JLabel lblNewLabel_8 = new JLabel(
				"Companies in your industry with your risk profile have a likelihood of experiencing a data breach in the next 12 months of: ");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 22;
		add(lblNewLabel_8, gbc_lblNewLabel_8);

		final JLabel lblNewLabel_9 = new JLabel(
				"Your average cost per record is: ");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 23;
		add(lblNewLabel_9, gbc_lblNewLabel_9);

		final JLabel lblNewLabel_10 = new JLabel(
				"Your average cost per breach is: ");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 24;
		add(lblNewLabel_10, gbc_lblNewLabel_10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblNewLabel_11.setText("Waiting...");
				lblNewLabel_12.setText("Waiting...");
				lblNewLabel_13.setText("Waiting...");

				HttpClient httpClient = HttpClientBuilder.create().build();
				HttpPost httpPost = new HttpPost(
						"http://databreachcalculator.com/Calculator/Default.aspx?q=1");
				// Request parameters and other properties.
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair(getQuestionFromCombobox(
						comboBox_1).getId(),
						getQuestionFromCombobox(comboBox_1).getValue()));
				params.add(new BasicNameValuePair(getQuestionFromCombobox(
						comboBox_2).getId(),
						getQuestionFromCombobox(comboBox_2).getValue()));
				params.add(new BasicNameValuePair(getQuestionFromCombobox(
						comboBox_3).getId(),
						getQuestionFromCombobox(comboBox_3).getValue()));
				params.add(new BasicNameValuePair(getQuestionFromCombobox(
						comboBox_4).getId(),
						getQuestionFromCombobox(comboBox_4).getValue()));
				params.add(new BasicNameValuePair(getQuestionFromCombobox(
						comboBox_5).getId(),
						getQuestionFromCombobox(comboBox_5).getValue()));
				params.add(new BasicNameValuePair(getQuestionFromCombobox(
						comboBox_6).getId(),
						getQuestionFromCombobox(comboBox_6).getValue()));
				params.add(new BasicNameValuePair(getQuestionFromCombobox(
						comboBox_7).getId(),
						getQuestionFromCombobox(comboBox_7).getValue()));
				params.add(new BasicNameValuePair(getQuestionFromCombobox(
						comboBox_8).getId(),
						getQuestionFromCombobox(comboBox_8).getValue()));
				params.add(new BasicNameValuePair(getQuestionFromCombobox(
						comboBox_9).getId(),
						getQuestionFromCombobox(comboBox_9).getValue()));
				params.add(new BasicNameValuePair(getQuestionFromCombobox(
						comboBox_10).getId(), getQuestionFromCombobox(
						comboBox_10).getValue()));
				params.add(new BasicNameValuePair(getQuestionFromCombobox(
						comboBox_11).getId(), getQuestionFromCombobox(
						comboBox_11).getValue()));
				params.add(new BasicNameValuePair(getQuestionFromCombobox(
						comboBox_12).getId(), getQuestionFromCombobox(
						comboBox_12).getValue()));
				params.add(new BasicNameValuePair(getQuestionFromCombobox(
						comboBox_13).getId(), getQuestionFromCombobox(
						comboBox_13).getValue()));
				params.add(new BasicNameValuePair("numquestions", "11"));
				params.add(new BasicNameValuePair("numquestionstocalc", "9"));
				try {
					httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
				} catch (UnsupportedEncodingException ex) {
					// writing error to Log
					ex.printStackTrace();
				}
				/*
				 * Execute the HTTP Request
				 */
				try {
					HttpResponse response = httpClient.execute(httpPost);
					HttpEntity respEntity = response.getEntity();

					if (respEntity != null) {
						// EntityUtils to get the response content
						HttpGet httpGet = new HttpGet(
								"http://databreachcalculator.com/Calculator/Result.aspx");

						HttpResponse responseGet = httpClient.execute(httpGet);
						HttpEntity respGetEntity = responseGet.getEntity();

						if (respGetEntity != null) {
							// EntityUtils to get the response content
							String contentGet = EntityUtils
									.toString(respGetEntity);
							Document doc = Jsoup.parse(contentGet);
							Elements results = doc.select("span.answer");
							int i = 0;
							for (Element element : results) {
								if (i == 0)
									lblNewLabel_11.setText(element.text());
								if (i == 1)
									lblNewLabel_12.setText(element.text());
								if (i == 2)
									lblNewLabel_13.setText(element.text());
								i++;
							}
						}
					}
					
					DecimalFormat df = new DecimalFormat("#");
			        df.setMaximumFractionDigits(3);

					label.setText(df.format((Double.valueOf(textField
							.getText())
							* Double.valueOf(textField_1.getText())
							* Double.valueOf(textField_2.getText()) * 12)) + "$");

				} catch (ClientProtocolException ex) {
					// writing exception to log
					ex.printStackTrace();
				} catch (IOException ex) {
					// writing exception to log
					ex.printStackTrace();
				}

			}
		});

		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridwidth = 6;
		gbc_btnSubmit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 18;
		add(btnSubmit, gbc_btnSubmit);

	}

	private DataBreachQuestion getQuestionFromCombobox(
			JComboBox<DataBreachQuestion> comboBox) {
		DataBreachQuestion question = new DataBreachQuestion();
		question = (DataBreachQuestion) comboBox.getSelectedItem();
		return question;
	}

}
