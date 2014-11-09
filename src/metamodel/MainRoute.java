package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.awt.geom.Point2D;
import java.sql.Time;
import java.util.*;

// line 85 "model.ump"
// line 176 "model.ump"
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

  public MainRoute(Time aTravelTime, Node aOrigin, Node aDestination, double aDistance, MapSystem aMapSystem, TransportationType aTransportationType, SolidArrow aSolidArrow)
  {
    super(aTravelTime, aOrigin, aDestination, aDistance, aMapSystem, aTransportationType);
    if (aSolidArrow == null || aSolidArrow.getMainRoute() != null)
    {
      throw new RuntimeException("Unable to create MainRoute due to aSolidArrow");
    }
    solidArrow = aSolidArrow;
  }

  public MainRoute(Time aTravelTime, Node aOrigin, Node aDestination, double aDistance, MapSystem aMapSystem, TransportationType aTransportationType, Point2D aBeginForSolidArrow, Point2D aEndForSolidArrow)
  {
    super(aTravelTime, aOrigin, aDestination, aDistance, aMapSystem, aTransportationType);
    solidArrow = new SolidArrow(aBeginForSolidArrow, aEndForSolidArrow, this);
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