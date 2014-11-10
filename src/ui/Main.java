package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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

public class Main {

	private JFrame frame;
	private Map map;
	private MapSystem system;
	private ImagePanel visualOutput;
	private MenuListener menuListener = new MenuListener(this);
	
	Graphics2D g2d;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//initializeCities();
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

	/*
	 * Initialize Cities as well as the venues and accomodations
	 
	private static void initializeCities() {
		// TODO Auto-generated method stub
		Circle losAngeles = new Circle("Los Angeles", 
		City losAngeles = new City("Los Angeles", this, c, null, 0, null, null);
		City chicago = new City()
	}*/

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
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
		
		visualOutput = new ImagePanel("images/map_bitches.jpg");
		splitPane.setRightComponent(visualOutput);
		
		JLabel widthLabel = new JLabel("width " + frame.getWidth());
		
		JLabel heightLabel = new JLabel("height " + frame.getHeight());
		
		final Console console = new Console();
		
		GroupLayout gl_visualOutput = new GroupLayout(visualOutput);
		gl_visualOutput.setHorizontalGroup(
			gl_visualOutput.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_visualOutput.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_visualOutput.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_visualOutput.createSequentialGroup()
							.addGroup(gl_visualOutput.createParallelGroup(Alignment.LEADING)
								.addComponent(widthLabel)
								.addComponent(heightLabel))
							.addContainerGap(1048, Short.MAX_VALUE))
						.addComponent(console, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE)))
		);
		gl_visualOutput.setVerticalGroup(
			gl_visualOutput.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_visualOutput.createSequentialGroup()
					.addContainerGap()
					.addComponent(widthLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(heightLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 491, Short.MAX_VALUE)
					.addComponent(console, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
		);
		visualOutput.setLayout(gl_visualOutput);
		
		JMenuBar menuContainer = new JMenuBar();
		splitPane.setLeftComponent(menuContainer);
		GroupLayout gl_menuContainer = new GroupLayout(menuContainer);
		
		JMenu mnLink = new JMenu("Link");
		JMenu mnCity = new JMenu("City");

		gl_menuContainer.setHorizontalGroup(
			gl_menuContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_menuContainer.createSequentialGroup()
					.addComponent(mnCity, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_menuContainer.createSequentialGroup()
					.addComponent(mnLink, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_menuContainer.setVerticalGroup(
			gl_menuContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuContainer.createSequentialGroup()
					.addGap(5)
					.addComponent(mnCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(mnLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(205))
		);
		
		JMenuItem mntmMainRoute = new JMenuItem("Main route");
		mntmMainRoute.setIcon(null);
		mnLink.add(mntmMainRoute);
		
		JMenuItem mntmAlternativeRoute = new JMenuItem("Alternative route");
		mnLink.add(mntmAlternativeRoute);
				
		JMenuItem mntmStart = new JMenuItem("Start");
		mnCity.add(mntmStart);
		
		JMenuItem mntmEnd = new JMenuItem("End");
		mnCity.add(mntmEnd);
		
		JMenuItem mntmTransferPoint = new JMenuItem("Transfer Point");
		mnCity.add(mntmTransferPoint);
		menuContainer.setLayout(gl_menuContainer);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		toolBar.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(menuListener);
		mnFile.add(mntmNew);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
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
	                public void mouseClicked( MouseEvent e ) { // this method takes in a MouseEvent (when the mouse is clicked)
	                        int x =e.getX(); // the specific x coordinate of the point clicked is stored in a place in the array
	                        int y =e.getY(); // the specific y coordinate of the point clicked is stored in a place in the array
	                        console.setText("X: " + x + "\nY: " + y + "\n");
	                        visualOutput.repaint(); // added because display was buggy                                
	                }
	            }
	        );
	}
	
	public void setVisualOutput(ImagePanel aVisualOutput) {
		visualOutput = aVisualOutput;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public MapSystem getSystem() {
		return system;
	}
	
	public ImagePanel getVisualOutput() {
		return visualOutput;
	}
	
    public void paint(Graphics g) { // the paint method draws shapes and other images onto the GUI
        g2d = ( Graphics2D ) g; // Graphics2D is accessed for more options
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
