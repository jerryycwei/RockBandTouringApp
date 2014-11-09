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
  private int sizeH;
  private int sizeW;
  private Image map;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Map(int aSizeH, int aSizeW, Image aMap)
  {
    sizeH = aSizeH;
    sizeW = aSizeW;
    map = aMap;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSizeH(int aSizeH)
  {
    boolean wasSet = false;
    sizeH = aSizeH;
    wasSet = true;
    return wasSet;
  }

  public boolean setSizeW(int aSizeW)
  {
    boolean wasSet = false;
    sizeW = aSizeW;
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

  public int getSizeH()
  {
    return sizeH;
  }

  public int getSizeW()
  {
    return sizeW;
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
            "sizeH" + ":" + getSizeH()+ "," +
            "sizeW" + ":" + getSizeW()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "map" + "=" + (getMap() != null ? !getMap().equals(this)  ? getMap().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}