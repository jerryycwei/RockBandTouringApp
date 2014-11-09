/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.sql.Time;

// line 173 "model.ump"
// line 246 "model.ump"
// line 298 "model.ump"
public class DirectedArrow
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DirectedArrow Attributes
  private double distance;

  //DirectedArrow Associations
  private Symbol symbol;
  private ArrowLabel arrowLabel;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DirectedArrow(double aDistance, Symbol aSymbol, ArrowLabel aArrowLabel)
  {
    distance = aDistance;
    if (aSymbol == null || aSymbol.getDirectedArrow() != null)
    {
      throw new RuntimeException("Unable to create DirectedArrow due to aSymbol");
    }
    symbol = aSymbol;
    if (aArrowLabel == null || aArrowLabel.getDirectedArrow() != null)
    {
      throw new RuntimeException("Unable to create DirectedArrow due to aArrowLabel");
    }
    arrowLabel = aArrowLabel;
  }

  public DirectedArrow(double aDistance, String aIconPathForSymbol, Circle aCircleForSymbol, String aDescriptionForArrowLabel, Time aTravelTimeForArrowLabel, Time aDepTimeForArrowLabel, Time aArrTimeForArrowLabel, double aCostForArrowLabel)
  {
    distance = aDistance;
    symbol = new Symbol(aIconPathForSymbol, this, aCircleForSymbol);
    arrowLabel = new ArrowLabel(aDescriptionForArrowLabel, aTravelTimeForArrowLabel, aDepTimeForArrowLabel, aArrTimeForArrowLabel, aCostForArrowLabel, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDistance(double aDistance)
  {
    boolean wasSet = false;
    distance = aDistance;
    wasSet = true;
    return wasSet;
  }

  public double getDistance()
  {
    return distance;
  }

  public Symbol getSymbol()
  {
    return symbol;
  }

  public ArrowLabel getArrowLabel()
  {
    return arrowLabel;
  }

  public void delete()
  {
    Symbol existingSymbol = symbol;
    symbol = null;
    if (existingSymbol != null)
    {
      existingSymbol.delete();
    }
    ArrowLabel existingArrowLabel = arrowLabel;
    arrowLabel = null;
    if (existingArrowLabel != null)
    {
      existingArrowLabel.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "distance" + ":" + getDistance()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "symbol = "+(getSymbol()!=null?Integer.toHexString(System.identityHashCode(getSymbol())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "arrowLabel = "+(getArrowLabel()!=null?Integer.toHexString(System.identityHashCode(getArrowLabel())):"null")
     + outputString;
  }
}