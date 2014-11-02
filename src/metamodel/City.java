package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4678 modeling language!*/


import java.util.*;

// line 65 "model.ump"
// line 129 "model.ump"
public class City extends Node
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //City Attributes
  private String region;
  private Long population;

  //City Associations
  private List<Venue> venues;
  private List<Accomodation> accomodations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public City(String aName, double aLongitude, double aLatitude, Weather aWeather, Map aMap, String aRegion, Long aPopulation)
  {
    super(aName, aLongitude, aLatitude, aWeather, aMap);
    region = aRegion;
    population = aPopulation;
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

  public boolean setPopulation(Long aPopulation)
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

  public Long getPopulation()
  {
    return population;
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
            "population" + ":" + getPopulation()+ "]"
     + outputString;
  }
}