
package eu.muses.sim.gui;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Component;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * The class AssetPanel
 * It provides a GUI to add new assets for simulation purposes.
 */
public class LoginPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtUsername;
	private JTextField tx;
	
	
	public LoginPanel() {
		JPanel panel1 = new JPanel();

		panel1.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel1.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel1.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel1.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel1.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		panel1.add(loginButton);
		
		JButton registerButton = new JButton("register");
		registerButton.setBounds(180, 80, 80, 25);
		panel1.add(registerButton);
	
		ActionListener loginButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				JOptionPane.showMessageDialog(source, source.getText()
						+ " button has been pressed");
			}
		};
		
		loginButton.addActionListener(loginButtonListener);
		
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog((Component) e.getSource(),
						"button has been pressed");
			}
		});
	
	}
}
