package ui;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import metamodel.MapSystem;

public class MenuListener implements ActionListener {
	private JMenuItem caller;
	private Main parent;
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			caller = (JMenuItem) e.getSource();
		}
		switch(caller.getText()) {
		case "About":
			JDialog aboutDialog = new JDialog(parent.getFrame());
			aboutDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			aboutDialog.setBounds(500, 200, 300, 200);
			JPanel panel = new JPanel();
			JTextArea aboutArea = new JTextArea();
			aboutArea.setText("GunTour MussBander\nVersion 1.0.6 (35247)\nCopyright � 2014, GunTour MussBander\n");
			aboutArea.setEditable(false);
			panel.add(aboutArea);
			aboutDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
			aboutDialog.add(panel);
			aboutDialog.setVisible(true);
			break;
		case "Clear Map":
			MapSystem system = parent.getSystem();
			if (system != null) {
				system.clearLists();
				parent.getVisualOutput().repaint();
				parent.getMouseListener().resetClickCount();
			}
			break;
		case "Undo":
			if (parent.getMouseListener().canUndo()) {
				parent.getMouseListener().undo();
			}
			break;
		case "Redo":
			if (parent.getMouseListener().canRedo()){
				parent.getMouseListener().redo();
			}
			break;
			
		case "Create Tour":
			parent.setIsCreateTourModeOn(true);
			caller.setText("End Tour");
			parent.getMouseListener().resetClickCount();
			parent.getConsole().setText("\tCREATE TOUR MODE ACTIVE");
			break;
			
		case "Alternate Route":
			parent.setIsAlternateRouteModeOn(true);
			caller.setText("End Alternate");
			parent.getMouseListener().resetClickCount();
			break;
			
		case "End Tour":
			parent.setIsCreateTourModeOn(false);
			caller.setText("Create Tour");
			parent.getMouseListener().resetClickCount();
			parent.getConsole().setText("\tTour Creation Ended.");
			break;
			
		case "End Alternate":
			parent.setIsAlternateRouteModeOn(false);
			caller.setText("Alternate Route");
			break;
		
		case "Save":
			String saveFileName = "";
			while(saveFileName != null && saveFileName.length() == 0) {
				saveFileName = (String)JOptionPane.showInputDialog(
                    parent.getFrame(),
                    "Enter the filename:\n"
                    + "(overwrites old files of the same name)\n"
                    + "Extension .tour will be added automatically.",
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null, null);
			}
			if (saveFileName != null) {
		    	parent.getConsole().setText("\tSaving to " + saveFileName + ".tour");
				parent.save(parent.getSystem(), saveFileName);
			}
			
			break;
			
		case "Load":
			String loadFileName = "";
			while(loadFileName != null && loadFileName.length() == 0) {
				loadFileName = (String)JOptionPane.showInputDialog(
                    parent.getFrame(),
                    "Enter the filename to load:\n"
                    + "Extension .tour will be added automatically.",
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null, null);
			}
			if (loadFileName != null) {
		    	parent.getConsole().setText("Loading to " + loadFileName + ".tour");
				parent.load(loadFileName);
			}
			break;
			
		default:
			break;
		}
		
	}
	
	public MenuListener(Main parent) {
		this.parent = parent;
	}

}
