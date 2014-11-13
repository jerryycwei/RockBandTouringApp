package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4738 modeling language!*/


import java.util.*;

// line 51 "model.ump"
// line 112 "model.ump"
public class City extends Node
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //City Attributes
  private String region;
  private int population;
  private boolean startNode;
  private boolean endNode;

  //City Associations
  private Weather weather;
  private List<Venue> venues;
  private List<Accommodation> accommodations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public City(String aName, Circle aCircle, MapSystem aMapSystem, String aRegion, int aPopulation, Weather aWeather)
  {
    super(aName, aCircle, aMapSystem);
    region = aRegion;
    population = aPopulation;
    startNode = false;
    endNode = false;
    if (aWeather == null || aWeather.getCity() != null)
    {
      throw new RuntimeException("Unable to create City due to aWeather");
    }
    weather = aWeather;
    venues = new ArrayList<Venue>();
    accommodations = new ArrayList<Accommodation>();
  }

  public City(String aName, Circle aCircle, MapSystem aMapSystem, String aRegion, int aPopulation, String aTypeForWeather, Symbol aSymbolForWeather)
  {
    super(aName, aCircle, aMapSystem);
    region = aRegion;
    population = aPopulation;
    startNode = false;
    endNode = false;
    weather = new Weather(aTypeForWeather, aSymbolForWeather, this);
    venues = new ArrayList<Venue>();
    accommodations = new ArrayList<Accommodation>();
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

  public boolean setStartNode(boolean aStartNode)
  {
    boolean wasSet = false;
    startNode = aStartNode;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndNode(boolean aEndNode)
  {
    boolean wasSet = false;
    endNode = aEndNode;
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

  public boolean getStartNode()
  {
    return startNode;
  }

  public boolean getEndNode()
  {
    return endNode;
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

  public Accommodation getAccommodation(int index)
  {
    Accommodation aAccommodation = accommodations.get(index);
    return aAccommodation;
  }

  public List<Accommodation> getAccommodations()
  {
    List<Accommodation> newAccommodations = Collections.unmodifiableList(accommodations);
    return newAccommodations;
  }

  public int numberOfAccommodations()
  {
    int number = accommodations.size();
    return number;
  }

  public boolean hasAccommodations()
  {
    boolean has = accommodations.size() > 0;
    return has;
  }

  public int indexOfAccommodation(Accommodation aAccommodation)
  {
    int index = accommodations.indexOf(aAccommodation);
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

  public static int minimumNumberOfAccommodations()
  {
    return 0;
  }

  public Accommodation addAccommodation(String aName, String aType, double aCost)
  {
    return new Accommodation(aName, aType, aCost, this);
  }

  public boolean addAccommodation(Accommodation aAccommodation)
  {
    boolean wasAdded = false;
    if (accommodations.contains(aAccommodation)) { return false; }
    City existingCity = aAccommodation.getCity();
    boolean isNewCity = existingCity != null && !this.equals(existingCity);
    if (isNewCity)
    {
      aAccommodation.setCity(this);
    }
    else
    {
      accommodations.add(aAccommodation);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAccommodation(Accommodation aAccommodation)
  {
    boolean wasRemoved = false;
    //Unable to remove aAccommodation, as it must always have a city
    if (!this.equals(aAccommodation.getCity()))
    {
      accommodations.remove(aAccommodation);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAccommodationAt(Accommodation aAccommodation, int index)
  {  
    boolean wasAdded = false;
    if(addAccommodation(aAccommodation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccommodations()) { index = numberOfAccommodations() - 1; }
      accommodations.remove(aAccommodation);
      accommodations.add(index, aAccommodation);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccommodationAt(Accommodation aAccommodation, int index)
  {
    boolean wasAdded = false;
    if(accommodations.contains(aAccommodation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccommodations()) { index = numberOfAccommodations() - 1; }
      accommodations.remove(aAccommodation);
      accommodations.add(index, aAccommodation);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccommodationAt(aAccommodation, index);
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
    for(int i=accommodations.size(); i > 0; i--)
    {
      Accommodation aAccommodation = accommodations.get(i - 1);
      aAccommodation.delete();
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "region" + ":" + getRegion()+ "," +
            "population" + ":" + getPopulation()+ "," +
            "startNode" + ":" + getStartNode()+ "," +
            "endNode" + ":" + getEndNode()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "weather = "+(getWeather()!=null?Integer.toHexString(System.identityHashCode(getWeather())):"null")
     + outputString;
  }
}