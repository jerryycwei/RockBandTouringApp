package ui;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Console extends JPanel {
	private JTextArea textArea;
	
	public Console() {
		textArea = new JTextArea();
		textArea.setBounds(120, 500, 915, 80);
		textArea.setEditable(false);
		textArea.setVisible(true);
	}
	public void setText(String text) {
		textArea.setText(text);
	}
	public JTextArea getTextArea() {
		return this.textArea;
	}
	
}
