package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

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

public class Main {

	private JFrame frame;
	private Map map;
	private MapSystem system;
	private ImagePanel visualOutput;

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

	/**
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
		frame.setBounds(0, 0, 1368, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		visualOutput = new ImagePanel("images/map_bitches.jpg");
		splitPane.setRightComponent(visualOutput);
		
		JLabel widthLabel = new JLabel("width " + frame.getWidth());
		
		JLabel heightLabel = new JLabel("height " + frame.getHeight());
		
		GroupLayout gl_visualOutput = new GroupLayout(visualOutput);
		gl_visualOutput.setHorizontalGroup(
			gl_visualOutput.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_visualOutput.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_visualOutput.createParallelGroup(Alignment.LEADING)
						.addComponent(widthLabel)
						.addComponent(heightLabel))
					.addContainerGap(1161, Short.MAX_VALUE))
		);
		gl_visualOutput.setVerticalGroup(
			gl_visualOutput.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_visualOutput.createSequentialGroup()
					.addContainerGap()
					.addComponent(widthLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(heightLabel)
					.addContainerGap(635, Short.MAX_VALUE))
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
		mnFile.add(mntmNew);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new MenuListener(frame, mntmAbout));
		mnHelp.add(mntmAbout);
		
		JMenuItem mntmWalkthrough = new JMenuItem("Walkthrough");
		mnHelp.add(mntmWalkthrough);
	}
}
