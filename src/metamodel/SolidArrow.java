package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.awt.geom.Point2D;
import java.sql.Time;

// line 197 "model.ump"
// line 231 "model.ump"
// line 273 "model.ump"
public class SolidArrow extends DirectedArrow
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SolidArrow Associations
  private MainRoute mainRoute;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SolidArrow(Point2D aBegin, Point2D aEnd, MainRoute aMainRoute)
  {
    super(aBegin, aEnd);
    if (aMainRoute == null || aMainRoute.getSolidArrow() != null)
    {
      throw new RuntimeException("Unable to create SolidArrow due to aMainRoute");
    }
    mainRoute = aMainRoute;
  }

  public SolidArrow(Point2D aBegin, Point2D aEnd, Time aTravelTimeForMainRoute, Node aOriginForMainRoute, Node aDestinationForMainRoute, double aDistanceForMainRoute, MapSystem aMapSystemForMainRoute, TransportationType aTransportationTypeForMainRoute)
  {
    super(aBegin, aEnd);
    mainRoute = new MainRoute(aTravelTimeForMainRoute, aOriginForMainRoute, aDestinationForMainRoute, aDistanceForMainRoute, aMapSystemForMainRoute, aTransportationTypeForMainRoute, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public MainRoute getMainRoute()
  {
    return mainRoute;
  }

  public void delete()
  {
    MainRoute existingMainRoute = mainRoute;
    mainRoute = null;
    if (existingMainRoute != null)
    {
      existingMainRoute.delete();
    }
    super.delete();
  }

}