package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.util.*;
import javax.swing.JTextArea;
import java.sql.Time;

// line 2 "model.ump"
// line 150 "model.ump"
public class MapSystem
{

	//------------------------
	// MEMBER VARIABLES
	//------------------------

	//MapSystem Attributes
	private Map map;

	//MapSystem Associations
	private List<Node> nodes;
	private List<Link> links;
	private InfoLabel infoLabel;

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public MapSystem(Map aMap, InfoLabel aInfoLabel)
	{
		map = aMap;
		nodes = new ArrayList<Node>();
		links = new ArrayList<Link>();
		if (aInfoLabel == null || aInfoLabel.getMapSystem() != null)
		{
			throw new RuntimeException("Unable to create MapSystem due to aInfoLabel");
		}
		infoLabel = aInfoLabel;
	}

	public MapSystem(Map aMap, JTextArea aInfoForInfoLabel)
	{
		map = aMap;
		nodes = new ArrayList<Node>();
		links = new ArrayList<Link>();
		infoLabel = new InfoLabel(aInfoForInfoLabel, this);
	}

	//------------------------
	// INTERFACE
	//------------------------

	public boolean setMap(Map aMap)
	{
		boolean wasSet = false;
		map = aMap;
		wasSet = true;
		return wasSet;
	}

	public Map getMap()
	{
		return map;
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

	public InfoLabel getInfoLabel()
	{
		return infoLabel;
	}

	public static int minimumNumberOfNodes()
	{
		return 0;
	}

	public Node addNode(String aName, Circle aCircle)
	{
		return new Node(aName, aCircle, false, this);
	}

	public boolean addNode(Node aNode)
	{
		boolean wasAdded = false;
		if (nodes.contains(aNode)) { return false; }
		MapSystem existingMapSystem = aNode.getMapSystem();
		boolean isNewMapSystem = existingMapSystem != null && !this.equals(existingMapSystem);
		if (isNewMapSystem)
		{
			aNode.setMapSystem(this);
		}
		else
		{
			nodes.add(aNode);
		}
		wasAdded = true;
		return wasAdded;
	}

	public boolean removeNode(Node aNode)
	{
		boolean wasRemoved = false;
		//Unable to remove aNode, as it must always have a mapSystem
		if (!this.equals(aNode.getMapSystem()))
		{
			nodes.remove(aNode);
			wasRemoved = true;
		}
		return wasRemoved;
	}

	public boolean addNodeAt(Node aNode, int index)
	{  
		boolean wasAdded = false;
		if(addNode(aNode))
		{
			if(index < 0 ) { index = 0; }
			if(index > numberOfNodes()) { index = numberOfNodes() - 1; }
			nodes.remove(aNode);
			nodes.add(index, aNode);
			wasAdded = true;
		}
		return wasAdded;
	}

	public boolean addOrMoveNodeAt(Node aNode, int index)
	{
		boolean wasAdded = false;
		if(nodes.contains(aNode))
		{
			if(index < 0 ) { index = 0; }
			if(index > numberOfNodes()) { index = numberOfNodes() - 1; }
			nodes.remove(aNode);
			nodes.add(index, aNode);
			wasAdded = true;
		} 
		else 
		{
			wasAdded = addNodeAt(aNode, index);
		}
		return wasAdded;
	}

	public static int minimumNumberOfLinks()
	{
		return 0;
	}

	public Link addLink(Time aTravelTime, Node aOrigin, Node aDestination, int aDistance, TransportationType aTransportationType)
	{
		return new Link(aTravelTime, aOrigin, aDestination, aDistance, this, aTransportationType);
	}

	public boolean addLink(Link aLink)
	{
		boolean wasAdded = false;
		if (links.contains(aLink)) { return false; }
		MapSystem existingMapSystem = aLink.getMapSystem();
		boolean isNewMapSystem = existingMapSystem != null && !this.equals(existingMapSystem);
		if (isNewMapSystem)
		{
			aLink.setMapSystem(this);
		}
		else
		{
			links.add(aLink);
		}
		wasAdded = true;
		return wasAdded;
	}

	public boolean removeLink(Link aLink)
	{
		boolean wasRemoved = false;
		//Unable to remove aLink, as it must always have a mapSystem
		if (!this.equals(aLink.getMapSystem()))
		{
			links.remove(aLink);
			wasRemoved = true;
		}
		return wasRemoved;
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
		for(int i=nodes.size(); i > 0; i--)
		{
			Node aNode = nodes.get(i - 1);
			aNode.delete();
		}
		for(int i=links.size(); i > 0; i--)
		{
			Link aLink = links.get(i - 1);
			aLink.delete();
		}
		InfoLabel existingInfoLabel = infoLabel;
		infoLabel = null;
		if (existingInfoLabel != null)
		{
			existingInfoLabel.delete();
		}
	}


	public String toString()
	{
		String outputString = "";
		return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
				"  " + "map" + "=" + (getMap() != null ? !getMap().equals(this)  ? getMap().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
				"  " + "infoLabel = "+(getInfoLabel()!=null?Integer.toHexString(System.identityHashCode(getInfoLabel())):"null")
				+ outputString;
	}

	//ADDED METHOD
	public void clearLists() {
		this.links.clear();
		this.nodes.clear();
	}
}