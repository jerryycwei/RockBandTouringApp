/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/



// line 217 "model.ump"
// line 285 "model.ump"
// line 343 "model.ump"
public class CircleLabel extends Label
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CircleLabel Attributes
  private Accomodation accom;
  private Venue venue;

  //CircleLabel Associations
  private Circle circle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CircleLabel(String aDescription, Accomodation aAccom, Venue aVenue, Circle aCircle)
  {
    super(aDescription);
    accom = aAccom;
    venue = aVenue;
    if (aCircle == null || aCircle.getCircleLabel() != null)
    {
      throw new RuntimeException("Unable to create CircleLabel due to aCircle");
    }
    circle = aCircle;
  }

  public CircleLabel(String aDescription, Accomodation aAccom, Venue aVenue, String aNameForCircle, double aLongitudeForCircle, double aLatitudeForCircle, Node aNodeForCircle)
  {
    super(aDescription);
    accom = aAccom;
    venue = aVenue;
    circle = new Circle(aNameForCircle, aLongitudeForCircle, aLatitudeForCircle, aNodeForCircle, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAccom(Accomodation aAccom)
  {
    boolean wasSet = false;
    accom = aAccom;
    wasSet = true;
    return wasSet;
  }

  public boolean setVenue(Venue aVenue)
  {
    boolean wasSet = false;
    venue = aVenue;
    wasSet = true;
    return wasSet;
  }

  public Accomodation getAccom()
  {
    return accom;
  }

  public Venue getVenue()
  {
    return venue;
  }

  public Circle getCircle()
  {
    return circle;
  }

  public void delete()
  {
    Circle existingCircle = circle;
    circle = null;
    if (existingCircle != null)
    {
      existingCircle.delete();
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "accom" + "=" + (getAccom() != null ? !getAccom().equals(this)  ? getAccom().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "venue" + "=" + (getVenue() != null ? !getVenue().equals(this)  ? getVenue().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "circle = "+(getCircle()!=null?Integer.toHexString(System.identityHashCode(getCircle())):"null")
     + outputString;
  }
}