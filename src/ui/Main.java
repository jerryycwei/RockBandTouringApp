package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	private JTextArea textArea = new JTextArea();
	private InfoLabel infoLabel = new InfoLabel(textArea, map);
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
		//textArea.setMinimumSize(new Dimension(60, 15));
		frame = new JFrame();
		frame.setBounds(0, 0, 1280, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		visualOutput = new ImagePanel("images/map.jpg", system);
		//visualOutput.setSize(1100, 631);
		//visualOutput.setMinimumSize(new Dimension(1100, 601));
		//visualOutput.setBounds(0, 0, 1000, 700);
		
		splitPane.setLeftComponent(visualOutput);
		
		final Console console = new Console();
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
	
    public MouseListener getMouseListener() {
    	return mouseListener;
    }
}
