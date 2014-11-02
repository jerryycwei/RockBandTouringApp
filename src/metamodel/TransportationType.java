package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4678 modeling language!*/


import java.sql.Time;

// line 41 "model.ump"
// line 107 "model.ump"
public class TransportationType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TransportationType Attributes
  private String name;

  //TransportationType Associations
  private Link link;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TransportationType(String aName, Link aLink)
  {
    name = aName;
    if (aLink == null || aLink.getTransportationType() != null)
    {
      throw new RuntimeException("Unable to create TransportationType due to aLink");
    }
    link = aLink;
  }

  public TransportationType(String aName, Time aTravelTimeForLink, Node aOriginForLink, Node aDestinationForLink, Map aMapForLink)
  {
    name = aName;
    link = new Link(aTravelTimeForLink, aOriginForLink, aDestinationForLink, aMapForLink, this);
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

  public String getName()
  {
    return name;
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
            "  " + "link = "+(getLink()!=null?Integer.toHexString(System.identityHashCode(getLink())):"null")
     + outputString;
  }
}