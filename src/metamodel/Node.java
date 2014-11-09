package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.util.*;

// line 9 "model.ump"
// line 151 "model.ump"
public class Node
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Node Attributes
  private String name;

  //Node Associations
  private MapSystem mapSystem;
  private List<Link> links;
  private Circle circle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Node(String aName, MapSystem aMapSystem, Circle aCircle)
  {
    name = aName;
    boolean didAddMapSystem = setMapSystem(aMapSystem);
    if (!didAddMapSystem)
    {
      throw new RuntimeException("Unable to create node due to mapSystem");
    }
    links = new ArrayList<Link>();
    if (aCircle == null || aCircle.getNode() != null)
    {
      throw new RuntimeException("Unable to create Node due to aCircle");
    }
    circle = aCircle;
  }

  public Node(String aName, MapSystem aMapSystem, String aNameForCircle, double aLongitudeForCircle, double aLatitudeForCircle, CircleLabel aCircleLabelForCircle)
  {
    name = aName;
    boolean didAddMapSystem = setMapSystem(aMapSystem);
    if (!didAddMapSystem)
    {
      throw new RuntimeException("Unable to create node due to mapSystem");
    }
    links = new ArrayList<Link>();
    circle = new Circle(aNameForCircle, aLongitudeForCircle, aLatitudeForCircle, this, aCircleLabelForCircle);
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

  public MapSystem getMapSystem()
  {
    return mapSystem;
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

  public Circle getCircle()
  {
    return circle;
  }

  public boolean setMapSystem(MapSystem aMapSystem)
  {
    boolean wasSet = false;
    if (aMapSystem == null)
    {
      return wasSet;
    }

    MapSystem existingMapSystem = mapSystem;
    mapSystem = aMapSystem;
    if (existingMapSystem != null && !existingMapSystem.equals(aMapSystem))
    {
      existingMapSystem.removeNode(this);
    }
    mapSystem.addNode(this);
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
    MapSystem placeholderMapSystem = mapSystem;
    this.mapSystem = null;
    placeholderMapSystem.removeNode(this);
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
    Circle existingCircle = circle;
    circle = null;
    if (existingCircle != null)
    {
      existingCircle.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "mapSystem = "+(getMapSystem()!=null?Integer.toHexString(System.identityHashCode(getMapSystem())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "circle = "+(getCircle()!=null?Integer.toHexString(System.identityHashCode(getCircle())):"null")
     + outputString;
  }
}