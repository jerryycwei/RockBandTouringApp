package ui;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MenuListener implements ActionListener {
	private JMenuItem caller;
	private JFrame parent;
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("called");
		switch(caller.getText()) {
		case "About":
			System.out.println("work");
			JDialog aboutDialog = new JDialog(parent);
			aboutDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			aboutDialog.setBounds(500, 200, 300, 200);
			JPanel panel = new JPanel();
			JTextArea aboutArea = new JTextArea();
			aboutArea.setText("GunTour MussBander\nVersion 1.0.6 (35247)\nCopyright © 2014, GunTour MussBander\n");
			aboutArea.setEditable(false);
			panel.add(aboutArea);
			aboutDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
			aboutDialog.add(panel);
			aboutDialog.setVisible(true);
			break;
		
		default:
			break;
		}
		
	}
	
	public MenuListener(JFrame parent, JMenuItem caller) {
		this.caller = caller;
	}

}
