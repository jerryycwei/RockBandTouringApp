package ui;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
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
		System.out.println("called");
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
		case "New":
			MapSystem system = parent.getSystem();
			system.clearLists();
			ImagePanel imgPanel = parent.getVisualOutput();
			imgPanel.repaint();
			break;
		case "Undo":
			//TODO: implements click stack to undo
			break;
		case "Redo":
			//TODO: implements click stack to redo
			break;
		
			
		default:
			break;
		}
		
	}
	
	public MenuListener(Main parent, JMenuItem caller) {
		this.parent = parent;
		this.caller = caller;
	}

}
