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
import metamodel.DottedArrow;
import metamodel.Link;
import metamodel.SolidArrow;
import metamodel.Symbol;
import metamodel.TransportationType;
import metamodel.Venue;

public class MouseListener extends MouseAdapter implements MouseMotionListener{
	private ImagePanel imgPanel;
	private Console console;
	private Main parent;
	private boolean insideMap;
	private static final int CLICK_RADIUS = 7;
	private int clickCounter;
	private HashMap<MouseEvent, City> mouseMap;
	private HashMap<City, City> destinationMap;
	private ArrayList<MouseEvent> mouseUndoStack;
	private ArrayList<MouseEvent> mouseRedoStack;
	private ArrayList<City> undoCities;
	private ArrayList<Link> undoLinks;
	private City origin;
	
	public MouseListener(Main parent, ImagePanel imgPanel, Console console) {
		this.parent = parent;
		this.imgPanel = imgPanel;
		this.console = console;
		clickCounter = 0;
		mouseMap = new HashMap<MouseEvent, City>();
		destinationMap = new HashMap<City, City>();
		mouseUndoStack = new ArrayList<MouseEvent>();
		mouseRedoStack = new ArrayList<MouseEvent>();
		undoCities = new ArrayList<City>();
		undoLinks = new ArrayList<Link>();
	}
	
	public void mouseClicked(MouseEvent e) {
		int mouseX = e.getX(); // the specific x coordinate of the point clicked is stored in a place in the array
        int mouseY = e.getY(); // the specific y coordinate of the point clicked is stored in a place in the array
        console.setText("Xclicked: " + mouseX + "\nYclicked: " + mouseY + "\n");
        
        if(parent.getIsCreateTourModeOn() || parent.getIsAlternateRouteModeOn()) {
        	for (City city : parent.getCities()) {
        		int cityX = city.getCircle().getPositionX();
        		int cityY = city.getCircle().getPositionY();
        		
        		if (hasClickedOnCity(mouseX, mouseY, cityX, cityY)) {
        			console.setText("CREATE TOUR MODE ACTIVE\nadded city " + city.getName());
        			city.setSelected(true);
        			switch(clickCounter) {
        			case 0:
        				this.origin = city;
        				origin.setStartNode(true);
        				clickCounter++;
        				break;
        			default:
        				City destination = city;
        				if (destination.equals(origin)) {
        					break;
        				}
        				Point2D.Double begin = new Point2D.Double(origin.getCircle().getPositionX(), origin.getCircle().getPositionY());
        				Point2D.Double end = new Point2D.Double(city.getCircle().getPositionX(), city.getCircle().getPositionY());
        				Time travelTime = null;
        				int distance = 0;
        				TransportationType transportType = new TransportationType("plane", new Symbol("images/airplane.png"));
                		
        				if (parent.getIsCreateTourModeOn()) {
        					new SolidArrow(begin, end, travelTime, origin, destination, distance, transportType, parent.getSystem());
        				} else {
        					new DottedArrow(begin, end, travelTime, origin, destination, distance, transportType, parent.getSystem());
        				}
        				origin.setEndNode(false);
        				destination.setEndNode(true);
        				
        				if (destination.getStartNode()) {  destination.setStartNode(false); }
        				
        				destinationMap.put(destination, origin); //undo stack

        				this.origin = destination;
        				break;
        			}
        			mouseMap.put(e, city); //undo stack
        			pushMouseEvent(mouseUndoStack, e); //undo stack
        			repaint();
        			break;
        		}
        		
        	}
        } else {
        	clickCounter = 0;
        	console.setText("CREATE TOUR IS NOT ACTIVE");
        }
	}
	
	public void mouseEntered(MouseEvent e) {
		insideMap = true;
	}
	
	public void mouseMoved(MouseEvent e) {
		if(insideMap) {
			int mouseX = e.getX();
	        int mouseY = e.getY();
	        
	        for (City city : parent.getCities()) {
	        	int cityX = city.getCircle().getPositionX();
	        	int cityY = city.getCircle().getPositionY();
	        	
	        	if (hasClickedOnCity(mouseX, mouseY, cityX, cityY)) {
	        		
	        		String printedText = "CITY:" + "\n" + city.getName() +"\n" +"\n" + "ACCOMODATION(S):";
	        		
	        		for (Accomodation accomodation : city.getAccomodations()){
	        			printedText = printedText + "\n" + accomodation.getName() + " $" + accomodation.getCost();
	        		}
	        		
	        		printedText = printedText +"\n" +"\n" + "VENUE:";
	        		
	        		for (Venue venue : city.getVenues()){
	        			printedText = printedText + "\n" + venue.getName() + " $" + venue.getCost();
	        		}
	        		
	        		printedText = printedText +"\n" +"\n" + "WEATHER:" + "\n" + city.getWeather().getType();
	        		
	        		parent.getInfoLabel().getInfo().setText(printedText);
	        		break;
	        	} else {
	    			parent.getInfoLabel().getInfo().setText("");
	    		}
	        }
		} 
	}
	
	public void mouseExited(MouseEvent e) {
		insideMap = false;
	}
	
	public void undo(){
		System.out.println("Undo");
		MouseEvent mouseUndoPopped = mouseUndoStack.remove(mouseUndoStack.size() - 1);
		pushMouseEvent(mouseRedoStack, mouseUndoPopped);
		City cityToBeUndo = mouseMap.get(mouseUndoPopped);
		cityToBeUndo.setSelected(false);
		
		if (cityToBeUndo.getEndNode()) { cityToBeUndo.setEndNode(false); }
		
		if (destinationMap.containsKey(cityToBeUndo)) {
			System.out.println("destinationMap has key " + cityToBeUndo.getName());
			City originOfUndoLink = destinationMap.remove(mouseMap.remove(mouseUndoPopped));
			for(int i = parent.getSystem().numberOfLinks() - 1; i > 0; i--){
				Link link = parent.getSystem().getLink(i);
				if(link.getOrigin().equals(originOfUndoLink) && link.getDestination().equals(cityToBeUndo)) {
					System.out.println("link found origin: " +link.getOrigin().getName() + " destination: " + link.getDestination().getName());
					link.setLinkActive(false);
					undoLinks.add(link);
					if(undoLinks.size() > 5) {
						parent.getSystem().removeLink(undoLinks.remove(0));
					}
					break;
				}
			}
			origin = originOfUndoLink;
			if (!origin.getStartNode()) {
				origin.setEndNode(true);
			}	
		} else {
			origin = null;
			resetClickCount();
		}
		pushCityStack(undoCities, cityToBeUndo);
		console.setText("CREATE TOUR MODE ACTIVE\nUndo: removed " + cityToBeUndo.getName());
		repaint();
	}
	
	public void redo(){
		MouseEvent mouseRedoPopped = mouseRedoStack.remove(mouseRedoStack.size() - 1);
		pushMouseEvent(mouseUndoStack, mouseRedoPopped);
		City redoCity = undoCities.remove(undoCities.size() - 1);
		redoCity.setSelected(true);
		if(redoCity.getStartNode()) {
			clickCounter++;
		} else if (origin.getEndNode() || origin.getStartNode()) {
			origin.setEndNode(false);
			redoCity.setEndNode(true);
			undoLinks.remove(undoLinks.size() - 1).setLinkActive(true);
			destinationMap.put(redoCity, origin);
		}
		origin = redoCity;
		mouseMap.put(mouseRedoPopped, redoCity);
		console.setText("CREATE TOUR MODE ACTIVE\nRedo: added " + redoCity.getName());
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
	
	private boolean hasClickedOnCity(int mouseX, int mouseY, int cityX, int cityY) {
		return mouseX < (cityX + CLICK_RADIUS) && mouseX > (cityX - CLICK_RADIUS) &&
				mouseY < (cityY + CLICK_RADIUS) && mouseY > (cityY - CLICK_RADIUS);
	}
	
	public void resetClickCount() {
		clickCounter = 0;
	}
	
	public boolean canUndo() {
		boolean canUndo = (parent.getIsCreateTourModeOn() || parent.getIsAlternateRouteModeOn()) && !mouseUndoStack.isEmpty();
		if(!canUndo) {
			console.setText("Cannot undo: Create tour is not active or nothing to undo");
		}
		return canUndo;
	}
	
	public boolean canRedo() {
		boolean canRedo = (parent.getIsCreateTourModeOn() || parent.getIsAlternateRouteModeOn()) && !mouseRedoStack.isEmpty();
		if(!canRedo) {
			console.setText("Cannot redo: Create tour is not active or nothing to redo");
		}
		return canRedo;
	}
	
	public void setOrigin(City origin) {
		this.origin = origin;
		this.clickCounter = 1;
	}
	
}
