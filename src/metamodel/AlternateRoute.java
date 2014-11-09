package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.awt.geom.Point2D;
import java.sql.Time;
import java.util.*;

// line 79 "model.ump"
// line 165 "model.ump"
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

  public AlternateRoute(Time aTravelTime, Node aOrigin, Node aDestination, double aDistance, MapSystem aMapSystem, TransportationType aTransportationType, DottedArrow aDottedArrow)
  {
    super(aTravelTime, aOrigin, aDestination, aDistance, aMapSystem, aTransportationType);
    if (aDottedArrow == null || aDottedArrow.getAlternateRoute() != null)
    {
      throw new RuntimeException("Unable to create AlternateRoute due to aDottedArrow");
    }
    dottedArrow = aDottedArrow;
  }

  public AlternateRoute(Time aTravelTime, Node aOrigin, Node aDestination, double aDistance, MapSystem aMapSystem, TransportationType aTransportationType, Point2D aBeginForDottedArrow, Point2D aEndForDottedArrow)
  {
    super(aTravelTime, aOrigin, aDestination, aDistance, aMapSystem, aTransportationType);
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