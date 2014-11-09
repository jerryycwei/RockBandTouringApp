package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.sql.Time;

// line 200 "model.ump"
// line 234 "model.ump"
// line 276 "model.ump"
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

  public DottedArrow(double aDistance, AlternateRoute aAlternateRoute)
  {
    super(aDistance);
    if (aAlternateRoute == null || aAlternateRoute.getDottedArrow() != null)
    {
      throw new RuntimeException("Unable to create DottedArrow due to aAlternateRoute");
    }
    alternateRoute = aAlternateRoute;
  }

  public DottedArrow(double aDistance, Time aTravelTimeForAlternateRoute, Node aOriginForAlternateRoute, Node aDestinationForAlternateRoute, int aDistanceForAlternateRoute, MapSystem aMapSystemForAlternateRoute, TransportationType aTransportationTypeForAlternateRoute)
  {
    super(aDistance);
    alternateRoute = new AlternateRoute(aTravelTimeForAlternateRoute, aOriginForAlternateRoute, aDestinationForAlternateRoute, aDistanceForAlternateRoute, aMapSystemForAlternateRoute, aTransportationTypeForAlternateRoute, this);
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