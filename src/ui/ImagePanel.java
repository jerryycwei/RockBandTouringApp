package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private Image image;
	
	public ImagePanel(String imagePath) {
		this(new ImageIcon(imagePath).getImage());
	}
	
	public ImagePanel(Image img) {
		this.image = img;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}
}
