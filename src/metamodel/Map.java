package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.awt.Image;

// line 205 "model.ump"
// line 239 "model.ump"
// line 281 "model.ump"
public class Map
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Map Attributes
  private int height;
  private int width;
  private Image map;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Map(int aHeight, int aWidth, Image aMap)
  {
    height = aHeight;
    width = aWidth;
    map = aMap;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setHeight(int aHeight)
  {
    boolean wasSet = false;
    height = aHeight;
    wasSet = true;
    return wasSet;
  }

  public boolean setWidth(int aWidth)
  {
    boolean wasSet = false;
    width = aWidth;
    wasSet = true;
    return wasSet;
  }

  public boolean setMap(Image aMap)
  {
    boolean wasSet = false;
    map = aMap;
    wasSet = true;
    return wasSet;
  }

  public int getHeight()
  {
    return height;
  }

  public int getWidth()
  {
    return width;
  }

  public Image getMap()
  {
    return map;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "height" + ":" + getHeight()+ "," +
            "width" + ":" + getWidth()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "map" + "=" + (getMap() != null ? !getMap().equals(this)  ? getMap().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}