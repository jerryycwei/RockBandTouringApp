package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4733 modeling language!*/


import java.util.*;

// line 67 "model.ump"
// line 142 "model.ump"
public class City extends Node
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //City Attributes
  private String region;
  private int population;

  //City Associations
  private Weather weather;
  private List<Venue> venues;
  private List<Accomodation> accomodations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public City(String aName, Circle aCircle, MapSystem aMapSystem, String aRegion, int aPopulation, Weather aWeather)
  {
    super(aName, aCircle, aMapSystem);
    region = aRegion;
    population = aPopulation;
    if (aWeather == null || aWeather.getCity() != null)
    {
      throw new RuntimeException("Unable to create City due to aWeather");
    }
    weather = aWeather;
    venues = new ArrayList<Venue>();
    accomodations = new ArrayList<Accomodation>();
  }

  public City(String aName, Circle aCircle, MapSystem aMapSystem, String aRegion, int aPopulation, String aTypeForWeather, Symbol aSymbolForWeather)
  {
    super(aName, aCircle, aMapSystem);
    region = aRegion;
    population = aPopulation;
    weather = new Weather(aTypeForWeather, aSymbolForWeather, this);
    venues = new ArrayList<Venue>();
    accomodations = new ArrayList<Accomodation>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRegion(String aRegion)
  {
    boolean wasSet = false;
    region = aRegion;
    wasSet = true;
    return wasSet;
  }

  public boolean setPopulation(int aPopulation)
  {
    boolean wasSet = false;
    population = aPopulation;
    wasSet = true;
    return wasSet;
  }

  public String getRegion()
  {
    return region;
  }

  public int getPopulation()
  {
    return population;
  }

  public Weather getWeather()
  {
    return weather;
  }

  public Venue getVenue(int index)
  {
    Venue aVenue = venues.get(index);
    return aVenue;
  }

  public List<Venue> getVenues()
  {
    List<Venue> newVenues = Collections.unmodifiableList(venues);
    return newVenues;
  }

  public int numberOfVenues()
  {
    int number = venues.size();
    return number;
  }

  public boolean hasVenues()
  {
    boolean has = venues.size() > 0;
    return has;
  }

  public int indexOfVenue(Venue aVenue)
  {
    int index = venues.indexOf(aVenue);
    return index;
  }

  public Accomodation getAccomodation(int index)
  {
    Accomodation aAccomodation = accomodations.get(index);
    return aAccomodation;
  }

  public List<Accomodation> getAccomodations()
  {
    List<Accomodation> newAccomodations = Collections.unmodifiableList(accomodations);
    return newAccomodations;
  }

  public int numberOfAccomodations()
  {
    int number = accomodations.size();
    return number;
  }

  public boolean hasAccomodations()
  {
    boolean has = accomodations.size() > 0;
    return has;
  }

  public int indexOfAccomodation(Accomodation aAccomodation)
  {
    int index = accomodations.indexOf(aAccomodation);
    return index;
  }

  public static int minimumNumberOfVenues()
  {
    return 0;
  }

  public Venue addVenue(String aName, String aType, double aCost)
  {
    return new Venue(aName, aType, aCost, this);
  }

  public boolean addVenue(Venue aVenue)
  {
    boolean wasAdded = false;
    if (venues.contains(aVenue)) { return false; }
    if (venues.contains(aVenue)) { return false; }
    if (venues.contains(aVenue)) { return false; }
    if (venues.contains(aVenue)) { return false; }
    City existingCity = aVenue.getCity();
    boolean isNewCity = existingCity != null && !this.equals(existingCity);
    if (isNewCity)
    {
      aVenue.setCity(this);
    }
    else
    {
      venues.add(aVenue);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVenue(Venue aVenue)
  {
    boolean wasRemoved = false;
    //Unable to remove aVenue, as it must always have a city
    if (!this.equals(aVenue.getCity()))
    {
      venues.remove(aVenue);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addVenueAt(Venue aVenue, int index)
  {  
    boolean wasAdded = false;
    if(addVenue(aVenue))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVenues()) { index = numberOfVenues() - 1; }
      venues.remove(aVenue);
      venues.add(index, aVenue);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVenueAt(Venue aVenue, int index)
  {
    boolean wasAdded = false;
    if(venues.contains(aVenue))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVenues()) { index = numberOfVenues() - 1; }
      venues.remove(aVenue);
      venues.add(index, aVenue);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVenueAt(aVenue, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfAccomodations()
  {
    return 0;
  }

  public Accomodation addAccomodation(String aName, String aType, double aCost)
  {
    return new Accomodation(aName, aType, aCost, this);
  }

  public boolean addAccomodation(Accomodation aAccomodation)
  {
    boolean wasAdded = false;
    if (accomodations.contains(aAccomodation)) { return false; }
    if (accomodations.contains(aAccomodation)) { return false; }
    if (accomodations.contains(aAccomodation)) { return false; }
    if (accomodations.contains(aAccomodation)) { return false; }
    City existingCity = aAccomodation.getCity();
    boolean isNewCity = existingCity != null && !this.equals(existingCity);
    if (isNewCity)
    {
      aAccomodation.setCity(this);
    }
    else
    {
      accomodations.add(aAccomodation);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAccomodation(Accomodation aAccomodation)
  {
    boolean wasRemoved = false;
    //Unable to remove aAccomodation, as it must always have a city
    if (!this.equals(aAccomodation.getCity()))
    {
      accomodations.remove(aAccomodation);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAccomodationAt(Accomodation aAccomodation, int index)
  {  
    boolean wasAdded = false;
    if(addAccomodation(aAccomodation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccomodations()) { index = numberOfAccomodations() - 1; }
      accomodations.remove(aAccomodation);
      accomodations.add(index, aAccomodation);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccomodationAt(Accomodation aAccomodation, int index)
  {
    boolean wasAdded = false;
    if(accomodations.contains(aAccomodation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccomodations()) { index = numberOfAccomodations() - 1; }
      accomodations.remove(aAccomodation);
      accomodations.add(index, aAccomodation);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccomodationAt(aAccomodation, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Weather existingWeather = weather;
    weather = null;
    if (existingWeather != null)
    {
      existingWeather.delete();
    }
    for(int i=venues.size(); i > 0; i--)
    {
      Venue aVenue = venues.get(i - 1);
      aVenue.delete();
    }
    for(int i=accomodations.size(); i > 0; i--)
    {
      Accomodation aAccomodation = accomodations.get(i - 1);
      aAccomodation.delete();
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "region" + ":" + getRegion()+ "," +
            "population" + ":" + getPopulation()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "weather = "+(getWeather()!=null?Integer.toHexString(System.identityHashCode(getWeather())):"null")
     + outputString;
  }
}