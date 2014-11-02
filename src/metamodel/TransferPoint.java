package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4678 modeling language!*/


import java.sql.Time;
import java.util.*;

// line 34 "model.ump"
// line 102 "model.ump"
public class TransferPoint extends City
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TransferPoint Attributes
  private Time layoverTime;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TransferPoint(String aName, double aLongitude, double aLatitude, Weather aWeather, Map aMap, String aRegion, Long aPopulation, Time aLayoverTime)
  {
    super(aName, aLongitude, aLatitude, aWeather, aMap, aRegion, aPopulation);
    layoverTime = aLayoverTime;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLayoverTime(Time aLayoverTime)
  {
    boolean wasSet = false;
    layoverTime = aLayoverTime;
    wasSet = true;
    return wasSet;
  }

  public Time getLayoverTime()
  {
    return layoverTime;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "layoverTime" + "=" + (getLayoverTime() != null ? !getLayoverTime().equals(this)  ? getLayoverTime().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}