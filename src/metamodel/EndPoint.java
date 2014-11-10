package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4733 modeling language!*/


import java.util.*;

// line 62 "model.ump"
// line 137 "model.ump"
public class EndPoint extends City
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public EndPoint(String aName, Circle aCircle, boolean aSelected, MapSystem aMapSystem, String aRegion, int aPopulation, Weather aWeather)
  {
    super(aName, aCircle, aSelected, aMapSystem, aRegion, aPopulation, aWeather);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}