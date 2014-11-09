/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/



// line 212 "model.ump"
// line 280 "model.ump"
// line 338 "model.ump"
public class Symbol
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Symbol Attributes
  private String iconPath;

  //Symbol Associations
  private DirectedArrow directedArrow;
  private Circle circle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Symbol(String aIconPath, DirectedArrow aDirectedArrow, Circle aCircle)
  {
    iconPath = aIconPath;
    if (aDirectedArrow == null || aDirectedArrow.getSymbol() != null)
    {
      throw new RuntimeException("Unable to create Symbol due to aDirectedArrow");
    }
    directedArrow = aDirectedArrow;
    boolean didAddCircle = setCircle(aCircle);
    if (!didAddCircle)
    {
      throw new RuntimeException("Unable to create symbol due to circle");
    }
  }

  public Symbol(String aIconPath, double aDistanceForDirectedArrow, ArrowLabel aArrowLabelForDirectedArrow, Circle aCircle)
  {
    iconPath = aIconPath;
    directedArrow = new DirectedArrow(aDistanceForDirectedArrow, this, aArrowLabelForDirectedArrow);
    boolean didAddCircle = setCircle(aCircle);
    if (!didAddCircle)
    {
      throw new RuntimeException("Unable to create symbol due to circle");
    }
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

  public DirectedArrow getDirectedArrow()
  {
    return directedArrow;
  }

  public Circle getCircle()
  {
    return circle;
  }

  public boolean setCircle(Circle aCircle)
  {
    boolean wasSet = false;
    if (aCircle == null)
    {
      return wasSet;
    }

    Circle existingCircle = circle;
    circle = aCircle;
    if (existingCircle != null && !existingCircle.equals(aCircle))
    {
      existingCircle.removeSymbol(this);
    }
    circle.addSymbol(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    DirectedArrow existingDirectedArrow = directedArrow;
    directedArrow = null;
    if (existingDirectedArrow != null)
    {
      existingDirectedArrow.delete();
    }
    Circle placeholderCircle = circle;
    this.circle = null;
    placeholderCircle.removeSymbol(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "iconPath" + ":" + getIconPath()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "directedArrow = "+(getDirectedArrow()!=null?Integer.toHexString(System.identityHashCode(getDirectedArrow())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "circle = "+(getCircle()!=null?Integer.toHexString(System.identityHashCode(getCircle())):"null")
     + outputString;
  }
}