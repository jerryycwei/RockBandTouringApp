package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

// line 93 "model.ump"
// line 291 "model.ump"
// line 297 "model.ump"
public class InfoLabel extends JPanel
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //InfoLabel Attributes
  private JTextArea info;

  //InfoLabel Associations
  private MapSystem mapSystem;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public InfoLabel(JTextArea aInfo, MapSystem aMapSystem)
  {
    info = aInfo;
	info.setText("City: Jersey");
	info.setBackground(new Color(0, 0, 0));
	info.setColumns(10);
	info.setRows(100);
	info.setVisible(true);
    this.add(info);
    this.setVisible(true);
    
    if (aMapSystem == null || aMapSystem.getInfoLabel() != null)
    {
      throw new RuntimeException("Unable to create InfoLabel due to aMapSystem");
    }
    mapSystem = aMapSystem;
  }

  public InfoLabel(JTextArea aInfo, Map aMapForMapSystem)
  {
    info = aInfo;
	info.setText("City: Jersey");
	info.setColumns(10);
	info.setRows(100);
	info.setVisible(true);
    this.add(info);
    this.setVisible(true);
    
    mapSystem = new MapSystem(aMapForMapSystem, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setInfo(JTextArea aInfo)
  {
    boolean wasSet = false;
    info = aInfo;
    wasSet = true;
    return wasSet;
  }

  public JTextArea getInfo()
  {
    return info;
  }

  public MapSystem getMapSystem()
  {
    return mapSystem;
  }

  public void delete()
  {
    MapSystem existingMapSystem = mapSystem;
    mapSystem = null;
    if (existingMapSystem != null)
    {
      existingMapSystem.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "info" + "=" + (getInfo() != null ? !getInfo().equals(this)  ? getInfo().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "mapSystem = "+(getMapSystem()!=null?Integer.toHexString(System.identityHashCode(getMapSystem())):"null")
     + outputString;
  }
}