package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4678 modeling language!*/


import java.sql.Time;
import java.util.*;

// line 82 "model.ump"
// line 162 "model.ump"
public class MainRoute extends Link
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MainRoute(Time aTravelTime, Node aOrigin, Node aDestination, Map aMap, TransportationType aTransportationType)
  {
    super(aTravelTime, aOrigin, aDestination, aMap, aTransportationType);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}