package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.sql.Time;
import java.util.*;

// line 84 "model.ump"
// line 175 "model.ump"
public class MainRoute extends Link
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MainRoute Associations
  private SolidArrow solidArrow;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MainRoute(Time aTravelTime, Node aOrigin, Node aDestination, int aDistance, MapSystem aMapSystem, TransportationType aTransportationType, SolidArrow aSolidArrow)
  {
    super(aTravelTime, aOrigin, aDestination, aDistance, aMapSystem, aTransportationType);
    if (aSolidArrow == null || aSolidArrow.getMainRoute() != null)
    {
      throw new RuntimeException("Unable to create MainRoute due to aSolidArrow");
    }
    solidArrow = aSolidArrow;
  }

  public MainRoute(Time aTravelTime, Node aOrigin, Node aDestination, int aDistance, MapSystem aMapSystem, TransportationType aTransportationType, double aDistanceForSolidArrow)
  {
    super(aTravelTime, aOrigin, aDestination, aDistance, aMapSystem, aTransportationType);
    solidArrow = new SolidArrow(aDistanceForSolidArrow, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public SolidArrow getSolidArrow()
  {
    return solidArrow;
  }

  public void delete()
  {
    SolidArrow existingSolidArrow = solidArrow;
    solidArrow = null;
    if (existingSolidArrow != null)
    {
      existingSolidArrow.delete();
    }
    super.delete();
  }

}