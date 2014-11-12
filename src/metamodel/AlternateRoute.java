package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4733 modeling language!*/


import java.awt.geom.Point2D;
import java.sql.Time;

// line 81 "model.ump"
// line 166 "model.ump"
public class AlternateRoute extends Link
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AlternateRoute Associations
  private DottedArrow dottedArrow;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AlternateRoute(Time aTravelTime, Node aOrigin, Node aDestination, double aDistance, TransportationType aTransportType, MapSystem aMapSystem, DottedArrow aDottedArrow)
  {
    super(aTravelTime, aOrigin, aDestination, aDistance, aTransportType, aMapSystem);
    if (aDottedArrow == null || aDottedArrow.getAlternateRoute() != null)
    {
      throw new RuntimeException("Unable to create AlternateRoute due to aDottedArrow");
    }
    dottedArrow = aDottedArrow;
  }

  public AlternateRoute(Time aTravelTime, Node aOrigin, Node aDestination, double aDistance, TransportationType aTransportType, MapSystem aMapSystem, Point2D aBeginForDottedArrow, Point2D aEndForDottedArrow)
  {
    super(aTravelTime, aOrigin, aDestination, aDistance, aTransportType, aMapSystem);
    dottedArrow = new DottedArrow(aBeginForDottedArrow, aEndForDottedArrow, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public DottedArrow getDottedArrow()
  {
    return dottedArrow;
  }

  public void delete()
  {
    DottedArrow existingDottedArrow = dottedArrow;
    dottedArrow = null;
    if (existingDottedArrow != null)
    {
      existingDottedArrow.delete();
    }
    super.delete();
  }

}
