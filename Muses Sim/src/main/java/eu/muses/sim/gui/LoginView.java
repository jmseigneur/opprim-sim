package eu.muses.sim.gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.userman.User;

import java.awt.Color;
import java.awt.Component;
import java.awt.MenuBar;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginView {

	public static void main(String[] args) {
		final JFrame frame = new JFrame("Login");
		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);

		panel.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		final JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		final JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setBounds(214, 97, 80, 25);
		panel.add(loginButton);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBounds(10, 97, 80, 25);
		panel.add(btnNewButton);
	
		ActionListener btnNewButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				GuiMain.initializeHomePanel();				
				GuiMain.frmMusesRtae.setVisible(true);
				JPanel ODPanel = new JPanel();
				GuiMain.switchPanel(ODPanel);
				GuiMain.frmMusesRtae.getJMenuBar().setVisible(true);
				JLabel backgroundImage = new JLabel();
				backgroundImage.setIcon(new ImageIcon(GuiMain.class
						.getResource("/eu/muses/sim/gui/muses-title.png")));
				ODPanel.setBackground(new Color(255, 255, 255));
				BoxLayout layout = new BoxLayout(ODPanel, BoxLayout.X_AXIS);
				ODPanel.setLayout(layout);
				ODPanel.add(Box.createHorizontalGlue());
				ODPanel.add(backgroundImage);
				ODPanel.add(Box.createHorizontalGlue());
				
			}
			
		};
		
		btnNewButton.addActionListener(btnNewButtonListener);
		
		
		ActionListener loginButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				String user = userText.getText();
				String password = passwordText.getText();
				String user1 = GuiMain.getPersistenceManager().getPsw();
				String psw1 = GuiMain.getPersistenceManager().getUsername();
				
				/*
				int index = -1;
                for(int i = 0; i<GuiMain.persistenceManager.getSimUsers().size(); i++) {
                	
                	System.out.println(GuiMain.persistenceManager.getSimUsers().get(i).getNickname());
                	if (GuiMain.persistenceManager.getSimUsers().get(i).getNickname().contains(user) && GuiMain.persistenceManager.getSimUsers().get(i).getPassword().contains(password)) {
                		
                		GuiMain.frmMusesRtae.setVisible(true);
        				JPanel ODPanel = new InstallPanel();
        				GuiMain.switchPanel(ODPanel);
        				GuiMain.frmMusesRtae.getJMenuBar().setVisible(false);
                		
                		break;
                	}
                }
               */
				
				if ("user".equals(user) && "user".equals(password)) {

					GuiMain.frmMusesRtae.setVisible(true);
					JPanel ODPanel = new InstallPanel();
					GuiMain.switchPanel(ODPanel);
					GuiMain.frmMusesRtae.getJMenuBar().setVisible(false);
				
				}else if ("admin".equals(user) && "admin".equals(password))	{
					GuiMain.frmMusesRtae.setVisible(true);
					JPanel ODPanel = new AdminClient();
					GuiMain.switchPanel(ODPanel);
					GuiMain.frmMusesRtae.getJMenuBar().setVisible(false);
					
				}else if(user.equals(user) && psw1.equals(password)){
					
					GuiMain.frmMusesRtae.setVisible(true);
				JPanel ODPanel = new InstallPanel();
				GuiMain.switchPanel(ODPanel);
				GuiMain.frmMusesRtae.getJMenuBar().setVisible(false);
				}else if (GuiMain.persistenceManager.getSimUsers() != null){
					int index = -1;
					for(int i = 0; i<GuiMain.persistenceManager.getSimUsers().size(); i++) {
	                	
	                	System.out.println(GuiMain.persistenceManager.getSimUsers().get(i).getNickname());
	                	if (GuiMain.persistenceManager.getSimUsers().get(i).getNickname().contains(user) && GuiMain.persistenceManager.getSimUsers().get(i).getPassword().contains(password)) {
	                		System.out.println("true");
	                		GuiMain.frmMusesRtae.setVisible(true);
	        				JPanel ODPanel = new InstallPanel();
	        				GuiMain.switchPanel(ODPanel);
	        				GuiMain.frmMusesRtae.getJMenuBar().setVisible(false);
	                		
	                		break;
	                	}
	                }
				
				}else{
					JOptionPane.showMessageDialog(null, "login failed");
				}
				frame.dispose();
			}
		};
		
		loginButton.addActionListener(loginButtonListener);
		
		
		
		
	
		frame.setVisible(true);
	}
}