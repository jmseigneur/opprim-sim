package eu.muses.sim.gui;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;

import javax.crypto.spec.PSource;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

import org.apache.commons.lang3.StringUtils;

import com.udojava.evalex.Expression;

import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.complexpolicy.ComplexPolicy;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.trustman.TrustValue;
import antlr.collections.List;


public class selectedFilePanel extends JPanel{
	
	/**
	 * 
	 */
	public String root = "/Users/jonathan/Desktop/asset";
	public String root1 = "/Users/jonathan/Desktop/asset/";
	private static final long serialVersionUID = 1L;
	private ComplexPolicy cp;
	private BigDecimal result = null;
	private Asset myasset = null;

	/**
	 * Creates and sets up the panel.
	 */
	public selectedFilePanel() {
		GuiMain.persistenceManager.getSelectedAssetsbyUser().clear();
		
		setToolTipText("");
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JLabel lblWitchFile = new JLabel("Which file would you like to download ?");
		lblWitchFile.setVerticalAlignment(SwingConstants.TOP);
		lblWitchFile.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblWitchFile);

		final JList displayList = new JList(new File(root).listFiles());
        displayList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        displayList.setCellRenderer(new MyCellRenderer());
        displayList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        
		JScrollPane areaScrollPane = new JScrollPane(displayList);
		areaScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(250, 250));
		add(areaScrollPane);

		JButton btnBack = new JButton("Home");
		
		btnBack.addActionListener(new ActionListener() {
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
			
		});
		add(btnBack);
		
		 final JFrame f = new JFrame("Asset");
	        f.setPreferredSize(new Dimension(500, 300));
	        f.pack();
	        
        displayList.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
            	String yo = displayList.getSelectedValue().toString();
                Object selected = displayList.getSelectedValue().toString();
                String ItemSelected = StringUtils.remove(yo, root1);
                int fin = ItemSelected.indexOf('.'); 
    			
    			myasset = GuiMain.getPersistenceManager().findAssetbyName(ItemSelected.substring(0,fin));
				System.out.println("Asset name1 : "+ItemSelected.substring(0,fin));
				if(myasset!=null){
					System.out.println("Asset name1 : "+myasset.getAssetName());
				}

    			GuiMain.persistenceManager.getSelectedAssetsbyUser().add(myasset);
    			System.out.println(ItemSelected +"menuList.addMouseListener.mousePressed selected=" + selected);
                //JOptionPane.showMessageDialog(null, "Opportunity not allowed");
				System.out.println("Asset name1 : "+GuiMain.persistenceManager.getAssets().size());
				System.out.println("Asset size : "+GuiMain.persistenceManager.getSelectedAssetsbyUser().size());

                try{
					double maxCostThreat = 0;
                	for (Asset asset : GuiMain.persistenceManager.getSelectedAssetsbyUser()) {

                		maxCostThreat = maxCostThreat + asset.getValue();
    					System.out.println("Asset : "+asset.getAssetName());

                	}
					
					SimUser user = new SimUser("user1", 120, new TrustValue(0.5), "pass");
					
					double costOpportunity = 0; 
					
					System.out.println("Asset name1 : "+myasset.getAssetName());
					
					ComplexPolicy cp = GuiMain.persistenceManager.getAdminConf().getCompleyRiskPolicy();

					double oppBenefit = costOpportunity - myasset.getValue();

					System.out.println("oppBenefit: " +oppBenefit);
					
					System.out.println("policy: " +cp.getName());
					System.out.println("policy: " +cp.getTextPolicy());
					
					System.out.println("getLogicalPolicy(): " +cp.getLogicalPolicy());
					
					String rules = "";
					
					String zones = "";
					
					String displayOpportunity = "0";
					
					//System.out.println("rules: "+GuiMain.persistenceManager.getAdminConf().getConnection() );

				
					System.out.println("rules: "+GuiMain.persistenceManager.getAdminConf().getZone() );

					if(GuiMain.persistenceManager.getAdminConf().getZone().equalsIgnoreCase("User inside company building")){
						
						zones = "1";
						
					}else{
						zones = "0";
					}
					System.out.println("rules: "+GuiMain.persistenceManager.getAdminConf().getRules() );
					System.out.println("zones: "+zones );


					if(GuiMain.persistenceManager.getAdminConf().getRules().equalsIgnoreCase("1") && zones.equalsIgnoreCase("1")){
						rules = "1";
						System.out.println("rules 1: "+rules);

					} else {
							rules = "0";
							System.out.println("rules 2: "+rules);

							}
					
					
	
					System.out.println("rules finale: "+rules);


					result = new Expression(cp.getLogicalPolicy())
					.with("a", String.valueOf(maxCostThreat))
					.and("b", "0")
					.and("c", String.valueOf(costOpportunity))
					.and("d", "0")
					.and("e", "0")
					.and("f", rules)
					.and("g", GuiMain.displayOpportunity).eval();
					
					System.out.println("Result: " + result.intValue());

					if(result.intValue() == 1){
						 			JOptionPane.showConfirmDialog(null,
								 	getPanelGranted(),
			                        "MUSES Dialog Allow",
			                        JOptionPane.OK_CANCEL_OPTION,
			                        JOptionPane.PLAIN_MESSAGE);
						 			GuiMain.persistenceManager.getSelectedAssetsbyUser().clear();
						}else{
						
							
							JPanel ODPanel = new OpportuniesDescriptorPanel();
							GuiMain.switchPanel(ODPanel);
							 		/*JOptionPane.showConfirmDialog(null,
							 		getPanelMaybe(),
				                    "MUSES Dialog MAY BE",
				                    JOptionPane.OK_CANCEL_OPTION,
				                    JOptionPane.PLAIN_MESSAGE);*/
						}

					 
					
					
				} catch (Exception ex){
					System.out.println("Erreur: " +ex.getMessage());

							JOptionPane.showConfirmDialog(null,
							"Input should be correctly filled", "Wrong Input",
							JOptionPane.OK_CANCEL_OPTION, 
							JOptionPane.ERROR_MESSAGE);
					
				}
                
                //GuiMain.getPersistenceManager().setObjAsset(selected);
                //openDialog(f);
                
			}
                
            
            
        });
		
	}
	private static class MyCellRenderer extends DefaultListCellRenderer  {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof File) {
                File file = (File) value;
                setText(file.getName());
                setIcon(FileSystemView.getFileSystemView().getSystemIcon(file));
                if (isSelected) {
                    setBackground(list.getSelectionBackground());
                    setForeground(list.getSelectionForeground());
                    
                    System.out.println(isSelected);
                } else {
                    setBackground(list.getBackground());
                    setForeground(list.getForeground());
                }
                setEnabled(list.isEnabled());
                setFont(list.getFont());
                setOpaque(true);
            }
            return this;
        }
    }
    
    private static void openDialog(final Frame f)
    {
    	int width = 300;
    	int height = HEIGHT;
        final JDialog dialog = new JDialog(f, "Opportunity Denied", true);
        final JButton button = new JButton("Proceed");
        final JTextArea label = new JTextArea("We are sorry but here is too much risk for"
        		+ " accessing this asset here without you giving more detail about your opportunity");
        label.setLineWrap(true);
        label.setWrapStyleWord(true);
        label.setSize(width, height);
        label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
         
        ImageIcon img1 = new ImageIcon(
				GuiMain.class.getResource("/eu/muses/sim/gui/warning.png"));
		
		int imageW = 50; //My Button width
		int imageH = 50;//My button height
		 
		Image img = img1.getImage();
		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.drawImage(img, 0, 0, imageW, imageH, null, null);
		ImageIcon newIcon = new ImageIcon(bi);
                 
        
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(button.getActionCommand());
                
                GuiMain.frmMusesRtae.setVisible(true);
				JPanel ODPanel = new OpportuniesDescriptorPanel();
				GuiMain.switchPanel(ODPanel);
				GuiMain.frmMusesRtae.getJMenuBar().setVisible(false);
				
                dialog.dispose();
                f.dispose();
                
            }
        });
        
        JPanel panel = new JPanel();
        
        panel.add(button);
        panel.add(label);
        JButton[] buttons = { button };
        JOptionPane optionPane = new JOptionPane(panel,
                                                 JOptionPane.YES_NO_OPTION,
                                                 JOptionPane.PLAIN_MESSAGE,
                                                 newIcon, buttons, button);
        
        dialog.getContentPane().add(optionPane);
        dialog.setSize(500,200);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        
        
        
    }
    
    private JPanel getPanelGranted() {
	 	
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Access Granted :");
        JLabel label2 = new JLabel();
        
        //JLabel label1 = new JLabel(Asset);
        ImageIcon img1 = new ImageIcon(
			GuiMain.class.getResource("/eu/muses/sim/gui/True.png"));

		int imageW = 50; //My Button width
		int imageH = 50;//My button height
		 
		Image img = img1.getImage();
		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.drawImage(img, 0, 0, imageW, imageH, null, null);
		ImageIcon newIcon = new ImageIcon(bi); 

        label.setIcon(newIcon);
        panel.add(label);
        panel.add(label2);

        return panel;
    }
 
 private JPanel getPanelWarnng() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Access Denied ");
        ImageIcon img1 = new ImageIcon(
			GuiMain.class.getResource("/eu/muses/sim/gui/warning.png"));

		int imageW = 50; //My Button width
		int imageH = 50;//My button height
		 
		Image img = img1.getImage();
		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.drawImage(img, 0, 0, imageW, imageH, null, null);
		ImageIcon newIcon = new ImageIcon(bi); 

        label.setIcon(newIcon);
        panel.add(label);

        return panel;
    }
 
 private JPanel getPanelMaybe() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("<html>We are sorry, But the info you gave us don't give enouth safety <br>"
        		+ "raeson to give you access to the requested asset </html> ");
        ImageIcon img1 = new ImageIcon(
			GuiMain.class.getResource("/eu/muses/sim/gui/warning.png"));

		int imageW = 50; //My Button width
		int imageH = 50;//My button height
		 
		Image img = img1.getImage();
		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.drawImage(img, 0, 0, imageW, imageH, null, null);
		ImageIcon newIcon = new ImageIcon(bi); 

        label.setIcon(newIcon);
        panel.add(label);

        return panel;
    }
 
 
    

}
