package ui;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import metamodel.MapSystem;

public class MenuListener implements ActionListener {
	private JMenuItem caller;
	private Main parent;
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			caller = (JMenuItem) e.getSource();
		}
		switch(caller.getText()) {
		case "About":
			JDialog aboutDialog = new JDialog(parent.getFrame());
			aboutDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			aboutDialog.setBounds(500, 200, 300, 200);
			JPanel panel = new JPanel();
			JTextArea aboutArea = new JTextArea();
			aboutArea.setText("\nGunTour MussBander\nVersion 1.0.6 (35247)\nCopyright 2014, GunTour MussBander\n");
			aboutArea.setEditable(false);
			aboutArea.setBackground(null);
			panel.add(aboutArea);
			aboutDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
			aboutDialog.add(panel);
			aboutDialog.setVisible(true);
			break;
		case "Walkthrough":
			String walkthrough =
			"The following are simple step-by-step instructions on how to use the GunTour MussBander software.\n"
			+ "\n"
			+ "     1. Click on Tour > Create Tour.\n"
			+ "     2. Click on Kansas City. Notice the red dot becomes green. This is your starting point.\n"
			+ "     3. Click on Chicago. An arrow gets drawn indicating the direction, with the transport method."
			+ " The default one is by plane."
			+ " In a later release it will be possible to change the travel type to other ones, such as bus or car."
			+ " Notice the Chicago red dot became yellow: this is the ending point of the tour.\n"
			+ "     4. Click on Detroit: Chicago yellow dot becomes blue, and Detroit is now the new end point (yellow).\n"
			+ "     5. Click on Toronto.\n"
			+ "     6. Click on Edit > Undo.\n"
			+ "     7. Click on Tour > End Tour.\n"
			+ "     8. Click on Tour > Alternate Route.\n"
			+ "     9. Click on Chicago, then Atlanta, then Detroit.\n"
			+ "     10. Click on Tour > End Alternate."
			+ " The dashed arrow represents the possibility for the band to stop by Atlanta for another concert before going to Detroit after Chicago.\n"
			+ "     11. Click on File > Save. A pop-up will appear, prompting you to save your current tour to your desired filename."
			+ " Enter anything, for example mytour. The tour will be saved as mytour.gtr. Saving takes a moment, please wait before closing the window.\n"
			+ "     12. Click on File > Clear Map.\n"
			+ "     13. Click on File > Load. Choose your saved file (mytour.gtr). Please wait, loading takes a moment.\n"
			+ "     14. Click on Tour > Create Tour. You can now resume your tour."
			+ " For example, click on Philadelphia, New York and Montreal, carefully avoiding Toronto and Ottawa.";
			JDialog walkthroughDialog = new JDialog(parent.getFrame());
			walkthroughDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			walkthroughDialog.setBounds(100, 100, 1000, 500);
			JPanel walkthroughPanel = new JPanel();
			JTextArea walkthroughArea = new JTextArea();
			walkthroughArea.setEditable(false);
			walkthroughArea.setLineWrap(true);
			walkthroughArea.setWrapStyleWord(true);
			walkthroughArea.setColumns(87);
			walkthroughArea.setRows(400);
			walkthroughArea.setBackground(null);
			walkthroughArea.setText(walkthrough);
			walkthroughPanel.add(walkthroughArea);
			walkthroughDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
			walkthroughDialog.add(walkthroughPanel);
			walkthroughDialog.setVisible(true);
		case "Clear Map":
			MapSystem system = parent.getSystem();
			if (system != null) {
				system.clearLists();
				parent.getVisualOutput().repaint();
				parent.getMouseListener().resetClickCount();
				parent.getConsole().setText("\tConsole Cleared");
			}
			break;
		case "Undo":
			if (parent.getMouseListener().canUndo()) {
				parent.getMouseListener().undo();
			}
			break;
		case "Redo":
			if (parent.getMouseListener().canRedo()){
				parent.getMouseListener().redo();
			}
			break;
			
		case "Create Tour":
			parent.setIsCreateTourModeOn(true);
			caller.setText("End Tour");
			parent.getMouseListener().resetClickCount();
			parent.getConsole().setText("\tCREATE TOUR MODE ACTIVE");
			break;
			
		case "Alternate Route":
			parent.setIsAlternateRouteModeOn(true);
			caller.setText("End Alternate");
			parent.getMouseListener().resetClickCount();
			break;
			
		case "End Tour":
			parent.setIsCreateTourModeOn(false);
			caller.setText("Create Tour");
			parent.getMouseListener().resetClickCount();
			parent.getConsole().setText("\tTour Creation Ended.");
			break;
			
		case "End Alternate":
			parent.setIsAlternateRouteModeOn(false);
			caller.setText("Alternate Route");
			break;
		
		case "Save":
			String saveFileName = "";
			while(saveFileName != null && saveFileName.length() == 0) {
				saveFileName = (String)JOptionPane.showInputDialog(
                    parent.getFrame(),
                    "Enter the filename:\n"
                    + "(overwrites old files of the same name)\n"
                    + "Extension .gtr will be added automatically.",
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null, null);
			}
			if (saveFileName != null) {
		    	parent.getConsole().setText("\tSaving to " + saveFileName + ".gtr");
				parent.save(parent.getSystem(), saveFileName);
			}
			
			break;
			
		case "Load":
		    JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "GunTour Model Files (.gtr)", "gtr");
		    chooser.setFileFilter(filter);
		    chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		    int returnVal = chooser.showOpenDialog(parent.getFrame());
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	parent.getConsole().setText("\tYou chose to open this file: " +
		    		   chooser.getSelectedFile().getName());
		    	parent.load(chooser.getSelectedFile());
		    }
			break;
			
		default:
			break;
		}
		
	}
	
	public MenuListener(Main parent) {
		this.parent = parent;
	}

}
