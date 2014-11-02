package ui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JToolBar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class Main {

	private JFrame frame;

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
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		ImagePanel visualOutput = new ImagePanel("images/usa-canada-map.jpg");
		splitPane.setRightComponent(visualOutput);
		
		JMenuBar menuContainer = new JMenuBar();
		splitPane.setLeftComponent(menuContainer);
		
		JMenu mnLink = new JMenu("Link");
		
		JMenu mnCity = new JMenu("City");
		mnCity.setSelectedIcon(new ImageIcon("C:\\Users\\Quang\\Documents\\GitHub\\ECSE539\\RockBandTouringApp\\Resources\\download.jpeg"));
		GroupLayout gl_menuContainer = new GroupLayout(menuContainer);
		gl_menuContainer.setHorizontalGroup(
			gl_menuContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_menuContainer.createSequentialGroup()
					.addComponent(mnLink, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_menuContainer.createSequentialGroup()
					.addComponent(mnCity, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_menuContainer.setVerticalGroup(
			gl_menuContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuContainer.createSequentialGroup()
					.addGap(5)
					.addComponent(mnLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(mnCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
	}
}
