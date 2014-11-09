package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/


import java.util.*;

// line 179 "model.ump"
// line 252 "model.ump"
// line 307 "model.ump"
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
  private List<Symbol> symbols;
  private Node node;
  private CircleLabel circleLabel;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Circle(String aName, double aLongitude, double aLatitude, Node aNode, CircleLabel aCircleLabel)
  {
    name = aName;
    longitude = aLongitude;
    latitude = aLatitude;
    symbols = new ArrayList<Symbol>();
    if (aNode == null || aNode.getCircle() != null)
    {
      throw new RuntimeException("Unable to create Circle due to aNode");
    }
    node = aNode;
    if (aCircleLabel == null || aCircleLabel.getCircle() != null)
    {
      throw new RuntimeException("Unable to create Circle due to aCircleLabel");
    }
    circleLabel = aCircleLabel;
  }

  public Circle(String aName, double aLongitude, double aLatitude, String aNameForNode, MapSystem aMapSystemForNode, String aDescriptionForCircleLabel, Accomodation aAccomForCircleLabel, Venue aVenueForCircleLabel)
  {
    name = aName;
    longitude = aLongitude;
    latitude = aLatitude;
    symbols = new ArrayList<Symbol>();
    node = new Node(aNameForNode, aMapSystemForNode, this);
    circleLabel = new CircleLabel(aDescriptionForCircleLabel, aAccomForCircleLabel, aVenueForCircleLabel, this);
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

  public Symbol getSymbol(int index)
  {
    Symbol aSymbol = symbols.get(index);
    return aSymbol;
  }

  public List<Symbol> getSymbols()
  {
    List<Symbol> newSymbols = Collections.unmodifiableList(symbols);
    return newSymbols;
  }

  public int numberOfSymbols()
  {
    int number = symbols.size();
    return number;
  }

  public boolean hasSymbols()
  {
    boolean has = symbols.size() > 0;
    return has;
  }

  public int indexOfSymbol(Symbol aSymbol)
  {
    int index = symbols.indexOf(aSymbol);
    return index;
  }

  public Node getNode()
  {
    return node;
  }

  public CircleLabel getCircleLabel()
  {
    return circleLabel;
  }

  public static int minimumNumberOfSymbols()
  {
    return 0;
  }

  public Symbol addSymbol(String aIconPath, DirectedArrow aDirectedArrow)
  {
    return new Symbol(aIconPath, aDirectedArrow, this);
  }

  public boolean addSymbol(Symbol aSymbol)
  {
    boolean wasAdded = false;
    if (symbols.contains(aSymbol)) { return false; }
    Circle existingCircle = aSymbol.getCircle();
    boolean isNewCircle = existingCircle != null && !this.equals(existingCircle);
    if (isNewCircle)
    {
      aSymbol.setCircle(this);
    }
    else
    {
      symbols.add(aSymbol);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSymbol(Symbol aSymbol)
  {
    boolean wasRemoved = false;
    //Unable to remove aSymbol, as it must always have a circle
    if (!this.equals(aSymbol.getCircle()))
    {
      symbols.remove(aSymbol);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSymbolAt(Symbol aSymbol, int index)
  {  
    boolean wasAdded = false;
    if(addSymbol(aSymbol))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSymbols()) { index = numberOfSymbols() - 1; }
      symbols.remove(aSymbol);
      symbols.add(index, aSymbol);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSymbolAt(Symbol aSymbol, int index)
  {
    boolean wasAdded = false;
    if(symbols.contains(aSymbol))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSymbols()) { index = numberOfSymbols() - 1; }
      symbols.remove(aSymbol);
      symbols.add(index, aSymbol);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSymbolAt(aSymbol, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=symbols.size(); i > 0; i--)
    {
      Symbol aSymbol = symbols.get(i - 1);
      aSymbol.delete();
    }
    Node existingNode = node;
    node = null;
    if (existingNode != null)
    {
      existingNode.delete();
    }
    CircleLabel existingCircleLabel = circleLabel;
    circleLabel = null;
    if (existingCircleLabel != null)
    {
      existingCircleLabel.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "longitude" + ":" + getLongitude()+ "," +
            "latitude" + ":" + getLatitude()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "node = "+(getNode()!=null?Integer.toHexString(System.identityHashCode(getNode())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "circleLabel = "+(getCircleLabel()!=null?Integer.toHexString(System.identityHashCode(getCircleLabel())):"null")
     + outputString;
  }
}