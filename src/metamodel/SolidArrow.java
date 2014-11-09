/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.sql.Time;

// line 190 "model.ump"
// line 260 "model.ump"
// line 318 "model.ump"
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

  public SolidArrow(double aDistance, Symbol aSymbol, ArrowLabel aArrowLabel, MainRoute aMainRoute)
  {
    super(aDistance, aSymbol, aArrowLabel);
    if (aMainRoute == null || aMainRoute.getSolidArrow() != null)
    {
      throw new RuntimeException("Unable to create SolidArrow due to aMainRoute");
    }
    mainRoute = aMainRoute;
  }

  public SolidArrow(double aDistance, Symbol aSymbol, ArrowLabel aArrowLabel, Time aTravelTimeForMainRoute, Node aOriginForMainRoute, Node aDestinationForMainRoute, MapSystem aMapSystemForMainRoute, TransportationType aTransportationTypeForMainRoute)
  {
    super(aDistance, aSymbol, aArrowLabel);
    mainRoute = new MainRoute(aTravelTimeForMainRoute, aOriginForMainRoute, aDestinationForMainRoute, aMapSystemForMainRoute, aTransportationTypeForMainRoute, this);
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