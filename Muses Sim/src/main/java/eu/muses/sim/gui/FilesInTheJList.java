package eu.muses.sim.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileFilter;

import javax.swing.filechooser.FileSystemView;

import org.apache.commons.lang3.StringUtils;

import eu.muses.sim.riskman.asset.Asset;


public class FilesInTheJList extends JPanel{
	
	public String root = "/Users/jonathan/Desktop/asset/";
	public String change;
	public String ItemSelectedRoot;
	public String yourSelectedAsset;
	public static Asset selectedAsset;
	
	public FilesInTheJList() {
		
        final JList displayList = new JList(new File("/Users/jonathan/Desktop/asset").listFiles());
        displayList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        displayList.setCellRenderer(new MyCellRenderer());
        displayList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        displayList.setName("displayList");
        final JFrame f = new JFrame("Asset");
        f.setPreferredSize(new Dimension(300, 300));
        displayList.setVisibleRowCount(-1);
        f.add(new JScrollPane(displayList));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
        displayList.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                Object selected = displayList.getSelectedValue();
                System.out.println("menuList.addMouseListener.mousePressed selected=" + selected);
                //JOptionPane.showMessageDialog(null, "Opportunity not allowed");
                
                String ItemSelected = displayList.getSelectedValue().toString();
                ItemSelectedRoot = StringUtils.remove(ItemSelected, root);
                
                if(ItemSelected.contains(".txt")){
                	
                	change = StringUtils.remove(ItemSelectedRoot, ".txt");
                     
                }else if(ItemSelected.contains(".pdf")){
                	
                    change = StringUtils.remove(ItemSelectedRoot, ".pdf");
                	
                }else{
                	
                    change = StringUtils.remove(ItemSelectedRoot, ".html");
                	
                }
                
                System.out.println(GuiMain.persistenceManager.getAssets().get(0).assetName);
                System.out.println( GuiMain.persistenceManager.getAssets().size());
               
                int index = -1;
                for(int i = 0; i<GuiMain.persistenceManager.getAssets().size(); i++) {
                	
                	System.out.println(GuiMain.persistenceManager.getAssets().get(i).assetName);
                	if (GuiMain.persistenceManager.getAssets().get(i).assetName.contains(change)) {
                		
                		index = i;
                		break;
                	}
                }
               
                if (index != -1) {
                	selectedAsset = GuiMain.persistenceManager.getAssets().get(index);
                	GuiMain.persistenceManager.getSelectedAssetsbyUser().add(selectedAsset);
                	System.out.println("true");
                }
                else {
                	System.out.println("false");
                }
                
                
                openDialog(f);
               
               
			}
                	   
            
        });
        
        
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                FilesInTheJList fITJL = new FilesInTheJList();
                
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
        final JDialog dialog = new JDialog(f, "Additional Asset ", true);
        final JButton button = new JButton("Proceed");
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
        JButton[] buttons = { button };
        JOptionPane optionPane = new JOptionPane("You choose : "
        		+ selectedAsset.getAssetName()+
        		" With Cost of :"+selectedAsset.getValue(),
                                                 JOptionPane.YES_NO_OPTION,
                                                 JOptionPane.PLAIN_MESSAGE,
                                                 null, buttons, button);
        dialog.getContentPane().add(optionPane);
        
        dialog.setSize(300,300);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
