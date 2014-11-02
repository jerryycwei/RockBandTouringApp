package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4678 modeling language!*/



// line 72 "model.ump"
// line 134 "model.ump"
public class Weather
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Weather Attributes
  private String type;

  //Weather Associations
  private Node node;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Weather(String aType, Node aNode)
  {
    type = aType;
    if (aNode == null || aNode.getWeather() != null)
    {
      throw new RuntimeException("Unable to create Weather due to aNode");
    }
    node = aNode;
  }

  public Weather(String aType, String aNameForNode, double aLongitudeForNode, double aLatitudeForNode, Map aMapForNode)
  {
    type = aType;
    node = new Node(aNameForNode, aLongitudeForNode, aLatitudeForNode, this, aMapForNode);
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

  public String getType()
  {
    return type;
  }

  public Node getNode()
  {
    return node;
  }

  public void delete()
  {
    Node existingNode = node;
    node = null;
    if (existingNode != null)
    {
      existingNode.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "type" + ":" + getType()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "node = "+(getNode()!=null?Integer.toHexString(System.identityHashCode(getNode())):"null")
     + outputString;
  }
}