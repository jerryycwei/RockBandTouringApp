package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/



// line 46 "model.ump"
// line 123 "model.ump"
public class Accommodation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Accommodation Attributes
  private String name;
  private String type;
  private double cost;

  //Accommodation Associations
  private City city;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Accommodation(String aName, String aType, double aCost, City aCity)
  {
    name = aName;
    type = aType;
    cost = aCost;
    boolean didAddCity = setCity(aCity);
    if (!didAddCity)
    {
      throw new RuntimeException("Unable to create accommodation due to city");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setCost(double aCost)
  {
    boolean wasSet = false;
    cost = aCost;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getType()
  {
    return type;
  }

  public double getCost()
  {
    return cost;
  }

  public City getCity()
  {
    return city;
  }

  public boolean setCity(City aCity)
  {
    boolean wasSet = false;
    if (aCity == null)
    {
      return wasSet;
    }

    City existingCity = city;
    city = aCity;
    if (existingCity != null && !existingCity.equals(aCity))
    {
      existingCity.removeAccommodation(this);
    }
    city.addAccommodation(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    City placeholderCity = city;
    this.city = null;
    placeholderCity.removeAccommodation(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "type" + ":" + getType()+ "," +
            "cost" + ":" + getCost()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "city = "+(getCity()!=null?Integer.toHexString(System.identityHashCode(getCity())):"null")
     + outputString;
  }
}