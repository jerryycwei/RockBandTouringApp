package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.geom.Path2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import metamodel.AlternateRoute;
import metamodel.Link;
import metamodel.MainRoute;
import metamodel.MapSystem;
import metamodel.Node;

public class ImagePanel extends JPanel {
	private Image image;
	private MapSystem system;
	
	public ImagePanel(String imagePath, MapSystem system) {
		this.image = new ImageIcon(imagePath).getImage();
		this.system = system;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Stroke defaultStroke = g2d.getStroke();
		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
		g2d.drawImage(image, 0, 0, null);
		if (system != null) {
			for (Node n : system.getNodes()) {
				//TODO: add boolean selected for Node
				n.getCircle().drawCircle(g2d, n.getSelected());
			}
			for (Link l : system.getLinks()) {
				if (l instanceof MainRoute) {
					Path2D head = ((MainRoute) l).getSolidArrow().getHead();
					Path2D line = ((MainRoute) l).getSolidArrow().getLine();
					g2d.setColor(Color.RED);
					g2d.setStroke(defaultStroke);
					g2d.draw(head);
					g2d.draw(line);
				}
				if (l instanceof AlternateRoute) {
					Path2D head = ((AlternateRoute) l).getDottedArrow().getHead();
					Path2D line = ((AlternateRoute) l).getDottedArrow().getLine();
					g2d.setColor(Color.MAGENTA);
					g2d.setStroke(dashed);
			        g2d.draw(head);
			        g2d.draw(line);
				}
			}
		}
	}
}
