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
		cities = new CityBuilder(system).getCities();
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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1280, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		visualOutput = new ImagePanel("images/map.jpg", system);
		splitPane.setLeftComponent(visualOutput);
		
		final Console console = new Console();
		visualOutput.add(console);
		mouseListener = new MouseListener(this, visualOutput, console);
		visualOutput.addMouseListener(mouseListener);
		visualOutput.addMouseMotionListener(mouseListener);
		
		GroupLayout gl_visualOutput = new GroupLayout(visualOutput);
		gl_visualOutput.setHorizontalGroup(
			gl_visualOutput.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1136, Short.MAX_VALUE)
		);
		gl_visualOutput.setVerticalGroup(
			gl_visualOutput.createParallelGroup(Alignment.LEADING)
				.addGap(0, 688, Short.MAX_VALUE)
		);
		visualOutput.setLayout(gl_visualOutput);
		
		splitPane.setRightComponent(infoLabel.getInfo());//infoLabel);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
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
		createTourMenuItem.addActionListener(menuListener);
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
