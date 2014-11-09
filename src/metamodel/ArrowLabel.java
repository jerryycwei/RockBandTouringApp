package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.sql.Time;

// line 224 "model.ump"
// line 290 "model.ump"
// line 348 "model.ump"
public class ArrowLabel extends Label
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ArrowLabel Attributes
  private Time travelTime;
  private Time depTime;
  private Time arrTime;
  private double cost;

  //ArrowLabel Associations
  private DirectedArrow directedArrow;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ArrowLabel(String aDescription, Time aTravelTime, Time aDepTime, Time aArrTime, double aCost, DirectedArrow aDirectedArrow)
  {
    super(aDescription);
    travelTime = aTravelTime;
    depTime = aDepTime;
    arrTime = aArrTime;
    cost = aCost;
    if (aDirectedArrow == null || aDirectedArrow.getArrowLabel() != null)
    {
      throw new RuntimeException("Unable to create ArrowLabel due to aDirectedArrow");
    }
    directedArrow = aDirectedArrow;
  }

  public ArrowLabel(String aDescription, Time aTravelTime, Time aDepTime, Time aArrTime, double aCost, double aDistanceForDirectedArrow, Symbol aSymbolForDirectedArrow)
  {
    super(aDescription);
    travelTime = aTravelTime;
    depTime = aDepTime;
    arrTime = aArrTime;
    cost = aCost;
    directedArrow = new DirectedArrow(aDistanceForDirectedArrow, aSymbolForDirectedArrow, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTravelTime(Time aTravelTime)
  {
    boolean wasSet = false;
    travelTime = aTravelTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setDepTime(Time aDepTime)
  {
    boolean wasSet = false;
    depTime = aDepTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setArrTime(Time aArrTime)
  {
    boolean wasSet = false;
    arrTime = aArrTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setCost(double aCost)
  {
    boolean wasSet = false;
    cost = aCost;
    wasSet = true;
    return wasSet;
  }

  public Time getTravelTime()
  {
    return travelTime;
  }

  public Time getDepTime()
  {
    return depTime;
  }

  public Time getArrTime()
  {
    return arrTime;
  }

  public double getCost()
  {
    return cost;
  }

  public DirectedArrow getDirectedArrow()
  {
    return directedArrow;
  }

  public void delete()
  {
    DirectedArrow existingDirectedArrow = directedArrow;
    directedArrow = null;
    if (existingDirectedArrow != null)
    {
      existingDirectedArrow.delete();
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "cost" + ":" + getCost()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "travelTime" + "=" + (getTravelTime() != null ? !getTravelTime().equals(this)  ? getTravelTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "depTime" + "=" + (getDepTime() != null ? !getDepTime().equals(this)  ? getDepTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "arrTime" + "=" + (getArrTime() != null ? !getArrTime().equals(this)  ? getArrTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "directedArrow = "+(getDirectedArrow()!=null?Integer.toHexString(System.identityHashCode(getDirectedArrow())):"null")
     + outputString;
  }
}