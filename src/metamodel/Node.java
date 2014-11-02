package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4678 modeling language!*/


import java.util.*;

// line 9 "model.ump"
// line 146 "model.ump"
public class Node
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Node Attributes
  private String name;
  private double longitude;
  private double latitude;

  //Node Associations
  private Weather weather;
  private Map map;
  private List<Link> links;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Node(String aName, double aLongitude, double aLatitude, Weather aWeather, Map aMap)
  {
    name = aName;
    longitude = aLongitude;
    latitude = aLatitude;
    if (aWeather == null || aWeather.getNode() != null)
    {
      throw new RuntimeException("Unable to create Node due to aWeather");
    }
    weather = aWeather;
    boolean didAddMap = setMap(aMap);
    if (!didAddMap)
    {
      throw new RuntimeException("Unable to create node due to map");
    }
    links = new ArrayList<Link>();
  }

  public Node(String aName, double aLongitude, double aLatitude, String aTypeForWeather, Map aMap)
  {
    name = aName;
    longitude = aLongitude;
    latitude = aLatitude;
    weather = new Weather(aTypeForWeather, this);
    boolean didAddMap = setMap(aMap);
    if (!didAddMap)
    {
      throw new RuntimeException("Unable to create node due to map");
    }
    links = new ArrayList<Link>();
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

  public boolean setLongitude(double aLongitude)
  {
    boolean wasSet = false;
    longitude = aLongitude;
    wasSet = true;
    return wasSet;
  }

  public boolean setLatitude(double aLatitude)
  {
    boolean wasSet = false;
    latitude = aLatitude;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public double getLongitude()
  {
    return longitude;
  }

  public double getLatitude()
  {
    return latitude;
  }

  public Weather getWeather()
  {
    return weather;
  }

  public Map getMap()
  {
    return map;
  }

  public Link getLink(int index)
  {
    Link aLink = links.get(index);
    return aLink;
  }

  public List<Link> getLinks()
  {
    List<Link> newLinks = Collections.unmodifiableList(links);
    return newLinks;
  }

  public int numberOfLinks()
  {
    int number = links.size();
    return number;
  }

  public boolean hasLinks()
  {
    boolean has = links.size() > 0;
    return has;
  }

  public int indexOfLink(Link aLink)
  {
    int index = links.indexOf(aLink);
    return index;
  }

  public boolean setMap(Map aMap)
  {
    boolean wasSet = false;
    if (aMap == null)
    {
      return wasSet;
    }

    Map existingMap = map;
    map = aMap;
    if (existingMap != null && !existingMap.equals(aMap))
    {
      existingMap.removeNode(this);
    }
    map.addNode(this);
    wasSet = true;
    return wasSet;
  }

  public boolean isNumberOfLinksValid()
  {
    boolean isValid = numberOfLinks() >= minimumNumberOfLinks();
    return isValid;
  }

  public static int minimumNumberOfLinks()
  {
    return 1;
  }

  public boolean addLink(Link aLink)
  {
    boolean wasAdded = false;
    if (links.contains(aLink)) { return false; }
    if (links.contains(aLink)) { return false; }
    links.add(aLink);
    if (aLink.indexOfNode(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aLink.addNode(this);
      if (!wasAdded)
      {
        links.remove(aLink);
      }
    }
    return wasAdded;
  }

  public boolean removeLink(Link aLink)
  {
    boolean wasRemoved = false;
    if (!links.contains(aLink))
    {
      return wasRemoved;
    }

    if (numberOfLinks() <= minimumNumberOfLinks())
    {
      return wasRemoved;
    }

    int oldIndex = links.indexOf(aLink);
    links.remove(oldIndex);
    if (aLink.indexOfNode(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aLink.removeNode(this);
      if (!wasRemoved)
      {
        links.add(oldIndex,aLink);
      }
    }
    return wasRemoved;
  }

  public boolean setLinks(Link... newLinks)
  {
    boolean wasSet = false;
    ArrayList<Link> verifiedLinks = new ArrayList<Link>();
    for (Link aLink : newLinks)
    {
      if (verifiedLinks.contains(aLink))
      {
        continue;
      }
      verifiedLinks.add(aLink);
    }

    if (verifiedLinks.size() != newLinks.length || verifiedLinks.size() < minimumNumberOfLinks())
    {
      return wasSet;
    }

    ArrayList<Link> oldLinks = new ArrayList<Link>(links);
    links.clear();
    for (Link aNewLink : verifiedLinks)
    {
      links.add(aNewLink);
      if (oldLinks.contains(aNewLink))
      {
        oldLinks.remove(aNewLink);
      }
      else
      {
        aNewLink.addNode(this);
      }
    }

    for (Link anOldLink : oldLinks)
    {
      anOldLink.removeNode(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean addLinkAt(Link aLink, int index)
  {  
    boolean wasAdded = false;
    if(addLink(aLink))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLinks()) { index = numberOfLinks() - 1; }
      links.remove(aLink);
      links.add(index, aLink);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLinkAt(Link aLink, int index)
  {
    boolean wasAdded = false;
    if(links.contains(aLink))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLinks()) { index = numberOfLinks() - 1; }
      links.remove(aLink);
      links.add(index, aLink);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLinkAt(aLink, index);
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
    Map placeholderMap = map;
    this.map = null;
    placeholderMap.removeNode(this);
    ArrayList<Link> copyOfLinks = new ArrayList<Link>(links);
    links.clear();
    for(Link aLink : copyOfLinks)
    {
      if (aLink.numberOfNodes() <= Link.minimumNumberOfNodes())
      {
        aLink.delete();
      }
      else
      {
        aLink.removeNode(this);
      }
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "longitude" + ":" + getLongitude()+ "," +
            "latitude" + ":" + getLatitude()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "weather = "+(getWeather()!=null?Integer.toHexString(System.identityHashCode(getWeather())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "map = "+(getMap()!=null?Integer.toHexString(System.identityHashCode(getMap())):"null")
     + outputString;
  }
}