package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4733 modeling language!*/


import java.awt.geom.Point2D;
import java.sql.Time;

// line 202 "model.ump"
// line 235 "model.ump"
// line 277 "model.ump"
public class DottedArrow extends DirectedArrow
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DottedArrow Associations
  private AlternateRoute alternateRoute;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DottedArrow(Point2D aBegin, Point2D aEnd, AlternateRoute aAlternateRoute)
  {
    super(aBegin, aEnd);
    if (aAlternateRoute == null || aAlternateRoute.getDottedArrow() != null)
    {
      throw new RuntimeException("Unable to create DottedArrow due to aAlternateRoute");
    }
    alternateRoute = aAlternateRoute;
  }

  public DottedArrow(Point2D aBegin, Point2D aEnd, Time aTravelTimeForAlternateRoute, Node aOriginForAlternateRoute, Node aDestinationForAlternateRoute, double aDistanceForAlternateRoute, TransportationType aTransportTypeForAlternateRoute, MapSystem aMapSystemForAlternateRoute)
  {
    super(aBegin, aEnd);
    alternateRoute = new AlternateRoute(aTravelTimeForAlternateRoute, aOriginForAlternateRoute, aDestinationForAlternateRoute, aDistanceForAlternateRoute, aTransportTypeForAlternateRoute, aMapSystemForAlternateRoute, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public AlternateRoute getAlternateRoute()
  {
    return alternateRoute;
  }

  public void delete()
  {
    AlternateRoute existingAlternateRoute = alternateRoute;
    alternateRoute = null;
    if (existingAlternateRoute != null)
    {
      existingAlternateRoute.delete();
    }
    super.delete();
  }

}
