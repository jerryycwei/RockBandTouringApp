/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.sql.Time;

// line 195 "model.ump"
// line 265 "model.ump"
// line 323 "model.ump"
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

  public DottedArrow(double aDistance, Symbol aSymbol, ArrowLabel aArrowLabel, AlternateRoute aAlternateRoute)
  {
    super(aDistance, aSymbol, aArrowLabel);
    if (aAlternateRoute == null || aAlternateRoute.getDottedArrow() != null)
    {
      throw new RuntimeException("Unable to create DottedArrow due to aAlternateRoute");
    }
    alternateRoute = aAlternateRoute;
  }

  public DottedArrow(double aDistance, Symbol aSymbol, ArrowLabel aArrowLabel, Time aTravelTimeForAlternateRoute, Node aOriginForAlternateRoute, Node aDestinationForAlternateRoute, MapSystem aMapSystemForAlternateRoute, TransportationType aTransportationTypeForAlternateRoute)
  {
    super(aDistance, aSymbol, aArrowLabel);
    alternateRoute = new AlternateRoute(aTravelTimeForAlternateRoute, aOriginForAlternateRoute, aDestinationForAlternateRoute, aMapSystemForAlternateRoute, aTransportationTypeForAlternateRoute, this);
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