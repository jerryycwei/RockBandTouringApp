package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import metamodel.*;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main {

	private JFrame frame;
	private Map map = new Map(600, 110, new ImageIcon("images/map.jpg").getImage());
	private InfoLabel infoLabel = new InfoLabel(new JTextArea(), map);
	private MapSystem system = new MapSystem(map, infoLabel.getInfo());
	private ImagePanel visualOutput;
	private MenuListener menuListener = new MenuListener(this);
	private MouseListener mouseListener;
	private static boolean isCreateTourModeOn = false;
	
	/**
	 * ArrayList of all Cities added in initializeCities()
	 */
	private ArrayList<City> cities = new ArrayList<City>();
	
	Graphics2D g2d;
	
	
	public void setIsCreateTourModeOn(boolean mode) {
		isCreateTourModeOn = mode;
	}
	
	public boolean getIsCreateTourModeOn() {
		return isCreateTourModeOn;
	}
	
	/**
	 * Create the application.
	 */
	public Main() {
		initializeCities();
		initialize();
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Initialize Cities as well as the venues and accomodations
	 */
	private void initializeCities() {
		
		City losAngeles = new City("Los Angeles", new Circle("Los Angeles", 121, 415), system, "California", 3884000, "Sunny", new Symbol("images/weatherSunny.jpg"));
		
		City chicago = new City("Chicago", new Circle("Chicago", 717, 221), system, "Illinois", 2790000, "Rainy", new Symbol("images/weatherRain.jpg"));
		
		City kansasCity = new City("Kansas City", new Circle("Kansas City", 582, 293), system, "Kansas", 467000, "Tornado", new Symbol("images/weatherTornado.jpg"));
		
		City newYork = new City("New York City", new Circle("New York City", 982, 252), system, "New York", 8400000, "Snow", new Symbol("images/weatherSnow.jpg"));
		
		City toronto = new City("Toronto", new Circle("Toronto", 878, 175), system, "Toronto", 2500000, "Snow", new Symbol("images/weatherSnow.jpg"));
		
		City montreal = new City("Montreal", new Circle("Montreal", 990, 125), system, "Montreal", 1600000, "Snow", new Symbol("images/weatherSnow.jpg"));
		
		City houston = new City("Houston", new Circle("Houston", 566, 514), system, "Houston", 2196000, "Sunny", new Symbol("images/weatherSunny.jpg"));
		
		City philadelphia = new City("Philadelphia", new Circle("Philadelphia", 960, 271), system, "Philadelphia", 1553000, "Rainy", new Symbol("images/weatherRain.jpg"));
		
		City phoenix = new City("Phoenix", new Circle("Phoenix", 242, 430), system, "Phoenix", 1513000, "Sunny", new Symbol("images/weatherSunny.jpg"));
		
		City sanDiego = new City("San Diego", new Circle("San Diego", 142, 446), system, "San Diego", 1356000, "Sunny", new Symbol("images/weatherSunny.jpg"));
		
		City sanFrancisco = new City("San Francisco", new Circle("San Francisco", 40, 326), system, "San Francisco", 837442, "Rainy", new Symbol("images/weatherRain.jpg"));
		
		City ottawa = new City("Ottawa", new Circle("Ottawa", 949, 126), system, "Ottawa", 883391, "Snow", new Symbol("images/weatherSnow.jpg"));
		
		City quebecCity = new City("Quebec City", new Circle("Quebec City", 1035, 88), system, "Quebec City", 491140, "Snow", new Symbol("images/weatherSnow.jpg"));
		
		City vancouver = new City("Vancouver", new Circle("Vancouver", 27, 16), system, "Vancouver", 578040, "Sunny", new Symbol("images/weatherSunny.jpg"));
		
		City detroit = new City("Detroit", new Circle("Detroit", 806, 210), system, "Detroit", 688701, "Snow", new Symbol("images/weatherSnow.jpg"));
		
		City seattle = new City("Seattle", new Circle("Seattle", 42, 64), system, "Seattle", 652405, "Sunny", new Symbol("images/weatherSunny.jpg"));
		
		City dallas = new City("Dallas", new Circle("Dallas", 538, 444), system, "Dallas", 1258000, "Sunny", new Symbol("images/weatherSunny.jpg"));
		
		City atlanta = new City("Atlanta", new Circle("Atlanta", 780, 421), system, "Atlanta", 447841, "Rainy", new Symbol("images/weatherRain.jpg"));
		
		City lasVegas = new City("Las Vegas", new Circle("Las Vegas", 182, 364), system, "Las Vegas", 603488, "Sunny", new Symbol("images/weatherSunny.jpg"));
		
		City sanJose = new City("San Jose", new Circle("San Jose", 50, 337), system, "San Jose", 998537, "Sunny", new Symbol("images/weatherSunny.jpg"));
		
		cities.add(losAngeles);
		cities.add(chicago);
		cities.add(kansasCity);
		cities.add(newYork);
		cities.add(toronto);
		cities.add(montreal);
		cities.add(houston);
		cities.add(philadelphia);
		cities.add(phoenix);
		cities.add(sanDiego);
		cities.add(sanFrancisco);
		cities.add(ottawa);
		cities.add(quebecCity);
		cities.add(vancouver);
		cities.add(detroit);
		cities.add(seattle);
		cities.add(dallas);
		cities.add(atlanta);
		cities.add(lasVegas);
		cities.add(sanJose);
		
		losAngeles.addAccomodation("Hilton", "Hotel", 150);
		chicago.addAccomodation("Hilton", "Hotel", 150);
		newYork.addAccomodation("Hilton", "Hotel", 150);
		kansasCity.addAccomodation("Hilton", "Hotel", 150);
		toronto.addAccomodation("Hilton", "Hotel", 150);
		montreal.addAccomodation("Hilton", "Hotel", 150);
		houston.addAccomodation("Hilton", "Hotel", 150);
		philadelphia.addAccomodation("Hilton", "Hotel", 150);
		phoenix.addAccomodation("Hilton", "Hotel", 150);
		sanDiego.addAccomodation("Hilton", "Hotel", 150);
		sanFrancisco.addAccomodation("Hilton", "Hotel", 150);
		ottawa.addAccomodation("Hilton", "Hotel", 150);
		quebecCity.addAccomodation("Hilton", "Hotel", 150);
		vancouver.addAccomodation("Hilton", "Hotel", 150);
		detroit.addAccomodation("Hilton", "Hotel", 150);
		seattle.addAccomodation("Hilton", "Hotel", 150);
		dallas.addAccomodation("Hilton", "Hotel", 150);
		atlanta.addAccomodation("Hilton", "Hotel", 150);
		lasVegas.addAccomodation("Hilton", "Hotel", 150);
		sanJose.addAccomodation("Hilton", "Hotel", 150);
		
		losAngeles.addVenue("Wei", "Stadium", 200000);
		chicago.addVenue("Wei", "Stadium", 200000);
		newYork.addVenue("Wei", "Stadium", 200000);
		kansasCity.addVenue("Wei", "Stadium", 200000);
		toronto.addVenue("Wei", "Stadium", 200000);
		montreal.addVenue("Wei", "Stadium", 200000);
		houston.addVenue("Wei", "Stadium", 200000);
		philadelphia.addVenue("Wei", "Stadium", 200000);
		phoenix.addVenue("Wei", "Stadium", 200000);
		sanDiego.addVenue("Wei", "Stadium", 200000);
		sanFrancisco.addVenue("Wei", "Stadium", 200000);
		ottawa.addVenue("Wei", "Stadium", 200000);
		quebecCity.addVenue("Wei", "Stadium", 200000);
		vancouver.addVenue("Wei", "Stadium", 200000);
		detroit.addVenue("Wei", "Stadium", 200000);
		seattle.addVenue("Wei", "Stadium", 200000);
		dallas.addVenue("Wei", "Stadium", 200000);
		lasVegas.addVenue("Wei", "Stadium", 200000);
		atlanta.addVenue("Wei", "Stadium", 200000);
		sanJose.addVenue("Wei", "Stadium", 200000);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1280, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		visualOutput = new ImagePanel("images/map.jpg", system);
		splitPane.setLeftComponent(visualOutput);
		
		JLabel widthLabel = new JLabel("width " + frame.getWidth());
		
		JLabel heightLabel = new JLabel("height " + frame.getHeight());
		
		final Console console = new Console();
		visualOutput.add(console);
		mouseListener = new MouseListener(this, visualOutput, console);
		visualOutput.addMouseListener(mouseListener);
		visualOutput.addMouseMotionListener(mouseListener);
		
		GroupLayout gl_visualOutput = new GroupLayout(visualOutput);
		gl_visualOutput.setHorizontalGroup(
			gl_visualOutput.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_visualOutput.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_visualOutput.createParallelGroup(Alignment.LEADING)
						.addComponent(widthLabel)
						.addComponent(heightLabel))
					.addContainerGap(1048, Short.MAX_VALUE))
		);
		gl_visualOutput.setVerticalGroup(
			gl_visualOutput.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_visualOutput.createSequentialGroup()
					.addContainerGap()
					.addComponent(widthLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(heightLabel)
					.addContainerGap(640, Short.MAX_VALUE))
		);
		visualOutput.setLayout(gl_visualOutput);
		
		splitPane.setRightComponent(infoLabel.getInfo());//infoLabel);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		toolBar.add(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem clearMenuItem = new JMenuItem("Clear Map");
		clearMenuItem.addActionListener(menuListener);
		fileMenu.add(clearMenuItem);
		
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		
		JMenuItem undoMenuItem = new JMenuItem("Undo");
		editMenu.add(undoMenuItem);
		
		JMenu tourMenu = new JMenu("Tour");
		menuBar.add(tourMenu);
		
		JMenuItem createTourMenuItem = new JMenuItem("Create Tour");
		tourMenu.add(createTourMenuItem);
		
		JMenuItem alternateRouteMenuItem = new JMenuItem("Alternate Route");
		tourMenu.add(alternateRouteMenuItem);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(menuListener);
		mnHelp.add(mntmAbout);
		
		JMenuItem mntmWalkthrough = new JMenuItem("Walkthrough");
		mnHelp.add(mntmWalkthrough);
		
		System.out.println("Frame created");
		
		visualOutput.addMouseListener( // a MouseListener is added, which takes in clicks from the user's mouse
				new MouseAdapter() { 
					int counter = 0;
                	Node origin;
                	Node destination;
                	Point2D begin;
                	Point2D end;
                	Time travelTime;
                	double distance;
                	TransportationType transportType;
                	SolidArrow solidArrow;
                	
	                public void mouseClicked( MouseEvent e ) { // this method takes in a MouseEvent (when the mouse is clicked)
	                        int x =e.getX(); // the specific x coordinate of the point clicked is stored in a place in the array
	                        int y =e.getY(); // the specific y coordinate of the point clicked is stored in a place in the array
	                        console.setText("X: " + x + "\nY: " + y + "\n");
	                        
	                        if (/*getIsCreateTourModeOn()*/true) {
	                        	counter++;
	                        	
	                        	if (counter < 2) {
	                        		begin = new Point2D.Double(x, y);
	                        		origin = new Node("Some city", new Circle("Some circle", x, y), system);
	                        	} else {
	                        		destination = new Node("Some other city", new Circle("Some other circle", x, y), system);
	                        		travelTime = null;
	                        		distance = 0;
	                        		transportType = new TransportationType("plane", new Symbol(""));
	                        		end = new Point2D.Double(x, y);
	                        		solidArrow = new SolidArrow(begin, end, travelTime, origin, destination, distance, transportType, system);
	                        		
		                        	system.addLink(solidArrow.getMainRoute());

	                        		origin = destination;
	                        	}
	                        }
	                        
	                        visualOutput.repaint(); // added because display was buggy                                
	                }
	            }
	        );
	}
	
	public void setVisualOutput(ImagePanel aVisualOutput) {
		visualOutput = aVisualOutput;
	}
	
	//------------------------
	// INTERFACE
	//------------------------
	
	public JFrame getFrame() {
		return frame;
	}
	
	public MapSystem getSystem() {
		return system;
	}
	
	public ImagePanel getVisualOutput() {
		return visualOutput;
	}
	
	public InfoLabel getInfoLabel() {
		return infoLabel;
	}
	
	public ArrayList<City> getCities() {
		return cities;
	}
	
    public void paint(Graphics g) { // the paint method draws shapes and other images onto the GUI
          g2d = ( Graphics2D ) g;// Graphics2D is accessed for more options
//        g2d.setColor(new Color(205,127,50)); // the color of the graphics is set
//        if (point == true) {
//            g2d.fillOval(xPoints[coord-1]-2, yPoints[coord-1]-2, 4, 4);
//            point = false;
//        }
//        if (makeit == true) { // if the boolean makeit is true, then we draw the shape
//            
//            shapepath.moveTo(xPoints[0], yPoints[0]); // the shape path is moved to the first point in the array
//
//            for (int a = 1; a < coord; a++) { // goes through all the coordinates in the array
//                shapepath.lineTo(xPoints[a], yPoints[a]); // a line is created from one point in the array to the other in the order they were clicked
//            }
//            shapepath.closePath(); // the shapepath is closed (shape is finalized)
//                       
//            g2d.fill(shapepath); // shape is drawn onto the GUI
//            clear.repaint(); // buttons are repainted because they would sometimes be hidden by the drawn shape
//            create.repaint();
//            shapepath.reset(); 
//            coord = 0; // coord is reset to 0 so that a new shape may be created
//            makeit = false;
//        }
//         if (clearit == true) {
//            g2d.clearRect(0,0,1152,834); // a rectangle the size of the window is cleared, so as to clear the entire shape
//            coord = 0; // coord is reset to 0 so that a new shape may be created
//            clear.repaint(); // buttons are repainted because they wouldn't display after clear was clicked
//            create.repaint();
//            clearit = false;            
//        }
    }
}
