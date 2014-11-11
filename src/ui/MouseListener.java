package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import metamodel.City;

public class MouseListener extends MouseAdapter implements MouseMotionListener{
	private ImagePanel imgPanel;
	private Console console;
	private Main parent;
	private boolean insideMap;
	private static final int CLICK_RADIUS = 10;
	private static final int HOVER_RADIUS = 10;
	
	public MouseListener(Main parent, ImagePanel imgPanel, Console console) {
		this.parent = parent;
		this.imgPanel = imgPanel;
		this.console = console;
	}
	
	
	public void mouseClicked(MouseEvent e) {
		int x =e.getX(); // the specific x coordinate of the point clicked is stored in a place in the array
        int y =e.getY(); // the specific y coordinate of the point clicked is stored in a place in the array
        console.setText("Xclicked: " + x + "\nYclicked: " + y + "\n");
        imgPanel.repaint(); // added because display was buggy
        for (City city : parent.getCities()) {
        	if (x < (city.getCircle().getPositionX() + CLICK_RADIUS) && x > (city.getCircle().getPositionX() - CLICK_RADIUS) &&
        			y < (city.getCircle().getPositionY() + CLICK_RADIUS) && y > (city.getCircle().getPositionY() - CLICK_RADIUS)) {
        		console.setText("added city " + city.getName());
        	}
        }
	}
	
	public void mouseEntered(MouseEvent e) {
		insideMap = true;
	}
	
	public void mouseMoved(MouseEvent e) {
		if(insideMap) {
			int x =e.getX(); // the specific x coordinate of the point clicked is stored in a place in the array
	        int y =e.getY(); // the specific y coordinate of the point clicked is stored in a place in the array
	        for (City city : parent.getCities()) {
	        	if (x < (city.getCircle().getPositionX() + HOVER_RADIUS) && x > (city.getCircle().getPositionX() - HOVER_RADIUS) &&
	        			y < (city.getCircle().getPositionY() + HOVER_RADIUS) && y > (city.getCircle().getPositionY() - HOVER_RADIUS)) {
	        		parent.getInfoLabel().getInfo().setText(city.getName() +"\n" + city.getAccomodation(0).getName());
	        	}
	        }
		}
	}
	
	public void mouseExited(MouseEvent e) {
		insideMap = false;
	}
	
	
}
