package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.sql.Time;
import java.util.*;

// line 15 "model.ump"
// line 101 "model.ump"
// line 171 "model.ump"
public class Link
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Link Attributes
  private Time travelTime;
  private Node origin;
  private Node destination;
  private double distance;

  //Link Associations
  private List<Node> nodes;
  private MapSystem mapSystem;
  private TransportationType transportationType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Link(Time aTravelTime, Node aOrigin, Node aDestination, double aDistance, MapSystem aMapSystem, TransportationType aTransportationType)
  {
    travelTime = aTravelTime;
    origin = aOrigin;
    destination = aDestination;
    distance = aDistance;
    nodes = new ArrayList<Node>();
    boolean didAddMapSystem = setMapSystem(aMapSystem);
    if (!didAddMapSystem)
    {
      throw new RuntimeException("Unable to create link due to mapSystem");
    }
    if (aTransportationType == null || aTransportationType.getLink() != null)
    {
      throw new RuntimeException("Unable to create Link due to aTransportationType");
    }
    transportationType = aTransportationType;
  }

  public Link(Time aTravelTime, Node aOrigin, Node aDestination, double aDistance, MapSystem aMapSystem, String aNameForTransportationType, Symbol aSymbolForTransportationType)
  {
    travelTime = aTravelTime;
    origin = aOrigin;
    destination = aDestination;
    distance = aDistance;
    nodes = new ArrayList<Node>();
    boolean didAddMapSystem = setMapSystem(aMapSystem);
    if (!didAddMapSystem)
    {
      throw new RuntimeException("Unable to create link due to mapSystem");
    }
    transportationType = new TransportationType(aNameForTransportationType, aSymbolForTransportationType, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTravelTime(Time aTravelTime)
  {
    boolean wasSet = false;
    travelTime = aTravelTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setOrigin(Node aOrigin)
  {
    boolean wasSet = false;
    origin = aOrigin;
    wasSet = true;
    return wasSet;
  }

  public boolean setDestination(Node aDestination)
  {
    boolean wasSet = false;
    destination = aDestination;
    wasSet = true;
    return wasSet;
  }

  public boolean setDistance(double aDistance)
  {
    boolean wasSet = false;
    distance = aDistance;
    wasSet = true;
    return wasSet;
  }

  public Time getTravelTime()
  {
    return travelTime;
  }

  public Node getOrigin()
  {
    return origin;
  }

  public Node getDestination()
  {
    return destination;
  }

  public double getDistance()
  {
    return distance;
  }

  public Node getNode(int index)
  {
    Node aNode = nodes.get(index);
    return aNode;
  }

  public List<Node> getNodes()
  {
    List<Node> newNodes = Collections.unmodifiableList(nodes);
    return newNodes;
  }

  public int numberOfNodes()
  {
    int number = nodes.size();
    return number;
  }

  public boolean hasNodes()
  {
    boolean has = nodes.size() > 0;
    return has;
  }

  public int indexOfNode(Node aNode)
  {
    int index = nodes.indexOf(aNode);
    return index;
  }

  public MapSystem getMapSystem()
  {
    return mapSystem;
  }

  public TransportationType getTransportationType()
  {
    return transportationType;
  }

  public boolean isNumberOfNodesValid()
  {
    boolean isValid = numberOfNodes() >= minimumNumberOfNodes() && numberOfNodes() <= maximumNumberOfNodes();
    return isValid;
  }

  public static int requiredNumberOfNodes()
  {
    return 2;
  }

  public static int minimumNumberOfNodes()
  {
    return 2;
  }

  public static int maximumNumberOfNodes()
  {
    return 2;
  }

  public boolean addNode(Node aNode)
  {
    boolean wasAdded = false;
    if (nodes.contains(aNode)) { return false; }
    if (nodes.contains(aNode)) { return false; }
    if (nodes.contains(aNode)) { return false; }
    if (numberOfNodes() >= maximumNumberOfNodes())
    {
      return wasAdded;
    }

    nodes.add(aNode);
    if (aNode.indexOfLink(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aNode.addLink(this);
      if (!wasAdded)
      {
        nodes.remove(aNode);
      }
    }
    return wasAdded;
  }

  public boolean removeNode(Node aNode)
  {
    boolean wasRemoved = false;
    if (!nodes.contains(aNode))
    {
      return wasRemoved;
    }

    if (numberOfNodes() <= minimumNumberOfNodes())
    {
      return wasRemoved;
    }

    int oldIndex = nodes.indexOf(aNode);
    nodes.remove(oldIndex);
    if (aNode.indexOfLink(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aNode.removeLink(this);
      if (!wasRemoved)
      {
        nodes.add(oldIndex,aNode);
      }
    }
    return wasRemoved;
  }

  public boolean setNodes(Node... newNodes)
  {
    boolean wasSet = false;
    ArrayList<Node> verifiedNodes = new ArrayList<Node>();
    for (Node aNode : newNodes)
    {
      if (verifiedNodes.contains(aNode))
      {
        continue;
      }
      verifiedNodes.add(aNode);
    }

    if (verifiedNodes.size() != newNodes.length || verifiedNodes.size() < minimumNumberOfNodes() || verifiedNodes.size() > maximumNumberOfNodes())
    {
      return wasSet;
    }

    ArrayList<Node> oldNodes = new ArrayList<Node>(nodes);
    nodes.clear();
    for (Node aNewNode : verifiedNodes)
    {
      nodes.add(aNewNode);
      if (oldNodes.contains(aNewNode))
      {
        oldNodes.remove(aNewNode);
      }
      else
      {
        aNewNode.addLink(this);
      }
    }

    for (Node anOldNode : oldNodes)
    {
      anOldNode.removeLink(this);
    }
    wasSet = true;
    return wasSet;
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
      existingMapSystem.removeLink(this);
    }
    mapSystem.addLink(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Node> copyOfNodes = new ArrayList<Node>(nodes);
    nodes.clear();
    for(Node aNode : copyOfNodes)
    {
      if (aNode.numberOfLinks() <= Node.minimumNumberOfLinks())
      {
        aNode.delete();
      }
      else
      {
        aNode.removeLink(this);
      }
    }
    MapSystem placeholderMapSystem = mapSystem;
    this.mapSystem = null;
    placeholderMapSystem.removeLink(this);
    TransportationType existingTransportationType = transportationType;
    transportationType = null;
    if (existingTransportationType != null)
    {
      existingTransportationType.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "distance" + ":" + getDistance()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "travelTime" + "=" + (getTravelTime() != null ? !getTravelTime().equals(this)  ? getTravelTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "origin" + "=" + (getOrigin() != null ? !getOrigin().equals(this)  ? getOrigin().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "destination" + "=" + (getDestination() != null ? !getDestination().equals(this)  ? getDestination().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "mapSystem = "+(getMapSystem()!=null?Integer.toHexString(System.identityHashCode(getMapSystem())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "transportationType = "+(getTransportationType()!=null?Integer.toHexString(System.identityHashCode(getTransportationType())):"null")
     + outputString;
  }
}