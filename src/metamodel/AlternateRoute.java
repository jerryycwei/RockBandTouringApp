/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.sql.Time;
import java.util.*;

// line 77 "model.ump"
// line 156 "model.ump"
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

  public AlternateRoute(Time aTravelTime, Node aOrigin, Node aDestination, MapSystem aMapSystem, TransportationType aTransportationType, DottedArrow aDottedArrow)
  {
    super(aTravelTime, aOrigin, aDestination, aMapSystem, aTransportationType);
    if (aDottedArrow == null || aDottedArrow.getAlternateRoute() != null)
    {
      throw new RuntimeException("Unable to create AlternateRoute due to aDottedArrow");
    }
    dottedArrow = aDottedArrow;
  }

  public AlternateRoute(Time aTravelTime, Node aOrigin, Node aDestination, MapSystem aMapSystem, TransportationType aTransportationType, double aDistanceForDottedArrow, Symbol aSymbolForDottedArrow, ArrowLabel aArrowLabelForDottedArrow)
  {
    super(aTravelTime, aOrigin, aDestination, aMapSystem, aTransportationType);
    dottedArrow = new DottedArrow(aDistanceForDottedArrow, aSymbolForDottedArrow, aArrowLabelForDottedArrow, this);
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