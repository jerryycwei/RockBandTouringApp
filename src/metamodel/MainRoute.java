package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.sql.Time;
import java.util.*;

// line 83 "model.ump"
// line 167 "model.ump"
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

  public MainRoute(Time aTravelTime, Node aOrigin, Node aDestination, MapSystem aMapSystem, TransportationType aTransportationType, SolidArrow aSolidArrow)
  {
    super(aTravelTime, aOrigin, aDestination, aMapSystem, aTransportationType);
    if (aSolidArrow == null || aSolidArrow.getMainRoute() != null)
    {
      throw new RuntimeException("Unable to create MainRoute due to aSolidArrow");
    }
    solidArrow = aSolidArrow;
  }

  public MainRoute(Time aTravelTime, Node aOrigin, Node aDestination, MapSystem aMapSystem, TransportationType aTransportationType, double aDistanceForSolidArrow, Symbol aSymbolForSolidArrow, ArrowLabel aArrowLabelForSolidArrow)
  {
    super(aTravelTime, aOrigin, aDestination, aMapSystem, aTransportationType);
    solidArrow = new SolidArrow(aDistanceForSolidArrow, aSymbolForSolidArrow, aArrowLabelForSolidArrow, this);
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