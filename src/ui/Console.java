package ui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Console extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	
	public Console() {
		this.setBounds(0, 602, 1100, 80); //update to reflect infoLabel
		textArea = new JTextArea(5, 100);
		textArea.setEditable(false);
		textArea.setVisible(true);
		textArea.setBackground(new Color(51,255,153));
		this.add(textArea);
		this.setBackground(new Color(51,255,153));
	}
	public void setText(String text) {
		textArea.setText(text);
	}
	public JTextArea getTextArea() {
		return this.textArea;
	}
	
}
