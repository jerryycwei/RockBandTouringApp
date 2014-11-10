package ui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Console extends JPanel {
	private JTextArea textArea;
	
	public Console() {
		this.setBounds(0, 613, 915, 80);
		textArea = new JTextArea();
		textArea.setBounds(0, 613, 915, 80);
		textArea.setEditable(false);
		textArea.setVisible(true);
		textArea.setBackground(new Color(205,127,50));
		this.add(textArea);
		this.setBackground(new Color(100, 100, 100));
	}
	public void setText(String text) {
		textArea.setText(text);
	}
	public JTextArea getTextArea() {
		return this.textArea;
	}
	
}
