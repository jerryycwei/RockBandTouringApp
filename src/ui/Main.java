package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import metamodel.City;
import metamodel.InfoLabel;
import metamodel.Map;
import metamodel.MapSystem;

import com.thoughtworks.xstream.XStream;

public class Main {

	private JFrame frame;
	private Map map = new Map(600, 110, new ImageIcon("images/map.jpg").getImage());
	private JTextArea textArea = new JTextArea();
	private InfoLabel infoLabel = new InfoLabel(textArea, map);
	private MapSystem system = infoLabel.getMapSystem();
	private ImagePanel visualOutput;
	private MenuListener menuListener = new MenuListener(this);
	private MouseListener mouseListener;
	private static boolean isCreateTourModeOn = false;
	private static boolean isAlternateRouteModeOn = false;
	private Console console;

	/**
	 * ArrayList of all Cities added in initializeCities()
	 */
	private ArrayList<City> cities = new ArrayList<City>();
	
	Graphics2D g2d;
	
	
	public void setIsCreateTourModeOn(boolean mode) {
		isCreateTourModeOn = mode;
		if (isCreateTourModeOn) {
			mouseListener.resetClickCount();
		}
	}
	
	public boolean getIsCreateTourModeOn() {
		return isCreateTourModeOn;
	}
	
	public void setIsAlternateRouteModeOn(boolean mode) {
		isAlternateRouteModeOn = mode;
	}
	
	public boolean getIsAlternateRouteModeOn() {
		return isAlternateRouteModeOn;
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
		frame.setResizable(false);
		frame.setBounds(0, 0, 1280, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		visualOutput = new ImagePanel("images/map.jpg", system);
		
		splitPane.setLeftComponent(visualOutput);
		
		console = new Console();
		console.setText("\tClick Tour -> Create Tour to begin creating a tour.");
		visualOutput.add(console);
		mouseListener = new MouseListener(this, visualOutput, console);
		visualOutput.addMouseListener(mouseListener);
		visualOutput.addMouseMotionListener(mouseListener);
		
		GroupLayout gl_visualOutput = new GroupLayout(visualOutput);
		gl_visualOutput.setHorizontalGroup(
			gl_visualOutput.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1101, Short.MAX_VALUE)
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
		
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(menuListener);
		fileMenu.add(saveMenuItem);
		
		JMenuItem loadMenuItem = new JMenuItem("Load");
		loadMenuItem.addActionListener(menuListener);
		fileMenu.add(loadMenuItem);
		
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		
		JMenuItem undoMenuItem = new JMenuItem("Undo");
		undoMenuItem.addActionListener(menuListener);
		editMenu.add(undoMenuItem);
		
		JMenuItem redoMenuItem = new JMenuItem("Redo");
		redoMenuItem.addActionListener(menuListener);
		editMenu.add(redoMenuItem);
		
		JMenu tourMenu = new JMenu("Tour");
		menuBar.add(tourMenu);
		
		JMenuItem createTourMenuItem = new JMenuItem("Create Tour");
		createTourMenuItem.addActionListener(menuListener);
		tourMenu.add(createTourMenuItem);
		
		JMenuItem alternateRouteMenuItem = new JMenuItem("Alternate Route");
		alternateRouteMenuItem.addActionListener(menuListener);
		tourMenu.add(alternateRouteMenuItem);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(menuListener);
		mnHelp.add(mntmAbout);
		
		JMenuItem mntmWalkthrough = new JMenuItem("Walkthrough");
		mnHelp.add(mntmWalkthrough);
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
	
	private ArrayList<City> loadCities() {
		cities.clear();
		for (int i = 0; i < system.numberOfNodes(); i++) {
			cities.add(i, (City) system.getNode(i));
		}
		return cities;
	}
	
    public MouseListener getMouseListener() {
    	return mouseListener;
    }
    
    public boolean save(MapSystem sys, String name) {
    	XStream xs = new XStream();
    	try {
    		File saveFile = new File(name + ".gtr");
    		Writer writer = new FileWriter(saveFile);
			xs.toXML(sys, writer);
			writer.close();
			console.setText("\tFile " + name + ".tour saved successfully.");
			return true;
		} catch (IOException e) {
			console.setText("\tError saving file.");
			return false;
		}
    }
    
    public boolean load(File toLoad) {
    	
    	XStream xs = new XStream();
    	try {
    		system = (MapSystem) xs.fromXML(new FileInputStream(toLoad));
    		loadCities();
    		visualOutput.setSystem(system);
    		visualOutput.repaint();
    		mouseListener.loadMouseListener();
			console.setText("\tFile " + toLoad.getName() + " loaded successfully.");

    		if (isCreateTourModeOn || isAlternateRouteModeOn) {
    			mouseListener.setOrigin((City) system.getLink(system.numberOfLinks()-1).getDestination());
    		}
    		return true;
    	} catch (Exception e) {
    		console.setText("\tError loading the file " + toLoad.getName());
    		return false;
    	}
    }

    public Console getConsole() {
    	return console;

    }
}
