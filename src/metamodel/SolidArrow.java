package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.sql.Time;

// line 195 "model.ump"
// line 229 "model.ump"
// line 271 "model.ump"
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

  public SolidArrow(double aDistance, MainRoute aMainRoute)
  {
    super(aDistance);
    if (aMainRoute == null || aMainRoute.getSolidArrow() != null)
    {
      throw new RuntimeException("Unable to create SolidArrow due to aMainRoute");
    }
    mainRoute = aMainRoute;
  }

  public SolidArrow(double aDistance, Time aTravelTimeForMainRoute, Node aOriginForMainRoute, Node aDestinationForMainRoute, int aDistanceForMainRoute, MapSystem aMapSystemForMainRoute, TransportationType aTransportationTypeForMainRoute)
  {
    super(aDistance);
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