package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import metamodel.Accomodation;
import metamodel.City;
import metamodel.SolidArrow;
import metamodel.Symbol;
import metamodel.TransportationType;

public class MouseListener extends MouseAdapter implements MouseMotionListener{
	private ImagePanel imgPanel;
	private Console console;
	private Main parent;
	private boolean insideMap;
	private static final int CLICK_RADIUS = 10;
	private static final int HOVER_RADIUS = 10;
	private int clickCounter;
	private HashMap<MouseEvent, City> mouseMap;
	private ArrayList<MouseEvent> mouseUndoStack = new ArrayList<MouseEvent>();
	private ArrayList<MouseEvent> mouseRedoStack = new ArrayList<MouseEvent>();
	private ArrayList<City> undoCity = new ArrayList<City>();
	private City origin;
	private Point2D.Double begin;
	
	public MouseListener(Main parent, ImagePanel imgPanel, Console console) {
		this.parent = parent;
		this.imgPanel = imgPanel;
		this.console = console;
		clickCounter = 0;
		mouseUndoStack = new ArrayList<MouseEvent>();
		mouseRedoStack = new ArrayList<MouseEvent>();
		undoCity = new ArrayList<City>();
	}
	
	
	public void mouseClicked(MouseEvent e) {
		//pushMouseEvent(mouseUndoStack, e);
		int x =e.getX(); // the specific x coordinate of the point clicked is stored in a place in the array
        int y =e.getY(); // the specific y coordinate of the point clicked is stored in a place in the array
        console.setText("Xclicked: " + x + "\nYclicked: " + y + "\n");
        //if(parent.getIsCreateTourModeOn()) {
        if(true) {
        	for (City city : parent.getCities()) {
        		if (x < (city.getCircle().getPositionX() + CLICK_RADIUS) && x > (city.getCircle().getPositionX() - CLICK_RADIUS) &&
        				y < (city.getCircle().getPositionY() + CLICK_RADIUS) && y > (city.getCircle().getPositionY() - CLICK_RADIUS)) {
        			console.setText("added city " + city.getName());
        			switch(clickCounter) {
        			case 0:
        				System.out.println("origin set");
        				this.origin = city;
        				begin = new Point2D.Double(city.getCircle().getPositionX(), city.getCircle().getPositionY());
        				clickCounter++;
        				break;
        			default:
        				System.out.println("destination set");
        				City destination = city;
        				Point2D.Double end = new Point2D.Double(city.getCircle().getPositionX(), city.getCircle().getPositionY());
        				Time travelTime = null;
        				int distance = 0;
        				TransportationType transportType = new TransportationType("plane", new Symbol("images/airplane.png"));
                		SolidArrow solidArrow = new SolidArrow(begin, end, travelTime, origin, destination, distance, transportType, parent.getSystem());
                		this.origin = destination;
                		this.begin = end;
        				break;
        			}
        			city.setSelected(true);
        			//mouseMap.put(e, city);
        			repaint();
        		}
        	}
        } else {
        	clickCounter = 0;
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
	        		
	        		String printedText = "CITY:" + "\n" + city.getName() +"\n" +"\n" + "ACCOMODATION(S):";
	        		
	        		for (Accomodation accomodation : city.getAccomodations()){
	        			printedText = printedText + "\n" + accomodation.getName();
	        		}
	        		
	        		printedText = printedText +"\n" +"\n" + "WEATHER:" + "\n" + city.getWeather().getType();
	        		
	        		parent.getInfoLabel().getInfo().setText(printedText);
	        	}
	        }
		}
	}
	
	public void mouseExited(MouseEvent e) {
		insideMap = false;
	}
	
	public void undo(){
		MouseEvent mouseUndoPopped = mouseUndoStack.get(mouseRedoStack.size() - 1);
		pushMouseEvent(mouseRedoStack, mouseUndoPopped);
		City cityToBeUndo = mouseMap.get(mouseUndoPopped);
		cityToBeUndo.setSelected(false);
		mouseMap.remove(mouseUndoPopped);
		pushCityStack(undoCity, cityToBeUndo);
		repaint();
	}
	
	public void redo(){
		MouseEvent mouseRedoPopped = mouseRedoStack.get(mouseRedoStack.size() - 1);
		pushMouseEvent(mouseUndoStack, mouseRedoPopped);
		City redoCity = undoCity.remove(undoCity.size() - 1);
		redoCity.setSelected(true);
		mouseMap.put(mouseRedoPopped, redoCity);	
		repaint();
	}
	
	private void repaint() {
		imgPanel.repaint();
	}
	
	private void pushMouseEvent(ArrayList<MouseEvent> list, MouseEvent element) {
		list.add(element);
		if (list.size() > 5) {
			list.remove(0);
		}
	}
	
	private void pushCityStack(ArrayList<City> list, City element) {
		list.add(element);
		if (list.size() > 5) {
			list.remove(0);
		}
	}
	
	
}
