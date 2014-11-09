package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.sql.Time;

// line 39 "model.ump"
// line 117 "model.ump"
public class TransportationType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TransportationType Attributes
  private String name;
  private Symbol symbol;

  //TransportationType Associations
  private Link link;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TransportationType(String aName, Symbol aSymbol, Link aLink)
  {
    name = aName;
    symbol = aSymbol;
    if (aLink == null || aLink.getTransportationType() != null)
    {
      throw new RuntimeException("Unable to create TransportationType due to aLink");
    }
    link = aLink;
  }

  public TransportationType(String aName, Symbol aSymbol, Time aTravelTimeForLink, Node aOriginForLink, Node aDestinationForLink, int aDistanceForLink, MapSystem aMapSystemForLink)
  {
    name = aName;
    symbol = aSymbol;
    link = new Link(aTravelTimeForLink, aOriginForLink, aDestinationForLink, aDistanceForLink, aMapSystemForLink, this);
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

  public boolean setSymbol(Symbol aSymbol)
  {
    boolean wasSet = false;
    symbol = aSymbol;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Symbol getSymbol()
  {
    return symbol;
  }

  public Link getLink()
  {
    return link;
  }

  public void delete()
  {
    Link existingLink = link;
    link = null;
    if (existingLink != null)
    {
      existingLink.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "symbol" + "=" + (getSymbol() != null ? !getSymbol().equals(this)  ? getSymbol().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "link = "+(getLink()!=null?Integer.toHexString(System.identityHashCode(getLink())):"null")
     + outputString;
  }
}