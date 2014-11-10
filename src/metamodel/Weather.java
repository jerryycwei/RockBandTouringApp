package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/



// line 72 "model.ump"
// line 145 "model.ump"
public class Weather
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Weather Attributes
  private String type;
  private Symbol symbol;

  //Weather Associations
  private City city;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Weather(String aType, Symbol aSymbol, City aCity)
  {
    type = aType;
    symbol = aSymbol;
    if (aCity == null || aCity.getWeather() != null)
    {
      throw new RuntimeException("Unable to create Weather due to aCity");
    }
    city = aCity;
  }

  public Weather(String aType, Symbol aSymbol, String aNameForCity, MapSystem aMapSystemForCity, Circle aCircleForCity, String aRegionForCity, int aPopulationForCity)
  {
    type = aType;
    symbol = aSymbol;
    city = new City(aNameForCity, aCircleForCity, aMapSystemForCity, aRegionForCity, aPopulationForCity, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setSymbol(Symbol aSymbol)
  {
    boolean wasSet = false;
    symbol = aSymbol;
    wasSet = true;
    return wasSet;
  }

  public String getType()
  {
    return type;
  }

  public Symbol getSymbol()
  {
    return symbol;
  }

  public City getCity()
  {
    return city;
  }

  public void delete()
  {
    City existingCity = city;
    city = null;
    if (existingCity != null)
    {
      existingCity.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "type" + ":" + getType()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "symbol" + "=" + (getSymbol() != null ? !getSymbol().equals(this)  ? getSymbol().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "city = "+(getCity()!=null?Integer.toHexString(System.identityHashCode(getCity())):"null")
     + outputString;
  }
}