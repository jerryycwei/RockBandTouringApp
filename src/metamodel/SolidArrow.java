package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4733 modeling language!*/


import java.awt.geom.Point2D;
import java.sql.Time;

// line 197 "model.ump"
// line 230 "model.ump"
// line 272 "model.ump"
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

  public SolidArrow(Point2D aBegin, Point2D aEnd, Time aTravelTimeForMainRoute, Node aOriginForMainRoute, Node aDestinationForMainRoute, double aDistanceForMainRoute, TransportationType aTransportTypeForMainRoute, MapSystem aMapSystemForMainRoute)
  {
    super(aBegin, aEnd);
    mainRoute = new MainRoute(aTravelTimeForMainRoute, aOriginForMainRoute, aDestinationForMainRoute, aDistanceForMainRoute, aTransportTypeForMainRoute, aMapSystemForMainRoute, this);
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
