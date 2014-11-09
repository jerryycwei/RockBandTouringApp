package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/



// line 186 "model.ump"
// line 223 "model.ump"
// line 260 "model.ump"
public class Circle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Circle Attributes
  private String name;
  private double longitude;
  private double latitude;

  //Circle Associations
  private Node node;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Circle(String aName, double aLongitude, double aLatitude, Node aNode)
  {
    name = aName;
    longitude = aLongitude;
    latitude = aLatitude;
    if (aNode == null || aNode.getCircle() != null)
    {
      throw new RuntimeException("Unable to create Circle due to aNode");
    }
    node = aNode;
  }

  public Circle(String aName, double aLongitude, double aLatitude, String aNameForNode, MapSystem aMapSystemForNode)
  {
    name = aName;
    longitude = aLongitude;
    latitude = aLatitude;
    node = new Node(aNameForNode, aMapSystemForNode, this);
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
            "name" + ":" + getName()+ "," +
            "longitude" + ":" + getLongitude()+ "," +
            "latitude" + ":" + getLatitude()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "node = "+(getNode()!=null?Integer.toHexString(System.identityHashCode(getNode())):"null")
     + outputString;
  }
}