package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/



// line 181 "model.ump"
// line 218 "model.ump"
// line 251 "model.ump"
public class DirectedArrow
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DirectedArrow Attributes
  private double distance;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DirectedArrow(double aDistance)
  {
    distance = aDistance;
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

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "distance" + ":" + getDistance()+ "]"
     + outputString;
  }
}