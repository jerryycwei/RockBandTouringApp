package ui;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JMenuItem;
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
				parent.setVisualOutput(new ImagePanel("images/map_bitches.jpg", system));
				parent.getVisualOutput().repaint();
			}
			break;
		case "Undo":
			//TODO: implements click stack to undo
			break;
		case "Redo":
			//TODO: implements click stack to redo
			break;
			
		case "Create Tour":
			parent.setIsCreateTourModeOn(true);
			caller.setText("End Tour");
			break;
			
		case "End Tour":
			parent.setIsCreateTourModeOn(false);
			caller.setText("Create Tour");
			parent.getMouseListener().resetClickCount();
			break;
		
			
		default:
			break;
		}
		
	}
	
	public MenuListener(Main parent) {
		this.parent = parent;
	}

}
