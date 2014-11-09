package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/



// line 213 "model.ump"
// line 244 "model.ump"
// line 286 "model.ump"
public class Symbol
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Symbol Attributes
  private String iconPath;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Symbol(String aIconPath)
  {
    iconPath = aIconPath;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIconPath(String aIconPath)
  {
    boolean wasSet = false;
    iconPath = aIconPath;
    wasSet = true;
    return wasSet;
  }

  public String getIconPath()
  {
    return iconPath;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "iconPath" + ":" + getIconPath()+ "]"
     + outputString;
  }
}